package br.unitins.topicos1.service.pedido;


import br.unitins.topicos1.dto.itemPedido.ItemPedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Filme;
import br.unitins.topicos1.model.FormaDePagamento;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Status;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.FilmeRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.validation.ValidationException;

import io.quarkus.security.identity.SecurityIdentity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    private FilmeRepository filmeRepository;

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwt;

    @Override
    @Transactional
    public PedidoResponseDTO insert(@Valid PedidoDTO dto, Long idCliente) {

        Pedido pedido = new Pedido();
        Cliente cliente = clienteRepository.findById(idCliente);

        pedido.setDataHora(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setFormaDePagamento(FormaDePagamento.valueOf(dto.idFormaDePagamento()));

        List<ItemPedido> itens = new ArrayList<ItemPedido>();
        double total = 0;

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();

            item.setFilme(filmeRepository.findById(itemDTO.idFilme()));
            item.setQuantidade((itemDTO.quantidade()));

            if (item.getQuantidade() <= item.getFilme().getQtdNoEstoque()) {
                item.getFilme().setQtdNoEstoque(item.getFilme().getQtdNoEstoque() - item.getQuantidade());
            } else {
                throw new ValidationException("QuantidadeDisponivel", "Quantidade Indisponivel");
            }

            total += calcularValorTotal(item.getFilme(), item);
            
            itens.add(item);
        }

        pedido.setItens(itens);
        pedido.setTotalPedido(total);

        pedido.setStatus(Status.PENDENTE);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);

    }

    private double calcularValorTotal(Filme filme, ItemPedido item) {
        double precofilme = filme.getPreco();
        return (precofilme * item.getQuantidade());
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
                .listAll()
                .stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public void alterarStatusPagamento(Long id) {
        Pedido pedido = pedidoRepository.findById(id);

        String login = jwt.getSubject();
        String nomeCliente = clienteRepository.findByLogin(login).getNome();

        if (pedido == null) {
            throw new ValidationException("Buscando Pedido", "O Pedido não foi encontrado");
        }

        if (!pedido.getCliente().getNome().equals(nomeCliente)) {
            throw new ValidationException("Verificando...",
                    "Você não tem permissão para alterar o status de pagamento desse");
        }

        if (pedido.getStatus() == Status.PENDENTE) {
            pedido.setStatus(Status.PAGO);
        } else if (pedido.getStatus() == Status.PAGO) {
            throw new ValidationException("Situação:", "Pedido ja esta pago");
        }
    }

    @Override
    @Transactional
    public List<PedidoResponseDTO> meusPedidos() {
        String login = jwt.getName();
        List<PedidoResponseDTO> pedidos = pedidoRepository.find("cliente.usuario.login", login).stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();

        if (pedidos.isEmpty()) {
            throw new ValidationException("Verificando...", "Você ainda não fez nenhum pedido :(");
        }
        return pedidos;

    }

}
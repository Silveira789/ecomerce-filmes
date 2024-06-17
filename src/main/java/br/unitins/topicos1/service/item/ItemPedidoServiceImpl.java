package br.unitins.topicos1.service.item;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.item.ItemPedidoDTO;
import br.unitins.topicos1.dto.item.ItemPedidoResponseDTO;
import br.unitins.topicos1.model.Filme;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.FilmeRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


import br.unitins.topicos1.repository.ItemPedidoRepository;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ItemPedidoServiceImpl implements ItemPedidoService{

    @Inject
    JsonWebToken jwt;

    @Inject
    FilmeRepository filmeRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    ItemPedidoRepository itemRepository;

    @Override
    @Transactional
    public ItemPedidoResponseDTO insert(ItemPedidoDTO dto) {
        // Encontrar o filme pelo ID fornecido no DTO
        Filme filme = filmeRepository.findById(dto.produto());
        if (filme == null) {
            throw new RuntimeException("Filme não encontrado");
        }

        // Criar um novo ItemPedido com os dados do filme e do DTO
        ItemPedido item = new ItemPedido();
        item.setFilme(filme);
        item.setQuantidade(dto.quantidade());
        item.setPreco(filme.getPreco());

        // Obter o login do JWT
        String login = jwt.getSubject();
        // Encontrar o usuário pelo login
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Encontrar um pedido não finalizado para o usuário
        List<Pedido> pedidos = pedidoRepository.findByFinalizadoIsFalse(usuario.getId());

        Pedido pedido;

        if (pedidos.isEmpty()) {
            // Criar um novo pedido se não houver nenhum não finalizado
            pedido = new Pedido();
            pedido.setUsuario(usuario);
            // Adicionar o item ao pedido
            List<ItemPedido> itens = new ArrayList<>();
            itens.add(item);
            pedido.setItens(itens);
        } else {
            // Usar o pedido não finalizado encontrado
            pedido = pedidos.get(0);
            // Adicionar o item ao pedido existente
            pedido.getItens().add(item);
        }

        // Persistir o pedido e o item (assumindo que o pedido cuida da persistência do item)
        pedidoRepository.persist(pedido);

        item.setPedido(pedido);

        // Retornar o DTO de resposta
        return ItemPedidoResponseDTO.valueOf(item);
    }

    @Override
    public ItemPedidoResponseDTO update(ItemPedidoDTO dto, Long id) {
        System.out.println("ID: " + id);

        ItemPedido item = itemRepository.findById(id);

        if (item == null) {
            throw new RuntimeException("Item não encontrado. ID: " + id);
        }

        item.setQuantidade(dto.quantidade());

        return new ItemPedidoResponseDTO(
                item.getId(),
                item.getFilme().getNome(),
                item.getPreco(),
                item.getQuantidade(),
                item.getPedido().getId()
        );
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemPedidoResponseDTO> findByAll() {
        return itemRepository.listAll().stream()
                .map(e -> ItemPedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public ItemPedidoResponseDTO findById(Long id) {
        if (itemRepository.findById(id) != null)
            return ItemPedidoResponseDTO.valueOf(itemRepository.findById(id));
        else {
            throw new NotFoundException("Arma não encontrada para o ID: " + id);
        }
    }

}

package br.unitins.topicos1.service.pagamento;

import br.unitins.topicos1.dto.pagamento.PagamentoDTO;
import br.unitins.topicos1.dto.pagamento.PagamentoResponseDTO;
import br.unitins.topicos1.model.FormaDePagamento;
import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.repository.PagamentoRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Inject
    JsonWebToken jwt;
    
    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PagamentoRepository pagamentoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PagamentoResponseDTO insert(PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento();
        Pedido pedido = pedidoRepository.findById(dto.idPedido());

        pagamento.setFormaDePagamento(FormaDePagamento.valueOf(dto.idFormaDePagamento()));
        pagamento.setValor(dto.valor());
        pagamento.setPedido(pedido);
        pagamento.getPedido().setFinalizado(true);

        pagamentoRepository.persist(pagamento);

        return PagamentoResponseDTO.valueOf(pagamento);
    }

    @Override
    public List<PagamentoResponseDTO> findByAll() {
        return pagamentoRepository.listAll().stream()
                .map(e -> PagamentoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public PagamentoResponseDTO findById(Long id) {
        if (pedidoRepository.findById(id) != null)
            return PagamentoResponseDTO.valueOf(pagamentoRepository.findById(id));
        else {
            throw new NotFoundException("Arma não encontrada para o ID: " + id);
        }
    }

}
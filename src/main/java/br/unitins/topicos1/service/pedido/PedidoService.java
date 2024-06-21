package br.unitins.topicos1.service.pedido;

import java.util.List;

import br.unitins.topicos1.dto.pedido.PedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

    public PedidoResponseDTO insert(@Valid PedidoDTO dto);
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findAll();
    public List<PedidoResponseDTO> findByCliente(Long idCliente);
    boolean AutenticacaoCliente(String login, Long idCliente);

    public void alterarStatusPagamento(Long id);

    public List<PedidoResponseDTO> meusPedidos();

}
package br.unitins.topicos1.service.pedido;

import java.util.List;

import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;

public interface PedidoService {

    public void delete(Long id);

    public List<PedidoResponseDTO> findByAll();

    public PedidoResponseDTO findById(Long id);
}
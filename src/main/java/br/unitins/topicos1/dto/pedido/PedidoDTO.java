package br.unitins.topicos1.dto.pedido;

import java.util.List;

import br.unitins.topicos1.dto.itemPedido.ItemPedidoDTO;


public record PedidoDTO(
        List<ItemPedidoDTO> itens,
        Integer idFormaDePagamento) {
}

package br.unitins.topicos1.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.dto.item.ItemPedidoResponseDTO;
import br.unitins.topicos1.model.Pedido;

public record PedidoResponseDTO(

        long id,
        LocalDateTime data,
        Double totalPedido,
        String finalizado,
        List<ItemPedidoResponseDTO> itens
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {

        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getDataHora(),
                pedido.getTotalPedido(),
                pedido.isFinalizado() ? "Finalizado" : "Em aberto",
                pedido.getItens().stream().map(item -> ItemPedidoResponseDTO.valueOf(item)).toList());
    }
}
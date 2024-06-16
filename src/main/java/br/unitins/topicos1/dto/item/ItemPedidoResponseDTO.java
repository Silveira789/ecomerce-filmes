package br.unitins.topicos1.dto.item;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoResponseDTO (

        long id,
        String nome,
        Double preco,
        int quantidade,
        long idPedido

) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {

        return new ItemPedidoResponseDTO(item.getId(),
                item.getFilme().getNome(),
                item.getPreco(),
                item.getQuantidade(),
                item.getPedido().getId());

    }



}

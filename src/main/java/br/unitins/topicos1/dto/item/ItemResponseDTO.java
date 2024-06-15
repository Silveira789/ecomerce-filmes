package br.unitins.topicos1.dto.item;

import br.unitins.topicos1.model.ItemPedido;

public record ItemResponseDTO (

        long id,
        String nome,
        Double preco,
        int quantidade,
        long idPedido

) {
    public static ItemResponseDTO valueOf(ItemPedido item) {

        return new ItemResponseDTO(item.getId(),
                item.getFilme().getNome(),
                item.getPreco(),
                item.getQuantidade(),
                item.getPedido().getId());

    }



}

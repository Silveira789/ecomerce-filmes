package br.unitins.topicos1.dto.item;


import br.unitins.topicos1.model.ItemPedido;


public record ItemPedidoDTO(
     Integer quantidade,
     Long produto
) {

    public static ItemPedidoDTO valueOf(ItemPedido itemPedido) {

        return new ItemPedidoDTO(

        itemPedido.getQuantidade(),
        itemPedido.getFilme().getId()
        );
        
    }

        
}

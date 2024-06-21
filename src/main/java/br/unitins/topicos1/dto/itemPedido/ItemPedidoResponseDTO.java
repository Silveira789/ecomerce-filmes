package br.unitins.topicos1.dto.itemPedido;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoResponseDTO (

    String nome,        
    Integer quantidade,
    long idFilme
    

) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item){
        return new ItemPedidoResponseDTO(
            item.getFilme().getNome(),
            item.getQuantidade(), 
            item.getFilme().getId());
    }
}

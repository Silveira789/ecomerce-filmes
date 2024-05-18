package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemPedido extends DefaultEntity{

    private Integer quantidade;
    private Double preco;

    

    // private Pedido Pedido

}

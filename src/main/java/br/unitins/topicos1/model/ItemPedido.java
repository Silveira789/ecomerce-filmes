package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemPedido extends DefaultEntity{

    private Integer quantidade;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}

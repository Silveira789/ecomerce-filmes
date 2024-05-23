package br.unitins.topicos1.model;


import java.util.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Pedido extends DefaultEntity{

    private LocalDateTime dataHora;

    private Usuario usuario;

    private List<ItemPedido> itens;

    private Double totalPedido;

}

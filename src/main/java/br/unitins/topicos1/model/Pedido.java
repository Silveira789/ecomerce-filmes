package br.unitins.topicos1.model;


import java.util.List;
import java.time.LocalDateTime;

public class Pedido extends DefaultEntity{

    private LocalDateTime dataHora;

    private Usuario usuario;

    private List<ItemPedido> itens;

    private Double totalPedido;

}

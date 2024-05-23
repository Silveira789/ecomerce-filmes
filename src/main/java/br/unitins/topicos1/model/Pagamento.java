package br.unitins.topicos1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Pagamento extends DefaultEntity {

    private Double valor;
    private Boolean confirmacaoPagamento;
    // private FormadePagamento formadepagamento;

    private LocalDate dataConfirmacaoPagamento;

    public Pagamento(Double valorTotal) {
        this.valor = valorTotal;
        this.confirmacaoPagamento = true;
        this.dataConfirmacaoPagamento = LocalDate.now();
    }
    








}

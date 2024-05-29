package br.unitins.topicos1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento extends DefaultEntity {

    private Double valor;
    private Boolean confirmacaoPagamento;
    private FormaDePagamento formaDePagamento;
    
    private LocalDate dataConfirmacaoPagamento;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public Pagamento(Double valorTotal) {
        this.valor = valorTotal;
        this.confirmacaoPagamento = true;
        this.dataConfirmacaoPagamento = LocalDate.now();
    }
    
    public Pagamento(){}
    



}

package br.unitins.topicos1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cartao extends DefaultEntity{
    

    private String banco;

    private String numero;

    private LocalDate dataVencimento;

    private String codVerificacao;

    private String nomeTitular;

    //
    




}

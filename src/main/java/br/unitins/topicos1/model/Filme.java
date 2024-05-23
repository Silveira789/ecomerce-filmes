package br.unitins.topicos1.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Table(name = "Filme")
public class Filme extends Produto{

    private String genero;
    private int duracao;
    private String AnoLancamento;
    private String direcao;
    private String TituloOriginal;
    



}

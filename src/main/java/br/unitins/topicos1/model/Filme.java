package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "filme")
public class Filme extends Produto{

    @Column(length = 60)
    private String genero;
    @Column(length = 60)
    private int duracao;
    @Column(length = 60)
    private String AnoLancamento;
    @Column(length = 60)
    private String direcao;
    @Column(length = 60)
    private String TituloOriginal;
    
    @Column(name = "tipo_filme")
    TipoFilme tipoFilme;


}

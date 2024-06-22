package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Produto extends DefaultEntity {

    @Column(length = 60)
    private String nome;

    @Column(length = 60)
    private int qtdNoEstoque;

    @Column(length = 60)
    private Double preco;

    @Column(length = 400)
    private String descricao;

    private String nomeImagem;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }


}

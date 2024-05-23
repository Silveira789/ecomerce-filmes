package br.unitins.topicos1.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Produto extends DefaultEntity {

    public String nome;

    public int qntestoque;
    
    public String descricao;
    
    public Double preco;


}

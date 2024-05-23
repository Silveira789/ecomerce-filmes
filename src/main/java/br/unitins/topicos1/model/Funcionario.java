package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Funcionario  extends DefaultEntity{

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String matricula;

    

}

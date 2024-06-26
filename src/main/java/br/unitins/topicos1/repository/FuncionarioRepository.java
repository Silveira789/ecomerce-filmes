package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {
    public List<Funcionario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

    public List<Funcionario> findByMatricula(String matricula) {
        return find("UPPER(matricula) LIKE UPPER(?1) ", "%" + matricula + "%").list();
    }
}

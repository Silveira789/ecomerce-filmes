package br.unitins.topicos1.repository.aula;

import java.util.List;

import br.unitins.topicos1.model.aula.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {

    public List<Cidade> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }
    
}

package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped 
public class ProdutoRepository implements PanacheRepository<Produto>{
    public List<Produto> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome.toUpperCase()+"%").list();
    }

    public Produto findById(Long id) {
        try {
            return find("id = ?1", id).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}

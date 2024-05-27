package br.unitins.topicos1.resource;



import java.util.List;

import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {


    @Inject
    UsuarioRepository usuarioRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll() {
        return usuarioRepository.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void create(Usuario usuario) {
        usuarioRepository.persist(usuario);
    }

}

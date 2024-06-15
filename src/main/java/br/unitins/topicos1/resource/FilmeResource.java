package br.unitins.topicos1.resource;

import br.unitins.topicos1.service.filme.FilmeService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/filmes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilmeResource {

    @Inject
    FilmeService service;

    @POST
    @RolesAllowed({"Admin"})
    public ArmaResponseDTO insert(ArmaDTO dto) {
        Log.info("Cadastrando uma arma.");
        return service.insert(dto);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public ArmaResponseDTO update(ArmaDTO dto, @PathParam("id") Long id) {
        Log.info("Atualizando dados de uma arma.");
        return service.update(dto, id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public void delete(@PathParam("id") Long id) {
        Log.info("Arma deletada.");
        service.delete(id);
    }

    @GET
    public Response findAll(){
        Log.info("Busca de todas as armas");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response findById(@PathParam("id") Long id){
        Log.info("Busca de uma arma expecificada pelo id");
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        Log.info("Busca de uma arma expecificada pelo nome");
        return Response.ok(service.findByNome(nome)).build();
    }
    

}

package br.unitins.topicos1.resource;

import br.unitins.topicos1.service.pedido.PedidoService;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService service;

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({ "Admin" })
    public void delete(@PathParam("id") Long id) {
        Log.info("Pedido deletado.");
        service.delete(id);
    }

    @GET
    public Response findAll() {
        Log.info("Busca de todos os filmes");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Admin" })
    public Response findById(@PathParam("id") Long id) {
        Log.info("Busca de um item especificado pelo id");
        return Response.ok(service.findById(id)).build();
    }
}

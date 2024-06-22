package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.filme.FilmeDTO;
import br.unitins.topicos1.dto.filme.FilmeResponseDTO;
import br.unitins.topicos1.service.filme.FilmeFileServiceImpl;
import br.unitins.topicos1.service.filme.FilmeService;
import br.unitins.topicos1.form.ImageForm;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/filmes")
public class FilmeResource {

    private static final Logger LOG = Logger.getLogger(FilmeResource.class);

    @Inject
    public FilmeService service;

    @Inject
    public FilmeFileServiceImpl fileService;

    @POST
    @RolesAllowed({"Admin"})
    public FilmeResponseDTO insert(FilmeDTO dto) {
        Log.info("Cadastrando um filme.");
        return service.insert(dto);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public FilmeResponseDTO update(FilmeDTO dto, @PathParam("id") Long id) {
        Log.info("Atualizando os dados de um filme.");
        return service.update(dto, id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public void delete(@PathParam("id") Long id) {
        Log.info("Filme deletado.");
        service.delete(id);
    }

    @GET
    public Response findAll(){
        Log.info("Busca de todos os filmes");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response findById(@PathParam("id") Long id){
        Log.info("Busca de um filme expecificado pelo id");
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        Log.info("Busca de uma filme expecificado pelo nome");
        return Response.ok(service.findByNome(nome)).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @RolesAllowed("Admin")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        LOG.info("Executando o método upload de imagem para console ");
        try {
            fileService.salvar(id, form.getNomeImagem(), form.getImagem());
            Response response = Response.noContent().build();
            LOG.info("Upload realizado com sucesso ");
            return response;
        } catch (Exception e){
            LOG.error("Erro ao realizar o método upload() de console ", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao realizar o método upload() de console ").build();
        }
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        LOG.info("Executando o método download de imagem de um console ");
        try {
            fileService.download(nomeImagem);
            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment; filename=" + nomeImagem);
            LOG.info("Download realizado com sucesso ");
            LOG.info("Nome da imagem: " + nomeImagem);
            return response.build();
        } catch (Exception e){
            LOG.error("Erro ao realizar o método download() de console ", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao realizar o método download() de console ").build();
        }
    }
    

}

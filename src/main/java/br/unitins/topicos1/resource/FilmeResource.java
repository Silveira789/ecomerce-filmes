package br.unitins.topicos1.resource;

import java.io.File;
import java.io.IOException;

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
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/filmes")
public class FilmeResource {

    @Inject
    FilmeService service;

    @Inject
    FilmeFileServiceImpl fileService;

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(FilmeDTO dto) {
        try {
            Log.info("Cadastrando um filme: " + dto.getNome());
            FilmeResponseDTO responseDTO = service.insert(dto);
            return Response.status(Response.Status.CREATED).entity(responseDTO).build();
        } catch (Exception e) {
            Log.error("Erro ao cadastrar um filme: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar um filme.").build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response update(FilmeDTO dto, @PathParam("id") Long id) {
        try {
            Log.info("Atualizando dados do filme: " + dto.getNome());
            FilmeResponseDTO updatedDTO = service.update(dto, id);
            return Response.ok(updatedDTO).build();
        } catch (Exception e) {
            Log.error("Erro ao atualizar o filme: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar o filme.").build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        try {
            Log.info("Deletando o filme com ID: " + id);
            service.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            Log.error("Erro ao deletar o filme: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar o filme.").build();
        }
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll() {
        try {
            Log.info("Buscando todos os filmes");
            return Response.ok(service.findByAll()).build();
        } catch (Exception e) {
            Log.error("Erro ao buscar todos os filmes: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar os filmes.").build();
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response findById(@PathParam("id") Long id) {
        try {
            Log.info("Buscando o filme pelo ID: " + id);
            return Response.ok(service.findById(id)).build();
        } catch (Exception e) {
            Log.error("Erro ao buscar o filme pelo ID: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar o filme.").build();
        }
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"User", "Admin"})
    public Response findByNome(@PathParam("nome") String nome) {
        try {
            Log.info("Buscando filme pelo nome: " + nome);
            return Response.ok(service.findByNome(nome)).build();
        } catch (Exception e) {
            Log.error("Erro ao buscar o filme pelo nome: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar o filme pelo nome.").build();
        }
    }

        @PATCH
    @Path("/upload/imagem/{id}")
    @RolesAllowed({"Admin"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form, @PathParam("id") Long id) {
        try {
            Log.info("Salvando imagem para a filme com ID: " + id);
            String nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
            FilmeResponseDTO filmeDTO = service.updateNomeImagem(id, nomeImagem);
            return Response.ok(filmeDTO).build();
        } catch (IOException e) {
            Log.error("Erro ao salvar a imagem: ", e);
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao salvar a imagem.").build();
        } catch (Exception e) {
            Log.error("Erro ao atualizar os dados da imagem: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar os dados da imagem.").build();
        }
    }

    @GET
    @Path("/download/imagem/{nomeImagem}")
    @RolesAllowed({"User", "Admin"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        try {
            Log.info("Baixando a imagem: " + nomeImagem);
            File imagem = fileService.obter(nomeImagem);
            if (!imagem.exists()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Imagem não encontrada.").build();
            }
            ResponseBuilder response = Response.ok(imagem);
            response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
            return response.build();
        } catch (Exception e) {
            Log.error("Erro ao baixar a imagem: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao baixar a imagem.").build();
        }
    }
    

}

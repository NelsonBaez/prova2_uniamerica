package br.uniamerica.prova2.controller;

import br.uniamerica.prova2.model.Filme;
import br.uniamerica.prova2.dao.FilmeDao;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/filmes")
public class FilmeController {
    private List<Filme> filmes;
    {
        FilmeDao filmeDao = new FilmeDao();
        try {
            filmes = filmeDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public Response filmes(){
        return Response.ok(new Gson().toJson(filmes)).build();
    }
}

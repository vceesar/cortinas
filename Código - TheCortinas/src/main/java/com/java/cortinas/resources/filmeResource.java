package com.java.cortinas.resources;


import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.java.cortinas.api.Filme;

@Path("filme")
@Produces(MediaType.APPLICATION_JSON)
public class filmeResource {
    com.java.cortinas.DB.daoFilme daoFilme;

    public filmeResource(com.java.cortinas.DB.daoFilme daoFilme){
        this.daoFilme= daoFilme;
    }

    @POST
    public Filme create(Filme filme){
        this.daoFilme.create(filme);
        return filme;
    }

    @GET
    public List<Filme> read(){
        return this.daoFilme.read();
    }

    @Path("/getFilmeByName/{tituloFilme}")
    @GET
    public List<Filme> createCondition(@PathParam("tituloFilme") String filme){
        return this.daoFilme.readCondition(filme);
    }

    @Path("/getJsonFilme")
    @GET
    public void exportJsonFileFilme(){
        this.daoFilme.exportJsonFileFilme();
    }
}

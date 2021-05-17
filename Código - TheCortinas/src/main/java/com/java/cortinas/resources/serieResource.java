package com.java.cortinas.resources;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.java.cortinas.api.Serie;

@Path("serie")
@Produces(MediaType.APPLICATION_JSON)
public class serieResource {
    com.java.cortinas.DB.daoSerie daoSerie;

    public serieResource( com.java.cortinas.DB.daoSerie daoSerie){
        this.daoSerie= daoSerie;
    }

    @POST
    public Serie create(Serie serie){
        this.daoSerie.create(serie);
        return serie;
    }

    @GET
    public List<Serie> read() {
        return this.daoSerie.read();
    }

    @Path("/getSerieByName")
    @GET
    public List<Serie> readCondition(Serie serie){
        return this.daoSerie.readCondition(serie);
    }

    @Path("/getJsonSerie")
    @GET
    public void exportJsonFileSerie(){
        this.daoSerie.exportJsonFileSerie();
    }
}

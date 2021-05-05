package RESOURCES;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import API.Serie;

@Path("serie")
@Produces(MediaType.APPLICATION_JSON)
public class serieResource {
    DB.daoSerie daoSerie;

    public serieResource(DB.daoSerie daoSerie){
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
}

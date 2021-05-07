package RESOURCES;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import API.Filme;

@Path("filme")
@Produces(MediaType.APPLICATION_JSON)
public class filmeResource {
    DB.daoFilme daoFilme;

    public filmeResource(DB.daoFilme daoFilme){
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

    @Path("/getFilmeById")
    @GET
    public List<Filme> createCondition(Filme filme){
        return this.daoFilme.readCondition(filme);
    }
}

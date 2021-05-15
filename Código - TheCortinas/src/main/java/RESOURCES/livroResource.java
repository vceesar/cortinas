package RESOURCES;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import API.Livro;

@Path("livro")
@Produces(MediaType.APPLICATION_JSON)
public class livroResource {
    DB.daoLivro daoLivro;

    public livroResource(DB.daoLivro daoLivro){
        this.daoLivro=daoLivro;
    }

    @POST
    public Livro create(Livro livro){
        this.daoLivro.create(livro);
        return livro;
    }
    @GET
    public List<Livro> read(){
        return this.daoLivro.read();
    }

    @Path("/getLivroByName")
    @GET
    public List<Livro> readCondition(Livro livro){
        return this.daoLivro.readCondition(livro);
    }

    @Path("/getJsonLivro")
    @GET
    public void exportJsonFile(){
        this.daoLivro.exportJsonFile();
    }
}

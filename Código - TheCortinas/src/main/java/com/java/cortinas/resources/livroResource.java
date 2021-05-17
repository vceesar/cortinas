package com.java.cortinas.resources;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.java.cortinas.api.Livro;

@Path("livro")
@Produces(MediaType.APPLICATION_JSON)
public class livroResource {
    com.java.cortinas.DB.daoLivro daoLivro;

    public livroResource( com.java.cortinas.DB.daoLivro daoLivro){
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
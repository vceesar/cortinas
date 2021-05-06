package RESOURCES;

import API.paramUser;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class paramUserResource {
    DB.daoUser daoUser;

    public paramUserResource(DB.daoUser daoUser){
        this.daoUser=daoUser;
    }

    @POST
    public paramUser create(paramUser paramUser){
        this.daoUser.create(paramUser);
        return paramUser;
    }

    @GET
    public List<paramUser> read(){
        return this.daoUser.read();
    }
}

package RESOURCES;

import API.paramLogin;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class paramLoginResource {
    DB.daoUserLogin daoUserLogin;

    public paramLoginResource(DB.daoUserLogin daoUserLogin){
        this.daoUserLogin=daoUserLogin;
    }

    @POST
    public paramLogin create(paramLogin paramLogin){
        this.daoUserLogin.create(paramLogin);
        return paramLogin;
    }

    @GET
    public List<paramLogin> read(){
        return this.daoUserLogin.read();
    }

    @Path("/getLoginById")
    @GET
    public List<paramLogin> readCondition(paramLogin paramLogin){
        return this.daoUserLogin.readCondition(paramLogin);
    }
}

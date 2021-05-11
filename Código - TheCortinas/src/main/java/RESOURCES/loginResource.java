package RESOURCES;

import API.Login;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class loginResource {
    DB.daoUserLogin daoUserLogin;

    public loginResource(DB.daoUserLogin daoUserLogin){
        this.daoUserLogin=daoUserLogin;
    }

    @POST
    public Login create(Login Login){
        this.daoUserLogin.create(Login);
        return Login;
    }

    @GET
    public List<Login> read(){
        return this.daoUserLogin.read();
    }

    @Path("/getLoginById")
    @GET
    public List<Login> readCondition(Login Login){
        return this.daoUserLogin.readCondition(Login);
    }
}

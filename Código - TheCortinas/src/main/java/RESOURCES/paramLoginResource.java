package RESOURCES;

import API.paramLogin;
import DB.DaoUserLogin;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class paramLoginResource {
    DaoUserLogin daoUserLogin;

    public paramLoginResource(DaoUserLogin daoUserLogin){
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

    @PUT
    @Path("/loginIdName")
    public paramLogin updateLoginUserName(paramLogin paramLogin){
        if (daoUserLogin.updateUserName(paramLogin))
            return paramLogin;
        throw new NotFoundException();
    }

    @PUT
    @Path("/loginIdPassword")
    public paramLogin updatePassword(paramLogin paramLogin){
        if (daoUserLogin.updateUserPassword(paramLogin))
            return paramLogin;
        throw new NotFoundException();
    }
}

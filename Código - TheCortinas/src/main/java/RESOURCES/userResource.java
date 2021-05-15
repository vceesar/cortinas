package RESOURCES;

import API.User;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class userResource {
    DB.daoUser daoUser;

    public userResource(DB.daoUser daoUser){
        this.daoUser=daoUser;
    }

    @POST
    public User create(User User){
        this.daoUser.create(User);
        return User;
    }

    @GET
    public List<User> read(){
        return this.daoUser.read();
    }

    @Path("/getUserById")
    @GET
    public List<User> readCondition(User User){
        return this.daoUser.readCondition(User);
    }
}

package com.java.cortinas.resources;

import com.java.cortinas.api.User;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class userResource {
    com.java.cortinas.DB.daoUser daoUser;

    public userResource( com.java.cortinas.DB.daoUser daoUser){
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

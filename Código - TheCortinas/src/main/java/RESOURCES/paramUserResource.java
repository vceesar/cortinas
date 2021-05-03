package RESOURCES;

import API.paramUser;
import DB.DaoUser;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class paramUserResource {
    DaoUser daoUser;

    public paramUserResource(DaoUser daoUser){
        this.daoUser=daoUser;
    }

    @POST
    public paramUser create(paramUser paramUser){
        this.daoUser.create(paramUser);
        return paramUser;
    }

    @GET
    public List<paramUser> read(paramUser paramUser){
        return this.daoUser.read(paramUser);
    }

    @PUT
    @Path("/userIdName")
    public paramUser updateName(paramUser paramUser) {
        if (daoUser.updateName(paramUser))
            return paramUser;
        throw new NotFoundException();
    }

    @PUT
    @Path("/userIdBirthday")
    public paramUser updateBirthday(paramUser paramUser) {
        if (daoUser.updateBirthday(paramUser))
            return paramUser;
        throw new NotFoundException();
    }

    @PUT
    @Path("/userIdCidade")
    public paramUser updateCidade(paramUser paramUser) {
        if (daoUser.updateCidade(paramUser))
            return paramUser;
        throw new NotFoundException();
    }

    @PUT
    @Path("/userIdEstado")
    public paramUser updateEstado(paramUser paramUser) {
        if (daoUser.updateEstado(paramUser))
            return paramUser;
        throw new NotFoundException();
    }
}

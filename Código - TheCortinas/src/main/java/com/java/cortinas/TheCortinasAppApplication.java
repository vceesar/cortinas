package com.java.cortinas;

import com.java.cortinas.DB.daoFilme;
import com.java.cortinas.DB.daoLivro;
import com.java.cortinas.DB.daoSerie;
import com.java.cortinas.DB.daoUserLogin;
import com.java.cortinas.DB.daoUser;
import com.java.cortinas.resources.*;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class TheCortinasAppApplication extends Application<TheCortinasAppConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TheCortinasAppApplication().run(new String[]{"server"}); //args new String[]{"server"}
    }

    @Override
    public String getName() {
        return "TheCortinasApp";
    }

    @Override
    public void initialize(final Bootstrap<TheCortinasAppConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/views", "/", "index.html"));
        bootstrap.addBundle(new AssetsBundle("/assets/style","/style",null,"css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js","/js",null,"javascript"));
        bootstrap.addBundle(new AssetsBundle("/assets/images","/images",null,"images"));
        bootstrap.addBundle(new AssetsBundle("/assets/JsonItens","/JsonItens",null,"Json"));
    }

    @Override
    public void run(final TheCortinasAppConfiguration configuration,
                    final Environment environment) throws Exception {
        final FilterRegistration.Dynamic cors= environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "GET,POST");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        daoUser daoUser= new daoUser();
        userResource userResource = new userResource(daoUser);
        environment.jersey().register(userResource);

        daoUserLogin daoUserLogin= new daoUserLogin();
        loginResource loginResource = new loginResource(daoUserLogin);
        environment.jersey().register(loginResource);

        daoFilme daoFilme= new daoFilme();
        filmeResource filmeResource= new filmeResource(daoFilme);
        environment.jersey().register(filmeResource);

        daoLivro daoLivro= new daoLivro();
        livroResource livroResource= new livroResource(daoLivro);
        environment.jersey().register(livroResource);

        daoSerie daoSerie= new daoSerie();
        serieResource serieResource= new serieResource(daoSerie);
        environment.jersey().register(serieResource);


        environment.jersey().setUrlPattern("/cortinas/*");
    }

}

package RESOURCES;

import DB.DaoUser;
import DB.DaoUserLogin;
import DB.daoLivro;
import DB.daoFilme;
import DB.daoSerie;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class App extends Application<Configuration>
{
    public static void main( String[] args ) throws Exception{
        new App().run(new String[]{"server"});
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/views", "/", "index.html"));
        bootstrap.addBundle(new AssetsBundle("/assets/style","/style",null,"css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js","/js",null,"javascript"));
        bootstrap.addBundle(new AssetsBundle("/assets/images","/images",null,"images"));

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        final FilterRegistration.Dynamic cors= environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "GET,POST");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        DaoUser daoUser= new DaoUser();
        userResource userResource = new userResource(daoUser);
        environment.jersey().register(userResource);

        DaoUserLogin daoUserLogin= new DaoUserLogin();
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

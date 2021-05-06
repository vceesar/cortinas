package RESOURCES;

import DB.daoUser;
import DB.daoUserLogin;
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
        AssetsBundle assetsBundle= new AssetsBundle("/site", "/", "index.html");
        bootstrap.addBundle(assetsBundle);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        final FilterRegistration.Dynamic cors= environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "GET,POST");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        daoUser daoUser= new daoUser();
        paramUserResource paramUserResource= new paramUserResource(daoUser);
        environment.jersey().register(paramUserResource);

        daoUserLogin daoUserLogin= new daoUserLogin();
        paramLoginResource paramLoginResource= new paramLoginResource(daoUserLogin);
        environment.jersey().register(paramLoginResource);

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

package DB;

import java.sql.*;
import java.util.*;
import API.Serie;

public class daoSerie {
    private final String createSerie= "INSERT INTO heroku_f818dae8c4e1452.serie (tituloSerie,diretorSerie,elencoPrincipalSerie,paisSerie,anoSerie,numTemp) VALUES (?,?,?,?,?,?)";
    private final String readSerie= "SELECT * FROM heroku_f818dae8c4e1452.serie"; //WHERE tituloSerie=?

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(Serie serie){
        Connection conexao= mysqlCon.getConnection();

        try{
            PreparedStatement statement= conexao.prepareStatement(createSerie);

            statement.setString(1, serie.getTituloSerie());
            statement.setString(2, serie.getDiretorSerie());
            statement.setString(3, serie.getElencoPrincipalSerie());
            statement.setString(4, serie.getPaisSerie());
            statement.setString(5, serie.getAnoSerie());
            statement.setInt(6, serie.getNumTemp());

            int register= statement.executeUpdate();

            return register>0?true:false;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar com o banco de dados");
            sqlE.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Serie> read(){
        Connection conexao= mysqlCon.getConnection();
        List<Serie> seriesList= new ArrayList();

        try{
            PreparedStatement statement= conexao.prepareStatement(readSerie);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                Serie serie= new Serie();
                serie.setTituloSerie(resultSet.getString("tituloSerie"));
                serie.setDiretorSerie(resultSet.getString("diretorSerie"));
                serie.setElencoPrincipalSerie(resultSet.getString("elencoPrincipalSerie"));
                serie.setPaisSerie(resultSet.getString("paisSerie"));
                serie.setAnoSerie(resultSet.getString("anoSerie"));
                serie.setNumTemp(resultSet.getInt("numTemp"));
                seriesList.add(serie);
            }
            return seriesList;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar ao banco de dados");
            sqlE.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return seriesList;
    }
}

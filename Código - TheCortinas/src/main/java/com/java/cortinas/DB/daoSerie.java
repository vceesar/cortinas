package com.java.cortinas.DB;

import java.sql.*;
import java.util.*;
import com.java.cortinas.api.Serie;
import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;

public class daoSerie {
    private final String createSerie= "INSERT INTO heroku_f818dae8c4e1452.serie (tituloSerie,diretorSerie,elencoPrincipalSerie,paisSerie,anoSerie,numTemp) VALUES (?,?,?,?,?,?)";
    private final String readSerie= "SELECT * FROM heroku_f818dae8c4e1452.serie";

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(Serie serie){
        Connection conexao= mysqlCon.getConnection();

        try{
            PreparedStatement statement= conexao.prepareStatement(createSerie);

            statement.setString(1, serie.getTituloSerie());
            statement.setString(2, serie.getDiretorSerie());
            statement.setString(3, serie.getElencoPrincipalSerie());
            statement.setString(4, serie.getPaisSerie());
            statement.setInt(5, serie.getAnoSerie());
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
                serie.setAnoSerie(resultSet.getInt("anoSerie"));
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

    public List<Serie> readCondition(Serie serie){
        Connection conexao= mysqlCon.getConnection();
        List<Serie> serieList= new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement("SELECT * FROM heroku_f818dae8c4e1452.serie WHERE tituloSerie=?");
            statement.setString(1, serie.getTituloSerie());
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                serie.setTituloSerie(resultSet.getString("tituloSerie"));
                serie.setDiretorSerie(resultSet.getString("diretorSerie"));
                serie.setElencoPrincipalSerie(resultSet.getString("elencoPrincipalSerie"));
                serie.setPaisSerie(resultSet.getString("paisSerie"));
                serie.setAnoSerie(resultSet.getInt("anoSerie"));
                serie.setNumTemp(resultSet.getInt("numTemp"));
                serieList.add(serie);
            }
            return serieList;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar com o banco de dados");
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return serieList;
    }

    public void exportJsonFileSerie() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Connection conexao = mysqlCon.getConnection();

        try {
            PreparedStatement statement = conexao.prepareStatement("Select * from serie");
            ResultSet resultSet = statement.executeQuery("Select * from  serie");
            array = new JSONArray();

            while (resultSet.next()) {
                obj = new JSONObject();
                obj.put("tituloSerie", resultSet.getString("tituloSerie"));
                obj.put("diretorSerie", resultSet.getString("diretorSerie"));
                obj.put("elencoPrincipalSerie", resultSet.getString("elencoPrincipalSerie"));
                obj.put("paisSerie", resultSet.getString("paisSerie"));
                obj.put("anoSerie", resultSet.getInt("anoSerie"));
                obj.put("numTemp", resultSet.getInt("numTemp"));
                array.add(obj);
            }

            try {
                FileWriter file = new FileWriter("src/main/front-end/assets/JsonItens/Serie.json");
                file.write(((JSONArray) array).toJSONString());
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (final SQLException sqlE) {
            System.out.println("Falha ao tentar se conectar com o banco de dados");
            sqlE.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.java.cortinas.DB;

import java.sql.*;
import java.util.*;
import com.java.cortinas.api.Filme;
import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;

public class daoFilme {
    private final String createFilme= "INSERT INTO heroku_f818dae8c4e1452.Filme (tituloFilme,diretorFilme,elencoPrincipalFilme,paisFilme,anoFilme) VALUES (?,?,?,?,?)";
    private final String readFilme= "SELECT * FROM heroku_f818dae8c4e1452.filme";

    private final mysqlConnection mysqlCon = new mysqlConnection();

    public boolean create(Filme filme){
        Connection conexao= mysqlCon.getConnection();

        try {
            PreparedStatement statement= conexao.prepareStatement(createFilme);

            statement.setString(1, filme.getTituloFilme());
            statement.setString(2, filme.getDiretorFilme());
            statement.setString(3, filme.getElencoPrincipalFilme());
            statement.setString(4, filme.getPaisFilme());
            statement.setInt(5, filme.getAnoFilme());

            int register= statement.executeUpdate();

            return register>0?true:false;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar com o banco de dados");
            sqlE.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Filme> read(){
        Connection conexao= mysqlCon.getConnection();
        List<Filme> filmesList= new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement(readFilme);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                Filme filme= new Filme();
                filme.setTituloFilme(resultSet.getString("tituloFilme"));
                filme.setDiretorFilme(resultSet.getString("diretorFilme"));
                filme.setElencoPrincipalFilme(resultSet.getString("elencoPrincipalFilme"));
                filme.setPaisFilme(resultSet.getString("paisFilme"));
                filme.setAnoFilme(resultSet.getInt("anoFilme"));
                filmesList.add(filme);
            }
            return filmesList;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar com o banco de dados");
            sqlE.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return filmesList;
    }

    public List<Filme> readCondition(String filme){
        Connection conexao= mysqlCon.getConnection();
        List<Filme> filmeList= new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement("SELECT * FROM heroku_f818dae8c4e1452.filme WHERE tituloFilme=?");
            statement.setString(1, filme);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Filme filme1= new Filme();
                filme1.setTituloFilme(resultSet.getString("tituloFilme"));
                filme1.setDiretorFilme(resultSet.getString("diretorFilme"));
                filme1.setElencoPrincipalFilme(resultSet.getString("elencoPrincipalFilme"));
                filme1.setPaisFilme(resultSet.getString("paisFilme"));
                filme1.setAnoFilme(resultSet.getInt("anoFilme"));
                filmeList.add(filme1);
            }
            return filmeList;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar no banco de dados");
            sqlE.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (final Exception e){
                e.printStackTrace();
            }
        }
        return filmeList;
    }

    public void exportJsonFileFilme() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Connection conexao = mysqlCon.getConnection();

        try {
            PreparedStatement statement = conexao.prepareStatement("Select * from filme");
            ResultSet resultSet = statement.executeQuery("Select * from filme");
            array = new JSONArray();

            while (resultSet.next()) {
                obj = new JSONObject();
                obj.put("tituloFilme", resultSet.getString("tituloFilme"));
                obj.put("diretorFilme", resultSet.getString("diretorFilme"));
                obj.put("elencoPrincipalFilme", resultSet.getString("elencoPrincipalFilme"));
                obj.put("paisFilme", resultSet.getString("paisFilme"));
                obj.put("anoFilme", resultSet.getInt("anoFilme"));
                array.add(obj);
            }

            try {
                FileWriter file = new FileWriter("src/main/front-end/assets/JsonItens/Filme.json");
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

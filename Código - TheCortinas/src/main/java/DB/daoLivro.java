package DB;

import java.sql.*;
import java.util.*;
import API.Livro;
import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;

public class daoLivro {
    private final String createLivro= "INSERT INTO heroku_f818dae8c4e1452.livro (tituloLivro,autorLivro,editora,anoLancamento) VALUES (?,?,?,?)";
    private final String readLivro= "SELECT * FROM heroku_f818dae8c4e1452.livro";

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(Livro livro){
        Connection conexao= mysqlCon.getConnection();

        try {
            PreparedStatement statement= conexao.prepareStatement(createLivro);

            statement.setString(1, livro.getTituloLivro());
            statement.setString(2, livro.getAutorLivro());
            statement.setString(3, livro.getEditora());
            statement.setInt(4, livro.getAnoLacamento());

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

    public List<Livro> read(){
        Connection conexao= mysqlCon.getConnection();
        List<Livro> livrosList= new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement(readLivro);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                Livro livro= new Livro();
                livro.setTituloLivro(resultSet.getString("tituloLivro"));
                livro.setAutorLivro(resultSet.getString("autorLivro"));
                livro.setEditora(resultSet.getString("editora"));
                livro.setAnoLacamento(resultSet.getInt("anoLancamento"));
                livrosList.add(livro);
            }
            return livrosList;
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
        return livrosList;
    }

    public List<Livro> readCondition(Livro livro){
        Connection conexao= mysqlCon.getConnection();
        List<Livro> livroList= new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement("SELECT * FROM heroku_f818dae8c4e1452.livro WHERE tituloLivro=?");
            statement.setString(1, livro.getTituloLivro());
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                livro.setTituloLivro(resultSet.getString("tituloLivro"));
                livro.setAutorLivro(resultSet.getString("autorLivro"));
                livro.setEditora(resultSet.getString("editora"));
                livro.setAnoLacamento(resultSet.getInt("anoLancamento"));
                livroList.add(livro);
            }
            return livroList;
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
        return livroList;
    }

    public void exportJsonFile() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Connection conexao = mysqlCon.getConnection();

        try {
            PreparedStatement statement = conexao.prepareStatement("Select * from livro");
            ResultSet resultSet = statement.executeQuery("Select * from livro");
            array = new JSONArray();

            while (resultSet.next()) {
                obj = new JSONObject();
                obj.put("tituloLivro", resultSet.getString("tituloLivro"));
                obj.put("autorLivro", resultSet.getString("autorLivro"));
                obj.put("editora", resultSet.getString("editora"));
                obj.put("anoLancamento", resultSet.getString("anoLancamento"));
                array.add(obj);
            }

            try {
                FileWriter file = new FileWriter("src/main/front-end/assets/JsonItens/Livro.json");
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

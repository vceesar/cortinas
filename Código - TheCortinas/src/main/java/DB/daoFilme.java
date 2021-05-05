package DB;

import java.sql.*;
import java.util.*;
import API.Filme;

public class daoFilme {
    private final String createFilme= "INSERT INTO heroku_f818dae8c4e1452.Filme (tituloFilme,diretorFilme,elencoPrincipalFilme,paisFilme,anoFilme) VALUES (?,?,?,?,?)";
    private final String readFilme= "SELECT * FROM heroku_f818dae8c4e1452.filme"; //WHERE tituloFilme=?

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
}

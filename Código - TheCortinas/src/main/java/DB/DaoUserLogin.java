package DB;

import java.sql.*;
import java.util.*;
import API.paramLogin;

public class DaoUserLogin {
    private final String createLogin= "INSERT INTO heroku_f818dae8c4e1452.userlogin (userName, userPassword) VALUES (?,?)";
    private final String readLogin= "SELECT loginId FROM heroku_f818dae8c4e1452.userlogin WHERE=?";
    private final String updateLoginUserName= "UPDATE heroku_f818dae8c4e1452.userlogin SET userName=? WHERE loginId="+ readLogin;
    private final String updateLoginUserPassword= "UPDATE heroku_f818dae8c4e1452.userlogin SET userPassword=? WHERE loginId="+ readLogin;

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(paramLogin login){
        Connection conexao= mysqlCon.getConnection();
        try {
            PreparedStatement statement= conexao.prepareStatement(createLogin);

            statement.setString(1, login.getUserName());
            statement.setString(2, login.getUserPassword());

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
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    //rever esse aqui também, já que o outro não está funcionando
    public List<paramLogin> read(){
        Connection conexao= mysqlCon.getConnection();
        List<paramLogin> paramLoginsList= new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement(readLogin);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                paramLogin paramLogin = new paramLogin();
                paramLogin.setLoginId(resultSet.getInt("loginId"));
                statement.setInt(1, paramLogin.getLoginId());
                paramLoginsList.add(paramLogin);
            }
            return paramLoginsList;
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
        return paramLoginsList;
    }

    public boolean updateUserName(paramLogin login){
        Connection conexao = mysqlCon.getConnection();

        try {
            PreparedStatement statement=conexao.prepareStatement(updateLoginUserName);

            statement.setString(1, login.getUserName());

            int register=statement.executeUpdate();

            return register>0?true:false;
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
        return false;
    }

    public boolean updateUserPassword(paramLogin login){
        Connection conexao = mysqlCon.getConnection();

        try {
            PreparedStatement statement=conexao.prepareStatement(updateLoginUserPassword);

            statement.setString(1, login.getUserPassword());

            int register=statement.executeUpdate();

            return register>0?true:false;
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
        return false;
    }
}

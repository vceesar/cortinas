package DB;

import java.sql.*;
import java.util.*;
import API.paramLogin;

public class daoUserLogin {
    private final String createLogin= "INSERT INTO heroku_f818dae8c4e1452.userlogin (userName, userPassword) VALUES (?,?)";
    private final String readLogin= "SELECT * FROM heroku_f818dae8c4e1452.userlogin"; //WHERE loginId=?

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

    public List<paramLogin> read(){
        Connection conexao= mysqlCon.getConnection();
        List<paramLogin> paramLoginsList= new ArrayList();

        try {
            //paramLogin paramLogin = new paramLogin();
            PreparedStatement statement= conexao.prepareStatement(readLogin);
            //statement.setInt(1, paramLogin.getLoginId());
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                paramLogin paramLogin = new paramLogin();
                paramLogin.setLoginId(resultSet.getInt("loginId"));
                paramLogin.setUserName(resultSet.getString("userName"));
                paramLogin.setUserPassword(resultSet.getString("userPassword"));
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

}

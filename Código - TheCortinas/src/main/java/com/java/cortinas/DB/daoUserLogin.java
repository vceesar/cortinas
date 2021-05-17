package com.java.cortinas.DB;
import java.sql.*;
import java.util.*;
import com.java.cortinas.api.Login;

public class daoUserLogin {
    //Login loginCapture= new Login();
    private final String createLogin= "INSERT INTO heroku_f818dae8c4e1452.userlogin (userName, userPassword) VALUES (?,?)";
    private final String readLogin= "SELECT * FROM heroku_f818dae8c4e1452.userlogin";

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(Login login){
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

    public List<Login> read(){
        Connection conexao= mysqlCon.getConnection();
        List<Login> loginsList = new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement(readLogin);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                Login Login = new Login();
                Login.setUserName(resultSet.getString("userName"));
                Login.setUserPassword(resultSet.getString("userPassword"));
                loginsList.add(Login);
            }
            return loginsList;
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
        return loginsList;
    }

    public List<Login> readCondition(Login Login){
        Connection conexao= mysqlCon.getConnection();
        List<Login> loginList = new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement("SELECT * FROM heroku_f818dae8c4e1452.userlogin WHERE loginId=?");
            statement.setInt(1, Login.getLoginId());
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Login.setUserName(resultSet.getString("userName"));
                Login.setUserPassword(resultSet.getString("userPassword"));
                loginList.add(Login);
            }
            return loginList;
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
        return loginList;
    }

    public List<String> captureLogin(String userName, String userPassword){
        List<String> loginList = new ArrayList();
        Connection conexao= mysqlCon.getConnection();
        try{
            PreparedStatement statement= conexao.prepareStatement("SELECT * FROM heroku_f818dae8c4e1452.userlogin WHERE userName=? and userPassword=?");
            statement.setString(1, userName);
            statement.setString(2, userPassword);
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                String catchUserName=resultSet.getString("userName");
                String catchUserPassword=resultSet.getString("userPassword");
                if ((catchUserName.equals(userName)) && (userPassword.equals(catchUserPassword))){
                    System.out.println("Username and Password exist");
                }else {
                    System.out.println("Username and Password dont exist");
                }
                loginList.add(catchUserName);
                loginList.add(catchUserPassword);




            }

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
        return loginList;
    }
}

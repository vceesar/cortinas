package DB;

import java.sql.*;
import java.util.*;
import API.User;

public class DaoUser {
    private final String createUser= "INSERT INTO heroku_f818dae8c4e1452.user (userCompleteName, userBirthday, userCidade, userEstado) VALUES (?,?,?,?)";
    private final String readUser= "SELECT * FROM heroku_f818dae8c4e1452.user";

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(User user){
        Connection conexao= mysqlCon.getConnection();
        try{
            PreparedStatement statement = conexao.prepareStatement(createUser);

            statement.setString(1, user.getName());
            statement.setString(2, user.getBirthday());
            statement.setString(3, user.getCidade());
            statement.setString(4, user.getEstado());

            int register= statement.executeUpdate();

            return register>0?true:false;
        }catch (final SQLException sqlE){
            System.out.println("Falha ao tentar se conectar com o banco de dados");
            sqlE.printStackTrace();
        }catch (final Exception e){
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

    public List<User> read(){
        Connection conexao= mysqlCon.getConnection();
        List<User> users= new ArrayList();
        try{
            PreparedStatement statement = conexao.prepareStatement(readUser);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                User user= new User();
                user.setName(resultSet.getString("userCompleteName"));
                user.setBirthday(resultSet.getString("userBirthday"));
                user.setCidade(resultSet.getString("userCidade"));
                user.setEstado(resultSet.getString("userEstado"));
                users.add(user);
            }
            return users;
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
        return users;
    }

    public List<User> readCondition(User User){
        Connection conexao= mysqlCon.getConnection();
        List<User> userList = new ArrayList();

        try {
            PreparedStatement statement= conexao.prepareStatement("SELECT * FROM heroku_f818dae8c4e1452.user WHERE userId=?");
            statement.setInt(1, User.getUserId());
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                User.setName(resultSet.getString("userCompleteName"));
                User.setBirthday(resultSet.getString("userBirthday"));
                User.setCidade(resultSet.getString("userCidade"));
                User.setEstado(resultSet.getString("userEstado"));
                userList.add(User);
            }
            return userList;
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
        return userList;
    }

}

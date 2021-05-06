package DB;

import java.sql.*;
import java.util.*;
import API.paramUser;

public class daoUser {
    private final String createUser= "INSERT INTO heroku_f818dae8c4e1452.user (userCompleteName, userBirthday, userCidade, userEstado) VALUES (?,?,?,?)";
    private final String readUser= "SELECT * FROM heroku_f818dae8c4e1452.user"; //WHERE userId=?

    private final mysqlConnection mysqlCon= new mysqlConnection();

    public boolean create(paramUser user){
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

    public List<paramUser> read(){
        Connection conexao= mysqlCon.getConnection();
        List<paramUser> users= new ArrayList();
        try{
            PreparedStatement statement = conexao.prepareStatement(readUser);
            //statement.setInt(1, user.getUserId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                paramUser user= new paramUser();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("userCompleteName"));
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

}

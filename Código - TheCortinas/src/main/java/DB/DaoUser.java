package DB;

import java.sql.*;
import java.util.*;
import API.paramUser;

public class DaoUser {
    private final String createUser= "INSERT INTO heroku_f818dae8c4e1452.user (userCompleteName, userBirthday, userCidade, userEstado) VALUES (?,?,?,?)";
    private final String readUser= "SELECT userId FROM heroku_f818dae8c4e1452.user WHERE userId=?";
    private final String updateUserName= "UPDATE heroku_f818dae8c4e1452.user SET userCompleteName=? WHERE userId=?";
    private final String updateUserBirthday= "UPDATE heroku_f818dae8c4e1452.user SET userBirthday=? WHERE userId="+ readUser;
    private final String updateUserCidade= "UPDATE heroku_f818dae8c4e1452.user SET userCidade=? WHERE userId="+ readUser;
    private final String updateUserEstado= "UPDATE heroku_f818dae8c4e1452.user SET userEstado=? WHERE userId="+ readUser;

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


    // O método não tá funcionando, fala que não tá sendo inserido um valor pro parâmetro
    public List<paramUser> read(paramUser paramUser){
        Connection conexao= mysqlCon.getConnection();
        List<paramUser> users= new ArrayList();
        try{
            PreparedStatement statement = conexao.prepareStatement(readUser);
            ResultSet resultSet = statement.executeQuery();

            statement.setInt(1, paramUser.getUserId());

            while (resultSet.next()){
                paramUser user= new paramUser();
                user.setUserId(resultSet.getInt("userId"));
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

    public boolean updateName(paramUser user){
        Connection conexao = mysqlCon.getConnection();
        try {
            PreparedStatement statement= conexao.prepareStatement(updateUserName);

            statement.setInt(2, user.getUserId());
            statement.setString(1, user.getName());


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

    public boolean updateBirthday(paramUser user){
        Connection conexao = mysqlCon.getConnection();
        try {
            PreparedStatement statement= conexao.prepareStatement(updateUserBirthday);

            statement.setString(1, user.getBirthday());

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

    public boolean updateCidade(paramUser user){
        Connection conexao = mysqlCon.getConnection();
        try {
            PreparedStatement statement= conexao.prepareStatement(updateUserCidade);

            statement.setString(1, user.getCidade());

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

    public boolean updateEstado(paramUser user){
        Connection conexao = mysqlCon.getConnection();
        try {
            PreparedStatement statement= conexao.prepareStatement(updateUserEstado);

            statement.setString(1, user.getEstado());

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
}

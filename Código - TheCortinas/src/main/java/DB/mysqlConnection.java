package DB;

import java.sql.*;


public class mysqlConnection {
    private static final String url = "jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_f818dae8c4e1452";
    private static final String username = "b2493a0e6ab4c6";
    private static final String password = "bd5a9da2";


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }
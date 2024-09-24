package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    static Connection connection = null;

    public static Connection getConnection()throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("\"jdbc:postgresql://localhost:5432/", "postgres", "admin");
        } catch (SQLException e){
            System.out.println(e);
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return connection;
    }
}

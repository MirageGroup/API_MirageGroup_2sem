package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/api", "root", "123321");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}

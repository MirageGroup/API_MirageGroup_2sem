package dao;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class DAO {

    public Connection conn;

    public DAO(){
        this.conn = new ConnectionFactory().getConnection();
    }

    public void closeConn() throws SQLException{
        this.conn.close();
    }
}

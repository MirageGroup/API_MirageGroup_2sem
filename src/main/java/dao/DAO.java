package dao;

import java.sql.Connection;
import factory.ConnectionFactory;

public class DAO {

    public Connection conn;

    public DAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
}

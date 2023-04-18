package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Clazz;

public class ClazzDAO extends DAO {

    public void save(Clazz clazz){
        String sql = "INSERT INTO classes(name_class, time_weekday, time_class) VALUES (?, ?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, clazz.getName());
            stmt.setString(2, clazz.getWeekday());
            stmt.setString(3, clazz.getTime());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Clazz clazz){
        String sql ="UPDATE classes SET name_class=?, time_weekday=?, time_class - ? WHERE id_class = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, clazz.getName());
            stmt.setString(2, clazz.getWeekday());
            stmt.setString(3, clazz.getTime());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}

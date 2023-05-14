package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Assignment;


public class AssignmentDAO extends DAO {
    
    public void save(Assignment assignment){
        String sql = "INSERT INTO assignments(name_assignment, desc_assignment, date_assigned, date_due, max_grade) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, assignment.getName());
            stmt.setString(2, assignment.getDescription());
            stmt.setString(3, assignment.getDate_assigned());
            stmt.setString(4, assignment.getDate_due());
            stmt.setDouble(4, assignment.getMax_grade());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                assignment.setId(rs.getInt(1));
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void NameAssignment(Assignment assignment){
        String sql = "INSERT INTO assignments(name_assignment) VALUES (?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, assignment.getName());          
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                assignment.setId(rs.getInt(1));
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    // public updateAssignment(){
    //     String sql = "UPDATE";
    // }
}
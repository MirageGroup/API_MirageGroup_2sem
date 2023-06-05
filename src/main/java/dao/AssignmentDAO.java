package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import gui.ClienteGUI;
import models.Assignment;
import models.Clazz;

public class AssignmentDAO extends DAO {

    public void save(Assignment assignment) {
        ClazzDAO clazzdao = new ClazzDAO();
        Clazz clazz = clazzdao.getByName(ClienteGUI.ComboSalas.getSelectedItem().toString());
        String sql = "INSERT INTO assignments(fk_Classes_id_class ,name_assignment, desc_assignment, date_assigned, date_due, max_grade) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, clazz.getId());
            stmt.setString(2, assignment.getName());
            stmt.setString(3, assignment.getDescription());
            stmt.setString(4, assignment.getDate_assigned());
            stmt.setString(5, assignment.getDate_due());
            stmt.setDouble(6, assignment.getMax_grade());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                assignment.setId(rs.getInt(1));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Assignment assignment){
        String sql = "DELETE FROM assignments WHERE id_assignment = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, assignment.getId());
            stmt.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void NameAssignment(Assignment assignment) {
        String sql = "INSERT INTO assignments(name_assignment) VALUES (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, assignment.getName());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                assignment.setId(rs.getInt(1));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Assignment> getAssignments(Clazz clazz) {
        ArrayList<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT id_assignment, fk_Classes_id_class, name_assignment, desc_assignment, date_assigned, date_due, max_grade FROM assignments INNER JOIN classes ON assignments.fk_Classes_id_class = classes.id_class WHERE fk_Classes_id_class = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, clazz.getId());
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Assignment assignment = new Assignment();
                assignment.setId(resultSet.getInt("id_assignment"));
                assignment.setName(resultSet.getString("name_assignment"));
                assignment.setDescription(resultSet.getString("desc_assignment"));
                assignment.setDate_assigned(resultSet.getString("date_assigned"));
                assignment.setDate_due(resultSet.getString("date_due"));
                assignment.setMax_grade(resultSet.getDouble("max_grade"));
                assignments.add(assignment);
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // Handle the exception or log it if necessary
            }
        }
    
        return assignments;
    }
    

}

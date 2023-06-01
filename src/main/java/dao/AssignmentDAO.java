package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Assignment> getAssignments() {
        ArrayList<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT * FROM assignments WHERE column = name_assignment";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Assignment assignment = new Assignment();
                assignment.setName(resultSet.getString("name_assignment"));
                assignments.add(assignment);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return assignments;
    }

}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Grade;

public class GradeDAO extends DAO {

    private ArrayList<Grade> lista = new ArrayList<>();
    
    public ArrayList<Grade>getAllGrades(){
        String sql = "SELECT * FROM student_assignment";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);           
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Grade grade = new Grade();
                grade.setFkStu(rs.getInt("fk_Students_id_student"));
                grade.setFkAss(rs.getString("fk_Assignments_id_assignment"));
                grade.setDelivered(rs.getString("delivered"));
                grade.setGrade(rs.getInt("grade"));
                this.lista.add(grade);
            }
            stmt.close();
            return this.lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveGrade(Grade grade){
        String sql = "INSERT INTO students(grade_student) VALUES (?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, grade.getGrade());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                grade.setGrade(rs.getInt(1));
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}

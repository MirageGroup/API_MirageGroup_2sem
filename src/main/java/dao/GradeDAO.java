package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Grade;
import models.Student;

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

    public void saveGrade(Grade grade, Student student){
        String sql = "INSERT INTO grades(fk_Grades_id_student,grade_student,grade_student1,grade_student2,grade_student3,grade_student4) VALUES (?,?,?,?,?,?)";       
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, student.getId());
            stmt.setDouble(2, grade.getGrade());
            stmt.setDouble(3, grade.getGrade1());
            stmt.setDouble(4, grade.getGrade2());
            stmt.setDouble(5, grade.getGrade3());
            stmt.setDouble(6, grade.getGrade4());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys(); 
            if(rs.next()){                
                grade.setGrade(rs.getInt(student.getId()));
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}

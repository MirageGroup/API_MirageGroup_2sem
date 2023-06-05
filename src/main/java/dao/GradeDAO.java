package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Clazz;
import models.Grade;
import models.Student;

public class GradeDAO extends DAO {

    private ArrayList<Grade> lista = new ArrayList<>();
    
    public ArrayList<Grade>getAllGrades(){
        String sql = "SELECT * FROM grades";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);           
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Grade grade = new Grade();
                grade.setId_student(rs.getInt("fk_Grades_id_student"));
                if(rs.getDouble("grade_student") != 0.0){
                    grade.setGrade(rs.getDouble("grade_student"));
                }
                if(rs.getDouble("grade_student1") != 0.0){
                    grade.setGrade1(rs.getDouble("grade_student1"));
                }
                if(rs.getDouble("grade_student2") != 0.0){
                    grade.setGrade2(rs.getDouble("grade_student2"));
                }
                if(rs.getDouble("grade_student3") != 0.0){
                    grade.setGrade3(rs.getDouble("grade_student3"));
                }
                if(rs.getDouble("grade_student4") != 0.0){
                    grade.setGrade4(rs.getDouble("grade_student4"));
                }
                this.lista.add(grade);
            }
            stmt.close();
            return this.lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveGrade(Grade grade, Student student){
        String sql = "update grades set grade_student = ?, grade_student1 = ?, grade_student2 = ?, grade_student3 = ?, grade_student4 = ? where fk_Grades_id_student = ? "; 
        // sql = "INSERT INTO grades(fk_Grades_id_student, grade_student, grade_student1, grade_student2, grade_student3, grade_student4) VALUES (?,?,?,?,?,?)";      
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, grade.getGrade());
            stmt.setDouble(2, grade.getGrade1());
            stmt.setDouble(3, grade.getGrade2());
            stmt.setDouble(4, grade.getGrade3());
            stmt.setDouble(5, grade.getGrade4());
            stmt.setInt(6, student.getId());
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

    public void initGrade(Student student, Clazz clazz){
        String sql = "INSERT INTO grades(fk_Grades_id_student, fk_Classes_id_class, grade_student, grade_student1, grade_student2, grade_student3, grade_student4) VALUES (?,?,?,?,?,?,?)";

          try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, student.getId());
            stmt.setInt(2, clazz.getId());
            stmt.setDouble(3,0 );
            stmt.setDouble(4, 0);
            stmt.setDouble(5, 0);
            stmt.setDouble(6, 0);
            stmt.setDouble(7, 0);
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int countStudentsWithAverageBelow(double threshold) throws SQLException {
        int count = 0;
    
        // Executa a consulta para contar o número de alunos com média abaixo do limite
        String query = "SELECT COUNT(*) FROM grades WHERE (grade_student1 + grade_student2 + grade_student3 + grade_student4 + grade_student) / 5 < ? and fk_Classes_id_class = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, threshold);
            ResultSet rs = stmt.executeQuery();
        
            // Obtém o resultado da consulta
            if (rs.next()) {
                count = rs.getInt(1);
            }
        
            // Fecha os recursos
            rs.close();
            stmt.close();
            conn.close();
            
            return count;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return count;

    }

    public int countStudentsWithAverageUp(double threshold) throws SQLException {
        int count = 0;
    
        // Executa a consulta para contar o número de alunos com média abaixo do limite
        String query = "SELECT COUNT(*) FROM grades WHERE (grade_student1 + grade_student2 + grade_student3 + grade_student4 + grade_student) / 5 >= ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, threshold);
            ResultSet rs = stmt.executeQuery();
        
            // Obtém o resultado da consulta
            if (rs.next()) {
                count = rs.getInt(1);
            }
        
            // Fecha os recursos
            rs.close();
            stmt.close();
            conn.close();
            
            return count;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return count;

    }

}

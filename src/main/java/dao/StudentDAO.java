package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Student;

public class StudentDAO extends DAO {

    private ArrayList<Student> lista = new ArrayList<>(null); 

    public void save(Student student){
        String sql = "INSERT INTO students(name_student) VALUES (?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Student student){
        String sql = "UPDATE students SET name_student = ?, grade_student = ? WHERE id_student = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setDouble(2, student.getGrade());
            stmt.setInt(3, student.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Student getById(int id){
        String sql = "SELECT * FROM students WHERE id_student = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Student student = new Student();
            while(rs.next()){
              student.setId(rs.getInt("id_student"));
              student.setName(rs.getString("name_student"));
              student.setGrade(rs.getDouble("grade_student"));
            }
            stmt.close();
            return student;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Student>getAll(){
        String sql = "SELECT * FROM students";
        try{
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Student aluno = new Student();
            aluno.setId(rs.getInt("id_student"));
            aluno.setName(rs.getString("name_student"));            
        }
            stmt.close();
            return this.lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}

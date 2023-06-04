package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Clazz;
import models.Student;

public class StudentDAO extends DAO {

    public void save(Student student){
        String sql = "INSERT INTO students(name_student) VALUES (?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, student.getName());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                student.setId(rs.getInt(1));
            }
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

    public void delete(Student student){
        String sql1 = "DELETE FROM grades WHERE fk_Grades_id_student = ?";
        String sql2 = "DELETE FROM student_assignment WHERE fk_Students_id_student = ?";
        String sql3 = "DELETE FROM student_class WHERE fk_Students_id_student = ?";
        String sql4 = "DELETE FROM students WHERE id_student = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement(sql2);
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();

            stmt = conn.prepareStatement(sql3);
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();

            stmt = conn.prepareStatement(sql4);
            stmt.setInt(1, student.getId());
            stmt.executeUpdate();
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

    public ArrayList<Student> getByClazz(Clazz clazz) {
      ArrayList<Student> list = new ArrayList<>();
  
      ClazzDAO clazzDao = new ClazzDAO();
      clazz = clazzDao.getByName(clazz.getName());

      String sql = "SELECT * FROM students INNER JOIN student_class ON student_class.fk_Students_id_student = students.id_student WHERE fk_Classes_id_class = ? ORDER BY students.id_student";
      try{
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setInt(1, clazz.getId());
          ResultSet rs = stmt.executeQuery();
          while(rs.next()){
              Student student = new Student();
              student.setId(rs.getInt("id_student"));
              student.setName(rs.getString("name_student"));
              student.setGrade(rs.getDouble("grade_student"));
              list.add(student);
          }
          stmt.close();

          return list;
      } catch(SQLException e){
          throw new RuntimeException(e);
      }
    }

    public ArrayList<Student> getAll(){
      ArrayList<Student> lista = new ArrayList<>(); // Inicializa a variável lista
      String sql = "SELECT * FROM students";
      try{
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
          Student student = new Student();
          student.setId(rs.getInt("id_student"));
          student.setName(rs.getString("name_student"));
          student.setGrade(rs.getDouble("grade_student"));
          lista.add(student);
      }
          stmt.close();
          return lista;
      }catch(SQLException e){
          throw new RuntimeException(e);
      }
    }

    public Student getByName(String name){
      String sql = "SELECT * FROM students WHERE name_student = ?";
      try{
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, name);
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

}

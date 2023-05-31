package dao;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import com.mysql.cj.xdevapi.PreparableStatement;

import models.Clazz;
import models.Note;
import models.Student;

public class ClazzDAO extends DAO {

    private ArrayList<Clazz> lista = new ArrayList<>(); 

    public void save(Clazz clazz){
        String sql = "INSERT INTO classes(name_class, time_weekday, time_start, time_end) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, clazz.getName());
            stmt.setString(2, clazz.getWeekday());
            stmt.setString(3, clazz.getTime_start());
            stmt.setString(4, clazz.getTime_end());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Clazz clazz){
        String sql ="UPDATE classes SET name_class=?, time_weekday=?, time_start = ?, time_end = ? WHERE id_class = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, clazz.getName());
            stmt.setString(2, clazz.getWeekday());
            stmt.setString(3, clazz.getTime_start());
            stmt.setString(4, clazz.getTime_end());
            stmt.setInt(4, clazz.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addNote(Clazz clazz, String note){
        String sql = "INSERT INTO classes_notes(fk_Classes_id_class, note) VALUES (?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, clazz.getId());
            stmt.setString(2, note);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Note> getNotes(Clazz clazz){
        String sql = "SELECT * FROM classes_notes INNER JOIN classes ON classes_notes.fk_Classes_id_class = classes.id_class WHERE fk_Classes_id_class = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, clazz.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Note> list = new ArrayList<>();
            while(rs.next()){
                Note note = new Note();
                note.setId(rs.getInt("id_note"));
                note.setClass_id(rs.getInt("fk_Classes_id_class"));
                note.setNote(rs.getString("note"));
                list.add(note);
            }
            stmt.close();
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
   
    public void addStudent(Clazz clazz, Student student){
        String sql = "INSERT INTO student_class(fk_Classes_id_class, fk_Students_id_student) VALUES (?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, clazz.getId());
            stmt.setInt(2, student.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Clazz getById(int id){
      String sql = "SELECT * FROM classes WHERE id_class = ?";
      try{
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();
          Clazz clazz = new Clazz();
          while(rs.next()){
            clazz.setId(rs.getInt("id_class"));
            clazz.setName(rs.getString("name_class"));
            clazz.setWeekday(rs.getString("time_weekday"));
            clazz.setTime_start(rs.getString("time_start"));
            clazz.setTime_end(rs.getString("time_end"));
          }
          stmt.close();
          return clazz;
      }catch(SQLException e){
          throw new RuntimeException(e);
      }
  }

    public void insertClazz(Clazz clazz){
        String sql = "INSERT INTO classes(name_class) VALUES (?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,clazz.getName());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }       
    }
    

    public Clazz getByName(String name){
        String sql = "SELECT * FROM classes WHERE name_class = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            Clazz clazz = new Clazz();
            while(rs.next()){
                clazz.setId(rs.getInt("id_class"));
                clazz.setName(rs.getString("name_class"));
                clazz.setWeekday(rs.getString("time_weekday"));
                clazz.setTime_start(rs.getString("time_start"));
                clazz.setTime_end(rs.getString("time_end"));
            }
            stmt.close();
            return clazz;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Clazz> getByWeekday(int weekday){
        String sql = "SELECT * FROM classes WHERE time_weekday = ?";
        try{
            PreparedStatement stmt  = conn.prepareStatement(sql);
            stmt.setInt(1, weekday);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Clazz> list = new ArrayList<>();
            while(rs.next()){
                Clazz clazz = new Clazz();
                clazz.setId(rs.getInt("id_class"));
                clazz.setName(rs.getString("name_class"));
                clazz.setWeekday(rs.getString("time_weekday"));
                clazz.setTime_start(rs.getString("time_start"));
                clazz.setTime_end(rs.getString("time_end"));
                list.add(clazz);
            }
            stmt.close();
            return list;        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Clazz> getAll(){
        String sql = "SELECT * FROM classes";
        try{
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Clazz clazz = new Clazz();
            clazz.setId(rs.getInt("id_class"));
            clazz.setName(rs.getString("name_class"));
            clazz.setWeekday(rs.getString("time_weekday"));
            clazz.setTime_start(rs.getString("time_start"));
            clazz.setTime_end(rs.getString("time_end"));
            this.lista.add(clazz);
        }
            stmt.close();
            return this.lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    
}

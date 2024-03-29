package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Clazz;
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

    public void saveNote(Clazz clazz, String notes){
        String sql = "UPDATE classes SET notes_class = ? WHERE id_class = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, notes);
            stmt.setInt(2, clazz.getId());
            stmt.execute();
            stmt.close();
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
            clazz.setNotes(rs.getString("notes_class"));
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
                clazz.setNotes(rs.getString("notes_class"));
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
                clazz.setNotes(rs.getString("notes_class"));
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
            clazz.setNotes(rs.getString("notes_class"));
            this.lista.add(clazz);
        }
            stmt.close();
            return this.lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    
}

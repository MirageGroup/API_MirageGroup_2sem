package dao;
import java.sql.*;
import models.Task;


public class Task_DAO extends DAO {
    
    public void save(Task task,String update){
        String sql = "";

        if(update == "update"){
            sql = "INSERT INTO assignments(name_assignment,desc_assignment,date_assigned,date_due,max_grade) VALUES (?, ?, ?, ?, ?)";
        }else{
            sql ="UPDATE classes SET name_assignment=?, desc_assignment=?, date_assigned = ?,date_due = ?,max_grade = ? WHERE id_class = ?";
         
        try{
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setString(1, task.getTask_name());
            stmt.setString(2, task.getTask_descrition());
            stmt.setString(3, task.getTask_date());
            stmt.setString(4, task.getTask_due());
            stmt.setDouble(5, task.getMax_grade());
            stmt.execute();
            stmt.close();
        }catch(SQLException e ){    
        }
    }
}

}
package controllers.models;


import java.sql.SQLException;


import javax.swing.JOptionPane;

import dao.GradeDAO;
import dao.StudentDAO;
import gui.ClienteGUI;
import models.Grade;
import models.Student;

public class GradesController {
    
    public static void saveGrades(String student_name) throws SQLException{
        if(ClienteGUI.jTextField6.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira todas as informações");
        } else {
            Grade grade = new Grade();
            StudentDAO student_Dao = new StudentDAO();
            Student student = student_Dao.getByName(student_name);
            grade.setGrade(Double.parseDouble(ClienteGUI.jTextField6.getText()));
            grade.setFkStu(1);
            GradeDAO gradedao = new GradeDAO();
            gradedao.saveGrade(grade,student);
            JOptionPane.showMessageDialog(null, "Nota "+ClienteGUI.jTextField2.getText()+" cadastrada");
            // ClienteGUI.jTextField1.setText("");
            
            gradedao.closeConn();

           
        }
    }

}

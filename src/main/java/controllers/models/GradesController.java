package controllers.models;


import java.sql.SQLException;


import javax.swing.JOptionPane;

import dao.GradeDAO;
import gui.ClienteGUI;
import models.Grade;

public class GradesController {
    
    public static void saveGrades() throws SQLException{
        if(ClienteGUI.jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo não pode estar vazio");
        } else {
            Grade grade = new Grade();
            grade.setGrade(Double.parseDouble(ClienteGUI.jTextField1.getText()));
            grade.setFkStu(1);
            GradeDAO gradedao = new GradeDAO();
            gradedao.saveGrade(grade);
            JOptionPane.showMessageDialog(null, "Nota "+ClienteGUI.jTextField1.getText()+" cadastrada");
            ClienteGUI.jTextField1.setText("");
            
            gradedao.closeConn();

           
        }
    }

}

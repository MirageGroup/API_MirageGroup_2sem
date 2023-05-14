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
        double nota = (Double.parseDouble(ClienteGUI.jTextField6.getText()));
        double nota1 = (Double.parseDouble(ClienteGUI.jTextField2.getText()));
        double nota2 = (Double.parseDouble(ClienteGUI.jTextField3.getText()));
        double nota3 = (Double.parseDouble(ClienteGUI.jTextField5.getText()));
        double nota4 = (Double.parseDouble(ClienteGUI.jTextField8.getText()));
        Grade grade = new Grade();
        StudentDAO student_Dao = new StudentDAO();
        Student student = student_Dao.getByName(student_name);
        grade.setGrade(nota);
        grade.setGrade1(nota1);
        grade.setGrade2(nota2);
        grade.setGrade3(nota3);
        grade.setGrade4(nota4);
        grade.setFkStu(1);
        GradeDAO gradedao = new GradeDAO();
        gradedao.saveGrade(grade,student);
        JOptionPane.showMessageDialog(null, "As notas foram cadastradas com sucesso!");
        ClienteGUI.jTextField6.setText("");
        ClienteGUI.jTextField2.setText("");
        ClienteGUI.jTextField3.setText("");
        ClienteGUI.jTextField5.setText("");
        ClienteGUI.jTextField8.setText("");
        
        gradedao.closeConn();

       
    }
 }

}

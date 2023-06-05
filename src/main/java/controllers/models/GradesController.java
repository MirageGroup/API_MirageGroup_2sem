package controllers.models;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        Grade grade = new Grade();
        grade.setGrade(nota);
        
        if(!ClienteGUI.jTextField2.getText().isEmpty()){
            double nota1 = (Double.parseDouble(ClienteGUI.jTextField2.getText()));
            grade.setGrade1(nota1);
        }
        if(!ClienteGUI.jTextField3.getText().isEmpty()){
            double nota2 = (Double.parseDouble(ClienteGUI.jTextField3.getText()));
            grade.setGrade2(nota2);
        }
        if(!ClienteGUI.jTextField5.getText().isEmpty()){
            double nota3 = (Double.parseDouble(ClienteGUI.jTextField5.getText()));
            grade.setGrade3(nota3);
        }
        if(!ClienteGUI.jTextField8.getText().isEmpty()){
            double nota4 = (Double.parseDouble(ClienteGUI.jTextField8.getText()));
            grade.setGrade4(nota4);
        }
            StudentDAO student_Dao = new StudentDAO();
            Student student = student_Dao.getByName(student_name);
                
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

    public static void insertGradesIntoTable() {
        DefaultTableModel model = (DefaultTableModel) ClienteGUI.tabelaNotas.getModel();
        model.setRowCount(0);
        GradeDAO dao = new GradeDAO();
        String[] namesList = StudentController.studentListByClazz();
        ArrayList<Grade> gradesList = dao.getAllGrades();
    
        for (Grade grade : gradesList) {
            System.out.println(grade.getId_student());
        }
    
        for (int i = 0; i < gradesList.size() && i < namesList.length; i++) {
            System.err.println(i);
            System.err.println(namesList[i]);
            model.addRow(new Object[]{
                namesList[i],
                gradesList.get(i).getGrade(),
                gradesList.get(i).getGrade1(),
                gradesList.get(i).getGrade2(),
                gradesList.get(i).getGrade3(),
                gradesList.get(i).getGrade4()
            });
        }
    }
    

}

package controllers.models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.ClazzDAO;
import dao.StudentDAO;
import gui.ClienteGUI;
import models.Clazz;
import models.Student;

public class StudentController {

  public static void showStudentsByClazz(){
      StudentDAO studentDAO = new StudentDAO();

      Clazz clazz = new Clazz();

      clazz.setName((String)ClienteGUI.ComboSalas.getSelectedItem());

      ArrayList<Student> studentsList = studentDAO.getByClazz(clazz);

      ClienteGUI.jTextArea1.setText("");
      for (Student student : studentsList) {
        ClienteGUI.jTextArea1.setText(ClienteGUI.jTextArea1.getText()+student.getName()+"\n");
      }
  }

  public static void saveStudent() throws SQLException{
    if((ClienteGUI.CadAluno.getText().isEmpty())){
        JOptionPane.showMessageDialog(null, "O campo não pode estar vazio");
    }
    else{
        Student student = new Student();
        student.setName(ClienteGUI.CadAluno.getText());

        StudentDAO studentdao = new StudentDAO();
        studentdao.save(student);
        JOptionPane.showMessageDialog(null,"Aluno "+ClienteGUI.CadAluno.getText()+" cadastrado na turma "+ClienteGUI.ComboSalasCad.getSelectedItem().toString());
        ClienteGUI.CadAluno.setText("");

        ClazzDAO clazzdao = new ClazzDAO();
        Clazz clazz = clazzdao.getByName(ClienteGUI.ComboSalasCad.getSelectedItem().toString());
        clazzdao.addStudent(clazz, student);

        clazzdao.closeConn();
        studentdao.closeConn();
        ClienteGUI.jTextArea1.setText("");
        StudentController.showStudentsByClazz();
     }
  }

}

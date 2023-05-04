package controllers.models;

import java.util.ArrayList;

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

}

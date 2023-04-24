package controllers.models;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import dao.StudentDAO;
import models.Clazz;
import models.Student;

public class StudentController {

    public static void showStudentsByClass(javax.swing.GroupLayout AlunosPanelLayout, String selectedClazz){
      System.out.println("Qualquer coisa");

      StudentDAO dao = new StudentDAO();
      
      Clazz clazz = new Clazz();
      clazz.setName(selectedClazz);

      ArrayList<Student> studentList = dao.getByClazz(clazz);
      
      for (Student student : studentList) {
        JCheckBox checkbox = new javax.swing.JCheckBox();
        checkbox.setText(student.getName());
        
        JButton button = new javax.swing.JButton();
          button.setText("Editar Aluno");
      
          AlunosPanelLayout.setHorizontalGroup(
              AlunosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(AlunosPanelLayout.createSequentialGroup()
                      .addGap(76, 76, 76)
                      .addComponent(checkbox)
                      .addGap(18, 18, 18)
                      .addComponent(button)
                      .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          AlunosPanelLayout.setVerticalGroup(
              AlunosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(AlunosPanelLayout.createSequentialGroup()
                      .addGap(20, 20, 20)
                      .addGroup(AlunosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                          .addComponent(checkbox)
                          .addComponent(button))
                      .addContainerGap(20, Short.MAX_VALUE))
          );

          

      }
    }

}

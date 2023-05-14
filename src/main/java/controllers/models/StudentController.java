package controllers.models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BotaoEdicaoAlunos.PainelDeAcao;
import dao.ClazzDAO;
import dao.StudentDAO;
import gui.ClienteGUI;
import java.awt.Dimension;
import models.Clazz;
import models.Student;

public class StudentController {

  public static String[] studentListByClazz(){
    StudentDAO dao = new StudentDAO();

    Clazz clazz = new Clazz();

      clazz.setName((String)ClienteGUI.ComboSalas.getSelectedItem());

      ArrayList<Student> list = dao.getByClazz(clazz);

    String students[] = new String[list.size()];

    for(int i = 0; i < list.size(); i++){
        students[i] = list.get(i).getName();
    }
    return students;

  }

  public static void showStudentsByClazz(){
      StudentDAO studentDAO = new StudentDAO();

        Clazz clazz = new Clazz();

        clazz.setName((String)ClienteGUI.ComboSalas.getSelectedItem());


        StudentDAO dao=new StudentDAO();
          ArrayList<Student> lista = dao.getByClazz(clazz);
          int contador=0;
          
          ClienteGUI.painelInserirAlunos.removeAll();
          
          for (Student student:lista){
  
              PainelDeAcao painel=new PainelDeAcao(student);
              
              ClienteGUI.painelInserirAlunos.add(painel);
              contador++;
              
          }
          ClienteGUI.painelInserirAlunos.setPreferredSize(new Dimension(901, 50*contador));
          ClienteGUI.painelInserirAlunos.revalidate();
          ClienteGUI.painelInserirAlunos.repaint();
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
          StudentController.showStudentsByClazz();
      }
    }
      ClienteGUI.ComboAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(StudentController.studentListByClazz()));
  }

    public static void deleteStudent(PainelDeAcao studentPanel){
        if(JOptionPane.showConfirmDialog(null, "Todas as informações serão deletadas", "Deseja excluir esse(a) aluno(a)?", JOptionPane.YES_NO_OPTION) == 0){
          StudentDAO studentDao = new StudentDAO();
          studentDao.delete(studentPanel.student);
          showStudentsByClazz();
        }
    }
}

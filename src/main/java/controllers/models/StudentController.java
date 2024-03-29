package controllers.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import BotaoEdicaoAlunos.PainelDeAcao;
import dao.ClazzDAO;
import dao.GradeDAO;
import dao.StudentDAO;
import gui.ClienteGUI;
import java.awt.Dimension;
import models.Clazz;
import models.Student;

public class StudentController {

    public static void showStudentsByClazz(){

      Clazz clazz = new Clazz();

        clazz.setName((String)ClienteGUI.ComboSalas.getSelectedItem());

      StudentDAO dao=new StudentDAO();
          ArrayList<Student> lista = dao.getByClazz(clazz);
          int contador=0;
          
          ClienteGUI.painelInserirAlunos.removeAll();
          //ClienteGUI.atividadesGui1.painelInserirAlunos.removeAll();
          
          for (Student student:lista){
  
              PainelDeAcao painel=new PainelDeAcao(student);
              //PainelDeAcao2 painel1=new PainelDeAcao2(student);
              painel.getCmdView().setVisible(false);
              //ClienteGUI.atividadesGui1.painelInserirAlunos.add(painel1);
              ClienteGUI.painelInserirAlunos.add(painel);

              contador++;
              
          }

          ClienteGUI.atividadesGui1.painelInserirAlunos.setPreferredSize(new Dimension(901, 50*contador));
          ClienteGUI.atividadesGui1.painelInserirAlunos.revalidate();
          ClienteGUI.atividadesGui1.painelInserirAlunos.repaint();

          ClienteGUI.painelInserirAlunos.setPreferredSize(new Dimension(901, 50*contador));
          ClienteGUI.painelInserirAlunos.revalidate();
          ClienteGUI.painelInserirAlunos.repaint();
         
    }
  
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

    public static void saveStudent() throws SQLException{
      if((ClienteGUI.CadAluno.getText().isEmpty())){
          JOptionPane.showMessageDialog(null, "O campo não pode estar vazio");
      }
      else{
          Student student = new Student();
          student.setName(ClienteGUI.CadAluno.getText());

          StudentDAO studentdao = new StudentDAO();
          studentdao.save(student);
          if(ClienteGUI.ComboSalas.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "escolha ou crie uma sala", null, 0);
          }
          else{

            JOptionPane.showMessageDialog(null,"Aluno "+ClienteGUI.CadAluno.getText()+" cadastrado na turma "+ClienteGUI.ComboSalas.getSelectedItem().toString());
            ClienteGUI.CadAluno.setText("");

            ClazzDAO clazzdao = new ClazzDAO();
            Clazz clazz = clazzdao.getByName(ClienteGUI.ComboSalas.getSelectedItem().toString());
            clazzdao.addStudent(clazz, student);

            clazzdao.closeConn();
            studentdao.closeConn();
            StudentController.showStudentsByClazz();

            GradeDAO gradeDAO = new GradeDAO();
            gradeDAO.initGrade(student, clazz);
            GradesController.insertGradesIntoTable();

          }
          
      }
    }

    public static void deleteStudent(PainelDeAcao studentPanel){
        if(JOptionPane.showConfirmDialog(null, "Todas as informações serão deletadas", "Deseja excluir esse(a) Aluno(a)?", JOptionPane.YES_NO_OPTION) == 0){
            StudentDAO studentDao = new StudentDAO();
            studentDao.delete(studentPanel.student);
            showStudentsByClazz();
        }
    }

    public static void updateStudent(PainelDeAcao studentPanel){
        if(JOptionPane.showConfirmDialog(null, "O nome do Aluno sera editado", "Deseja alterar esse(a) aluno(a)?", JOptionPane.YES_NO_OPTION) == 0){
            StudentDAO studentDao = new StudentDAO();
            studentDao.update(studentPanel.student);
            showStudentsByClazz();
        }
  }

    public static void ShowStudentQuant() throws SQLException {
        ClazzDAO dao = new ClazzDAO();
        Clazz clazz = dao.getByName((String)ClienteGUI.ComboSalas.getSelectedItem());
        StudentDAO studentDAO = new StudentDAO();
        int count = studentDAO.countStudentsFromClass(clazz);
        studentDAO.closeConn();

        ClienteGUI.AlunosTotal.setText("" + count);

    }

}

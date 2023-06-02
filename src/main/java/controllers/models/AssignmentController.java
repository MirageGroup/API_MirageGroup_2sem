package controllers.models;

import BotaoEdicaoAlunos.PainelDeAcao;
import BotaoEdicaoAlunos.PainelDeAcao2;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import dao.AssignmentDAO;
import dao.StudentDAO;
import gui.AtividadesGui;
import gui.ClienteGUI;
import java.awt.Dimension;
import java.util.Iterator;
import models.Assignment;
import models.Clazz;
import models.Student;

public class AssignmentController {
    public static void addAssignment(){


        if(AtividadesGui.nameAssin.getText().isEmpty() || AtividadesGui.iniData.getText().isEmpty() || AtividadesGui.fimData.getText().isEmpty() || AtividadesGui.jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira todas as informações");
            
        }else{
            Assignment assignment = new Assignment();
            if(!AtividadesGui.nameAssin.getText().isEmpty()){
                String name = (AtividadesGui.nameAssin.getText());
                assignment.setName(name);
            }
            if(!AtividadesGui.iniData.getText().isEmpty()){
                String date_assigned = (AtividadesGui.iniData.getText());
                assignment.setDate_assigned(date_assigned);
            }
            if(!AtividadesGui.fimData.getText().isEmpty()){
                String date_due = (AtividadesGui.fimData.getText());
                assignment.setDate_due(date_due);
            }
            if (!AtividadesGui.jTextField1.getText().isEmpty()) {
                int max_grade = Integer.parseInt(AtividadesGui.jTextField1.getText());
                assignment.setMax_grade(max_grade);
            }
            

            AssignmentDAO assignmentDAO = new AssignmentDAO();
            assignmentDAO.save(assignment);
            JOptionPane.showMessageDialog(null, "A atividade foi cadastrada com sucesso!");
            AtividadesGui.nameAssin.setText("");
            AtividadesGui.iniData.setText("");
            AtividadesGui.fimData.setText("");
            AtividadesGui.jTextField1.setText("");

            
        }
    }

    public static String[] GetAllAssignmentName() {
        AssignmentDAO dao = new AssignmentDAO();

        ArrayList<Assignment> list = dao.getAssignments();
        String assignments[] = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            assignments[i] = list.get(i).getName();
        }
        

        return assignments;

    }
    
    public static void showAssignmentsByClazz(){

      Clazz clazz = new Clazz();

        clazz.setName((String)ClienteGUI.ComboSalas.getSelectedItem());

      AssignmentDAO dao = new AssignmentDAO();
          ArrayList<Assignment> list = dao.getAssignments();
          int contador=0;
          
          ClienteGUI.atividadesGui1.painelInserirAlunos.removeAll();
          
          for (Assignment assignment:list){
  
              
              PainelDeAcao2 painel1=new PainelDeAcao2(assignment);
              ClienteGUI.atividadesGui1.painelInserirAlunos.add(painel1);
              

              contador++;
              
          }

          ClienteGUI.atividadesGui1.painelInserirAlunos.setPreferredSize(new Dimension(901, 50*contador));
          ClienteGUI.atividadesGui1.painelInserirAlunos.revalidate();
          ClienteGUI.atividadesGui1.painelInserirAlunos.repaint();

         
    }
}
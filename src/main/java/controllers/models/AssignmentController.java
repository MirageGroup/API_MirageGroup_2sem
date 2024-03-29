package controllers.models;

import BotaoEdicaoAlunos.PainelDeAcao1;
import BotaoEditarAtividade.PainelComEdicao;
import BotaoVisualizacaoAtividade.PainelComVisualizacao;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.ArrayList;
import dao.AssignmentDAO;
import dao.ClazzDAO;
import gui.AtividadesGui;
import gui.ClienteGUI;
import java.awt.Dimension;
import models.Assignment;
import models.Clazz;

public class AssignmentController {
    public static void addAssignment(){
        if(ClienteGUI.ComboSalas.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "escolha ou crie uma sala", null, 0);
        }
        else{
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
                showAssignmentsByClazz();
            }
        }        
    }

    public static void deleteAssignment(PainelDeAcao1 assignmentPanel) {
        if(JOptionPane.showConfirmDialog(null, "Deseja excluir essa atividade?", "Excluir atividade", JOptionPane.YES_NO_OPTION) == 0){
            AssignmentDAO dao = new AssignmentDAO();
            dao.delete(assignmentPanel.assignment);
            showAssignmentsByClazz();
          }
    }

    public static void updateAssignment(PainelComEdicao painelEdicao){
        if(JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações feitas?", "Salvar atividade", JOptionPane.YES_NO_OPTION) == 0){
            painelEdicao.assignment.setName(painelEdicao.AtividadeNomeCampo.getText());
            painelEdicao.assignment.setDescription(painelEdicao.jTextArea1.getText());
            painelEdicao.assignment.setDate_assigned(painelEdicao.DataInicioCampo.getText());
            painelEdicao.assignment.setDate_due(painelEdicao.DataFimCampo.getText());
            painelEdicao.assignment.setMax_grade(Double.parseDouble(painelEdicao.NotaCampo.getText()));
            AssignmentDAO dao = new AssignmentDAO();
            dao.update(painelEdicao.assignment);
            AssignmentController.toggleAssignmentView(null);
        }
    }

    public static String[] GetAllAssignmentName() {
        AssignmentDAO dao = new AssignmentDAO();
        ClazzDAO dao2 = new ClazzDAO();
        Clazz clazz = dao2.getByName(ClienteGUI.ComboSalas.getSelectedItem().toString());

        ArrayList<Assignment> list = dao.getAssignments(clazz);
        String assignments[] = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            assignments[i] = list.get(i).getName();
        }
        

        return assignments;

    }
    
    public static void showAssignmentsByClazz(){

        ClazzDAO dao2 = new ClazzDAO();
        if (ClienteGUI.ComboSalas.getSelectedItem() == null){
        

        }else{
            Clazz clazz = dao2.getByName(ClienteGUI.ComboSalas.getSelectedItem().toString());

        AssignmentDAO dao = new AssignmentDAO();
            ArrayList<Assignment> list = dao.getAssignments(clazz);
            int contador=0;
            
            ClienteGUI.atividadesGui1.painelInserirAlunos.removeAll();
            ClienteGUI.painelInserirAlunos1.removeAll();
            
            for (Assignment assignment:list){
    
                
                PainelDeAcao1 painel2=new PainelDeAcao1(assignment);
                PainelDeAcao1 painel3=new PainelDeAcao1(assignment);
                painel3.getCmdView().setVisible(false);
                painel3.getCmdEditar().setVisible(false);
                painel3.getCmdDelete().setVisible(false);
                painel3.getjCheckBox3().setVisible(false);
                ClienteGUI.atividadesGui1.painelInserirAlunos.add(painel2);
                ClienteGUI.painelInserirAlunos1.add(painel3);
                

                contador++;
                
            }

        ClienteGUI.atividadesGui1.painelInserirAlunos.setPreferredSize(new Dimension(901, 50*contador));
        ClienteGUI.atividadesGui1.painelInserirAlunos.revalidate();
        ClienteGUI.atividadesGui1.painelInserirAlunos.repaint();
        
        ClienteGUI.painelInserirAlunos1.setPreferredSize(new Dimension(901, 50*contador));
        ClienteGUI.painelInserirAlunos1.revalidate();
        ClienteGUI.painelInserirAlunos1.repaint();
        }
        

         
    }

    public static void toggleAssignmentView(PainelDeAcao1 painel){
        JPanel painelAlunos = ClienteGUI.atividadesGui1.painelInserirAlunos;
        if(painel != null){
            painelAlunos.removeAll();
            painelAlunos.repaint();
            painelAlunos.add(new PainelComVisualizacao(painel.assignment));
        }else{
            painelAlunos.removeAll();
            painelAlunos.repaint();
            AssignmentController.showAssignmentsByClazz();
        }
    }

    public static void toggleAssignmentEdit(PainelDeAcao1 painel){
        JPanel painelAlunos = ClienteGUI.atividadesGui1.painelInserirAlunos;
        if(painel != null){
            painelAlunos.removeAll();
            painelAlunos.repaint();
            painelAlunos.add(new PainelComEdicao(painel.assignment));
        }else{
            painelAlunos.removeAll();
            painelAlunos.repaint();
            AssignmentController.showAssignmentsByClazz();
        }
    }
        
}
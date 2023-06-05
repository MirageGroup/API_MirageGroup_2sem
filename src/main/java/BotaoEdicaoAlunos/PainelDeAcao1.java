package BotaoEdicaoAlunos;



import javax.swing.JCheckBox;
import javax.swing.JPanel;

import BotaoVisualizacaoAtividade.PainelComVisualizacao;
import controllers.models.AssignmentController;
import dao.AssignmentDAO;
import gui.ClienteGUI;
import models.Assignment;



public class PainelDeAcao1 extends javax.swing.JPanel {

    public AcaoBotao getCmdDelete() {
        return cmdDelete;
    }

    public AcaoBotao getCmdEditar() {
        return cmdEditar;
    }

    public JCheckBox getjCheckBox3() {
        return jCheckBox3;
    }
    
    public AcaoBotao getCmdView() {
        return cmdView;
    }
    
    

public Assignment assignment;

    public PainelDeAcao1(Assignment assignment) {
       this.assignment=assignment;
       initComponents();
       jTextField1.setText(assignment.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        cmdEditar = new BotaoEdicaoAlunos.AcaoBotao();
        cmdDelete = new BotaoEdicaoAlunos.AcaoBotao();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        cmdView = new BotaoEdicaoAlunos.AcaoBotao();

        jCheckBox2.setText("jCheckBox2");

        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotaoEdicaoAlunos/edit.png"))); // NOI18N
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
            }
        });

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotaoEdicaoAlunos/delete.png"))); // NOI18N
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotaoEdicaoAlunos/view.png"))); // NOI18N
        cmdView.setToolTipText("");
        cmdView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdViewActionPerformed
        AssignmentController.toggleAssignmentView(this);
    }//GEN-LAST:event_cmdViewActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        AssignmentController.deleteAssignment(this);
    }

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        if(jCheckBox3.isSelected()){
            jTextField1.setEditable(true);
        }
        else{
            jTextField1.setEditable(false);
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BotaoEdicaoAlunos.AcaoBotao cmdDelete;
    private BotaoEdicaoAlunos.AcaoBotao cmdEditar;
    private BotaoEdicaoAlunos.AcaoBotao cmdView;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

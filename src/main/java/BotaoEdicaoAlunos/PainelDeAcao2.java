package BotaoEdicaoAlunos;


import controllers.models.StudentController;
import javax.swing.JCheckBox;
import models.Student;


public class PainelDeAcao2 extends javax.swing.JPanel {

    public AcaoBotao getCmdDelete() {
        return cmdDelete;
    }

    public AcaoBotao getCmdEditar() {
        return cmdEditar;
    }

    public JCheckBox getjCheckBox3() {
        return jCheckBox3;
    }  

    public Student student;

    public PainelDeAcao2(Student student) {
       this.student=student;
       initComponents();
       nota3_area.setText(student.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        cmdEditar = new BotaoEdicaoAlunos.AcaoBotao();
        cmdDelete = new BotaoEdicaoAlunos.AcaoBotao();
        jCheckBox3 = new javax.swing.JCheckBox();
        nota3_area = new javax.swing.JTextField();
        Nome_Area = new javax.swing.JTextField();
        nota2_area = new javax.swing.JTextField();
        nota1_area = new javax.swing.JTextField();
        nota4_area = new javax.swing.JTextField();
        nota5_area = new javax.swing.JTextField();

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

        nota3_area.setEditable(false);
        nota3_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //nota3_areaActionPerformed(evt);
            }
        });

        Nome_Area.setEditable(false);
        Nome_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nome_AreaActionPerformed(evt);
            }
        });

        nota2_area.setEditable(false);
        nota2_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota2_areaActionPerformed(evt);
            }
        });

        nota1_area.setEditable(false);
        nota1_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota1_areaActionPerformed(evt);
            }
        });

        nota4_area.setEditable(false);
        nota4_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota4_areaActionPerformed(evt);
            }
        });

        nota5_area.setEditable(false);
        nota5_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nota5_areaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(nota1_area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nota2_area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nota3_area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nota4_area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nota5_area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(Nome_Area, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(420, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nota3_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nota4_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nota5_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nota2_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nota1_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(8, Short.MAX_VALUE)
                    .addComponent(Nome_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Nome_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nome_AreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nome_AreaActionPerformed

    private void nota2_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota2_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nota2_areaActionPerformed

    private void nota1_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota1_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nota1_areaActionPerformed

    private void nota4_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota4_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nota4_areaActionPerformed

    private void nota5_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nota5_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nota5_areaActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        if(jCheckBox3.isSelected()){
            nota3_area.setEditable(true);
        }
        else{
            nota3_area.setEditable(false);
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nome_Area;
    private BotaoEdicaoAlunos.AcaoBotao cmdDelete;
    private BotaoEdicaoAlunos.AcaoBotao cmdEditar;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JTextField nota1_area;
    private javax.swing.JTextField nota2_area;
    private javax.swing.JTextField nota3_area;
    private javax.swing.JTextField nota4_area;
    private javax.swing.JTextField nota5_area;
    // End of variables declaration//GEN-END:variables

}

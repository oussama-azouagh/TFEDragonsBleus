/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.GUICompetition;

import dao.DAOCompetition;
import dao.DAOTypeCompetition;
import daoMySQL.DAOTypeCompetitionMySQL;
import factory.Factory;
import javax.swing.JFrame;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.ListModelTypeCompetition;
import model.TableModelCompetition;
import presentation.GUICompetition.JDAddCompetition;
import presentation.GUITypeCompetition.JDAddTypeCompetition;
import presentation.GUICompetition.JDUpdateCompetition;
import transfertObject.Competition;
import transfertObject.TypeCompetition;

/**
 *
 * @author MediaMonster
 */
public class JIFCompetition extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFCompetition
     */
    public JIFCompetition() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableCompetition = new JTable(myModelComp);
        jScrollPane2 = new javax.swing.JScrollPane();
        ListTypeCompetition = new javax.swing.JList<>();
        boutonMenu = new javax.swing.JButton();
        labelCompetition = new javax.swing.JLabel();
        labelTypeCompetition = new javax.swing.JLabel();
        boutonAjoutCompetition = new javax.swing.JButton();
        boutonSuppressionCompetition = new javax.swing.JButton();
        boutonModificationCompetition = new javax.swing.JButton();
        boutonAjoutTypeCompetition = new javax.swing.JButton();
        boutonSuppressionTypeCompetition = new javax.swing.JButton();
        boutonModificationTypeCompetition = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(0, 0));

        TableCompetition.setShowGrid(true);
        jScrollPane1.setViewportView(TableCompetition);

        ListTypeCompetition.setModel(myModel);
        jScrollPane2.setViewportView(ListTypeCompetition);

        boutonMenu.setText("Menu ");
        boutonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMenuActionPerformed(evt);
            }
        });

        labelCompetition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCompetition.setText("Competitions");
        labelCompetition.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTypeCompetition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTypeCompetition.setText("Type de Competition");
        labelTypeCompetition.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        boutonAjoutCompetition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boutonAjoutCompetition.setForeground(new java.awt.Color(0, 255, 0));
        boutonAjoutCompetition.setText("+");
        boutonAjoutCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAjoutCompetitionActionPerformed(evt);
            }
        });

        boutonSuppressionCompetition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boutonSuppressionCompetition.setForeground(new java.awt.Color(255, 0, 0));
        boutonSuppressionCompetition.setText("-");
        boutonSuppressionCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSuppressionCompetitionActionPerformed(evt);
            }
        });

        boutonModificationCompetition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boutonModificationCompetition.setForeground(new java.awt.Color(255, 102, 0));
        boutonModificationCompetition.setText("Modifier");
        boutonModificationCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonModificationCompetitionActionPerformed(evt);
            }
        });

        boutonAjoutTypeCompetition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boutonAjoutTypeCompetition.setForeground(new java.awt.Color(0, 255, 0));
        boutonAjoutTypeCompetition.setText("+");
        boutonAjoutTypeCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAjoutTypeCompetitionActionPerformed(evt);
            }
        });

        boutonSuppressionTypeCompetition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boutonSuppressionTypeCompetition.setForeground(new java.awt.Color(255, 0, 0));
        boutonSuppressionTypeCompetition.setText("-");
        boutonSuppressionTypeCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSuppressionTypeCompetitionActionPerformed(evt);
            }
        });

        boutonModificationTypeCompetition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boutonModificationTypeCompetition.setForeground(new java.awt.Color(255, 102, 0));
        boutonModificationTypeCompetition.setText("Modifier");
        boutonModificationTypeCompetition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonModificationTypeCompetitionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(labelCompetition, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTypeCompetition)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boutonMenu)
                        .addGap(80, 80, 80)
                        .addComponent(boutonAjoutCompetition)
                        .addGap(18, 18, 18)
                        .addComponent(boutonSuppressionCompetition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boutonModificationCompetition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutonAjoutTypeCompetition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonSuppressionTypeCompetition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonModificationTypeCompetition))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCompetition)
                            .addComponent(labelTypeCompetition))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boutonAjoutCompetition)
                                .addComponent(boutonSuppressionCompetition)
                                .addComponent(boutonModificationCompetition))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boutonModificationTypeCompetition)
                                .addComponent(boutonSuppressionTypeCompetition)
                                .addComponent(boutonAjoutTypeCompetition))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boutonMenu)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonMenuActionPerformed
        // TODO add your handling code here: Menu
        this.dispose();
    }//GEN-LAST:event_boutonMenuActionPerformed

    private void boutonAjoutTypeCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAjoutTypeCompetitionActionPerformed
        // TODO add your handling code here: ajouter TypeCompetition 
        
        JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
        new JDAddTypeCompetition(parent,"INSERTION D'UN NOUVEAU TYPE DE COMPETITION");
        
       
        // après l'insertion : rafraîchir les données en relisant la BD
        refreshModel(
        );
    }//GEN-LAST:event_boutonAjoutTypeCompetitionActionPerformed

    private void boutonSuppressionTypeCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSuppressionTypeCompetitionActionPerformed
        // TODO add your handling code here: Supprimer
         TypeCompetition typeCompSupp;
        //supp 1correct 2iem non check out ouf bound
        if (ListTypeCompetition.getSelectedIndex() == -1 )
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord un type de competition svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else
        {
            int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer " +
            (String)ListTypeCompetition.getSelectedValue() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION)
            {
                typeCompSupp = myModel.getMyList(ListTypeCompetition.getSelectedIndex());
                boolean ok = daoTypeComp.deleteTypeCompetition(typeCompSupp.getIdTypeCompetition());
                if (!ok)
                    JOptionPane.showMessageDialog(this,"Suppression impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
            }
            // après : rafraîchir la liste
            refreshModel();
        }
    }//GEN-LAST:event_boutonSuppressionTypeCompetitionActionPerformed

    private void boutonModificationTypeCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonModificationTypeCompetitionActionPerformed
        // TODO add your handling code here: Modifier
         TypeCompetition typeCompModif;
        
        if (ListTypeCompetition.getSelectedIndex() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord un type de competition svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else
        {
            String nouvNomTypeComp = JOptionPane.showInputDialog(this,"Entrez le nouveau nom de ce type de competition",(String)ListTypeCompetition.getSelectedValue());
            if (nouvNomTypeComp != null)
            {
                nouvNomTypeComp = nouvNomTypeComp.substring(0, 1).toUpperCase() + nouvNomTypeComp.substring(1);//1ère lettre en majuscule
                typeCompModif = myModel.getMyList(ListTypeCompetition.getSelectedIndex());
                typeCompModif.setNomType(nouvNomTypeComp);
                boolean ok = daoTypeComp.updateTypeCompetition(typeCompModif);
                if (!ok)
                    JOptionPane.showMessageDialog(this,"Modification impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this,"Opération annulée !","Avertissement",JOptionPane.ERROR_MESSAGE);
            // après : rafraîchir la liste
            refreshModel();
        } 
    }//GEN-LAST:event_boutonModificationTypeCompetitionActionPerformed

    private void boutonModificationCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonModificationCompetitionActionPerformed
        // TODO add your handling code here:
        if (TableCompetition.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord une ligne svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            // renvoie l'objet Categorie à passer en paramètre
            Competition comp =myModelComp.getMyList(TableCompetition.convertRowIndexToModel(TableCompetition.getSelectedRow()));
                      
            // récupère la JFrame parente
            JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
            new JDUpdateCompetition(parent, "MODIFICATION D'UNE COMPETITION", comp);
            
            // après la modification : rafraîchir les données en relisant la BD
            refreshModel();
        }
    }//GEN-LAST:event_boutonModificationCompetitionActionPerformed

    private void boutonAjoutCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAjoutCompetitionActionPerformed
        // TODO add your handling code here:
        // récupère la JFrame parente
        JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
        new JDAddCompetition(parent, "INSERTION D'UNE COMPETITION");
        
        // après l'insertion : rafraîchir les données en relisant la BD
        this.refreshModel();
        myModelComp.fireTableDataChanged();
        
        
        ArrayList tmp = myModelComp.getMyList();
         myModelComp.setMyList(tmp);
         myModelComp.fireTableDataChanged();
    }//GEN-LAST:event_boutonAjoutCompetitionActionPerformed

    private void boutonSuppressionCompetitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSuppressionCompetitionActionPerformed
        // TODO add your handling code here:
        //supprimer
         if (TableCompetition.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(null,"Sélectionnez d'abord une ligne svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer " +
                    myModelComp.getValueAt(TableCompetition.convertRowIndexToModel(TableCompetition.getSelectedRow()),0) + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION)
                daoComp.deleteCompetition((int)myModelComp.getValueAt(TableCompetition.convertRowIndexToModel(TableCompetition.getSelectedRow()),0));
            // après la suppression : rafraîchir les données en relisant la BD
            refreshModel();
            myModel.getMyList();
        }
    }//GEN-LAST:event_boutonSuppressionCompetitionActionPerformed

private DAOTypeCompetition daoTypeComp = Factory.getDAOTypeCompetition();
private ListModelTypeCompetition myModel = new ListModelTypeCompetition(daoTypeComp.selectTypeCompetition());

private DAOCompetition daoComp = Factory.getDAOCompetition();
private TableModelCompetition myModelComp = new TableModelCompetition(daoComp.selectCompetition());
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListTypeCompetition;
    private javax.swing.JTable TableCompetition;
    private javax.swing.JButton boutonAjoutCompetition;
    private javax.swing.JButton boutonAjoutTypeCompetition;
    private javax.swing.JButton boutonMenu;
    private javax.swing.JButton boutonModificationCompetition;
    private javax.swing.JButton boutonModificationTypeCompetition;
    private javax.swing.JButton boutonSuppressionCompetition;
    private javax.swing.JButton boutonSuppressionTypeCompetition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCompetition;
    private javax.swing.JLabel labelTypeCompetition;
    // End of variables declaration//GEN-END:variables

        private void refreshModel() {
        myModel.setMyList(daoTypeComp.selectTypeCompetition());
        myModelComp.setMyList(daoComp.selectCompetition());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.GUIStage;

import dao.*;
import factory.*;
import transfertObject.*;
import model.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MediaMonster
 */
public class JIFStage extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFStage
     */
    public JIFStage() {
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
        jTable1 = new JTable(myModel);
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        jTable1.setModel(new model.TableModelStage(daoStage.selectStage()));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);

        /* initialisation des largeurs de colonnes */
        javax.swing.table.TableColumn column = null;
        column = jTable1.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        column = jTable1.getColumnModel().getColumn(1);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(2);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(3);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(4);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(5);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(6);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(7);
        column.setPreferredWidth(150);

        /* jTableApp.setRowSorter(new TableRowSorter(myModel)); */

        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stages");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 255, 0));
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 102, 0));
        jButton4.setText("Modifier");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(103, 103, 103)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // bouton Menu
        this.dispose();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // récupère la JFrame parente
        JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
        new JDAddStage(parent, "INSERTION D'UN STAGE");
        
        // après l'insertion : rafraîchir les données en relisant la BD
        this.refreshModel();
        myModel.fireTableDataChanged();
        
        
        ArrayList tmp = myModel.getMyList();
         myModel.setMyList(tmp);
         myModel.fireTableDataChanged();
            
       
        System.out.println(" ajout test");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        //supprimer
         if (jTable1.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(null,"Sélectionnez d'abord une ligne svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer " +
                    myModel.getValueAt(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()),0) + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION)
                daoStage.deleteStage((int)myModel.getValueAt(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()),0));
            // après la suppression : rafraîchir les données en relisant la BD
            refreshModel();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    /**    
        Stage staModif;
        
        if (jTable1.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord un Stage svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else
        {
            String nouvNomStage = JOptionPane.showInputDialog(this,"Entrez le nouveau nom du Stage",(String)jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            if (nouvNomStage != null)
            {
                nouvNomStage = nouvNomStage.substring(0, 1).toUpperCase() + nouvNomStage.substring(1);//1ère lettre en majuscule
                staModif = myModel.getMyList(jTable1.getSelectedRow());
                staModif.setNom(nouvNomStage);
                boolean ok = daoStage.updateStage(staModif);
                if (!ok)
                    JOptionPane.showMessageDialog(this,"Modification impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this,"Opération annulée !","Avertissement",JOptionPane.ERROR_MESSAGE);
            // après : rafraîchir la liste
            refreshModel();
        }
        * 
        * 
        **/
    if (jTable1.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord une ligne svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            // renvoie l'objet Appareil à passer en paramètre
            Stage sta =myModel.getMyList(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()));
                      
            // récupère la JFrame parente
            JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
            new JDUpdateStage(parent, "MODIFICATION DU STAGE", sta);
            
            // après la modification : rafraîchir les données en relisant la BD
            refreshModel();
            System.out.println(" modif test");
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
   private void refreshModel(){
    myModel.setMyList(daoStage.selectStage());
    
    
    }
    
    private DAOStage daoStage = Factory.getDAOStage();
   private TableModelStage myModel = new model.TableModelStage(daoStage.selectStage());
    
   //corriger erreur 
    /**
     * correct add delete alter
     */
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.GUIEleve;

import dao.DAOAdresse;
import dao.DAOEleve;
import dao.DAOVille;
import daoMySQL.DAOEleveMySQL;
import factory.Factory;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JTable;
import model.TableModelEleve;

/**
 *
 * @author MediaMonster
 */
public class JIFEleve extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFMoniteur
     */
    public JIFEleve() {
        initComponents();
        refreshModel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelEleve = new javax.swing.JLabel();
        boutonEleve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEleve = new JTable(myModel);
        BoutonAjout = new javax.swing.JButton();
        BoutonSuppression = new javax.swing.JButton();
        BoutonModification = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(0, 0));

        LabelEleve.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelEleve.setText("Eleves");
        LabelEleve.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        boutonEleve.setText("Menu");
        boutonEleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonEleveActionPerformed(evt);
            }
        });

        TableEleve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableEleve.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TableEleve);

        BoutonAjout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonAjout.setForeground(new java.awt.Color(0, 255, 0));
        BoutonAjout.setText("+");
        BoutonAjout.setToolTipText("");

        BoutonSuppression.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonSuppression.setForeground(new java.awt.Color(255, 0, 0));
        BoutonSuppression.setText("-");

        BoutonModification.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonModification.setForeground(new java.awt.Color(255, 102, 0));
        BoutonModification.setText("modifier");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boutonEleve)
                        .addGap(86, 86, 86)
                        .addComponent(BoutonAjout)
                        .addGap(18, 18, 18)
                        .addComponent(BoutonSuppression)
                        .addGap(18, 18, 18)
                        .addComponent(BoutonModification))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(LabelEleve))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelEleve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonEleve)
                    .addComponent(BoutonAjout)
                    .addComponent(BoutonSuppression)
                    .addComponent(BoutonModification))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonEleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonEleveActionPerformed
        // bouton precedent
        this.dispose();
    }//GEN-LAST:event_boutonEleveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAjout;
    private javax.swing.JButton BoutonModification;
    private javax.swing.JButton BoutonSuppression;
    private javax.swing.JLabel LabelEleve;
    private javax.swing.JTable TableEleve;
    private javax.swing.JButton boutonEleve;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private DAOEleve daoEleve = Factory.getDAOEleve();
private TableModelEleve myModel = new model.TableModelEleve(daoEleve.selectEleve());

private DAOAdresse daoAdresse = Factory.getDAOAdresse();
private DAOVille daoVille = Factory.getDAOVille();


private void refreshModel(){
    myModel.setMyList(daoEleve.selectEleve());  
    myModel.getMyList().forEach(model->System.out.println(model));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.GUIVille;

import dao.DAOVille;
import factory.Factory;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ListModelVille;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class JIFVille extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFVille
     */
    public JIFVille() {
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

        ScrollPaneVille = new javax.swing.JScrollPane();
        ListVille = new javax.swing.JList<>();
        BoutonMenu = new javax.swing.JButton();
        BoutonAjouter = new javax.swing.JButton();
        BoutonSuppression = new javax.swing.JButton();
        BoutonModification = new javax.swing.JButton();

        setTitle("Ville");
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(0, 0));

        ListVille.setModel(myModel);
        ScrollPaneVille.setViewportView(ListVille);

        BoutonMenu.setText("Menu");
        BoutonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonMenuActionPerformed(evt);
            }
        });

        BoutonAjouter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonAjouter.setForeground(new java.awt.Color(0, 255, 0));
        BoutonAjouter.setText("+");
        BoutonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAjouterActionPerformed(evt);
            }
        });

        BoutonSuppression.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonSuppression.setForeground(new java.awt.Color(255, 0, 0));
        BoutonSuppression.setText("-");
        BoutonSuppression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSuppressionActionPerformed(evt);
            }
        });

        BoutonModification.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonModification.setForeground(new java.awt.Color(255, 102, 0));
        BoutonModification.setText("modifier");
        BoutonModification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonModificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPaneVille, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(BoutonAjouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoutonSuppression)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoutonModification)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneVille, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonMenu)
                    .addComponent(BoutonAjouter)
                    .addComponent(BoutonSuppression)
                    .addComponent(BoutonModification)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonMenuActionPerformed
        // bouton menu
        
        this.dispose();
    }//GEN-LAST:event_BoutonMenuActionPerformed

    private void BoutonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAjouterActionPerformed
        // TODO add your handling code here: Add Ville  
        JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
        new JDAddVille(parent,"INSERTION D'UNE NOUVELLE Ville");
        
       
        // après l'insertion : rafraîchir les données en relisant la BD
        refreshModel(
        );
    }//GEN-LAST:event_BoutonAjouterActionPerformed

    private void BoutonSuppressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSuppressionActionPerformed
        // TODO add your handling code here: Supprimer
         Ville villeSupp;
        //supp 1correct 2iem non check out ouf bound
        if (ListVille.getSelectedIndex() == -1 )
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord une ville svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else
        {
            int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer " +
            (String)ListVille.getSelectedValue() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION)
            {
                villeSupp = myModel.getMyList(ListVille.getSelectedIndex());
                boolean ok = daoVille.deleteVille(villeSupp.getIdVille());
                if (!ok)
                    JOptionPane.showMessageDialog(this,"Suppression impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
            }
            // après : rafraîchir la liste
            refreshModel();
        }
        
    }//GEN-LAST:event_BoutonSuppressionActionPerformed

    private void BoutonModificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModificationActionPerformed
        // TODO add your handling code here: Modifier
         Ville villeModif;
        
        if (ListVille.getSelectedIndex() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord un Local svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else
        {
            String nouvNomVille = JOptionPane.showInputDialog(this,"Entrez le nouveau nom du local",(String)ListVille.getSelectedValue());
            if (nouvNomVille != null)
            {
                nouvNomVille = nouvNomVille.substring(0, 1).toUpperCase() + nouvNomVille.substring(1);//1ère lettre en majuscule
                villeModif = myModel.getMyList(ListVille.getSelectedIndex());
                villeModif.setNom(nouvNomVille);
                boolean ok = daoVille.updateVille(villeModif);
                if (!ok)
                    JOptionPane.showMessageDialog(this,"Modification impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this,"Opération annulée !","Avertissement",JOptionPane.ERROR_MESSAGE);
            // après : rafraîchir la liste
            refreshModel();
        } 
    }//GEN-LAST:event_BoutonModificationActionPerformed

private DAOVille daoVille = Factory.getDAOVille();
    private ListModelVille myModel = new ListModelVille(daoVille.selectVille());
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAjouter;
    private javax.swing.JButton BoutonMenu;
    private javax.swing.JButton BoutonModification;
    private javax.swing.JButton BoutonSuppression;
    private javax.swing.JList<String> ListVille;
    private javax.swing.JScrollPane ScrollPaneVille;
    // End of variables declaration//GEN-END:variables

    private void refreshModel() {
        myModel.setMyList(daoVille.selectVille());
    }
}

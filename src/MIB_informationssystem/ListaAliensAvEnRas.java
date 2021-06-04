/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamd
 */
public class ListaAliensAvEnRas extends javax.swing.JFrame {

    private static InfDB mibdb;
    
    /**
     * Creates new form ListaAliensAvEnRas
     */
    public ListaAliensAvEnRas() {
        initComponents();
        
        try {
            mibdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }
        catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasen mibdb nåddes inte.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taAlienInstanser = new javax.swing.JTextArea();
        lblRas = new javax.swing.JLabel();
        bildRas = new javax.swing.JLabel();
        btnSok = new javax.swing.JButton();
        cbValjRas = new javax.swing.JComboBox<>();
        bildTitel = new javax.swing.JLabel();
        lblTitel = new javax.swing.JLabel();
        btnNollstall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taAlienInstanser.setColumns(20);
        taAlienInstanser.setRows(5);
        jScrollPane1.setViewportView(taAlienInstanser);

        lblRas.setText("Ras: ");

        bildRas.setText("jLabel2");

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        cbValjRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boglodite", "Squid", "Worm" }));

        bildTitel.setText("jLabel1");

        lblTitel.setText("Lista Alienraser");
        lblTitel.setPreferredSize(new java.awt.Dimension(580, 140));

        btnNollstall.setText("Nollställ fönstret");
        btnNollstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNollstallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(bildRas)
                                .addGap(49, 49, 49)
                                .addComponent(lblRas)
                                .addGap(52, 52, 52)
                                .addComponent(cbValjRas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNollstall, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bildTitel))
                        .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(bildTitel))
                    .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRas)
                    .addComponent(bildRas)
                    .addComponent(btnSok)
                    .addComponent(cbValjRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNollstall))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
        
        try{
            String ras = cbValjRas.getSelectedItem().toString();
            String fraga = "SELECT * FROM alien WHERE Alien_ID LIKE (SELECT Alien_ID FROM " + ras + ")";
            
            ArrayList<HashMap<String, String>> alienInstanser = mibdb.fetchRows(fraga);
            String alienInstanserString = OvrigaFunktioner.hashMapArrayListToString(alienInstanser);
            taAlienInstanser.setText(alienInstanserString);
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, "Hämtningen av alieninstansen/instanserna lyckades ej.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnNollstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNollstallActionPerformed
        // TODO add your handling code here:
        taAlienInstanser.setText("");
        
    }//GEN-LAST:event_btnNollstallActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaAliensAvEnRas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAliensAvEnRas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAliensAvEnRas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAliensAvEnRas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAliensAvEnRas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bildRas;
    private javax.swing.JLabel bildTitel;
    private javax.swing.JButton btnNollstall;
    private javax.swing.JButton btnSok;
    private javax.swing.JComboBox<String> cbValjRas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRas;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JTextArea taAlienInstanser;
    // End of variables declaration//GEN-END:variables
}

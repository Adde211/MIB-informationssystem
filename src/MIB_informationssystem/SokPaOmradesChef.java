/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author axelh
 */
public class SokPaOmradesChef extends javax.swing.JFrame {
//deklarerar vår databas objekt
    private InfDB idb;
    
    public SokPaOmradesChef() {
        initComponents();
        //instansiferar vår objekt och kopplar mot DB
         try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
        }
    }
    
    //skapar en metood för att hämta en sträng från databasen
     private String getString(String fraga) {

        try {

            return idb.fetchSingle(fraga);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Något gick fel i hämtadet av data ur databasen");
            return null;
        }
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboOmrade = new javax.swing.JComboBox<>();
        txtWindowName = new javax.swing.JTextField();
        txtWindowTel = new javax.swing.JTextField();
        txtNamn = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtForklaraCombo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Norrland", "Svealand", "Götaland" }));
        comboOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOmradeActionPerformed(evt);
            }
        });

        txtWindowName.setColumns(8);

        txtWindowTel.setColumns(15);

        txtNamn.setText("Namn:");

        txtTelefon.setText("Telefon:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtForklaraCombo.setText("Välj Område:");

        jButton2.setText("Stäng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtForklaraCombo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefon)
                            .addComponent(txtNamn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWindowName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWindowTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txtForklaraCombo))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn)
                    .addComponent(txtWindowName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefon)
                    .addComponent(txtWindowTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOmradeActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_comboOmradeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Skapar en sträng av markerat i comboboxen
         String omrade = comboOmrade.getSelectedItem().toString();
        //Skapar SQL fragan som hämtar omraderschefen
        String fragaNamn = "SELECT namn FROM agent WHERE Agent_ID Like (SELECT agent_ID FROM omradeschef WHERE omrade LIKE (SELECT omrades_ID FROM omrade WHERE benamning LIKE '"+ omrade +"'));";
       //sätter texter i vårt jFormFönster till fragaNamn 
        txtWindowName.setText(getString(fragaNamn));
        //Upprepar koden för telefon
        String fragaTel = "SELECT telefon FROM agent WHERE Agent_ID Like (SELECT agent_ID FROM omradeschef WHERE omrade LIKE (SELECT omrades_ID FROM omrade WHERE benamning LIKE '"+ omrade +"'));";
        txtWindowTel.setText(getString(fragaTel));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Stänger ner vårt fönster
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SokPaOmradesChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SokPaOmradesChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SokPaOmradesChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SokPaOmradesChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SokPaOmradesChef().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboOmrade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel txtForklaraCombo;
    private javax.swing.JLabel txtNamn;
    private javax.swing.JLabel txtTelefon;
    private javax.swing.JTextField txtWindowName;
    private javax.swing.JTextField txtWindowTel;
    // End of variables declaration//GEN-END:variables
}

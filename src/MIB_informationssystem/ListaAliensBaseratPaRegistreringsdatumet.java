/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamd
 */
public class ListaAliensBaseratPaRegistreringsdatumet extends javax.swing.JFrame {
    
    private static InfDB mibdb;

    /**
     * Creates new form ListaAliensBaseratPaRegistreringsdatumet
     */
    public ListaAliensBaseratPaRegistreringsdatumet() {
        initComponents();
        
        try
        {
            mibdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }
        catch (InfException ex)
        {
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

        lblFran = new javax.swing.JLabel();
        bildTidsintervall = new javax.swing.JLabel();
        btnSok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlienInstanser = new javax.swing.JTextArea();
        bildTitel = new javax.swing.JLabel();
        lblTitel = new javax.swing.JLabel();
        btnNollstall = new javax.swing.JButton();
        lblTidsintervallTitel = new javax.swing.JLabel();
        tfAngeDatum1 = new javax.swing.JTextField();
        tfAngeDatum2 = new javax.swing.JTextField();
        lblTill = new javax.swing.JLabel();
        lblFelmeddelande1 = new javax.swing.JLabel();
        lblFelmeddelande2 = new javax.swing.JLabel();
        btnAvsluta1 = new javax.swing.JButton();
        btnAvsluta2 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFran.setText("Från: ");

        bildTidsintervall.setText("jLabel2");

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        taAlienInstanser.setColumns(20);
        taAlienInstanser.setRows(5);
        jScrollPane1.setViewportView(taAlienInstanser);

        bildTitel.setText("jLabel1");

        lblTitel.setText("Lista Aliens Som Har Registrerats Inom Ett Visst Tidsintervall");
        lblTitel.setPreferredSize(new java.awt.Dimension(580, 140));

        btnNollstall.setText("Nollställ fönstret");
        btnNollstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNollstallActionPerformed(evt);
            }
        });

        lblTidsintervallTitel.setText("Ange ett Tidsintervall");

        tfAngeDatum1.setForeground(new java.awt.Color(153, 153, 153));
        tfAngeDatum1.setText("Ange datum");
        tfAngeDatum1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAngeDatum1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAngeDatum1FocusLost(evt);
            }
        });
        tfAngeDatum1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tfAngeDatum1ComponentHidden(evt);
            }
        });

        tfAngeDatum2.setForeground(new java.awt.Color(153, 153, 153));
        tfAngeDatum2.setText("Ange datum");
        tfAngeDatum2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAngeDatum2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAngeDatum2FocusLost(evt);
            }
        });

        lblTill.setText("Till:");

        btnAvsluta1.setText("Avsluta");

        btnAvsluta2.setText("Avsluta");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(bildTitel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnNollstall, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bildTidsintervall)
                                .addGap(49, 49, 49)
                                .addComponent(lblFran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(tfAngeDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFelmeddelande1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(lblTill)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfAngeDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFelmeddelande2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(lblTidsintervallTitel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnAvsluta1)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnAvsluta2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bildTitel))
                        .addGap(23, 23, 23)
                        .addComponent(lblTidsintervallTitel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFran)
                            .addComponent(bildTidsintervall)
                            .addComponent(btnSok)
                            .addComponent(btnNollstall)
                            .addComponent(tfAngeDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTill)
                            .addComponent(tfAngeDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFelmeddelande2, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                            .addComponent(lblFelmeddelande1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnAvsluta1)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnAvsluta2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
        
        boolean isDatum1 = false;
        boolean isDatum2 = false;
        
        
        String datum1 = tfAngeDatum1.getText();
        
        if(datum1.isEmpty())
        {
            lblFelmeddelande1.setText("Skriv in ett datum.");
        }
        else
        {
            if(!Validering.kollaOmEttDatumArGiltigt(datum1).isEmpty())
            {
                String felmeddelande = Validering.kollaOmEttDatumArGiltigt(datum1);
                lblFelmeddelande1.setText(felmeddelande);
            }
            else
            {
                isDatum1 = true;
            }
        }
        
        
        
        String datum2 = tfAngeDatum2.getText();
        
        if(datum2.isEmpty())
        {
            lblFelmeddelande2.setText("Skriv in ett datum.");
        }
        else
        {
            if(!Validering.kollaOmEttDatumArGiltigt(datum1).isEmpty())
            {
                String felmeddelande = Validering.kollaOmEttDatumArGiltigt(datum1);
                lblFelmeddelande1.setText(felmeddelande);
            }
            else
            {
                isDatum2 = true;
            }
        }
        
        
        if(isDatum1 && isDatum2) {
            
            try {
                lblFelmeddelande1.setText("");
                lblFelmeddelande2.setText("");
                
                
                String query = "SELECT * FROM alien WHERE registreringsdatum >= '" + datum1 + "' AND registreringsdatum <= '" + datum2 + "'";
                ArrayList<HashMap<String, String>> alienInstanser = mibdb.fetchRows(query);
                String alienInstanserString = OvrigaFunktioner.hashMapArrayListToString(alienInstanser);
                
                if(alienInstanser == null)
                {
                    taAlienInstanser.setText("Det finns inga utomjordingar som är registrerade mellan de två angivna datumen");
                }
                else
                {
                    taAlienInstanser.setText(alienInstanserString);
                }
                
                
                
            }
            catch(InfException ex) {
                JOptionPane.showMessageDialog(null, "Hämtningen av alieninstansen/instanserna lyckades ej.");
                System.out.println("Internt felmeddelande: " + ex.getMessage());
            }
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnNollstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNollstallActionPerformed
        // TODO add your handling code here:
        taAlienInstanser.setText("");

    }//GEN-LAST:event_btnNollstallActionPerformed

    private void tfAngeDatum1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAngeDatum1FocusGained
        // TODO add your handling code here:
        
        if(tfAngeDatum1.getText().equals("Ange datum")) {
            
            tfAngeDatum1.setText("");
            tfAngeDatum1.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tfAngeDatum1FocusGained

    private void tfAngeDatum1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAngeDatum1FocusLost
        // TODO add your handling code here:
        
        if(tfAngeDatum1.getText().equals("")) {
            
            tfAngeDatum1.setText("Ange datum");
            tfAngeDatum1.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfAngeDatum1FocusLost

    private void tfAngeDatum2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAngeDatum2FocusGained
        // TODO add your handling code here:
        
        if(tfAngeDatum2.getText().equals("Ange datum")) {
            
            tfAngeDatum2.setText("");
            tfAngeDatum2.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tfAngeDatum2FocusGained

    private void tfAngeDatum2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAngeDatum2FocusLost
        // TODO add your handling code here:
        
        if(tfAngeDatum2.getText().equals("")) {
            
            tfAngeDatum2.setText("Ange datum");
            tfAngeDatum2.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfAngeDatum2FocusLost

    private void tfAngeDatum1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tfAngeDatum1ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAngeDatum1ComponentHidden

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        
        new AdminUtomjordingsmeny().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(ListaAliensBaseratPaRegistreringsdatumet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAliensBaseratPaRegistreringsdatumet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAliensBaseratPaRegistreringsdatumet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAliensBaseratPaRegistreringsdatumet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAliensBaseratPaRegistreringsdatumet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bildTidsintervall;
    private javax.swing.JLabel bildTitel;
    private javax.swing.JButton btnAvsluta1;
    private javax.swing.JButton btnAvsluta2;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNollstall;
    private javax.swing.JButton btnSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFelmeddelande1;
    private javax.swing.JLabel lblFelmeddelande2;
    private javax.swing.JLabel lblFran;
    private javax.swing.JLabel lblTidsintervallTitel;
    private javax.swing.JLabel lblTill;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JTextArea taAlienInstanser;
    private javax.swing.JTextField tfAngeDatum1;
    private javax.swing.JTextField tfAngeDatum2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author axelh
 */
public class SokPaAgent extends javax.swing.JFrame {

    //Deklarerar vår list manupelerare
    DefaultListModel listModel;
   private InfDB idb;
   String soktAgent;
    /**
     * Creates new form SokPaAgent
     */
    public SokPaAgent() {
        initComponents();
        showHittad(false);
        lbFel.setVisible(false);
        
        
      //skapar en ny infDB klass mot vår databas
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
        }
     
    }
    
    private void showHittad(boolean hittat){
        
        lbHittatAgent.setVisible(hittat);
        lbVillVisa.setVisible(hittat);
        btnVillVisa.setVisible(hittat);
        textWindowVisaInfo.setVisible(hittat);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtWindowAgentNamn = new javax.swing.JTextField();
        lbSokNamn = new javax.swing.JLabel();
        lbHittatAgent = new javax.swing.JLabel();
        lbVillVisa = new javax.swing.JLabel();
        btnVillVisa = new javax.swing.JButton();
        textWindowVisaInfo = new javax.swing.JTextField();
        lbFel = new javax.swing.JLabel();
        btnAvsluta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtWindowAgentNamn.setColumns(8);

        lbSokNamn.setText("Sök på Agent namn:");

        lbHittatAgent.setText("Hittat agent!");

        lbVillVisa.setText("Vill du visa Agent info?");

        btnVillVisa.setText("JA");
        btnVillVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVillVisaActionPerformed(evt);
            }
        });

        textWindowVisaInfo.setColumns(30);

        lbFel.setText("jLabel1");

        btnAvsluta.setText("Avsluta");
        btnAvsluta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbVillVisa)
                        .addGap(33, 33, 33)
                        .addComponent(btnVillVisa))
                    .addComponent(lbHittatAgent)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSokNamn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWindowAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(lbFel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textWindowVisaInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAvsluta)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSokNamn)
                    .addComponent(txtWindowAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFel))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(lbHittatAgent)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVillVisa)
                    .addComponent(btnVillVisa))
                .addGap(18, 18, 18)
                .addComponent(textWindowVisaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAvsluta)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       /** ArrayList<String> test = new ArrayList<String>();
        test.add("HEEJ");
        test.add("KNAS");
        String testSTring = "df";
        
        listModel = new DefaultListModel();
        
        String[] ar = {"one", "two", "three"};
        JList list = new JList(ar);
        
        listModel.addElement("“item 1fdgdfg");
        listModel.addElement("item 2nldfg");
        
        agentLista.add(list);
        
        agentListaFonster.add(list);
        */
        ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
        String databasfraga = "SELECT * FROM agent;";
        
        try{
            lista = idb.fetchRows(databasfraga);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Det gick inte att hämta Agenter ut databasen, starta om fönstret");
        }
       
       String inputNamn = txtWindowAgentNamn.getText();
       
       boolean find =false;
       
       for (int i = 0; i < lista.size(); i++) {

                //Varje rad sparas till en string via lista.get(index som räknas uppåt)
                //.toString() gör listorna till strings + ett rad byte
                String rad = lista.get(i).toString();
                String rad4 = rad.substring(1, rad.length() - 1);

                //Tarbort resterande tecken så bara namnet är kvar.
                String rad2 = rad.substring(6, 13);
                
                
                if (inputNamn.equals(rad2)){
                    
                showHittad(true);
                soktAgent = rad4;
                find = true;
                //soktAgent = rad.substring(1, rad.length() - 1);
                lbFel.setVisible(false);
                
                }
                
               

                //lägger till varjerad i min textArea.
                

            }
        
       if (find == false){
           
           lbFel.setVisible(true);
           lbFel.setText("Ingen matchning hittades");
       }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVillVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVillVisaActionPerformed
        // TODO add your handling code here:
        textWindowVisaInfo.setText(soktAgent);
        
        
        
        
    }//GEN-LAST:event_btnVillVisaActionPerformed

    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_btnAvslutaActionPerformed

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
            java.util.logging.Logger.getLogger(SokPaAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SokPaAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SokPaAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SokPaAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SokPaAgent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvsluta;
    private javax.swing.JButton btnVillVisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbFel;
    private javax.swing.JLabel lbHittatAgent;
    private javax.swing.JLabel lbSokNamn;
    private javax.swing.JLabel lbVillVisa;
    private javax.swing.JTextField textWindowVisaInfo;
    private javax.swing.JTextField txtWindowAgentNamn;
    // End of variables declaration//GEN-END:variables
}

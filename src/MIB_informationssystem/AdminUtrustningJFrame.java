package MIB_informationssystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.cj.xdevapi.DbDoc;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;

/**
 *
 * @author axelh
 */
public class AdminUtrustningJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminUtrustningJFrame
     */
    private InfDB idb;

    public AdminUtrustningJFrame() {
        initComponents();
// döljer de knappar/fönster/labels vi inte vill ska synas
        döljNyUtrustning();
        lbTillagd.setVisible(false);
        doljTaBort(true);
        btnTillbakaNy.setVisible(false);

        lbBorttagen.setVisible(false);
//skapar en infDB klass mot vår databas
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
        }
    }

    //metod som anropas om det inte är en admin som startar vår JFRame,
    //metoden följer allt som har med tabort utrustning att göra
    public void ejAdmin() {

        txtBortEtt.setVisible(false);
        lbBortEtt.setVisible(false);
        lbBortTvå.setVisible(false);
        comboTaBort.setVisible(false);
        btnTaBort.setVisible(false);
        btnTillbakaTabort.setVisible(false);
        txtArea.setVisible(false);
        btnStorTaBort.setVisible(false);

    }
//vår metod-fråga mot databasen via vår infDB class som behandlar all läggtill scenarion eller insert 

    private void insertDB(String fraga) {

        try {
//strängen sparar fraga till ettfordon frågan
            String ettFordon = fraga;
            // vår label när ngt lyckas insert'as till vår DB visas
            lbTillagd.setVisible(true);
            //vår metod för insert av infDB-klassen
            idb.insert(ettFordon);

        } catch (Exception e) {
//vårt catch scenario om något blir fel i frågan
            JOptionPane.showMessageDialog(null, "Försök igen");
        }
    }
//Vår fråga för att hämta ett enskilt värde från databasen, skapar en egen string metod som 
    //retunerar ett sträng värde genom vårt InfDB-klass objekt idb och om det blir fel i catch scenariot retunerar den null

    private String selectDB(String fraga) {

        try {

            return idb.fetchSingle(fraga);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Försök igen");
            return null;
        }
    }

    private void setTxtArea(String databasfraga) {

        //min fråga skickas via fetchrows
        //Skapar en Arraylist Hashmap för att ta emot min lista från databasen
        //som kmr retuneras av fetchRows() metoden i databas-klassen
        ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();

        try {
            //först nollställer vår text area varjegång den kallas
            txtAreaSkriv.setText("");
//Hämtar vår lista från vår databas genom fetchRows() medoten genom konstruktorns DB fråga databasfraga
            lista = idb.fetchRows(databasfraga);

            //for each loop som går igenom varje objekt i lista, hämtar listan storlek med
            //size() metoden och räknar upp med mitt index i genom i++
            for (int i = 0; i < lista.size(); i++) {

                //Varje rad sparas till en string via lista.get(index som räknas uppåt)
                //.toString() gör listorna till strings + ett rad byte
                String rad = lista.get(i).toString();

                //Tarbort första pch sista tecknet i varje sträng för att ta bort måsvingarna 
                //så det ska se lite snyggare ut via substring metoden (1 börja från 1, hämta strängens
                //längd och -1 för att ta bort sista tecknet. avslutar med \n rad byte
                rad = rad.substring(1, rad.length() - 1) + "\n";

                //lägger till varjerad i min textArea.
                txtAreaSkriv.append(rad);

            }

        } catch (Exception e) {
            //om frågan misslyckas hamnar skickar en popupp ruta fram
            JOptionPane.showMessageDialog(null, "Något gick fel");

        }

    }
//liknade de metoder över skillnaden är att här använder vi idb.delete()för att ta bort ur databasen vid anrop

    private void taBort(String fraga) {

        try {

            String DBfraga = fraga;

            idb.delete(DBfraga);

            lbBorttagen.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Försök igen");
        }

    }
//döljer de knappar och objekt som har med NyUtrustning att göra 

    private void döljNyUtrustning() {

        ntbOKutrustning.setVisible(false);
        btnVäljUtrustning.setVisible(false);

        txtNyEtt.setVisible(false);
        txtNyTvå.setVisible(false);
        txtNyTre.setVisible(false);
        txtNyFyra.setVisible(false);

        // Ger de namnen jag vill
        lbNyEtt.setVisible(false);
        lbNyTvå.setVisible(false);
        lbNyTre.setVisible(false);
        lbNyFyra.setVisible(false);

    }
//Sätter våra textboxan till tomma, via denna setText metoden som finns i textFieldKlassen

    private void cleartxtWindow() {

        txtNyEtt.setText("");
        txtNyTvå.setText("");
        txtNyTre.setText("");
        txtNyFyra.setText("");

    }
//metod för att ta dölja ta bort Jframe objekt som har med ta bort knappen att göra

    private void doljTaBort(boolean tabort) {

        //utropsteknet är omvänt "tecken"
        // skickar ju redan in boolean tabort är antingenen true/false
        //och efteroms vi 
        txtBortEtt.setVisible(!tabort);
        lbBortEtt.setVisible(!tabort);
        lbBortTvå.setVisible(!tabort);
        comboTaBort.setVisible(!tabort);
        btnTaBort.setVisible(!tabort);
        btnTillbakaTabort.setVisible(!tabort);
        txtArea.setVisible(!tabort);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnNyUtrustning = new javax.swing.JButton();
        btnVäljUtrustning = new javax.swing.JComboBox<>();
        btnStorTaBort = new javax.swing.JButton();
        ntbOKutrustning = new javax.swing.JButton();
        txtNyEtt = new javax.swing.JTextField();
        txtNyTvå = new javax.swing.JTextField();
        txtNyTre = new javax.swing.JTextField();
        txtNyFyra = new javax.swing.JTextField();
        lbNyEtt = new javax.swing.JLabel();
        lbNyTre = new javax.swing.JLabel();
        lbNyTvå = new javax.swing.JLabel();
        lbNyFyra = new javax.swing.JLabel();
        lbTillagd = new javax.swing.JLabel();
        comboTaBort = new javax.swing.JComboBox<>();
        btnTaBort = new javax.swing.JButton();
        txtBortEtt = new javax.swing.JTextField();
        lbBorttagen = new javax.swing.JLabel();
        lbBortEtt = new javax.swing.JLabel();
        lbBortTvå = new javax.swing.JLabel();
        btnTillbakaTabort = new javax.swing.JButton();
        btnTillbakaNy = new javax.swing.JButton();
        btnAvsluta = new javax.swing.JButton();
        txtArea = new javax.swing.JScrollPane();
        txtAreaSkriv = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNyUtrustning.setText("Ny utrustning");
        btnNyUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyUtrustningActionPerformed(evt);
            }
        });

        btnVäljUtrustning.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Typ", "Utrustning", "Kommunikation", "Fordon", "Teknik", "Vapen" }));
        btnVäljUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVäljUtrustningActionPerformed(evt);
            }
        });

        btnStorTaBort.setText("Ta bort Utrustning");
        btnStorTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStorTaBortActionPerformed(evt);
            }
        });

        ntbOKutrustning.setText("OK");
        ntbOKutrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntbOKutrustningActionPerformed(evt);
            }
        });

        txtNyEtt.setColumns(8);

        txtNyTvå.setColumns(8);

        txtNyTre.setColumns(8);
        txtNyTre.setText("ÅÅÅÅ-MM-DD");

        txtNyFyra.setColumns(8);

        lbNyFyra.setToolTipText("");

        lbTillagd.setText("Utrustning Tillagd!");

        comboTaBort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Typ", "Utrustning", "Kommunikation", "Fordon", "Teknik", "Vapen" }));
        comboTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTaBortActionPerformed(evt);
            }
        });

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        txtBortEtt.setColumns(8);

        lbBorttagen.setText("Utrustning bort tagen!");

        lbBortEtt.setText("Utrustnings ID:");

        btnTillbakaTabort.setText("Tillbaka");
        btnTillbakaTabort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaTabortActionPerformed(evt);
            }
        });

        btnTillbakaNy.setText("Tillbaka");
        btnTillbakaNy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaNyActionPerformed(evt);
            }
        });

        btnAvsluta.setText("Avsluta");
        btnAvsluta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaActionPerformed(evt);
            }
        });

        txtAreaSkriv.setColumns(20);
        txtAreaSkriv.setRows(5);
        txtArea.setViewportView(txtAreaSkriv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(342, 342, 342)
                                .addComponent(lbBortTvå))
                            .addComponent(comboTaBort, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbBortEtt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBortEtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnTaBort))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbBorttagen)
                                .addGap(18, 18, 18)
                                .addComponent(btnTillbakaTabort)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnStorTaBort, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(btnNyUtrustning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbTillagd)
                                    .addComponent(btnVäljUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(ntbOKutrustning)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNyTre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNyTre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNyEtt)
                                        .addGap(7, 7, 7)
                                        .addComponent(txtNyEtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNyFyra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNyFyra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNyTvå)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNyTvå, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(btnTillbakaNy)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAvsluta)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNyUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTillagd))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVäljUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ntbOKutrustning)
                                    .addComponent(txtNyEtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNyTvå, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNyEtt)
                                    .addComponent(lbNyTvå))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNyTre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNyFyra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNyTre)
                                    .addComponent(lbNyFyra))))
                        .addGap(18, 18, 18)
                        .addComponent(btnTillbakaNy)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStorTaBort, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBortEtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbBortEtt)
                                    .addComponent(btnTaBort))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbBorttagen)
                                    .addComponent(btnTillbakaTabort)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboTaBort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(lbBortTvå))))
                    .addComponent(txtArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnAvsluta)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNyUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyUtrustningActionPerformed
        // Visar min combobox för att välja typ av utrustning
        lbTillagd.setVisible(false);
        btnVäljUtrustning.setVisible(true);
    }//GEN-LAST:event_btnNyUtrustningActionPerformed

    private void btnStorTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStorTaBortActionPerformed
        // TODO add your handling code here:
        doljTaBort(false);
    }//GEN-LAST:event_btnStorTaBortActionPerformed

    private void btnVäljUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVäljUtrustningActionPerformed
        // Strängen sparar vad som finns i vår Jframecombobox
        // till string utrustning

        String utrustning = btnVäljUtrustning.getSelectedItem().toString();
//följande if scenarion visar de knappar/labels/textfields som tillhör respektive utrustning
        if ("Fordon".equals(utrustning)) {

            //Visar de labels jag vill
            txtNyEtt.setVisible(true);
            txtNyTvå.setVisible(true);
            txtNyTre.setVisible(true);
            txtNyFyra.setVisible(true);
            lbNyEtt.setVisible(true);
            lbNyTvå.setVisible(true);
            lbNyTre.setVisible(true);
            lbNyFyra.setVisible(true);
            ntbOKutrustning.setVisible(true);
            btnTillbakaNy.setVisible(true);

            // Ger de namnen jag vill till labels
            lbNyEtt.setText("Fordons ID:");
            lbNyTvå.setText("Fordonsbeskrivning:");
            lbNyTre.setText("Registreringsdatum:");
            lbNyFyra.setText("Årsmodell:");
            txtNyTre.setText("ÅÅÅÅ-MM-DD");

        }

        if ("Kommunikation".equals(utrustning)) {

            //Visar de labels jag vill
            txtNyEtt.setVisible(true);
            txtNyTvå.setVisible(true);
            txtNyTre.setVisible(false);
            txtNyFyra.setVisible(false);
            ntbOKutrustning.setVisible(true);
            btnTillbakaNy.setVisible(true);

            // Ger de namnen jag vill och döljer 3 samt 4
            lbNyEtt.setText("Utrustnings_ID:");
            lbNyTvå.setText("Överforingsteknik:");
            lbNyTre.setVisible(false);
            lbNyFyra.setVisible(false);
            lbNyEtt.setVisible(true);
            lbNyTvå.setVisible(true);
        }

        if ("Teknik".equals(utrustning)) {

            //Visar de labels jag vill
            txtNyEtt.setVisible(true);
            txtNyTvå.setVisible(true);
            txtNyTre.setVisible(false);
            txtNyFyra.setVisible(false);
            ntbOKutrustning.setVisible(true);
            btnTillbakaNy.setVisible(true);

            // Ger de namnen jag vill
            lbNyEtt.setText("Utrustnings_ID:");
            lbNyTvå.setText("Kraftkalla:");
            lbNyTre.setVisible(false);
            lbNyFyra.setVisible(false);
            lbNyEtt.setVisible(true);
            lbNyTvå.setVisible(true);

        }

        if ("Utrustning".equals(utrustning)) {

            //Visar de labels jag vill
            txtNyEtt.setVisible(true);
            txtNyTvå.setVisible(true);
            txtNyTre.setVisible(false);
            txtNyFyra.setVisible(false);
            ntbOKutrustning.setVisible(true);

            // Ger de namnen jag vill
            lbNyEtt.setText("Utrustnings_ID:");
            lbNyTvå.setText("Benämning:");
            lbNyTre.setVisible(false);
            lbNyFyra.setVisible(false);
            lbNyEtt.setVisible(true);
            lbNyTvå.setVisible(true);
            btnTillbakaNy.setVisible(true);

        }

        if ("Vapen".equals(utrustning)) {

            //Visar de labels jag vill
            txtNyEtt.setVisible(true);
            txtNyTvå.setVisible(true);
            txtNyTre.setVisible(false);
            txtNyFyra.setVisible(false);
            ntbOKutrustning.setVisible(true);

            // Ger de namnen jag vill
            lbNyEtt.setText("Utrustnings_ID:");
            lbNyTvå.setText("Kaliber:");
            lbNyTre.setVisible(false);
            lbNyFyra.setVisible(false);
            lbNyEtt.setVisible(true);
            lbNyTvå.setVisible(true);
            btnTillbakaNy.setVisible(true);
        }

        if ("Välj Typ".equals(utrustning)) {
            txtNyEtt.setVisible(false);
            txtNyTvå.setVisible(false);
            txtNyTre.setVisible(false);
            txtNyFyra.setVisible(false);
            ntbOKutrustning.setVisible(false);
            btnTillbakaNy.setVisible(true);

            // Ger de namnen jag vill
            lbNyEtt.setVisible(false);
            lbNyTvå.setVisible(false);
            lbNyTre.setVisible(false);
            lbNyFyra.setVisible(false);

        }

    }//GEN-LAST:event_btnVäljUtrustningActionPerformed

    private void ntbOKutrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntbOKutrustningActionPerformed
        // A Spara comboboxens text till sträng
        // B Spara varje string användaren matat inn
        // D insert fråga till databasen

        //A)
        String utrustning = btnVäljUtrustning.getSelectedItem().toString();
//B)
        String txtEtt = txtNyEtt.getText();
        String txtTvå = txtNyTvå.getText();
        String txtTre = txtNyTre.getText();
        String txtFyra = txtNyFyra.getText();

        //D) varje if scenario skickar in specifika SQL frågor som ändras visa sparade string värdet vi 
        //hämtar från våra textfields, 
        if ("Fordon".equals(utrustning)) {

            String input = "INSERT INTO fordon VALUES ('" + txtEtt + "','" + txtTvå + "','" + txtTre + "', '" + txtFyra + "');";

            JOptionPane.showMessageDialog(null, "frågan  " + input);
//metoden insertDB anropas med vår spefika SQL-fråga sparat i ett string input
            insertDB(input);

        }
// Stegen som ovan if (fordon) scenariot repeteras  rad 591  
        if ("Kommunikation".equals(utrustning)) {

            String input = "INSERT INTO kommunikation VALUES ('" + txtEtt + "','" + txtTvå + "');";

            insertDB(input);

        }
// Stegen som ovan if (fordon) scenariot repeteras  rad 591 
        if ("Teknik".equals(utrustning)) {

            String input = "INSERT INTO teknik VALUES ('" + txtEtt + "','" + txtTvå + "');";

            insertDB(input);

        }
// Stegen som ovan if (fordon) scenariot repeteras  rad 591 
        if ("Utrustning".equals(utrustning)) {

            String input = "INSERT INTO utrustning VALUES ('" + txtEtt + "','" + txtTvå + "');";

            insertDB(input);

        }
        // Stegen som ovan if (fordon) scenariot repeteras  rad 591 
        if ("Vapen".equals(utrustning)) {

            String input = "INSERT INTO vapen VALUES ('" + txtEtt + "','" + txtTvå + "');";

            insertDB(input);

        }
// När det är klar rensar vi våra textrutor cleartxtWindow samt döljer utrustnings jframeobjekten döljNyUtrustning
        döljNyUtrustning();
        cleartxtWindow();


    }//GEN-LAST:event_ntbOKutrustningActionPerformed

    private void comboTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTaBortActionPerformed
        // Sparar vår valda text i vår combobox till sträng utrustning,
        String utrustning = comboTaBort.getSelectedItem().toString();

        //Om fordon Väljs i comboListan ska även alla forddon visas i text rutan
        if ("Fordon".equals(utrustning)) {

            //Sätter Texten Till Fordons ID:
            lbBortEtt.setText("Fordons ID:");
            //Väljer att visa alla mina knappar genom färdig metod (högre upp finns den)
            doljTaBort(false);

            //min databasFråga
            String databasfraga = "SELECT * FROM fordon;";
//här anropar vi vår metod setTxtArea för att skriva ut alla object som finns sparade i fordons tabelleln
            setTxtArea(databasfraga);

        }
//upprepar steg som första if-scenariot rad 644 av denna metod, med skillnad att byta av setText och 
//SQL -frågan manuellt ändrats för olika val i vår combox
        if ("Kommunikation".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");
            doljTaBort(false);

            //min databasFråga
            String databasfraga = "SELECT * FROM Kommunikation;";

            setTxtArea(databasfraga);
        }
        //upprepar steg som första if-scenariot rad 644 av denna metod, med skillnad att byta av setText och 
//SQL -frågan manuellt ändrats för olika val i vår combox

        if ("Teknik".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");
            doljTaBort(false);

            String databasfraga = "SELECT * FROM Teknik;";

            setTxtArea(databasfraga);
        }
        //upprepar steg som första if-scenariot rad 644 av denna metod, med skillnad att byta av setText och 
//SQL -frågan manuellt ändrats för olika val i vår combox

        if ("Utrustning".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");
            doljTaBort(false);

            String databasfraga = "SELECT * FROM Utrustning;";

            setTxtArea(databasfraga);
        }
        //upprepar steg som första if-scenariot rad 644 av denna metod, med skillnad att byta av setText och 
//SQL -frågan manuellt ändrats för olika val i vår combox

        if ("Vapen".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");
            doljTaBort(false);

            String databasfraga = "SELECT * FROM Vapen;";

            setTxtArea(databasfraga);

        }
        //när Välj Typ-väljs tav vi bara inmatnings rutor och labels
        if ("Välj Typ".equals(utrustning)) {

            txtBortEtt.setVisible(false);

            lbBortEtt.setVisible(false);
            lbBortTvå.setVisible(false);
            comboTaBort.setVisible(true);
            btnTaBort.setVisible(false);
            btnTillbakaTabort.setVisible(false);

        }


    }//GEN-LAST:event_comboTaBortActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        // hämtar texten från vår combobox
        String utrustning = comboTaBort.getSelectedItem().toString();

        //if-scenariot kollar vad som är valti comboboxen  
        if ("Fordon".equals(utrustning)) {
            //ändrar texten i vår label för att matcha vald utrustning
            lbBortEtt.setText("Fordons ID:");
            //hämtar vår text användaern skriver inn i vår textField
            String ID = txtBortEtt.getText();
            //frågar om någon agent har fordonet genom ID'et vi sparat
            //hämtar all data i tabellen där vi har matchande ID
            String fraga = "SELECT * FROM innehar_fordon WHERE Fordons_ID ='" + ID + "';";
            //skickar frågan
            String svar = selectDB(fraga);
            //har agenten ett fordon länkat till sig så vill vi ta bort länken, då startas if 
            //om svaret inte retuneras null

            if (svar != null) {
                //då tar vi bort länken som finns via ID
                fraga = "DELETE FROM innehar_fordon WHERE Fordons_ID = '" + ID + "';";
//anropar vår tabortmetod och utrustningsID vi vet tillhör någon agent
                taBort(fraga);

            }
            //Nu tar vi bort fordonet  

            fraga = "DELETE FROM Fordon WHERE fordons_ID = '" + ID + "';";

            taBort(fraga);

            //Uppdaterar vår textArea med alla fordons som finns tillgängliga
            String databasfraga = "SELECT * FROM fordon;";

            setTxtArea(databasfraga);

        }
//Stegen upprepas som första IF-senariot i metoden, se rad 724. Alla steg utom det inre IF -scenariot 
//då denna inte har en innehar_tabell länkat till sig så ingen agent har på sig denna utrusting ,
//Då behöver vi inte kolla nån annan tabell för att ta bort utrustning
        if ("Kommunikation".equals(utrustning)) {

            lbBortEtt.setText("Utrustnings ID:");

            String ID = txtBortEtt.getText();

            String fraga = "DELETE FROM kommunikation WHERE Utrustnings_ID = '" + ID + "';";

            taBort(fraga);

            //min databasFråga
            String databasfraga = "SELECT * FROM Kommunikation;";

            setTxtArea(databasfraga);

        }
//Stegen upprepas som första IF-senariot i metoden, se rad 724. Alla steg utom det inre IF -scenariot 
//då denna inte har en innehar_tabell länkat till sig så ingen agent har på sig denna utrusting ,
//Då behöver vi inte kolla nån annan tabell för att ta bort utrustning
        if ("Teknik".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");

            String ID = txtBortEtt.getText();

            String fraga = "DELETE FROM teknik WHERE Utrustnings_ID = '" + ID + "';";

            taBort(fraga);

            String databasfraga = "SELECT * FROM Teknik;";

            setTxtArea(databasfraga);
        }
//Stegen upprepas som första IF-senariot i metoden, se rad 724.
        if ("Utrustning".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");

            String ID = txtBortEtt.getText();

            String fraga = "SELECT * FROM innehar_utrustning WHERE Utrustnings_ID ='" + ID + "';";
            //skickar frågan
            String svar = selectDB(fraga);
            //har aget ett utrustning länkat till sig så vill vi ta bort länken, då startas if 
            if (svar != null) {
                //då tar vi bort länken
                fraga = "DELETE FROM innehar_utrustning WHERE Utrustnings_ID = '" + ID + "';";

                taBort(fraga);

            }

            fraga = "DELETE FROM utrustning WHERE Utrustnings_ID = " + ID + ";";

            taBort(fraga);

            String databasfraga = "SELECT * FROM Utrustning;";

            setTxtArea(databasfraga);
        }
//Stegen upprepas som första IF-senariot i metoden, se rad 724. Alla steg utom det inre IF -scenariot 
//då denna inte har en innehar_tabell länkat till sig så ingen agent har på sig denna utrusting ,
//Då behöver vi inte kolla nån annan tabell för att ta bort utrustning
        if ("Vapen".equals(utrustning)) {
            lbBortEtt.setText("Utrustnings ID:");

            String ID = txtBortEtt.getText();

            String fraga = "DELETE FROM vapen WHERE Utrustnings_ID = '" + ID + "';";

            taBort(fraga);

            String databasfraga = "SELECT * FROM Vapen;";

            setTxtArea(databasfraga);

        }

    }//GEN-LAST:event_btnTaBortActionPerformed

    private void btnTillbakaTabortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaTabortActionPerformed
        // Väljer vilka JFRame-objekt som ska visas, detta fall döljer via tillbaka knappen
        doljTaBort(true);
        lbBorttagen.setVisible(false);

    }//GEN-LAST:event_btnTillbakaTabortActionPerformed

    private void btnTillbakaNyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaNyActionPerformed
        // Väljer vilka jFrame-objekt som ska visas, datta fall döljer via tillbaka knappen

        döljNyUtrustning();

        btnTillbakaNy.setVisible(false);
    }//GEN-LAST:event_btnTillbakaNyActionPerformed

    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // Stänger ner vår ruta
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
            java.util.logging.Logger.getLogger(AdminUtrustningJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUtrustningJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUtrustningJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUtrustningJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUtrustningJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvsluta;
    private javax.swing.JButton btnNyUtrustning;
    private javax.swing.JButton btnStorTaBort;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JButton btnTillbakaNy;
    private javax.swing.JButton btnTillbakaTabort;
    private javax.swing.JComboBox<String> btnVäljUtrustning;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboTaBort;
    private javax.swing.JLabel lbBortEtt;
    private javax.swing.JLabel lbBortTvå;
    private javax.swing.JLabel lbBorttagen;
    private javax.swing.JLabel lbNyEtt;
    private javax.swing.JLabel lbNyFyra;
    private javax.swing.JLabel lbNyTre;
    private javax.swing.JLabel lbNyTvå;
    private javax.swing.JLabel lbTillagd;
    private javax.swing.JButton ntbOKutrustning;
    private javax.swing.JScrollPane txtArea;
    private javax.swing.JTextArea txtAreaSkriv;
    private javax.swing.JTextField txtBortEtt;
    private javax.swing.JTextField txtNyEtt;
    private javax.swing.JTextField txtNyFyra;
    private javax.swing.JTextField txtNyTre;
    private javax.swing.JTextField txtNyTvå;
    // End of variables declaration//GEN-END:variables
}

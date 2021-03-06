import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class kisiListesi extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form kisiListesi
     */
    public kisiListesi() {
        
        initComponents();
        tabloyudoldur();
    }
    
    
    public void tabloyudoldur() 
    {
          model=(DefaultTableModel)tblogrenciler.getModel(); 
          model.setRowCount(0); 
        try {
            ArrayList<ogrenci> ogrenciler=getOgrenciler();
            for(ogrenci ogr: ogrenciler )
            {
                Object[] row={ogr.getId(),ogr.getName(),ogr.getSurname(),ogr.getPassword(),ogr.getTCKN()};
                model.addRow(row);
                        }
                    } catch (SQLException ex) {
            
        }
    }
    
    
    public ArrayList<ogrenci> getOgrenciler() throws SQLException{
    Connection connection=null;
    dbHelper db=new dbHelper();//bizim diğerleri javanın kendi sınıfı biz kullandık. 
    Statement statement =null;
    ResultSet resultSet;
     ArrayList<ogrenci> ogrenciler =null;
    
    try{
        connection=db.getConnection();
        statement = connection.createStatement();
        resultSet=statement.executeQuery("select * from kayitliogrenciler");//select listeler veri tabanındakileri
        ogrenciler=new ArrayList<ogrenci>();
        
       while(resultSet.next())
     {
          ogrenciler.add(new ogrenci  
                ( resultSet.getInt("ID") , 
                  resultSet.getString("NAME") , 
                  resultSet.getString("SURNAME"),
                  resultSet.getInt("password"),
                 resultSet.getInt("TCKN")
                ));
     }
        
        
    }catch(SQLException exception)
     {
        
     }finally
    {
        statement.close();
        connection.close();
    }
    return ogrenciler;
            
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        siralabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblogrenciler = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        kaydolbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soyadiniztxt = new javax.swing.JTextField();
        sifreniztxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        adiniztxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tctxt = new javax.swing.JTextField();
        dilekistekyonetici = new javax.swing.JButton();
        duyurueklebtn = new javax.swing.JToggleButton();
        kat1btn = new javax.swing.JButton();
        kat2btn = new javax.swing.JButton();
        kat3btn = new javax.swing.JButton();
        kat4btn = new javax.swing.JButton();
        kat5btn = new javax.swing.JButton();
        kat6btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        siralabel.setBackground(new java.awt.Color(153, 153, 255));

        tblogrenciler.setBackground(new java.awt.Color(255, 255, 204));
        tblogrenciler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "surname", "password", "TCKN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblogrenciler);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblSearch.setText("ARAMA İFADESİ:");
        lblSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblSearchKeyReleased(evt);
            }
        });

        kaydolbutton.setBackground(new java.awt.Color(153, 153, 255));
        kaydolbutton.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        kaydolbutton.setText("KAYDET");
        kaydolbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydolbuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel1.setText("SOYADI:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setText("ŞİFRE:");

        soyadiniztxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soyadiniztxtActionPerformed(evt);
            }
        });

        sifreniztxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifreniztxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel5.setText("ADI:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setText("SIRA NUMARASI:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel4.setText("TCKN:");

        dilekistekyonetici.setBackground(new java.awt.Color(153, 153, 255));
        dilekistekyonetici.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        dilekistekyonetici.setText("DİLEK İSTEK VE ŞİKAYETLERİ GÖRÜNTÜLE");
        dilekistekyonetici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dilekistekyoneticiActionPerformed(evt);
            }
        });

        duyurueklebtn.setBackground(new java.awt.Color(153, 153, 255));
        duyurueklebtn.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        duyurueklebtn.setText("DUYURU EKLE ");
        duyurueklebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duyurueklebtnActionPerformed(evt);
            }
        });

        kat1btn.setText("KAT-1");
        kat1btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat1btnActionPerformed(evt);
            }
        });

        kat2btn.setText("KAT-2");
        kat2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat2btnActionPerformed(evt);
            }
        });

        kat3btn.setText("KAT-3");
        kat3btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat3btnActionPerformed(evt);
            }
        });

        kat4btn.setText("KAT-4");
        kat4btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat4btnActionPerformed(evt);
            }
        });

        kat5btn.setText("KAT-5");
        kat5btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat5btnActionPerformed(evt);
            }
        });

        kat6btn.setText("KAT-6");
        kat6btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat6btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout siralabelLayout = new javax.swing.GroupLayout(siralabel);
        siralabel.setLayout(siralabelLayout);
        siralabelLayout.setHorizontalGroup(
            siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(siralabelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dilekistekyonetici)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(duyurueklebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(siralabelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(siralabelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(soyadiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(siralabelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(215, 215, 215)))
                        .addGap(82, 82, 82))
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sifreniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                        .addComponent(kaydolbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                        .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))
                        .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kat1btn)
                            .addComponent(kat4btn)
                            .addComponent(kat5btn)
                            .addComponent(kat6btn)
                            .addComponent(kat2btn)
                            .addComponent(kat3btn))
                        .addGap(12, 12, 12))))
        );
        siralabelLayout.setVerticalGroup(
            siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, siralabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(kat1btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat2btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat3btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat4btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kat5btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat6btn)
                        .addGap(10, 10, 10))
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(siralabelLayout.createSequentialGroup()
                        .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(13, 13, 13))
                    .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(soyadiniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sifreniztxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(28, 28, 28)
                .addComponent(kaydolbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(siralabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dilekistekyonetici, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duyurueklebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(siralabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(siralabel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey=txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter=new TableRowSorter<DefaultTableModel>(model);
        tblogrenciler.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void lblSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSearchKeyReleased

    }//GEN-LAST:event_lblSearchKeyReleased

    private void kaydolbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydolbuttonActionPerformed
        Connection connection=null;
        dbHelper dbhelper=new dbHelper();
        PreparedStatement statement = null;

        try
        {
            connection=dbhelper.getConnection();
            String sql="insert into kayitliogrenciler (id,name,surname,password,TCKN) values(?,?,?,?,?)";

            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.valueOf( idtxt.getText()));
            statement.setString(2,adiniztxt.getText() );
            statement.setString(3,soyadiniztxt.getText());
            statement.setInt(4,Integer.valueOf( sifreniztxt.getText()));
            statement.setInt(5, Integer.valueOf( tctxt.getText()));
            int result=statement.executeUpdate();
            tabloyudoldur();
        }catch(SQLException exception ){
            dbhelper.showErrorMessage(exception);
        }finally{
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_kaydolbuttonActionPerformed

    private void soyadiniztxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soyadiniztxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soyadiniztxtActionPerformed

    private void sifreniztxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifreniztxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sifreniztxtActionPerformed

    private void dilekistekyoneticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dilekistekyoneticiActionPerformed
        dilekistekyonetici di = new dilekistekyonetici ();
        di.setVisible(true);
    }//GEN-LAST:event_dilekistekyoneticiActionPerformed

    private void duyurueklebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duyurueklebtnActionPerformed
        duyuruyonetici dy = new duyuruyonetici();
        dy.setVisible(true);
    }//GEN-LAST:event_duyurueklebtnActionPerformed

    private void kat1btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat1btnActionPerformed
        kat1veli k1 = new kat1veli();
        k1.setVisible(true);
    }//GEN-LAST:event_kat1btnActionPerformed

    private void kat2btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat2btnActionPerformed
         kat2veli k2 = new kat2veli();
         k2.setVisible(true);
    }//GEN-LAST:event_kat2btnActionPerformed

    private void kat3btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat3btnActionPerformed
         kat3veli k3 = new kat3veli();
         k3.setVisible(true);
    }//GEN-LAST:event_kat3btnActionPerformed

    private void kat4btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat4btnActionPerformed
        kat4veli k4 = new kat4veli();
        k4.setVisible(true);
    }//GEN-LAST:event_kat4btnActionPerformed

    private void kat5btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat5btnActionPerformed
        kat5veli k5 = new kat5veli();
        k5.setVisible(true);
    }//GEN-LAST:event_kat5btnActionPerformed

    private void kat6btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat6btnActionPerformed
        kat6veli k6 = new kat6veli();
        k6.setVisible(true);
    }//GEN-LAST:event_kat6btnActionPerformed

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
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kisiListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kisiListesi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adiniztxt;
    private javax.swing.JButton dilekistekyonetici;
    private javax.swing.JToggleButton duyurueklebtn;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kat1btn;
    private javax.swing.JButton kat2btn;
    private javax.swing.JButton kat3btn;
    private javax.swing.JButton kat4btn;
    private javax.swing.JButton kat5btn;
    private javax.swing.JButton kat6btn;
    private javax.swing.JButton kaydolbutton;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextField sifreniztxt;
    private javax.swing.JPanel siralabel;
    private javax.swing.JTextField soyadiniztxt;
    private javax.swing.JTable tblogrenciler;
    private javax.swing.JTextField tctxt;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

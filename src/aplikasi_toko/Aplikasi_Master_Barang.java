/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_toko;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author cosnors
 */
public class Aplikasi_Master_Barang extends javax.swing.JFrame {
koneksi kon = new koneksi();
private Object [] [] databarang=null;
private String [] label = {"Kode Barang","Nama Barang","Harga Jual","Stok"};
    /**
     * Creates new form Aplikasi_Master_Barang
     */
    public Aplikasi_Master_Barang() {
        initComponents();
        kon.setKoneksi();
        BacaTabelBarang();
    }
     private void BacaTabelBarang()
    {
        try{
            String sql="Select * From barang order by kd_brg";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            databarang=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                databarang[x][0]=kon.rs.getString("kd_brg");
                databarang[x][1]=kon.rs.getString("nm_brg");
                databarang[x][2]=kon.rs.getString("hrg_jual");
                databarang[x][3]=kon.rs.getString("stok");
                x++;
            }
            tbl_brg.setModel(new DefaultTableModel(databarang,label));
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        private void BacaTabelProdukCari()
        {
            try{
                String sql="Select *From barang where nm_brg like '%"+tcari.getText()+"%'";
                kon.rs=kon.st.executeQuery(sql);
                ResultSetMetaData m=kon.rs.getMetaData();
                int kolom=m.getColumnCount();
                int baris=0;
                while(kon.rs.next()){
                    baris=kon.rs.getRow();
            }
                databarang=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                databarang[x][0]=kon.rs.getString("kd_brg");
                databarang[x][1]=kon.rs.getString("nm_brg");
                databarang[x][2]=kon.rs.getString("hrg_jual");
                databarang[x][3]=kon.rs.getString("stok");
                x++;
        }
            tbl_brg.setModel(new DefaultTableModel(databarang,label));
    }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
        private void SetTabel()
        {
            int row=tbl_brg.getSelectedRow();
            tkd_brg.setText((String)tbl_brg.getValueAt(row, 0));
            tnm_brg.setText((String)tbl_brg.getValueAt(row, 1));
            thrg_jual.setText((String)tbl_brg.getValueAt(row, 2));
            tstok.setText((String)tbl_brg.getValueAt(row, 0));
        }
        private void Bersih()
        {
            tkd_brg.setText("");
            tnm_brg.setText("");
            thrg_jual.setText("");
            tstok.setText("");
        }
        private void aktif()
        {
            tkd_brg.setEnabled(true);
            tnm_brg.setEnabled(true);
            thrg_jual.setEnabled(true);
            tstok.setEnabled(true);
        }
        private void nonaktif()
        {
             tkd_brg.setEnabled(false);
            tnm_brg.setEnabled(false);
            thrg_jual.setEnabled(false);
            tstok.setEnabled(false);
        }
        private void SimpanData()
        {
            try{
                String sql="insert into barang values('"+tkd_brg.getText()+"',"
                        +"'"+tnm_brg.getText()+"','"+thrg_jual.getText()+"',"
                        +"'"+tstok.getText()+"')";
                kon.st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                Bersih();
                BacaTabelBarang();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        private void UpdateData()
        {
            try{
                String sql = "update barang set kd_brg='"+tkd_brg.getText()+"',"
                        +"nm_brg='"+tnm_brg.getText()+"',"
                        +"hrg_jual='"+thrg_jual.getText()+"',"
                        +"stok='"+tstok.getText()+"' where kd_brg='"+tkd_brg.getText()+"'";
                kon.st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"data berhasil diedit");
                Bersih();
                BacaTabelBarang();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        private void HapusData()
        {
            try{
                String sql="delete from barang where kd_brg'"+tkd_brg.getText()+"'";
                kon.st.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                Bersih();
                BacaTabelBarang();
            }
            catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_brg = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tkd_brg = new javax.swing.JTextField();
        tnm_brg = new javax.swing.JTextField();
        thrg_jual = new javax.swing.JTextField();
        tstok = new javax.swing.JTextField();
        bt_tambah = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("TABEL DATA BARANG");

        jLabel2.setText("Cari Barang");

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });

        tbl_brg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_brg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_brgMouseClicked(evt);
            }
        });
        tbl_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_brgKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_brg);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("INPUT DATA BARANG");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA BARANG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N

        jLabel4.setText("Kode Barang");

        jLabel5.setText("Nama Barang");

        jLabel6.setText("Harga Jual");

        jLabel7.setText("Stok");

        tkd_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_brgKeyPressed(evt);
            }
        });

        tnm_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnm_brgKeyPressed(evt);
            }
        });

        thrg_jual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thrg_jualKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tstok, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thrg_jual, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(thrg_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_tambah.setText("tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_keluar.setText("keluar");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bt_tambah)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_keluar))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel3)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_keluar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   nonaktif();
   BacaTabelBarang();
    }//GEN-LAST:event_formWindowActivated

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        if(bt_keluar.getText().equals("keluar"))
   {
       dispose();
   }
   else if(bt_keluar.getText().equals("batal"))
   {
       Bersih();
       nonaktif();
       bt_keluar.setText("keluar");
       bt_tambah.setText("tambah");
     }
              
    }//GEN-LAST:event_bt_keluarActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
    if(bt_tambah.getText().equals("tambah"))
        {   
        bt_tambah.setText("simpan");
        bt_keluar.setText("batal");
        Bersih();
        aktif();
        tkd_brg.requestFocus();
        }
   else if(bt_tambah.getText().equals("simpan"))
        {
           SimpanData();
           BacaTabelBarang();
           bt_tambah.setText("tambah");
           bt_keluar.setText("keluar");
           Bersih();
           nonaktif();
        }
   else if(bt_tambah.getText().equals("update"))
           {
           UpdateData();
           BacaTabelBarang();
           bt_tambah.setText("tambah");
           bt_keluar.setText("keluar");
           Bersih();
           nonaktif();
           }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void tkd_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_brgKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          try{
              String sql ="Select *from barang where kd_brg='"+tkd_brg.getText()+"'";
              kon.rs=kon.st.executeQuery(sql);
              if (kon.rs.next()){
                  tkd_brg.setEnabled(false);
                  tkd_brg.setText(kon.rs.getString("kd_brg"));
                  tnm_brg.setText(kon.rs.getString("nm_brg"));
                  thrg_jual.setText(kon.rs.getString("hrg_jual"));
                  tstok.setText(kon.rs.getString("stok"));
                  bt_tambah.setText("update");
              }else{
                  tnm_brg.requestFocus();
              }
          }catch (SQLException e){
              JOptionPane.showMessageDialog(null, e);
          }
         }
    }//GEN-LAST:event_tkd_brgKeyPressed

    private void tnm_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnm_brgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           thrg_jual.requestFocus();
       }
    }//GEN-LAST:event_tnm_brgKeyPressed

    private void thrg_jualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thrg_jualKeyPressed
          if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tstok.requestFocus();
        }
    }//GEN-LAST:event_thrg_jualKeyPressed

    private void tbl_brgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_brgMouseClicked
        SetTabel();

    }//GEN-LAST:event_tbl_brgMouseClicked

    private void tbl_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_brgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           HapusData();
       }
    }//GEN-LAST:event_tbl_brgKeyPressed

    private void tcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyTyped
        // TODO add your handling code here:
        kon.setKoneksi();
        BacaTabelProdukCari();
    }//GEN-LAST:event_tcariKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Master_Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_brg;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField thrg_jual;
    private javax.swing.JTextField tkd_brg;
    private javax.swing.JTextField tnm_brg;
    private javax.swing.JTextField tstok;
    // End of variables declaration//GEN-END:variables

}

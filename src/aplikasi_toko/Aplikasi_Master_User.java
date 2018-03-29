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
public class Aplikasi_Master_User extends javax.swing.JFrame {
koneksi kon = new koneksi();
private Object [] [] datauser=null;
private String [] label = {"Kode User","Nama User","Password","Level"};
    /**
     * Creates new form Aplikasi_Master_user
     */
    public Aplikasi_Master_User() {
        initComponents();
        kon.setKoneksi();
        BacaTabelUser();
    }
     private void BacaTabelUser()
    {
        try{
            String sql="Select * From user order by kd_user";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datauser=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datauser[x][0]=kon.rs.getString("kd_user");
                datauser[x][1]=kon.rs.getString("nama_user");
                datauser[x][2]=kon.rs.getString("password");
                datauser[x][3]=kon.rs.getString("level");
                x++;
            }
            tbl_user.setModel(new DefaultTableModel(datauser,label));
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        private void BacaTabelProdukCari()
        {
            try{
                String sql="Select *From user where nama_user like '%"+tcari.getText()+"%'";
                kon.rs=kon.st.executeQuery(sql);
                ResultSetMetaData m=kon.rs.getMetaData();
                int kolom=m.getColumnCount();
                int baris=0;
                while(kon.rs.next()){
                    baris=kon.rs.getRow();
            }
                datauser=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datauser[x][0]=kon.rs.getString("kd_user");
                datauser[x][1]=kon.rs.getString("nama_user");
                datauser[x][2]=kon.rs.getString("password");
                datauser[x][3]=kon.rs.getString("level");
                x++;
        }
            tbl_user.setModel(new DefaultTableModel(datauser,label));
    }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
        private void SetTabel()
        {
            int row=tbl_user.getSelectedRow();
            tkd_user.setText((String)tbl_user.getValueAt(row, 0));
            tnama_user.setText((String)tbl_user.getValueAt(row, 1));
            tpassword.setText((String)tbl_user.getValueAt(row, 2));
            tlevel.setText((String)tbl_user.getValueAt(row, 0));
        }
        private void Bersih()
        {
            tkd_user.setText("");
            tnama_user.setText("");
            tpassword.setText("");
            tlevel.setText("");
        }
        private void aktif()
        {
            tkd_user.setEnabled(true);
            tnama_user.setEnabled(true);
            tpassword.setEnabled(true);
            tlevel.setEnabled(true);
        }
        private void nonaktif()
        {
             tkd_user.setEnabled(false);
            tnama_user.setEnabled(false);
            tpassword.setEnabled(false);
            tlevel.setEnabled(false);
        }
        private void SimpanData()
        {
            try{
                String sql="insert into user values('"+tkd_user.getText()+"',"
                        +"'"+tnama_user.getText()+"','"+tpassword.getText()+"',"
                        +"'"+tlevel.getText()+"')";
                kon.st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                Bersih();
                BacaTabelUser();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        private void UpdateData()
        {
            try{
                String sql = "update user set kd_user='"+tkd_user.getText()+"',"
                        +"nama_user='"+tnama_user.getText()+"',"
                        +"password='"+tpassword.getText()+"',"
                        +"level='"+tlevel.getText()+"' where kd_user='"+tkd_user.getText()+"'";
                kon.st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"data berhasil diedit");
                Bersih();
                BacaTabelUser();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        private void HapusData()
        {
            try{
                String sql="delete from user where kd_user'"+tkd_user.getText()+"'";
                kon.st.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                Bersih();
                BacaTabelUser();
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

        jLabel2 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tkd_user = new javax.swing.JTextField();
        tnama_user = new javax.swing.JTextField();
        tpassword = new javax.swing.JTextField();
        tlevel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel2.setText("Cari Nama");

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        tbl_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_userKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA USER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N

        jLabel4.setText("Kode User");

        jLabel5.setText("Nama User");

        jLabel6.setText("Password");

        jLabel7.setText("Akses Level");

        tkd_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_userKeyPressed(evt);
            }
        });

        tnama_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnama_userKeyPressed(evt);
            }
        });

        tpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tpasswordKeyPressed(evt);
            }
        });

        jLabel1.setText("[1.Admin 2.Kasir]");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(tpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkd_user, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tkd_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tnama_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tlevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_keluar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_keluar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   nonaktif();
   BacaTabelUser();
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
        tkd_user.requestFocus();
        }
   else if(bt_tambah.getText().equals("simpan"))
        {
           SimpanData();
           BacaTabelUser();
           bt_tambah.setText("tambah");
           bt_keluar.setText("keluar");
           Bersih();
           nonaktif();
        }
   else if(bt_tambah.getText().equals("update"))
           {
           UpdateData();
           BacaTabelUser();
           bt_tambah.setText("tambah");
           bt_keluar.setText("keluar");
           Bersih();
           nonaktif();
           }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void tkd_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_userKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          try{
              String sql ="Select *from user where kd_user='"+tkd_user.getText()+"'";
              kon.rs=kon.st.executeQuery(sql);
              if (kon.rs.next()){
                  tkd_user.setEnabled(false);
                  tkd_user.setText(kon.rs.getString("kd_user"));
                  tnama_user.setText(kon.rs.getString("nama_user"));
                  tpassword.setText(kon.rs.getString("password"));
                  tlevel.setText(kon.rs.getString("level"));
                  bt_tambah.setText("update");
              }else{
                  tnama_user.requestFocus();
              }
          }catch (SQLException e){
              JOptionPane.showMessageDialog(null, e);
          }
         }
    }//GEN-LAST:event_tkd_userKeyPressed

    private void tnama_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnama_userKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           tpassword.requestFocus();
       }
    }//GEN-LAST:event_tnama_userKeyPressed

    private void tpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpasswordKeyPressed
          if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tlevel.requestFocus();
        }
    }//GEN-LAST:event_tpasswordKeyPressed

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        SetTabel();

    }//GEN-LAST:event_tbl_userMouseClicked

    private void tbl_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_userKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           HapusData();
       }
    }//GEN-LAST:event_tbl_userKeyPressed

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
            java.util.logging.Logger.getLogger(Aplikasi_Master_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Master_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_user;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tkd_user;
    private javax.swing.JTextField tlevel;
    private javax.swing.JTextField tnama_user;
    private javax.swing.JTextField tpassword;
    // End of variables declaration//GEN-END:variables

}

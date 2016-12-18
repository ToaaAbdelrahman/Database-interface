import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import static com.oracle.util.Checksums.update;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
class updateEmployeesII  extends javax.swing.JFrame {

    /**
     * Creates new form conn
     */
    public updateEmployeesII() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        p1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        update = new javax.swing.JButton();
         jTextField1 = new javax.swing.JTextField();
         jLabel1=new javax.swing.JLabel();

        jButton1.setText("update");

       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "name", "Phone", "DOB","JOB","Salary"
            }
        ));
        jScrollPane2.setViewportView(p1);

        jButton2.setText("submit");
        update.setText("Update");
        update.setVisible(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
           
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
           
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
           
        });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jButton2)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       DefaultTableModel model=( DefaultTableModel)p1.getModel();
       try
       {     
                   try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","root");
        String IDString=jTextField1.getText();
        int empID=Integer.parseInt(IDString);
        Statement stmt=con.createStatement();
        String query="select * from employee where id_employee='"+empID+"'" ;
        ResultSet rs=stmt.executeQuery(query);
   
        while(rs.next())
        {
            int sr=rs.getInt("id_employee");
            String Chemical=rs.getString("name_employee");
            int manu=rs.getInt("phone_no");
            String man=rs.getString("date_of_birth");
            String j=rs.getString("job");
            int s = rs.getInt("salary");

            model.addRow(new Object[]{sr,Chemical,manu,man,j,s});
        }
        rs.close();
        stmt.close();
        con.close();
        
    }//GEN-LAST:event_jButton2ActionPerformed
catch(Exception e)
{
   
    e.printStackTrace();
}
}
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int Did =Integer.parseInt(p1.getModel().getValueAt(0, 0).toString());
        float salary =Float.parseFloat(p1.getModel().getValueAt(0, 5).toString());
        
        try{
              try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
               String IDString=jTextField1.getText();
        int drugID=Integer.parseInt(IDString);
                Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","root");
                  Statement stmt=con.createStatement();
        String test="update employee set salary = '"+salary+"'where id_employee='"+Did+"'";
          stmt.executeUpdate(test);
          JOptionPane.showMessageDialog(null, "updated successfully", "SUCCESS " , JOptionPane.INFORMATION_MESSAGE);
          dispose();       
      
}
        
  catch(Exception e)
{
   
    e.printStackTrace();
}} 
 private void updateActionPerformed(java.awt.event.ActionEvent evt){
      new updateDrugs().setVisible(true);
 
 }
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
            java.util.logging.Logger.getLogger(connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new connection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton update;
   
    private javax.swing.JTable p1;
       private javax.swing.JTextField jTextField1;
        private javax.swing.JLabel jLabel1;
          private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}


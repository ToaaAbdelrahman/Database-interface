import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
public class drug_companies  extends javax.swing.JFrame{

    public drug_companies() {
        initComponents();
         jButton2ActionPerformed();

    }
   private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable p1;
    private void initComponents() {
           jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        p1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cid", "name", "address"
            }
        ));
        jScrollPane1.setViewportView(p1);

        jButton2.setText("find the company which makes ...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }

               private void jButton2ActionPerformed(ActionEvent evt) {
                    new make2().setVisible(true);
}
               });
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton2ActionPerformed() {
 DefaultTableModel model=( DefaultTableModel)p1.getModel();
       try
       {     
                   try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","root");
        Statement stmt=con.createStatement();
        String query="select* from drug_companies where cid in(select cid from contacts where pid=1);";
        ResultSet rs=stmt.executeQuery(query);
   
        while(rs.next())
        {
            String sr=rs.getString("cid");
            String Chemical=rs.getString("name");
            String manu=rs.getString("address");
           // String man=rs.getString("type");
            model.addRow(new Object[]{sr,Chemical,manu});
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
    
}

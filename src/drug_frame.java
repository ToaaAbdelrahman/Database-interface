
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class drug_frame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public drug_frame() {
        initComponents();
        show_users_in_Jtable();
    }
    public Connection getConnection()
    {
        Connection con;
        try
        {
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","root");
             return con;
        }
        catch(Exception e)
{
    System.out.println("Something went wrong");
    return null;
}
    }
    
    public ArrayList<drug> getUsersList()
    {
         ArrayList<drug> usersList= new ArrayList<drug>() ;
         Connection connection=getConnection();
         String query="select drug.Did,name,price,type from drug,contain where drug.Did=contain.did And pid=1;";
       //  String query="select * from drug;";
                  Statement st;
                  ResultSet rs;
                  
                  try
                  {
                     st=connection.createStatement();
                     rs=st.executeQuery(query);
                     drug U;
                     while(rs.next())
                     {
                       U=new drug(rs.getInt("Did"),rs.getString("name"),rs.getInt("price"),rs.getString("type"));
                       usersList.add(U);
                     }
                     
                  }
                  catch(Exception e)
{
    System.out.println("Something went wrong");
    
}
                  return usersList;
    }
    
    
    public void show_users_in_Jtable()
    {
        ArrayList<drug> List=getUsersList();
        DefaultTableModel model=( DefaultTableModel)jTable1_Display_user.getModel();
        Object [] row=new Object[4];
        for(int i=0;i<List.size();i++)
        {
            row[0]=List.get(i).getdid();
            row[1]=List.get(i).getname();
            row[2]=List.get(i).getprice();
            row[3]=List.get(i).gettype();
            model.addRow(row);
        }
        
    }
    public void executesqlQuery(String query,String msg)
    {
     Connection con=getConnection();
     Statement st;
     ResultSet rs;
     try
     {
         st=con.createStatement(); 
         if("inserted".equals(msg))
              {
                    Connection connection=getConnection();
                    String query1="select* from drug where Did ='"+jTextField1_Did.getText()+"';";
                     st=connection.createStatement();
                     rs=st.executeQuery(query1);
                    // if( jTextField1_Did.getText().equals(c))
                    if(rs.next()!=false)
                             {
                                  String query2=("insert into contain (pid,did)values(1,'"+jTextField1_Did.getText()+"');");
                                  st.executeUpdate(query2);
                             
                    
               DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
             show_users_in_Jtable();
             JOptionPane.showMessageDialog(null,"Data "+msg+" Succesfully");
             }
                     else{
                          st.executeUpdate(query);
                           query1=("insert into contain (pid,did)values(1,'"+jTextField1_Did.getText()+"');");
                           st.executeUpdate(query1);
                            DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
             show_users_in_Jtable();
             JOptionPane.showMessageDialog(null,"Data "+msg+" Succesfully");
                     }
              }
  else   if(st.executeUpdate(query)==1 )
         {
             //rfresh table
             DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
             show_users_in_Jtable();
             JOptionPane.showMessageDialog(null,"Data "+msg+" Succesfully");
             
         }
        
         else
         {
             JOptionPane.showMessageDialog(null,"Data Not "+msg);
         }
             
     }
     catch(Exception e)
{
   JOptionPane.showMessageDialog(null,"Data Not "+msg);
    
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1_Did = new javax.swing.JTextField();
        jTextField2_name = new javax.swing.JTextField();
        jTextField3_price = new javax.swing.JTextField();
        jTextField4_type = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_Display_user = new javax.swing.JTable();
        jButton1_insert = new javax.swing.JButton();
        jButton2_update = new javax.swing.JButton();
        jButton3_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1_sort_by_name = new javax.swing.JButton();
        jButton1_sort_bye_price = new javax.swing.JButton();
        jButton1_sort_by_type = new javax.swing.JButton();
        jButton1_sort_by_Did = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("name:");

        jLabel5.setText("price:");

        jLabel6.setText("type:");

        jTextField1_Did.setBackground(new java.awt.Color(255, 204, 153));

        jTextField2_name.setBackground(new java.awt.Color(255, 204, 153));

        jTextField3_price.setBackground(new java.awt.Color(255, 204, 153));

        jTextField4_type.setBackground(new java.awt.Color(255, 204, 153));

        jTable1_Display_user.setBackground(new java.awt.Color(204, 153, 255));
        jTable1_Display_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Did", "name", "price", "type"
            }
        ));
        jTable1_Display_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_Display_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_Display_user);

        jButton1_insert.setBackground(new java.awt.Color(0, 102, 0));
        jButton1_insert.setForeground(new java.awt.Color(240, 240, 240));
        jButton1_insert.setText("insert");
        jButton1_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_insertActionPerformed(evt);
            }
        });

        jButton2_update.setBackground(new java.awt.Color(0, 0, 153));
        jButton2_update.setForeground(new java.awt.Color(240, 240, 240));
        jButton2_update.setText("update");
        jButton2_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_updateActionPerformed(evt);
            }
        });

        jButton3_delete.setBackground(new java.awt.Color(255, 0, 0));
        jButton3_delete.setForeground(new java.awt.Color(240, 240, 240));
        jButton3_delete.setText("delete");
        jButton3_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Did:");

        jButton1_sort_by_name.setBackground(new java.awt.Color(102, 0, 102));
        jButton1_sort_by_name.setForeground(new java.awt.Color(240, 240, 240));
        jButton1_sort_by_name.setText("sort");
        jButton1_sort_by_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_sort_by_nameActionPerformed(evt);
            }
        });

        jButton1_sort_bye_price.setBackground(new java.awt.Color(102, 0, 102));
        jButton1_sort_bye_price.setForeground(new java.awt.Color(240, 240, 240));
        jButton1_sort_bye_price.setText("sort");
        jButton1_sort_bye_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_sort_bye_priceActionPerformed(evt);
            }
        });

        jButton1_sort_by_type.setBackground(new java.awt.Color(102, 0, 102));
        jButton1_sort_by_type.setForeground(new java.awt.Color(240, 240, 240));
        jButton1_sort_by_type.setText("sort");
        jButton1_sort_by_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_sort_by_typeActionPerformed(evt);
            }
        });

        jButton1_sort_by_Did.setBackground(new java.awt.Color(102, 0, 102));
        jButton1_sort_by_Did.setForeground(new java.awt.Color(240, 240, 240));
        jButton1_sort_by_Did.setText("sort");
        jButton1_sort_by_Did.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_sort_by_DidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2_update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addComponent(jButton3_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1_Did, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2_name, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(jTextField3_price)
                                .addComponent(jTextField4_type)))))
                .addGap(18, 88, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1_sort_by_Did)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1_sort_by_name)
                        .addGap(51, 51, 51)
                        .addComponent(jButton1_sort_bye_price)
                        .addGap(49, 49, 49)
                        .addComponent(jButton1_sort_by_type)
                        .addGap(50, 50, 50))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1_Did, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField3_price, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4_type, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)))
                .addComponent(jButton1_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2_update, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton3_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1_sort_by_Did, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1_sort_by_name)
                        .addComponent(jButton1_sort_bye_price)
                        .addComponent(jButton1_sort_by_type)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1_Display_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_Display_userMouseClicked
        // TODO add your handling code here:
        //Display selected row in textfileds
        int i=jTable1_Display_user.getSelectedRow();
        TableModel model=jTable1_Display_user.getModel();
        jTextField1_Did.setText(String.valueOf(model.getValueAt(i,0)));
        jTextField2_name.setText(String.valueOf(model.getValueAt(i,1)));
        jTextField3_price.setText(String.valueOf(model.getValueAt(i,2)));
        jTextField4_type.setText(String.valueOf(model.getValueAt(i,3)));
    }//GEN-LAST:event_jTable1_Display_userMouseClicked

    private void jButton1_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_insertActionPerformed
        // TODO add your handling code here:
        
         String query=
       (" insert into drug(Did, name, price, type) values('"+jTextField1_Did.getText()+"','"+jTextField2_name.getText()+"','"+jTextField3_price.getText()+"','"+jTextField4_type.getText()+"');");
        executesqlQuery(query,"inserted");  
    }//GEN-LAST:event_jButton1_insertActionPerformed

    private void jButton2_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_updateActionPerformed
        // TODO add your handling code here:
        String query=
        ("update drug set price ='"+jTextField3_price.getText()+"',name='"+jTextField2_name.getText()+"',type='"+jTextField4_type.getText()+"' Where Did ="+jTextField1_Did.getText()+";");
        executesqlQuery(query,"updated");
    }//GEN-LAST:event_jButton2_updateActionPerformed

    private void jButton3_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_deleteActionPerformed
        // TODO add your handling code here:
        String query="DELETE FROM contain where pid=1 And Did= "+jTextField1_Did.getText();
         executesqlQuery(query,"deleted");
    }//GEN-LAST:event_jButton3_deleteActionPerformed

    private void jButton1_sort_by_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_sort_by_nameActionPerformed
        // TODO add your handling code here:
        
        String query="select DISTINCT name,Did,price,type from drug order by name";
        ArrayList<drug> usersList2= new ArrayList<drug>() ;
         Connection connection=getConnection();
         // String query="select drug.Did,name,price,type from drug,contain where drug.Did=contain.did And pid=1;";
         
                  Statement st;
                  ResultSet rs;
                  
                  try
                  {
                     st=connection.createStatement();
                     rs=st.executeQuery(query);
                     drug U;
                     while(rs.next())
                     {
                       U=new drug(rs.getInt("Did"),rs.getString("name"),rs.getInt("price"),rs.getString("type"));
                       usersList2.add(U);
                     }
                     
                  }
                  catch(Exception e)
{
    System.out.println("Something went wrong");
    
}
             DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
              
        
        Object [] row=new Object[4];
        for(int i=0;i<usersList2.size();i++)
        {
            row[0]=usersList2.get(i).getdid();
            row[1]=usersList2.get(i).getname();
            row[2]=usersList2.get(i).getprice();
            row[3]=usersList2.get(i).gettype();
            model.addRow(row);
        }
                 
        
    }//GEN-LAST:event_jButton1_sort_by_nameActionPerformed

    private void jButton1_sort_bye_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_sort_bye_priceActionPerformed
        // TODO add your handling code here:
        String query="select name,Did,price,type from drug order by price";
        ArrayList<drug> usersList2= new ArrayList<drug>() ;
         Connection connection=getConnection();
         // String query="select drug.Did,name,price,type from drug,contain where drug.Did=contain.did And pid=1;";
         
                  Statement st;
                  ResultSet rs;
                  
                  try
                  {
                     st=connection.createStatement();
                     rs=st.executeQuery(query);
                     drug U;
                     while(rs.next())
                     {
                       U=new drug(rs.getInt("Did"),rs.getString("name"),rs.getInt("price"),rs.getString("type"));
                       usersList2.add(U);
                     }
                     
                  }
                  catch(Exception e)
{
    System.out.println("Something went wrong");
    
}
             DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
              
        
        Object [] row=new Object[4];
        for(int i=0;i<usersList2.size();i++)
        {
            row[0]=usersList2.get(i).getdid();
            row[1]=usersList2.get(i).getname();
            row[2]=usersList2.get(i).getprice();
            row[3]=usersList2.get(i).gettype();
            model.addRow(row);
        }
                
    }//GEN-LAST:event_jButton1_sort_bye_priceActionPerformed

    private void jButton1_sort_by_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_sort_by_typeActionPerformed
        // TODO add your handling code here:
        String query="select name,Did,price,type from drug order by type";
        ArrayList<drug> usersList2= new ArrayList<drug>() ;
         Connection connection=getConnection();
         // String query="select drug.Did,name,price,type from drug,contain where drug.Did=contain.did And pid=1;";
         
                  Statement st;
                  ResultSet rs;
                  
                  try
                  {
                     st=connection.createStatement();
                     rs=st.executeQuery(query);
                     drug U;
                     while(rs.next())
                     {
                       U=new drug(rs.getInt("Did"),rs.getString("name"),rs.getInt("price"),rs.getString("type"));
                       usersList2.add(U);
                     }
                     
                  }
                  catch(Exception e)
{
    System.out.println("Something went wrong");
    
}
             DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
              
        
        Object [] row=new Object[4];
        for(int i=0;i<usersList2.size();i++)
        {
            row[0]=usersList2.get(i).getdid();
            row[1]=usersList2.get(i).getname();
            row[2]=usersList2.get(i).getprice();
            row[3]=usersList2.get(i).gettype();
            model.addRow(row);
        }
                
    }//GEN-LAST:event_jButton1_sort_by_typeActionPerformed

    private void jButton1_sort_by_DidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_sort_by_DidActionPerformed
        // TODO add your handling code here:
        String query="select name,Did,price,type from drug order by Did";
        ArrayList<drug> usersList2= new ArrayList<drug>() ;
         Connection connection=getConnection();
         // String query="select drug.Did,name,price,type from drug,contain where drug.Did=contain.did And pid=1;";
         
                  Statement st;
                  ResultSet rs;
                  
                  try
                  {
                     st=connection.createStatement();
                     rs=st.executeQuery(query);
                     drug U;
                     while(rs.next())
                     {
                       U=new drug(rs.getInt("Did"),rs.getString("name"),rs.getInt("price"),rs.getString("type"));
                       usersList2.add(U);
                     }
                     
                  }
                  catch(Exception e)
{
    System.out.println("Something went wrong");
    
}
             DefaultTableModel model=(DefaultTableModel)jTable1_Display_user.getModel();
             model.setRowCount(0);
              
        
        Object [] row=new Object[4];
        for(int i=0;i<usersList2.size();i++)
        {
            row[0]=usersList2.get(i).getdid();
            row[1]=usersList2.get(i).getname();
            row[2]=usersList2.get(i).getprice();
            row[3]=usersList2.get(i).gettype();
            model.addRow(row);
        }
                
    }//GEN-LAST:event_jButton1_sort_by_DidActionPerformed

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
            java.util.logging.Logger.getLogger(drug_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(drug_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(drug_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(drug_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new drug_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_insert;
    private javax.swing.JButton jButton1_sort_by_Did;
    private javax.swing.JButton jButton1_sort_by_name;
    private javax.swing.JButton jButton1_sort_by_type;
    private javax.swing.JButton jButton1_sort_bye_price;
    private javax.swing.JButton jButton2_update;
    private javax.swing.JButton jButton3_delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_Display_user;
    private javax.swing.JTextField jTextField1_Did;
    private javax.swing.JTextField jTextField2_name;
    private javax.swing.JTextField jTextField3_price;
    private javax.swing.JTextField jTextField4_type;
    // End of variables declaration//GEN-END:variables
}
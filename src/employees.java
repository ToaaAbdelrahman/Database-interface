import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class employees  extends javax.swing.JFrame{

    public employees() {
        initComponents();
        show_users_in_Jtable();
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
                "Employee ID", "Employee Name", "Phone number","data of birth","job","salary"
            }
        ));
        jScrollPane1.setViewportView(p1);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }

              private void jButton2ActionPerformed(ActionEvent evt) {
                      new updateEmployeesII().setVisible(true);
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
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void show_users_in_Jtable() {
         ArrayList<user> List=getUsersList();
        DefaultTableModel model=( DefaultTableModel)p1.getModel();
        Object [] row=new Object[6];
        for(int i=0;i<List.size();i++)
        {
            row[0]=List.get(i).geteid();
            row[1]=List.get(i).getname();
            row[2]=List.get(i).getphone();
            row[3]=List.get(i).getDOB();
            row[4]=List.get(i).getJob();
            row[5]=List.get(i).getSalary();
            model.addRow(row);
    }
        
    
}
        public ArrayList<user> getUsersList()
    {
         ArrayList<user> usersList= new ArrayList<user>() ;
         java.sql.Connection connection=getConnection();
         // String query="select drug.Did,name,price,type from drug,contain where drug.Did=contain.did And pid=1;";
         String query="select * from employee;";
                  Statement st;
                  ResultSet rs;
                  
                  try
                  {
                     st=connection.createStatement();
                     rs=st.executeQuery(query);
                     user U;
                     while(rs.next())
                     {
                       U=new user(rs.getInt("id_employee"),rs.getString("name_employee"),rs.getInt("phone_no"),rs.getString("date_of_birth"),rs.getString("Job"),rs.getInt("salary"));
                       usersList.add(U);
                     }
                     
                  }
                  catch(Exception e)
{
   e.printStackTrace();
    
}
                  return usersList;
    }
        public java.sql.Connection getConnection()
    {
        java.sql.Connection con;
        try
        {
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","root");
             return con;
        }
        catch(Exception e)
{
   e.printStackTrace();
    return null;
}
    }
}
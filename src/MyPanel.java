import java.awt.*;
 import java.awt.event.*;

 import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel {
private JTextField How;

private JButton jcomp4;
private JButton jcomp5;
private JButton jcomp6;
private JButton jcomp7;






public MyPanel()    {
    //construct components
   
    jcomp4 = new JButton ("Employees");
    jcomp5= new JButton ("Drugs");
    jcomp6=new JButton("Drug Companies");
    jcomp7 =new JButton ("Patients");
    

    jcomp4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          new employees().setVisible(true);

       

        }
    });
    jcomp5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          //  JFrame frame = new JFrame ("Drugs");
           // frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
          //  frame.getContentPane().add (new MyPanel());
              new drug_frame().setVisible(true);
            //frame.pack();
            //frame.setVisible (true);

        }
    });
    jcomp6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame ("Drug companies");
            //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
          //  frame.getContentPane().add (new MyPanel());
            frame.pack();
            frame.setVisible (true);

        }
    });
    jcomp7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new patients().setVisible(true);
           // JFrame frame = new JFrame ("Patients");
            //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
          //  frame.getContentPane().add (new MyPanel());
           // frame.pack();
           // frame.setVisible (true);

        }
    });

    //adjust size and set layout
    setPreferredSize (new Dimension (315, 85));
    setLayout (null);

    //add components
   
    add (jcomp4);
     add (jcomp5);
      add (jcomp6);
       add (jcomp7);

    //set component bounds (only needed by Absolute Positioning)
  
    jcomp4.setBounds (0, 0, 315, 25);
    
    jcomp5.setBounds (0, 20, 315, 25);
    jcomp6.setBounds (0, 40, 315, 25);
    jcomp7.setBounds (0, 60, 315, 25);

       jcomp4.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    });
 jcomp5.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    });
  jcomp6.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    });
     jcomp7.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    });
}


public static void main (String[] args) {
   JFrame frame = new JFrame ("Home");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add (new MyPanel());
    frame.pack();
    frame.setVisible (true);
   
    
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecafe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import jdk.internal.org.objectweb.asm.tree.analysis.Frame;

/**
 *
 * @author aroosha
 */
public class Login extends javax.swing.JFrame  {
    public static String uid=null;
 JLabel l1, l2, l3;
 JTextField t1;
 JButton btn1;
 JPasswordField p1;
 
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        Dimension d=getMaximumSize();
        JFrame frame = new JFrame("Login Form");
         frame.setSize(d.width, d.height);
  l1 = new JLabel("Login Form");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 60));
 
  l2 = new JLabel("Username");
   l2.setFont(new Font("Serif", Font.BOLD, 40));
 
  l3 = new JLabel("Password");
   l3.setFont(new Font("Serif", Font.BOLD, 40));
 
  t1 = new JTextField();
  t1.setFont(new Font("Serif", Font.BOLD, 20));
  p1 = new JPasswordField();
  p1.setFont(new Font("Serif", Font.BOLD, 20));
  btn1 = new JButton("Login");
 btn1.setFont(new Font("Arial", Font.PLAIN, 20));
  l1.setBounds(800, 30, 400, 100);
  l2.setBounds(700, 150, 200, 30);
  l3.setBounds(700, 200, 200, 30);
  t1.setBounds(900, 150, 200, 30);
  p1.setBounds(900, 200, 200, 30);
  btn1.setBounds(900, 250, 100, 30);
 
  frame.add(l1);
  frame.add(l2);
  frame.add(t1);
  frame.add(l3);
  frame.add(p1);
  frame.add(btn1);
 
  //frame.setSize(400, 400);
  frame.setLayout(null);
  frame.setVisible(true);
    frame.toFront();
        frame.repaint();
  btn1.addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent e) {
String uname = t1.getText();
   String pass = p1.getText();
    String dname = null;
    String dpass = null;
    String did=null;
     try {
         //loading the jdbc driver
         Class.forName("com.mysql.jdbc.Driver").newInstance();
    //get a connection to database
           Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecafe","root","");
    Statement stmt=(Statement)myConn.createStatement();
           //execute sql query
          ResultSet rs=stmt.executeQuery("select * from Users where Username='"+uname+"'");
         // System.out.println("Connected"+rs.getString("Username"));
         if(rs.next()){
          dname=rs.getString("Username");  
          dpass=rs.getString("Pasword");
          uid=rs.getString("UserID");
          
          }
                
   if( !uname.equals("Amal")){
       if( uname.equals(dname) && pass.equals(dpass))
   {
      
       try {
           frame.dispose();
           Menu wel;
           wel = new Menu();
       wel.setVisible(true);
      JLabel label = new JLabel("Welcome:"+uname);
    
      wel.getContentPane().add(label); } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }}
     
    }
   else  if(dname.equals("Amal") && pass.equals("123"))
          {
          
          try {
           frame.dispose();
          Admin a;
           a= new Admin();
      a.setVisible(true);
      JLabel label = new JLabel("Welcome:"+uname);
    
      a.getContentPane().add(label); } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
          }
   else
    {
        JOptionPane.showMessageDialog(frame, "Please enter your details again.");
    
    }
          
          
     } 
     catch (ClassNotFoundException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
     }  catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
    }
    
});
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login();
              
            }
        });
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

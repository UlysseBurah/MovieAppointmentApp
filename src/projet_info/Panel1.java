/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.lang.Math;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
/**
 *
 * @author ulyss
 */
public class Panel1 extends JPanel
{
    JLabel email;
    JLabel password;
    JTextField email2;
    JPasswordField password2;
    JTextField result;
    JComboBox cityList;
    String[] cities;
    JButton guest;
    JButton employee;
    JButton createAccount;
    JButton connect;
    
    
    
   Panel1()
   {
       //PANEL
       
       this.setLayout(null);
      
       //MISE EN PAGE 
       email = new JLabel("Email ");
       email.setFont(new Font("Consolas", Font.ITALIC, 25));
       email.setBounds(200, 215, 100, 20);
       
       password = new JLabel("Password ");
       password.setFont(new Font("Consolas", Font.ITALIC, 25));
       password.setBounds(170, 320, 150, 20);
       
       email2 = new JTextField();
       email2.setFont(new Font("Consolas", Font.PLAIN, 20));
       email2.setPreferredSize(new Dimension(80, 10));
       email2.setBounds(325, 200, 350, 50);
       
       password2 = new JPasswordField();
       password2.setFont(new Font("Consolas", Font.PLAIN, 20));
       password2.setPreferredSize(new Dimension(80, 10));
       password2.setBounds(325, 300, 350, 50);
       
       guest = new JButton("Continue as guest");
       guest.setFont(new Font("Consolas", Font.BOLD, 10));
       guest.setFocusable(false);
       guest.setBounds(650, 50, 300, 20);
       
       employee = new JButton("Continue as employee");
       employee.setFont(new Font("Consolas", Font.BOLD, 10));
       employee.setFocusable(false);
       employee.setBounds(650, 80, 300, 20);
       
       createAccount = new JButton("Create an account");
       createAccount.setFont(new Font("Consolas", Font.BOLD, 10));
       createAccount.setFocusable(false);
       createAccount.setBounds(100, 600, 150, 20);
       
       
       connect = new JButton("Continue");
       connect.setFont(new Font("Consolas", Font.BOLD, 20));
       connect.setFocusable(false);
       connect.setBounds(425, 420, 150, 50);
       
       enableClick();
           
           
       
       this.add(email);
       this.add(password);
       this.add(email2);
       this.add(password2);
       this.add(guest);
       this.add(employee);
       this.add(createAccount);
       this.add(connect);
       
      
       
           
       
   }
   
   public void enableClick()
   {
       String myPass=String.valueOf(password2.getPassword());
        if(email2.getText().equals("") && myPass.equals(""))
        {
            System.out.println("FALSE");
            connect.setEnabled(false);
        }
        else
        {
            System.out.println("True");
            connect.setEnabled(true);
        }
       
   }
    
}

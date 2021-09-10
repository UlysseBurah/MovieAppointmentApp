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
/**
 *
 * @author ulyss
 */
public class EmployeePanel extends JPanel
{
    JLabel email;
    JLabel password;
    JLabel employeeNumber;
    JTextField email2;
    JPasswordField password2;
    JTextField result;
    JTextField employeeNumber2;
    JButton back;
    JButton connect;
    
    
    
   EmployeePanel()
   {
       //PANEL
       
       //PANEL
       
       this.setLayout(null);
       
       //MISE EN PAGE 
      
       
       email = new JLabel("Email ");
       email.setFont(new Font("Consolas", Font.ITALIC, 25));
       email.setBounds(200, 170, 100, 20);
       
       password = new JLabel("Password ");
       password.setFont(new Font("Consolas", Font.ITALIC, 25));
       password.setBounds(170, 270, 150, 20);
       
       employeeNumber = new JLabel("Employee Number ");
       employeeNumber.setFont(new Font("Consolas", Font.ITALIC, 25));
       employeeNumber.setBounds(90, 370, 250, 20);
      
       email2 = new JTextField();
       email2.setFont(new Font("Consolas", Font.PLAIN, 20));
       email2.setPreferredSize(new Dimension(80, 10));
       email2.setBounds(325, 150, 350, 50);
       
       password2 = new JPasswordField();
       password2.setFont(new Font("Consolas", Font.PLAIN, 20));
       password2.setPreferredSize(new Dimension(80, 10));
       password2.setBounds(325, 250, 350, 50);
       
       employeeNumber2 = new JTextField();
       employeeNumber2.setFont(new Font("Consolas", Font.PLAIN, 20));
       employeeNumber2.setPreferredSize(new Dimension(80, 10));
       employeeNumber2.setBounds(325, 350, 350, 50);
       
       connect = new JButton("Continue");
       connect.setFont(new Font("Consolas", Font.BOLD, 20));
       connect.setFocusable(false);
       connect.setBounds(425, 450, 150, 50);
       
       back = new JButton("Back");
       back.setFont(new Font("Consolas", Font.BOLD, 20));
       back.setFocusable(false);
       back.setBounds(10, 10, 100, 50);
       
       this.add(email);
       this.add(password);
       this.add(email2);
       this.add(password2);
       this.add(employeeNumber);
       this.add(employeeNumber2);
       this.add(connect);
       this.add(back);
       
      
       
           
       
   }
    
}

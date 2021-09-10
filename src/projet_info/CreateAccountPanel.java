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


public class CreateAccountPanel extends JPanel
{
    JLabel email;
    JLabel password;
    JLabel prenom;
    JLabel nom;
    JTextField email2;
    JPasswordField password2;
    JTextField result;
    JTextField prenom2;
    JTextField nom2;
    JComboBox type;
    String[] promo;
    JButton connect;
    JButton back;
    
    CreateAccountPanel()
   {
       //PANEL
       
       this.setLayout(null);
       
       //MISE EN PAGE 
       prenom = new JLabel("Prenom ");
       prenom.setFont(new Font("Consolas", Font.ITALIC, 25));
       prenom.setBounds(200, 70, 100, 20);
       
       nom = new JLabel("Nom ");
       nom.setFont(new Font("Consolas", Font.ITALIC, 25));
       nom.setBounds(200, 170, 100, 20);
       
       email = new JLabel("Email ");
       email.setFont(new Font("Consolas", Font.ITALIC, 25));
       email.setBounds(200, 270, 100, 20);
       
       password = new JLabel("Password ");
       password.setFont(new Font("Consolas", Font.ITALIC, 25));
       password.setBounds(170, 370, 150, 20);
       
       prenom2 = new JTextField();
       prenom2.setFont(new Font("Consolas", Font.PLAIN, 20));
       prenom2.setPreferredSize(new Dimension(80, 10));
       prenom2.setBounds(325, 50, 350, 50);
       
       nom2 = new JTextField();
       nom2.setFont(new Font("Consolas", Font.PLAIN, 20));
       nom2.setPreferredSize(new Dimension(80, 10));
       nom2.setBounds(325, 150, 350, 50);
       
       email2 = new JTextField();
       email2.setFont(new Font("Consolas", Font.PLAIN, 20));
       email2.setPreferredSize(new Dimension(80, 10));
       email2.setBounds(325, 250, 350, 50);
       
       password2 = new JPasswordField();
       password2.setFont(new Font("Consolas", Font.PLAIN, 20));
       password2.setPreferredSize(new Dimension(80, 10));
       password2.setBounds(325, 350, 350, 50);
       
       promo = new String[]{"Regular", "Senior", "Children" };
       type = new JComboBox(promo);
       type.setSelectedIndex(2);
       type.setFont(new Font("Consolas", Font.BOLD, 20));
       type.setBounds(325, 450, 350, 50);
       
       connect = new JButton("Continue");
       connect.setFont(new Font("Consolas", Font.BOLD, 20));
       connect.setFocusable(false);
       connect.setBounds(425, 550, 150, 50);
       
       back = new JButton("Back");
       back.setFont(new Font("Consolas", Font.BOLD, 20));
       back.setFocusable(false);
       back.setBounds(10, 10, 100, 50);
       
       this.add(email);
       this.add(password);
       this.add(email2);
       this.add(password2);
       this.add(type);
       this.add(prenom);
       this.add(prenom2);
       this.add(nom);
       this.add(nom2);
       this.add(connect);
       this.add(back);
       
   }
    
}

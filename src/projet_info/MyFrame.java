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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JComboBox;
/**
 *
 * @author ulyss
 */
public class MyFrame extends JFrame implements ActionListener
{
    Panel1 panel;
    CreateAccountPanel createAccount;
    EmployeePanel employeePanel;
    CinemaPanel cinemaPanel;
    PanelTest panelTest;
    TenetPanel tenetPanel;
    PlayPanel playPanel;
    Panel1917 panel1917;
    Film film1;
    Film film2;
    Film film3;
    
            
    MyFrame()
    {
        final int WINDOW_WIDTH = 1000 ;
        final int WINDOW_HEIGHT = 700 ;
        
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setTitle("WELCOME ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(100, 100, 100));
        
        //FILM
        ArrayList<String> actors = new ArrayList<String>(Arrays.asList("Robert Pattinson", "Elizabeth Debicki","John David Washington")); 
        film1 = new Film("Tenet", "Film d'action et de suspens", "Christopher Nolan", 12, actors, 220, 320, 10, 50, "2h12");
        
        ArrayList<String> actors2 = new ArrayList<String>(Arrays.asList("Max Boubil", "Alice Isaaz ","Camille Lou")); 
        film2 = new Film("Play", "Film d'humour", "Anthony Marciano", 12, actors, 220, 320, 10, 390,"1h45");
        
        ArrayList<String> actors3 = new ArrayList<String>(Arrays.asList("George McKay", "Richard Madden ","Benedict Cumberbatch")); 
        film3 = new Film("1917", "Film d'action et d'emotion", "Sam Mendes", 12, actors, 220, 320, 10, 390,"1h58");
        
        
        //PANEL 1
        panel = new Panel1();
        panel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        panel.guest.addActionListener(this);
        panel.employee.addActionListener(this);
        panel.createAccount.addActionListener(this);
        panel.connect.addActionListener(this);
        panel.email2.addActionListener(this);
        panel.password2.addActionListener(this);
        this.add(panel);
        
        
        //CREATE ACCOUNT PANEL
        createAccount = new CreateAccountPanel();
        createAccount.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        createAccount.type.addActionListener(this);
        createAccount.connect.addActionListener(this);
        createAccount.back.addActionListener(this);
        //this.add(createAccount);
        
        //EMPLOYEE PANEL
        employeePanel = new EmployeePanel();
        employeePanel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        employeePanel.connect.addActionListener(this);
        employeePanel.back.addActionListener(this);
        
        //CINEMA PANEL
        /*cinemaPanel = new CinemaPanel(film1, film2);
        cinemaPanel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        cinemaPanel.back.addActionListener(this);*/
        //this.add(cinemaPanel); 
        
        //TEST PANEL
        panelTest = new PanelTest(film1, film2,film3);
        panelTest.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        panelTest.boutonTenet.addActionListener(this);
        panelTest.boutonPlay.addActionListener(this);
        panelTest.bouton1917.addActionListener(this);
        panelTest.back.addActionListener(this);
        panelTest.deco.addActionListener(this);
        //panelTest.addMouseListener(this);
        
        //TENET PANEL
        tenetPanel = new TenetPanel(film1);
        tenetPanel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        tenetPanel.back.addActionListener(this);
        tenetPanel.deco.addActionListener(this);
        
        //PLAY PANEL
        playPanel = new PlayPanel(film2);
        playPanel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        playPanel.back.addActionListener(this);
        playPanel.deco.addActionListener(this);
        
        //1917PANEL
        panel1917 = new Panel1917(film3);
        panel1917.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        panel1917.back.addActionListener(this);
        panel1917.deco.addActionListener(this);
        

        
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {

        if (ae.getSource() == panel.guest) 
        {
            //setContentPane(cinemaPanel);
            setContentPane(panelTest);
            invalidate();
            validate();
            //this.remove(panel);
            
        } 
        
        else if (ae.getSource() == panel.employee) 
        {
            setContentPane(employeePanel);
            invalidate();
            validate();
            
        }
        
        else if (ae.getSource() == panel.createAccount) 
        {
            setContentPane(createAccount);
            invalidate();
            validate();
            
        }
        
        else if (ae.getSource() == panel.connect) 
        {
            System.out.println("CONNECT");
            invalidate();
            validate();
        }
        else if (ae.getSource() == createAccount.back) 
        {
            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (ae.getSource() == employeePanel.back) 
        {
            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (ae.getSource() == panel.email2) //ENABLE LE BOUTON
        {
            System.out.println("BONJOUR");
            panel.enableClick();
            
        }
        else if (ae.getSource() == panelTest.boutonTenet) //AFFICHE TENET
        {
            setContentPane(tenetPanel);
            invalidate();
            validate();
            System.out.println("CHACALLL");
            
            
        }
        else if (ae.getSource() == panelTest.boutonPlay) //AFFICHE TENET
        {
            setContentPane(playPanel);
            invalidate();
            validate();
            System.out.println("CHACALLL2");
            
            
        }
        else if (ae.getSource() == panelTest.bouton1917) //AFFICHE TENET
        {
            setContentPane(panel1917);
            invalidate();
            validate();
            System.out.println("CHACALLL3");
            
            
        }
        else if (ae.getSource() == panelTest.back) //AFFICHE TENET
        {
            setContentPane(panel);
            invalidate();
            validate();
            System.out.println("CHACALLL3");
            
            
        }
        else if (ae.getSource() == panelTest.deco) //AFFICHE TENET
        {
            setContentPane(panel);
            invalidate();
            validate();
            System.out.println("CHACALLL3");
            
            
        }
        
        else if (ae.getSource() == tenetPanel.back) //AFFICHE TENET
        {
            setContentPane(panelTest);
            invalidate();
            validate();
            System.out.println("CHACALLL3");
            
            
        }
        else if (ae.getSource() == tenetPanel.deco) //AFFICHE TENET
        {
            setContentPane(panel);
            invalidate();
            validate();
            System.out.println("CHACALLL3");
            
            
        }
        
        else if (ae.getSource() == playPanel.back) //AFFICHE TENET
        {
            setContentPane(panelTest);
            invalidate();
            validate();

        }
        else if (ae.getSource() == playPanel.deco) //AFFICHE TENET
        {
            setContentPane(panel);
            invalidate();
            validate();
   
        }
        
        else if (ae.getSource() == panel1917.back) //AFFICHE TENET
        {
            setContentPane(panelTest);
            invalidate();
            validate();

        }
        else if (ae.getSource() == panel1917.deco) //AFFICHE TENET
        {
            setContentPane(panel);
            invalidate();
            validate();
   
        }
    }    
        
        
        
    
    
    
}

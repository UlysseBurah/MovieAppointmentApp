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
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;


/**
 *
 * @author ulyss
 */
public class CinemaPanel extends JPanel
{
   
   
    JButton back;
    Film tenet;
    Film play;
    JLabel photo;
    JPanel mainPanel;
    
    CinemaPanel(Film film1, Film play)
    {
       this.setLayout(new GridLayout(3, 3));
       mainPanel.setLayout(new GridLayout(3, 3));
       this.tenet = film1;
       this.play = play;
      
       
       back = new JButton("Back");
       back.setFont(new Font("Consolas", Font.BOLD, 15));
       back.setFocusable(false);
       //back.setBounds(10, 10, 100, 20);
       
       
       this.add(back);
      
        
       
        
    }
    
    @Override
    public void paint(Graphics g)
    {
        System.out.println("1");
        //g.drawImage(tenet.myImage, tenet.x, tenet.y, tenet.width, tenet.high, null);
        //g.drawImage(play.myImage, play.x, play.y, play.width, play.high, null);
        g.drawImage(tenet.myImage, 0, 0, tenet.width, tenet.high, null);
    }
    
    
}

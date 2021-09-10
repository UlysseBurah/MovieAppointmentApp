/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.nio.file.Files.size;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ulyss
 */
public class PanelTest extends JPanel implements MouseListener
{
    JButton back;
    JButton deco;
    JButton boutonTenet;
    JButton boutonPlay;
    JButton bouton1917;
    Film tenet;
    Film play;
    Film film1917;
    JLabel photo;
    JPanel buttonImageTenet;
    JPanel buttonImagePlay;
    JPanel buttonImage1917;
    JPanel moviePanel;
    JPanel descriptionTenetPanel;
    JPanel panelNorth;
    JPanel panelEast;
    JPanel panelWest;
    JPanel panelSouth;
    JPanel borderPanel2;
    JPanel logOut;
    JLabel descriptionTenet1;
    JLabel descriptionTenet2;
    JLabel descriptionTenet3;
    JPanel descriptionPlayPanel;
    JLabel descriptionPlay1;
    JLabel descriptionPlay2;
    JLabel descriptionPlay3;
    JPanel description1917Panel;
    JLabel description19171;
    JLabel description19172;
    JLabel description19173;
    
    PanelTest(Film film1, Film play, Film film1917)
    {
        //FILM
        this.tenet = film1;
        this.play = play;
        this.film1917 = film1917;

        this.setLayout(new BorderLayout());
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.black);
        panelNorth.setPreferredSize(new Dimension(100,100));
        panelSouth = new JPanel();
        panelSouth.setBackground(Color.black);
        panelEast = new JPanel();
        panelEast.setBackground(Color.black);
        panelWest = new JPanel();
        panelWest.setBackground(Color.black);
        //this.setPreferredSize(new Dimension(1000,700));
        
        //BOUTON 
        back = new JButton("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setFocusable(false);
        deco = new JButton("Log Out");
        deco.setFont(new Font("Consolas", Font.BOLD, 20));
        deco.setFocusable(false);
        
        //PANEL LOG OUT
        borderPanel2 = new JPanel();
        borderPanel2.setLayout(new BorderLayout());
        logOut = new JPanel();
        logOut.setLayout(new GridLayout(2,1));
        logOut.add(back);
        logOut.add(deco);
        borderPanel2.add(logOut, BorderLayout.EAST);
        this.add(borderPanel2, BorderLayout.NORTH);
        
        
        
        //GRID PANEL
        moviePanel = new JPanel();
        moviePanel.setPreferredSize(new Dimension(1000,2000));
        moviePanel.setLayout(new GridLayout(3,2));
        moviePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        
        //PANEL IMAGE+BOUTON
        buttonImageTenet = new JPanel();
        buttonImagePlay = new JPanel();
        buttonImage1917 = new JPanel();
        
        //GRID PANEL DANS GRID PANEL TENET
        descriptionTenetPanel = new JPanel();
        descriptionTenetPanel.setLayout(new GridLayout(4,1));
        descriptionTenet1 = new JLabel("TENET (2020) ");
        descriptionTenet1.setFont(new Font("Consolas", Font.BOLD, 50));
        descriptionTenetPanel.add(descriptionTenet1);
        descriptionTenet2 = new JLabel(tenet.duree + ", Sortie : 12 fevrier 2020, "+ tenet.description);
        descriptionTenet2.setFont(new Font("Consolas", Font.ITALIC, 20));
        descriptionTenetPanel.add(descriptionTenet2);
        descriptionTenet3 = new JLabel("Film de " + tenet.realisateur + " avec " + "ULYSSE");
        descriptionTenet3.setFont(new Font("Consolas", Font.PLAIN, 20));
        descriptionTenetPanel.add(descriptionTenet3);
        
        //GRID PANEL DANS GRID PANEL PLAY
        descriptionPlayPanel = new JPanel();
        descriptionPlayPanel.setLayout(new GridLayout(4,1));
        descriptionPlay1 = new JLabel("PLAY (2020) ");
        descriptionPlay1.setFont(new Font("Consolas", Font.BOLD, 50));
        descriptionPlayPanel.add(descriptionPlay1);
        descriptionPlay2 = new JLabel(play.duree + ", Sortie : 22 Mars 2020, " + play.description);
        descriptionPlay2.setFont(new Font("Consolas", Font.ITALIC, 20));
        descriptionPlayPanel.add(descriptionPlay2);
        descriptionPlay3 = new JLabel("Film de " + play.realisateur + " avec " + "ULYSSE");
        descriptionPlay3.setFont(new Font("Consolas", Font.PLAIN, 20));
        descriptionPlayPanel.add(descriptionPlay3);
        
        //GRID PANEL DANS GRID PANEL 1917
        description1917Panel = new JPanel();
        description1917Panel.setLayout(new GridLayout(4,1));
        description19171 = new JLabel("1917 (2020) ");
        description19171.setFont(new Font("Consolas", Font.BOLD, 50));
        description1917Panel.add(description19171);
        description19172 = new JLabel(film1917.duree + ", Sortie : 15 Janvier 2020, " + film1917.description );
        description19172.setFont(new Font("Consolas", Font.ITALIC, 20));
        description1917Panel.add(description19172);
        description19173 = new JLabel("Film de " + film1917.realisateur + " avec " + "ULYSSE");
        description19173.setFont(new Font("Consolas", Font.PLAIN, 20));
        description1917Panel.add(description19173);
        
        
        
        //DESCRIPTION FILM    
        /*description = new JLabel();
        description.setFont(new Font("Consolas", Font.ITALIC, 25));
        description.setBounds(200, 215, 100, 20);*/
        
        //CHARGEMENT DES IMAGES + BOUTON IMAGE
        JLabel picLabel = new JLabel(new ImageIcon(tenet.myImage));
        JLabel picLabel2 = new JLabel(new ImageIcon(play.myImage));
        JLabel picLabel3 = new JLabel(new ImageIcon(film1917.myImage));
        
        ImageIcon iconTenet = new ImageIcon(tenet.myImage);
        ImageIcon iconPlay = new ImageIcon(play.myImage);
        ImageIcon icon1917 = new ImageIcon(film1917.myImage);
        
        Border emptyBorder = BorderFactory.createEmptyBorder();
        
        boutonTenet = new JButton(iconTenet);
        boutonTenet.setRolloverIcon(iconTenet);
        boutonTenet.setBackground(Color.white);
        boutonTenet.setBorder(emptyBorder);
        
        boutonPlay = new JButton(iconPlay);
        boutonPlay.setRolloverIcon(iconPlay);
        boutonPlay.setBackground(Color.white);
        boutonPlay.setBorder(emptyBorder);
        
        bouton1917 = new JButton(icon1917);
        bouton1917.setRolloverIcon(icon1917);
        bouton1917.setBackground(Color.white);
        bouton1917.setBorder(emptyBorder);
        
        buttonImageTenet.add(boutonTenet);
        buttonImagePlay.add(boutonPlay);
        buttonImage1917.add(bouton1917);
        
        
        //AFFICHAGE ELEMENT DE LA GRID
        
        moviePanel.add(buttonImageTenet);
        moviePanel.add(descriptionTenetPanel);
        moviePanel.add(buttonImagePlay);
        moviePanel.add(descriptionPlayPanel);
        moviePanel.add(buttonImage1917);
        moviePanel.add(description1917Panel);
        moviePanel.repaint(); 
        
        
        moviePanel.addMouseListener(this);
        //SCROLL BAR
        JScrollPane scrollPane = new JScrollPane(moviePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
        
        //this.add(moviePanel);//, BorderLayout.CENTER);
        //this.add(back, BorderLayout.NORTH);
        //this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panelWest, BorderLayout.WEST);
        
        //this.addMouseListener(this);
        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        // Finds the location of the mouse
       int relativeX = e.getX();
       int relativeY = e.getY();
        System.out.println("X Tile: " + relativeX);
        System.out.println("Y Tile: " + relativeY);
        System.out.println("CLIKED");

    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        System.out.println("PRESSED");

    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        System.out.println("REALESED");

    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        System.out.println("ENTERED");

    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        System.out.println("EXITED");

    }
    
    
    
  
}

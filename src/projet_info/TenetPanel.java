/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;


import javax.swing.JPanel;
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
public class TenetPanel extends JPanel
{
    JPanel descriptionTenetPanel;
    JPanel panelNorth;
    JPanel panelEast;
    JPanel panelWest;
    JPanel panelSouth;
    JPanel gridPanel1;
    JPanel gridPanel2;
    JPanel gridPanel3;
    JPanel gridPanel4;
    JPanel gridPanel5;
    JPanel borderPanel2;
    JPanel logOut;
    JScrollPane scrollPane;
    Film tenet;
    JLabel descriptionTenet1;
    JLabel descriptionTenet2;
    JLabel descriptionTenet3;
    JLabel descriptionTenet4;
    JLabel resumeTenet1;
    JLabel BookingSession;
    JLabel BookingSession2;
    JLabel BookingSession3;
    JLabel BookingSession4;
    JLabel BookingSession5;
    JButton back;
    JButton deco;
    
    TenetPanel(Film tenet)
    {
        this.tenet = tenet;
        
        JLabel picLabel = new JLabel(new ImageIcon(tenet.myImage));
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
        
        //MISE EN PAGE
        gridPanel1 = new JPanel();
        gridPanel1.setLayout(new GridLayout(2,1));
        
        gridPanel2 = new JPanel();
        gridPanel2.setLayout(new GridLayout(1,2));
        gridPanel1.add(gridPanel2);
        gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(10,1));
        gridPanel1.add(gridPanel3);
        gridPanel4 = new JPanel();
        gridPanel4.setLayout(new GridLayout(2,1));
        gridPanel2.add(picLabel);
        gridPanel2.add(gridPanel4); 
        gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(7,1));
        
        //GRID PANEL DANS GRID PANEL TENET
        descriptionTenetPanel = new JPanel();
        descriptionTenetPanel.setLayout(new GridLayout(4,1));
        descriptionTenet1 = new JLabel("TENET (2020) ");
        descriptionTenet1.setFont(new Font("Consolas", Font.BOLD, 60));
        descriptionTenetPanel.add(descriptionTenet1);
        descriptionTenet2 = new JLabel(tenet.duree + ", Sortie : 12 fevrier 2020, "+ tenet.description +"      ");
        descriptionTenet2.setFont(new Font("Consolas", Font.ITALIC, 25));
        descriptionTenetPanel.add(descriptionTenet2);
        descriptionTenet3 = new JLabel("Film de " + tenet.realisateur + " avec " + "ULYSSE");
        descriptionTenet3.setFont(new Font("Consolas", Font.PLAIN, 25));
        descriptionTenetPanel.add(descriptionTenet3);
        descriptionTenet4 = new JLabel("SYNOPSIS");
        descriptionTenet4.setFont(new Font("Consolas", Font.BOLD, 60));
        descriptionTenetPanel.add(descriptionTenet4);
        
        gridPanel4.add(descriptionTenetPanel);
        
        JTextArea textArea = new JTextArea(
             
            "After having a near-death experience, an unnamed CIA operative, known as the Protagonist, is selected to join the ranks of the shadowy government organization called Tenet: a group tasked with ensuring the survival of the human race. Entrusted with coming to grips with a terrifying, cutting-edge technology, and an imminent attack from the future, the Protagonist teams up with his cryptic new partner, Neil, following a faint trail of clues that lead to the villainous Russian oligarch, Sator. However, this is a race against time, and as the suffocating stranglehold of the invisible threat tightens, more and more, the future of our world is hanging by a thread. Can two agents working alone avert the impending Armageddon?" 
                
        );
        textArea.setFont(new Font("Serif", Font.PLAIN, 25));
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        gridPanel4.add(textArea);
             
        BookingSession = new JLabel("BOOKING SESSION");
        BookingSession.setFont(new Font("Consolas", Font.BOLD, 40));
        BookingSession2 = new JLabel("07 Mars 2021     16h30 ");
        BookingSession2.setFont(new Font("Consolas", Font.ITALIC, 25));
        BookingSession3 = new JLabel("08 Mars 2021     14h30 ");
        BookingSession3.setFont(new Font("Consolas", Font.ITALIC, 25));
        BookingSession4 = new JLabel("09 Mars 2021     18h30 ");
        BookingSession4.setFont(new Font("Consolas", Font.ITALIC, 25));
        BookingSession4 = new JLabel("09 Mars 2021     18h30 ");
        BookingSession4.setFont(new Font("Consolas", Font.ITALIC, 25));
        BookingSession5 = new JLabel("10 Mars 2021     20h00 ");
        BookingSession5.setFont(new Font("Consolas", Font.ITALIC, 25));
        gridPanel5.add(new JLabel());
        gridPanel5.add(BookingSession);
        gridPanel5.add(new JLabel());
        gridPanel5.add(BookingSession2);
        gridPanel5.add(BookingSession3);
        gridPanel5.add(BookingSession4);
        gridPanel5.add(BookingSession5);
        gridPanel1.add(gridPanel5);
        
            
        
        scrollPane = new JScrollPane(gridPanel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
        
        
        
    }
    
    
}

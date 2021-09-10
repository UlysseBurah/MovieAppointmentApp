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
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author ulyss
 */
public class Movie 
{
    private String titre;
    private String description;
    private String realisateur;
    private String synopsis;
    private String releaseDate;
    private int year;
    private String duree;
    private String actors;
    private int width;
    private int high;
    private int x;
    private int y;
    
    JPanel panelDescription;
    JPanel panelDescriptionCopie;
    JPanel panelDescriptionModify;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JLabel description1;
    JLabel description2;
    JLabel description3;
    JLabel description4;
    JLabel description5;
    JTextField descriptionModify1;
    JTextField descriptionModify2;
    JTextField descriptionModify3;
    JTextField descriptionModify4;
    JLabel descriptionModify5;
    JButton imageButton;
    JPanel imageButtonPanel;
    JButton saveModify;
    JButton modify;
    JButton delete;
    JPanel panelNorth;
    JPanel panelEast;
    JPanel panelWest;
    JPanel panelSouth;
    JPanel panelNorth3;
    JPanel panelEast3;
    JPanel panelWest3;
    JPanel panelSouth3;
    JPanel borderSouth;
    JPanel borderSouth3;
    JButton back;
    JButton deco;
    JButton back3;
    JButton deco3;
    JButton book1;
    JButton book2;
    JButton book3;
    JPanel borderPanel2;
    JPanel borderPanel3;
    JPanel logOut;
    JPanel logOut3;
    JPanel gridPanel1;
    JPanel gridPanel2;
    JPanel gridPanel3;
    JPanel gridPanel4;
    JPanel gridPanel5;
    JPanel gridPanelModify1;
    JPanel gridPanelModify2;
    JPanel gridPanelModify3;
    JPanel gridPanelModify4;
    JPanel gridPanelModify5;
    JLabel BookingSession;
    JLabel BookingSession2;
    JLabel BookingSession3;
    JLabel BookingSession4;
    JLabel BookingSession5;
    JScrollPane scrollPane;
    JScrollPane scrollPane2;
    JScrollPane scrollPane3;
    
    BufferedImage myImage;
    
    List<MovieSession> listMovieSession;
    MovieSessionDAO sessionDAO;
    
    Movie(String titre, String description,String realisateur,int year,String actors,int width,int high, String duree,String synopsis,String releaseDate) throws Exception
    {
        this.titre = titre;
        this.actors = actors;
        this.year = year;
        this.description = description;
        this.high = high;
        this.width = width;
        this.realisateur = realisateur;
        this.duree = duree;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        
        //RECUPERATION MOVIE SESSION
        //listMovieSession = new List<MovieSession>();
        sessionDAO = new MovieSessionDAO();
        listMovieSession = sessionDAO.getAllMovieSession(this.titre);
        
        try
        {
            myImage = ImageIO.read(new File(titre+".png"));
 
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
        
        //CREATION PREMIER PANEL FILM
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panelDescription = new JPanel();
        
        panelDescription.setPreferredSize(new Dimension(100,100));
        panelDescription.setLayout(new GridLayout(5,1));
        description1 = new JLabel(titre +" ("+ year+")");
        description1.setFont(new Font("Consolas", Font.BOLD, 60));
        panelDescription.add(description1);
        description2 = new JLabel(" " + duree + "   /  Release : " + releaseDate +"  /  "+ description +"");
        description2.setFont(new Font("Consolas", Font.ITALIC, 25));
        panelDescription.add(description2);
        description3 = new JLabel("Produced by " + realisateur );
        description3.setFont(new Font("Consolas", Font.PLAIN, 25));
        panelDescription.add(description3);
        description4 = new JLabel("Starring " + actors);
        description4.setFont(new Font("Consolas", Font.PLAIN, 25));
        panelDescription.add(description4);
        panelDescription.add(new JLabel());
        
        
        Border emptyBorder = BorderFactory.createEmptyBorder();
        ImageIcon iconTenet = new ImageIcon(myImage);
        imageButtonPanel = new JPanel();
        //imageButtonPanel.setPreferredSize(new Dimension(1000,1000));
        imageButton = new JButton(iconTenet);
        imageButton.setRolloverIcon(iconTenet);
        imageButton.setBackground(Color.white);
        imageButton.setBorder(emptyBorder);
        imageButtonPanel.add(imageButton);
        panel1.add(imageButtonPanel);
        panel1.add(panelDescription);
        
        
        ////////////////////////////////////////////PANEL 2////////////////////////////////////////////
        
        JLabel picLabel = new JLabel(new ImageIcon(myImage));
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(1000,2000));
        panel2.setBackground(Color.blue);
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
        book1 = new JButton("Book");
        book1.setFont(new Font("Consolas", Font.BOLD, 20));
        book1.setFocusable(false);
        
        //PANEL LOG OUT
        borderPanel2 = new JPanel();
        borderPanel2.setLayout(new BorderLayout());
        logOut = new JPanel();
        logOut.setLayout(new GridLayout(2,1));
        logOut.add(back);
        logOut.add(deco);
        borderPanel2.add(logOut, BorderLayout.EAST);
        panel2.add(borderPanel2, BorderLayout.NORTH);
        
        //SOUTH PANEL
        modify = new JButton("Modify ");
        modify.setFont(new Font("Consolas", Font.BOLD, 20));
        modify.setBackground(Color.yellow);
        modify.setFocusable(false);
        delete = new JButton("Delete ");
        delete.setFont(new Font("Consolas", Font.BOLD, 20));
        delete.setBackground(Color.red);
        delete.setFocusable(false);
        
        borderSouth = new JPanel();
        borderSouth.setLayout(new GridLayout(2,1));
        borderSouth.add(modify);
        borderSouth.add(delete);
        borderSouth.setVisible(false);
        
        panel2.add(borderSouth, BorderLayout.SOUTH);
        //MISE EN PAGE
        gridPanel1 = new JPanel();
        gridPanel1.setLayout(new GridLayout(2,1));
        
        gridPanel2 = new JPanel();
        gridPanel2.setLayout(new GridLayout(1,2));
        gridPanel1.add(gridPanel2);
        gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(listMovieSession.size()+1,1));
        gridPanel4 = new JPanel();
        gridPanel4.setLayout(new GridLayout(2,1));
        gridPanel2.add(picLabel);
        gridPanel2.add(gridPanel4); 
        //gridPanel5 = new JPanel();
        //gridPanel5.setLayout(new GridLayout(10,1));
        
        //GRID PANEL DANS GRID PANEL TENET
        
        description5 = new JLabel("SYNOPSIS");
        description5.setFont(new Font("Consolas", Font.BOLD, 60));
        
        panelDescriptionCopie = new JPanel();
        panelDescriptionCopie.setPreferredSize(new Dimension(100,100));
        panelDescriptionCopie.setLayout(new GridLayout(5,1));
        description1 = new JLabel(titre + " ("+ year+")");
        description1.setFont(new Font("Consolas", Font.BOLD, 60));
        panelDescriptionCopie.add(description1);
        description2 = new JLabel(duree + "/   Release : " + releaseDate +"   /  "+ description +"");
        description2.setFont(new Font("Consolas", Font.ITALIC, 25));
        panelDescriptionCopie.add(description2);
        description3 = new JLabel("Produced by " + realisateur );
        description3.setFont(new Font("Consolas", Font.PLAIN, 25));
        panelDescriptionCopie.add(description3);
        description4 = new JLabel("Starring " + actors);
        description4.setFont(new Font("Consolas", Font.PLAIN, 25));
        panelDescriptionCopie.add(description4);
        panelDescriptionCopie.add(description5);
        
        gridPanel4.add(panelDescriptionCopie);
        
        JTextArea textArea = new JTextArea(synopsis);
        
        textArea.setFont(new Font("Serif", Font.PLAIN, 25));
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        gridPanel4.add(textArea);
         
        BookingSession = new JLabel("       BOOKING SESSION");
        BookingSession.setFont(new Font("Consolas", Font.BOLD, 60));
        gridPanel3.add(BookingSession);
        
        for(int i =0;i<listMovieSession.size();i++)
        {
            JPanel tempPanel = new JPanel();
            tempPanel = listMovieSession.get(i).displaySession();
            gridPanel3.add(tempPanel);
        }
        gridPanel1.add(gridPanel3);
        

        scrollPane2 = new JScrollPane(gridPanel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel2.add(scrollPane2, BorderLayout.CENTER);
        
        ////////////////////////////////////////////PANEL 3 MODIFICATION////////////////////////////////////////////
        
        JLabel picLabel3 = new JLabel(new ImageIcon(myImage));
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.setPreferredSize(new Dimension(1000,2000));
        panel3.setBackground(Color.blue);
        panelNorth3 = new JPanel();
        panelNorth3.setBackground(Color.black);
        panelNorth3.setPreferredSize(new Dimension(100,100));
        panelSouth3 = new JPanel();
        panelSouth3.setBackground(Color.black);
        panelEast3 = new JPanel();
        panelEast3.setBackground(Color.black);
        panelWest3 = new JPanel();
        panelWest3.setBackground(Color.black);
        
        //BOUTON 
        back3 = new JButton("Back");
        back3.setFont(new Font("Consolas", Font.BOLD, 20));
        back3.setFocusable(false);
        deco3 = new JButton("Log Out");
        deco3.setFont(new Font("Consolas", Font.BOLD, 20));
        deco3.setFocusable(false);
        book3 = new JButton("Book");
        book3.setFont(new Font("Consolas", Font.BOLD, 20));
        book3.setFocusable(false);
        
        //PANEL LOG OUT
        borderPanel3 = new JPanel();
        borderPanel3.setLayout(new BorderLayout());
        logOut3 = new JPanel();
        logOut3.setLayout(new GridLayout(2,1));
        logOut3.add(back3);
        logOut3.add(deco3);
        borderPanel3.add(logOut3, BorderLayout.EAST);
        panel3.add(borderPanel3, BorderLayout.NORTH);
        
        //SOUTH PANEL
        saveModify = new JButton("Save modification ");
        saveModify.setFont(new Font("Consolas", Font.BOLD, 20));
        saveModify.setBackground(Color.yellow);
        saveModify.setFocusable(false);
        
        
        borderSouth3 = new JPanel();
        borderSouth3.setLayout(new GridLayout(1,1));
        borderSouth3.add(saveModify);
        
        
        panel3.add(borderSouth3, BorderLayout.SOUTH);
        //MISE EN PAGE
        gridPanelModify1 = new JPanel();
        gridPanelModify1.setLayout(new GridLayout(2,1));
        
        gridPanelModify2 = new JPanel();
        gridPanelModify2.setLayout(new GridLayout(1,2));
        gridPanelModify1.add(gridPanelModify2);
        gridPanelModify3 = new JPanel();
        gridPanelModify3.setLayout(new GridLayout(listMovieSession.size()+1,1));
        gridPanelModify4 = new JPanel();
        gridPanelModify4.setLayout(new GridLayout(2,1));
        gridPanelModify2.add(picLabel3);
        gridPanelModify2.add(gridPanelModify4); 
        //gridPanel5 = new JPanel();
        //gridPanel5.setLayout(new GridLayout(10,1));
        
        //GRID PANEL DANS GRID PANEL TENET
        
        descriptionModify5 = new JLabel("SYNOPSIS");
        descriptionModify5.setFont(new Font("Consolas", Font.BOLD, 60));
        panelDescriptionModify = new JPanel();
        panelDescriptionModify.setPreferredSize(new Dimension(100,100));
        panelDescriptionModify.setLayout(new GridLayout(5,1));
        descriptionModify1 = new JTextField(titre + " ("+ year+")");
        descriptionModify1.setFont(new Font("Consolas", Font.BOLD, 60));
        panelDescriptionModify.add(descriptionModify1);
        descriptionModify2 = new JTextField(duree + "/   Release : " + releaseDate +"   /  "+ description +"");
        descriptionModify2.setFont(new Font("Consolas", Font.ITALIC, 25));
        panelDescriptionModify.add(descriptionModify2);
        descriptionModify3 = new JTextField("Produced by " + realisateur );
        descriptionModify3.setFont(new Font("Consolas", Font.PLAIN, 25));
        panelDescriptionModify.add(descriptionModify3);
        descriptionModify4 = new JTextField("Starring " + actors);
        descriptionModify4.setFont(new Font("Consolas", Font.PLAIN, 25));
        panelDescriptionModify.add(descriptionModify4);
        panelDescriptionModify.add(descriptionModify5);
        
        gridPanelModify4.add(panelDescriptionModify);
        
        JTextArea textArea3 = new JTextArea(synopsis);
        
        textArea3.setFont(new Font("Serif", Font.PLAIN, 25));
        textArea3.setEditable(true);
        textArea3.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        textArea3.setLineWrap(true);
        textArea3.setWrapStyleWord(true);
        gridPanelModify4.add(textArea3);
         
        BookingSession3 = new JLabel("       BOOKING SESSION");
        BookingSession3.setFont(new Font("Consolas", Font.BOLD, 60));
        gridPanelModify3.add(BookingSession3);
        
        for(int i =0;i<listMovieSession.size();i++)
        {
            JPanel tempPanel3 = new JPanel();
            tempPanel3 = listMovieSession.get(i).displayModifySession();
            gridPanelModify3.add(tempPanel3);
        }
        gridPanelModify1.add(gridPanelModify3);
        

        scrollPane3 = new JScrollPane(gridPanelModify1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel3.add(scrollPane3, BorderLayout.CENTER);
        
       
    }
    
    public String getTitle()
    {
        return titre;
    }
    public String getDescription()
    {
        return description;
    }
    public String getDirector()
    {
        return realisateur;
    }
    public int getYear()
    {
        return year;
    }
    public String getActors()
    {
        return actors;
    }
    public int getwidth()
    {
        return width;
    }
    public int getHigh()
    {
        return high;
    }
    public String getDuration()
    {
        return duree;
    }
    public String getSynopsis()
    {
        return synopsis;
    }
    public String getReleaseDate()
    {
        return releaseDate;
    }
    
    
    
}

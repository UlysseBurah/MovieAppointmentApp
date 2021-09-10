/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author ulyss
 */
public class Film 
{
    String titre;
    String description;
    String realisateur;
    int date;
    ArrayList<String> actors;
    int width;
    int high;
    int x;
    int y;
    String duree;
    BufferedImage myImage;
    
    Film(String titre, String description,String realisateur,int date,ArrayList<String> actors,int width,int high,int x,int y, String duree)
    {
        this.titre = titre;
        this.actors = actors;
        this.date = date;
        this.description = description;
        this.high = high;
        this.width = width;
        this.realisateur = realisateur;
        this.x = x;
        this.y = y;
        this.duree = duree;
        
        try
        {
            myImage = ImageIO.read(new File(titre+".png"));
 
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
        
    }
}

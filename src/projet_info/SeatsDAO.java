/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author ulyss
 */
public class SeatsDAO 
{
    private Connection myConn;
    
    
    SeatsDAO() throws SQLException
    {
        // get db properties
        Properties props = new Properties();
        /*props.load(new FileInputStream("demo.properties"));

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");*/

        // connect to database
        String url = "jdbc:mysql://localhost:3308/moviedatabase?allowPublicKeyRetrieval=true&useSSL=false";
        myConn = DriverManager.getConnection(url, "root", "1234");
        
    }
    
        
    public void addSeats(int id, String date, String taken, String titre) throws SQLException
    {
        int seatsID = id;
        String seatsTaken = taken;
        String sessionDate = date;
        String title = titre;

        PreparedStatement myStmt = myConn.prepareStatement("INSERT INTO `seats` (`id`, `title`, `sessionDate`, `seatsID` ,`taken`) VALUES (NULL, ?, ?,?,?);");
        myStmt.setString(1, title);
        myStmt.setString(2, sessionDate);
        myStmt.setInt(3, seatsID);
        myStmt.setString(4, seatsTaken);
        
        myStmt.execute();
        myStmt.close(); 


    }
    
    public void updateSeats(String taken, int id, String date, String title) throws SQLException
    {
        int seatsID = id;
        String sessionDate = date;
        String seatsTaken = taken;
        String movieTitle = title;
        

        
        PreparedStatement myStmt = myConn.prepareStatement("UPDATE `seats` SET `taken` = ? WHERE `seatsID` LIKE ? && `sessionDate` LIKE ? && `title` LIKE ? ");
        myStmt.setString(1, seatsTaken);
        myStmt.setInt(2, seatsID);
        myStmt.setString(3, sessionDate);
        myStmt.setString(4, movieTitle);
        
        myStmt.execute();
        myStmt.close();
        
        
    }
    
    public boolean seatsCheck(int id, String date, String title) throws SQLException
    {
        boolean test=false;
        int seatsID = id;
        String sessionDate = date;
        String movieTitle = title;
        PreparedStatement myStmt = myConn.prepareStatement("SELECT `taken` FROM `seats` WHERE `seatsID` LIKE ? &&  `sessionDate` LIKE ? &&  `title` LIKE ?");
        myStmt.setInt(1, seatsID);
        myStmt.setString(2, sessionDate);
        myStmt.setString(3, movieTitle);
        ResultSet result = myStmt.executeQuery();
        
        
        while(result.next())
        {
            
            if(result.getString("taken").equals("true"))
            {
                System.out.println("true");
                test = false;
                break;
                
            }
            else 
            {
                System.out.println("false");
                test = true;
                break;

            }
            
        }
        myStmt.close();
        return test;
        
        
    }
    
    public void removeMSeats(MovieSession movieSession) throws SQLException
    {
        
        
        String title = movieSession.getTitle();
        String date = movieSession.getDate();
        PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM `seats` WHERE `title` LIKE ? AND `sessionDate` LIKE ? ;");
        myStmt.setString(1, title);
        myStmt.setString(2, date);
        myStmt.execute();
        myStmt.close();

        
    }
        
    

    
    
}

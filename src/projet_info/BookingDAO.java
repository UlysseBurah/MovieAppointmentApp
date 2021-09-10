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

/**
 *
 * @author ulyss
 */
public class BookingDAO 
{
    private Connection myConn;
    
    
    BookingDAO() throws SQLException
    {
        // get db properties
        Properties props = new Properties();
        /*props.load(new FileInputStream("demo.properties"));

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");*/

        // connect to database
        String url = "jdbc:mysql://localhost:3306/moviedatabase?useSSL=false";
        myConn = DriverManager.getConnection(url, "root", "1234");
        
    }
    public void addBooking(Movie movie, User user, MovieSession movieSession, int seat_nb) throws SQLException
    {
        int sessionID = movieSession.getID();
        int seatNb = seat_nb;
        String date = movieSession.getDate();
        String title = movie.getTitle();
        
        if(user==null)
        {
            System.out.println("Add booking = guest");
            PreparedStatement myStmt = myConn.prepareStatement("INSERT INTO `booking` (`id`, `MovieSessionID`, `UserID`, `User1Name`, `User2Name`, `MovieTitle`, `Date`, `nb_seats`) VALUES (NULL, ?, ?, ?, ?, ?,?,?);");
            myStmt.setInt(1, sessionID);
            myStmt.setInt(2, 0);
            myStmt.setString(3, "GUEST");
            myStmt.setString(4, "GUEST");
            myStmt.setString(5, title);
            myStmt.setString(6, date);
            myStmt.setInt(7, seatNb);
            myStmt.execute();
            myStmt.close(); 
            
        }
        else 
        {
            int userID = user.getID();
            String prenom = user.getPrenom();
            String nom = user.getNom();
            PreparedStatement myStmt = myConn.prepareStatement("INSERT INTO `booking` (`id`, `MovieSessionID`, `UserID`, `User1Name`, `User2Name`, `MovieTitle`, `Date`, `nb_seats`) VALUES (NULL, ?, ?, ?, ?, ?,?,?);");
            myStmt.setInt(1, sessionID);
            myStmt.setInt(2, userID);
            myStmt.setString(3, prenom);
            myStmt.setString(4, nom);
            myStmt.setString(5, title);
            myStmt.setString(6, date);
            myStmt.setInt(7, seatNb);
            myStmt.execute();
            myStmt.close(); 
        
        }
         
        
        
        
        
    }
    
    private Booking convertRowToBooking(ResultSet myRs) throws SQLException, Exception 
        {
		
		
		int sessionID = myRs.getInt("MovieSessionID");
		int userID = myRs.getInt("UserID");
		String prenom = myRs.getString("User1Name");
                String nom = myRs.getString("User2Name ");
                String title = myRs.getString("MovieTitle");
                String date = myRs.getString("Date");
                int seatNb = myRs.getInt("nb_seats");
                
                
		
		Booking tempBooking = new Booking( sessionID, userID, prenom, nom, title,date,seatNb);
		
		return tempBooking;
	}
        
        private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException 
        {
		close(null, myStmt, myRs);		
	}
}

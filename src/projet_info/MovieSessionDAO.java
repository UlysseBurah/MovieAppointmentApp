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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author ulyss
 */
public class MovieSessionDAO {

    private Connection myConn;

    public MovieSessionDAO() throws Exception {

        // get db properties
        Properties props = new Properties();
        /*props.load(new FileInputStream("demo.properties"));

         String user = props.getProperty("user");
         String password = props.getProperty("password");
         String dburl = props.getProperty("dburl");*/

        // connect to database
        String url = "jdbc:mysql://localhost:3308/moviedatabase?allowPublicKeyRetrieval=true&useSSL=false";
        myConn = DriverManager.getConnection(url, "root", "1234");

        System.out.println("TI ES FADA NARVALOOOOOO");
    }

    public List<MovieSession> getAllMovieSession(String titre) throws Exception {

        List<MovieSession> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        System.out.println("ok1");
        try {

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM `moviesession` WHERE `movietitle` LIKE '" + titre + "'");
            while (myRs.next()) {
                MovieSession tempMovieSession = convertRowToMovieSession(myRs);
                list.add(tempMovieSession);
                
            }
            
            return list;
        } finally {
            close(myStmt, myRs);
            System.out.println("ok2");
        }
        
    }

    private MovieSession convertRowToMovieSession(ResultSet myRs) throws SQLException {

        String date = myRs.getString("date");
        int sit_nb = myRs.getInt("sit_nb");
        String title = myRs.getString("movietitle");
        int id = myRs.getInt("id");

        MovieSession tempMovieSession = new MovieSession(date, sit_nb, title,id);

        return tempMovieSession;
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

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }
    
    public void updateSession(MovieSession session, int seat_nb) throws SQLException
    {
        String title = session.getTitle();
        String date = session.getDate();
        int id = session.getID();
        int seat_nb_final = session.getSit_nb()-seat_nb;

        
        PreparedStatement myStmt = myConn.prepareStatement("UPDATE `moviesession` SET `movietitle`= ?,`date`= ?,`sit_nb`= ? WHERE id LIKE ?");
        myStmt.setString(1, title);
        myStmt.setString(2, date);
        myStmt.setInt(3, seat_nb_final);
        myStmt.setInt(4, id);
        myStmt.execute();
        myStmt.close();
        System.out.println(title +date+ seat_nb_final + id );
        
    }
    
    public void removeMovieSession(MovieSession movieSession) throws SQLException
    {
        int reponse = JOptionPane.showConfirmDialog(null, "Do you really want to delete this movie session ?","Remove movie session", JOptionPane.YES_NO_CANCEL_OPTION);

        if(reponse == JOptionPane.YES_OPTION)
        {
            String title = movieSession.getTitle();
            String date = movieSession.getDate();
            PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM `moviesession` WHERE `movietitle` LIKE ? AND `date` LIKE ? ;");
            myStmt.setString(1, title);
            myStmt.setString(2, date);
            myStmt.execute();
            myStmt.close();

        }
    }
    
    public void addMovieSession(MovieSession movieSession) throws SQLException
    {

        String title = movieSession.getTitle();
        String date = movieSession.getDate();
        int sit_nb = movieSession.getSit_nb();
        
        

      
        PreparedStatement myStmt = myConn.prepareStatement("INSERT INTO `moviesession` (`id`, `movietitle`, `date`, `sit_nb`) VALUES (NULL, ?, ?, ?);");
        myStmt.setString(1, title);
        myStmt.setString(2, date);
        myStmt.setInt(3, sit_nb);
        
        myStmt.execute();
        myStmt.close();



    }
}

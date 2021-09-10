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
import java.util.List;
import java.util.Properties;

/**
 *
 * @author ulyss
 */
public class ChartsDAO 
{
    private Connection myConn;
    
    
    ChartsDAO() throws SQLException
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
    
    public ChartsPanel getBookingChart(List<Movie> movies) throws SQLException
    {
        int[] datas = new int[movies.size()];
        int index = 0;
        String[] titles = new String[movies.size()];
        
        for(Movie movie : movies)
        {
            String title = movie.getTitle();
            int nbBooking = 0;
            
            
            PreparedStatement myStmt = myConn.prepareStatement("SELECT COUNT(*) AS num_rows FROM booking WHERE  MovieTitle = ?");
            myStmt.setString(1, title); 
            ResultSet rs = myStmt.executeQuery();
            
            
            while (rs.next()) 
            {
                nbBooking = rs.getInt("num_rows");
                datas[index] = nbBooking;
                titles[index] = title;
                index += 1;

            }
            
        }
        
        return new ChartsPanel(datas,titles,"Booking per movie");
    }
}

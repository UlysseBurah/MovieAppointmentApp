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
import javax.naming.spi.DirStateFactory.Result;
import static javax.swing.text.html.HTML.Tag.SELECT;

/**
 *
 * @author ulyss
 */
public class UserDAO 
{
    private Connection myConn;
    
    
    UserDAO() throws SQLException
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
    
    public void addUser(User user) throws SQLException
    {
        String nom = user.getNom();
        String prenom = user.getPrenom();
        String mail = user.getEmail();
        String password = user.getPassword();
        String discount = user.getDiscount();
        
        PreparedStatement myStmt = myConn.prepareStatement("INSERT INTO `user` (`id`, `nom`, `prenom`, `email`, `password`, `discount`) VALUES (NULL, ?, ?, ?, ?, ?);");
        myStmt.setString(1, nom);
        myStmt.setString(2, prenom);
        myStmt.setString(3, mail);
        myStmt.setString(4, password);
        myStmt.setString(5, discount);
        myStmt.execute();
        myStmt.close();
        
        
        
    }
    
    
    
    public boolean connectUser(String mail, String password) throws SQLException
    {
        boolean test = false;
        Statement myStmt = myConn.createStatement();
        ResultSet result = myStmt.executeQuery("SELECT `email`,`password` FROM `user` WHERE 1");
        
        while(result.next())
        {
            if(mail.equals(result.getString("email")) && password.equals(result.getString("password")))
            {
                
                test = true;
                break;
                
            }
            else
            {
               test = false;

            }
            
            
            
        }
        myStmt.close();
        return test;
        
    }
    
    public User getUser(String mail, String password) throws SQLException, Exception
    {
        User user = null;
        PreparedStatement myStmt = myConn.prepareStatement("SELECT * FROM `user` WHERE `email` LIKE ? && `password` LIKE ?");
        myStmt.setString(1, mail);
        myStmt.setString(2, password);
        ResultSet myRs = myStmt.executeQuery();
        
        while(myRs.next())
        {
            
            user = convertRowToUser(myRs);
            
        }
        myStmt.close();
        return user;
        
    }
        private User convertRowToUser(ResultSet myRs) throws SQLException, Exception 
        {
		
		int id = myRs.getInt("id");
		String nom = myRs.getString("nom");
		String prenom = myRs.getString("prenom");
		String email = myRs.getString("email");
                String password = myRs.getString("password");
                String discount = myRs.getString("discount");
                
                
		
		User tempUser = new User( nom, prenom, email, password, discount,id);
		
		return tempUser;
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
    
    public boolean mailCheck(User user) throws SQLException
    {
        boolean test=false;
        String mail = user.getEmail();
        Statement myStmt = myConn.createStatement();
        ResultSet result = myStmt.executeQuery("SELECT `email` FROM `user` WHERE 1");
        
        while(result.next())
        {
            System.out.println(result.toString());
            if(mail.equals(result.getString("email")))
            {
                
                test = false;
                break;
                
            }
            else
            {
                
                test = true;

            }
            
        }
        myStmt.close();
        return test;
        
        
    }
}

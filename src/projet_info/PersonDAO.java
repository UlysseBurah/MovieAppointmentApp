/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ulyss
 */
public class PersonDAO 
{
    private Connection myConn;
    
    
    PersonDAO() throws SQLException
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
    
    public void addPerson(Person person)
    {
        String nom = person.getNom();
        String prenom = person.getPrenom();
        
        
        
    }
}

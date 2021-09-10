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
public class EmployeeDAO 
{
    private Connection myConn;
    
    EmployeeDAO() throws SQLException
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
    
   
    
    public boolean connectEmployee(String mail, String password, String employee_nb) throws SQLException
    {
        boolean test = false;
        Statement myStmt = myConn.createStatement();
        ResultSet result = myStmt.executeQuery("SELECT `email`,`password`,`employee_nb` FROM `employee` WHERE 1");
        
        while(result.next())
        {
            
            if(mail.equals(result.getString("email")) && password.equals(result.getString("password"))&& employee_nb.equals(result.getString("employee_nb")))
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
    
    public Employee getEmployee(String mail, String password, String employeeNb) throws SQLException, Exception
    {
        Employee employee = null;
        PreparedStatement myStmt = myConn.prepareStatement("SELECT * FROM `employee` WHERE `email` LIKE ? && `password` LIKE ? && `employee_nb` LIKE ?");
        myStmt.setString(1, mail);
        myStmt.setString(2, password);
        myStmt.setString(3, employeeNb);
        ResultSet myRs = myStmt.executeQuery();
        
        while(myRs.next())
        {
            
            employee = convertRowToEmployee(myRs);
            
        }
        myStmt.close();
        return employee;
        
    }
        private Employee convertRowToEmployee(ResultSet myRs) throws SQLException, Exception 
        {
		
		
		String nom = myRs.getString("nom");
		String prenom = myRs.getString("prenom");
		String email = myRs.getString("email");
                String password = myRs.getString("password");
                String employee_nb = myRs.getString("employee_nb");
                
		
		Employee tempEmployee = new Employee( nom, prenom, email, password, employee_nb);
		
		return tempEmployee;
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

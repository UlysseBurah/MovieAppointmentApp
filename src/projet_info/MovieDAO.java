package projet;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;
import javax.swing.JOptionPane;



/**
 * 
 * @author www.luv2code.com
 *
 */
public class MovieDAO {

	private Connection myConn;
	
	public MovieDAO() throws Exception {
		
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
	
	public List<Movie> getAllMovies() throws Exception 
        {
		List<Movie> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from movie");
			
			while (myRs.next()) {
				Movie tempMovie = convertRowToMovie(myRs);
				list.add(tempMovie);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
        
        private Movie convertRowToMovie(ResultSet myRs) throws SQLException, Exception 
        {
		
		
		String title = myRs.getString("title");
		String description = myRs.getString("description");
		String director = myRs.getString("director");
		int year = myRs.getInt("year");
                String actors = myRs.getString("actors");
                int width = myRs.getInt("width");
                int high = myRs.getInt("high");
                String duration = myRs.getString("duration");
                String synopsis = myRs.getString("synopsis");
                String releaseDate = myRs.getString("releaseDate");
		
		Movie tempMovie = new Movie(title,description, director, year,actors,width,high,duration,synopsis,releaseDate);
		
		return tempMovie;
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
	
        public void addMovie(Movie movie) throws SQLException
        {
            
            String titre = movie.getTitle();
            String description = movie.getDescription();
            String realisateur = movie.getDirector();
            int year = movie.getYear();
            String actors = movie.getActors();
            int width = movie.getwidth();
            int high = movie.getHigh();
            String duree = movie.getDuration();
            String synopsis = movie.getSynopsis();
            String releaseDate = movie.getReleaseDate();
            
            System.out.println(titre);
            System.out.println(description);
            System.out.println(realisateur);
            System.out.println(year);
            System.out.println(actors);
            System.out.println(width);
            System.out.println(high);
            System.out.println(duree);
            System.out.println(synopsis);
            System.out.println(releaseDate);
            

            PreparedStatement myStmt = myConn.prepareStatement("INSERT INTO `movie` (`id`, `title`, `description`, `director`, `year`, `actors`, `width`, `high`, `duration`, `synopsis`, `releaseDate`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            myStmt.setString(1, titre);
            myStmt.setString(2, description);
            myStmt.setString(3, realisateur);
            myStmt.setInt(4, year);
            myStmt.setString(5, actors);
            myStmt.setInt(6, width);
            myStmt.setInt(7, high);
            myStmt.setString(8, duree);
            myStmt.setString(9, synopsis);
            myStmt.setString(10, releaseDate);
            myStmt.execute();
            myStmt.close();



        }
        
        public void removeMovie(Movie movie) throws SQLException
        {
            int reponse = JOptionPane.showConfirmDialog(null, "Do you really want to delete this movie ?","Remove movie", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(reponse == JOptionPane.YES_OPTION)
            {
                String title = movie.getTitle();
                PreparedStatement myStmt = myConn.prepareStatement("DELETE FROM `movie` WHERE `title` LIKE ?;");
                myStmt.setString(1, title);
                myStmt.execute();
                myStmt.close();
                
            }
        }
        
        public void updateMovie(Movie movie) throws SQLException
        {
            String titre = movie.descriptionModify1.getText();
            String description = movie.descriptionModify6.getText();
            String realisateur = movie.descriptionModify7.getText();
            int year = Integer.parseInt(movie.descriptionModify2.getText());
            String actors = movie.descriptionModify4.getText();
            
            String duree = movie.descriptionModify3.getText();
            String synopsis = movie.textArea3.getText();
            String releaseDate = movie.descriptionModify5.getText();
            int reponse = JOptionPane.showConfirmDialog(null, "Do you really want to update this movie ?"," Movie update", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(reponse == JOptionPane.YES_OPTION)
            {
                String title = movie.getTitle();
                PreparedStatement myStmt = myConn.prepareStatement("UPDATE `movie` SET `title`= ?,`description`= ?,`director`= ?,`year`=?,`actors`=?,`duration`= ?,`synopsis`=?,`releaseDate` = ? WHERE title LIKE ?");
                myStmt.setString(1, titre);
                myStmt.setString(2, description);
                myStmt.setString(3, realisateur);
                myStmt.setInt(4, year);
                myStmt.setString(5, actors);
                myStmt.setString(6, duree);
                myStmt.setString(7, synopsis);
                myStmt.setString(8, releaseDate);
                myStmt.setString(9, movie.getTitle());
                
                myStmt.execute();
                myStmt.close();
                
            }
        }
        
        
	/*public List<Employee> searchEmployees(String lastName) throws Exception {
		List<Employee> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			lastName += "%";
			myStmt = myConn.prepareStatement("select * from employees where last_name like ?");
			
			myStmt.setString(1, lastName);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}*/
	
	

	
	

	
}

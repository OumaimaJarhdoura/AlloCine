package daos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import entities.Movie;

public class MovieDAO {
	
	private final String adressBD = "jdbc:mysql://localhost";
	private final String nameBD = "allocinedb";
	private final String userBD = "root";
	private final String mdpBD = "root";
	
	private Connection connection;
	
	public MovieDAO(){
		connection = null;
		
	}
	
	public int create(Movie movie)
	{
		if(movie.getTitle().equals("") || movie.getGenre().equals("") || movie.getDuration().equals("") ||
				movie.getSynopsis().equals("") || movie.getReleaseDate().equals("")) return -1; //erreur
		
		else
		{
			Statement st = getConnection();
			String sql = "Insert into movie(Id,Title,Genre,Duration,Synopsis,ReleaseDate,Director,Cast,Nationality) "
						+ "values("+movie.getId()+",'"+movie.getTitle()+"','"+movie.getGenre()+"','"+movie.getDuration()
						+",'"+movie.getSynopsis()+",'"+movie.getReleaseDate()+",'"+movie.getDirector()
						+",'"+movie.getCast()+"',"+movie.getNationality()+")";
				int cpt;
				try {
					cpt = st.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("Error creating  the movie : "+ sql);
					exitConnection(st);
					return 0;
				}
				exitConnection(st);
				if(cpt == 1)
					return 1;
				else
					return 0;
		}
	}
	

	private Statement getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection)DriverManager.getConnection(adressBD+"/"+nameBD,userBD,mdpBD);
			Statement st = (Statement) connection.createStatement();
			return st;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trouv\u00e9e "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erreur SQL : "+e.getMessage());
		}
		return null;
	}
	
	private void exitConnection(Statement st)
	{
		try {
			st.close();
		} catch (SQLException e1) {
		} catch(NullPointerException n){}
		try {
			connection.close();
		} catch (SQLException e) {
		} catch(NullPointerException n){}
	}
	

}

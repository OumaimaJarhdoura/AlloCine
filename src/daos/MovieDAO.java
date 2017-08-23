package daos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

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

	public int create(Movie movie)
	{
		if(movie.getTitle().equals("") || movie.getGenre().equals("") || movie.getDuration().equals("") ||
				movie.getSynopsis().equals("") || movie.getReleaseDate().equals("") || movie.getLanguage().equals("") ||
				movie.getDirector().equals("") || movie .getCast().equals("") ||movie.getStarts().equals("") ||
				movie.getEnds().equals("")) return -1; //erreur
		
		else
		{
			Statement st = getConnection();
			String sql = "Insert into movie(ID,Title,Genre,Duration,Synopsis,ReleaseDate,Director,Cast,Language,Age,ProjectionStarts,ProjectionEnds,Link) "
						+ "values('0','"+movie.getTitle()+"','"+movie.getGenre()+"','"+movie.getDuration()
						+"','"+movie.getSynopsis()+"','"+movie.getReleaseDate()+"','"+movie.getDirector()
						+"','"+movie.getCast()+"','"+movie.getLanguage()+"','"+movie.getAge()+"','"+movie.getStarts()+"','"+movie.getEnds()+"','"+movie.getLink()+"')";
				int cpt;
				try {
					cpt = st.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("Error creating  the movie : "+ sql+" "+ e.getMessage());
				
					exitConnection(st);
					return 0;
				}
				exitConnection(st);
				if(cpt == 1){
					System.out.println("Ok ");
					return 1;
				}
				else {
					System.out.println("KO ");
					return 0;
				}
		}
	}
	

	
	public ArrayList<Movie> search(String title) {
		Statement st = getConnection();
			ArrayList<Movie> moviesFounded = new ArrayList<Movie>();
			try {
				String sql = "SELECT * From movie WHERE Title LIKE'"+title+"'";
				ResultSet resultat = st.executeQuery(sql);
				while(resultat.next())
				{
					String m_title = resultat.getString("Title");
					String m_genre = resultat.getString("Genre");
					String m_releasedate = resultat.getString("ReleaseDate");
					String m_duration = resultat.getString("Duration");
					String m_synopsis = resultat.getString("Synopsis");
					String m_language = resultat.getString("Language");
					String m_director = resultat.getString("Director");
					String m_cast = resultat.getString("Cast");
					String m_starts = resultat.getString("ProjectionStarts");
					String m_ends = resultat.getString("ProjectionEnds");
					String m_link = resultat.getString("Link");
					int m_age = resultat.getInt("Age");
					
					Movie movie = new Movie(m_title, m_genre, m_duration,m_releasedate, m_synopsis,
							m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
					moviesFounded.add(movie);
				}
				resultat.close();
				exitConnection(st);
				return moviesFounded;
			} catch (SQLException e) {
				System.out.println("Erreur select "+e.getMessage());
				exitConnection(st);
				return null;
			}		
		}

}

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

import services.MovieServices;
import entities.Movie;

public class MovieDAO {
	
	private final String adressBD = "jdbc:mysql://localhost";
	private final String nameBD = "allocinedb";
	private final String userBD = "root";
	private final String mdpBD = "root";
	private HttpServletRequest request;
	 
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
	
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
	
	public Movie searchById(String id){
		Statement st = getConnection();
		String sql;
		Movie moviefounded = new Movie();
		try {
			
			sql = "SELECT * From movie WHERE ID ='"+id+"'";
			ResultSet resultat = st.executeQuery(sql);
			while(resultat.next())
			{
				String m_id = resultat.getString("ID");
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
				
				moviefounded = new Movie(m_id,m_title, m_genre, m_duration,m_releasedate, m_synopsis,
						m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
			}
			resultat.close();
			exitConnection(st);
			System.out.println(moviefounded.toString());
			return moviefounded;
		} catch (SQLException e) {
			System.out.println("Erreur select "+e.getMessage());
			exitConnection(st);
			return new Movie();
		}		
	
	}
	
	public ArrayList<Movie> search(String title) {
		Statement st = getConnection();
			ArrayList<Movie> moviesFounded = new ArrayList<Movie>();
			String sql;
			try {
				if (title.equals(""))
					sql = "SELECT * From movie";
				else 
					sql = "SELECT * From movie WHERE Title ='"+title+"'";
				ResultSet resultat = st.executeQuery(sql);
				while(resultat.next())
				{
					String m_id = resultat.getString("ID");
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
					
					Movie movie = new Movie(m_id,m_title, m_genre, m_duration,m_releasedate, m_synopsis,
							m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
							moviesFounded.add(movie);
				}
				
				resultat.close();
				exitConnection(st);
				return moviesFounded;
			} catch (SQLException e) {
				System.out.println("Erreur select "+e.getMessage());
				exitConnection(st);
				return new ArrayList<Movie>();
			}		
		}
	
	public ArrayList<Movie> findByCity(String city) {
		Statement st = getConnection();
			ArrayList<Movie> moviesFounded = new ArrayList<Movie>();
			String sql;
			try {
				if (city.equals(""))
					sql = "SELECT * From movie";
				else 
					sql = "SELECT * From movie m, theatre t, session s WHERE m.ID = s.MovieID AND"
							+ " s.RoomID = t.ID AND t.City ='"+city+"'";
				ResultSet resultat = st.executeQuery(sql);
				while(resultat.next())
				{
					String m_id = resultat.getString("ID");
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
					
					Movie movie = new Movie(m_id,m_title, m_genre, m_duration,m_releasedate, m_synopsis,
							m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
							moviesFounded.add(movie);
				}
				
				resultat.close();
				exitConnection(st);
				return moviesFounded;
			} catch (SQLException e) {
				System.out.println("Erreur select "+e.getMessage());
				exitConnection(st);
				return new ArrayList<Movie>();
			}		
		}
	
	
	public ArrayList<Movie> findAll() {
		Statement st = getConnection();
			ArrayList<Movie> moviesFounded = new ArrayList<Movie>();
			String sql;
			try {
				sql = "SELECT * From movie";
				ResultSet resultat = st.executeQuery(sql);
				while(resultat.next())
				{
					String m_id = resultat.getString("ID");
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
					
					Movie movie = new Movie(m_id,m_title, m_genre, m_duration,m_releasedate, m_synopsis,
							m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
							moviesFounded.add(movie);
				}
				
				resultat.close();
				exitConnection(st);
				return moviesFounded;
			} catch (SQLException e) {
				System.out.println("Erreur select "+e.getMessage());
				exitConnection(st);
				return new ArrayList<Movie>();
			}		
		}
	
	public boolean delete(String id){
		Statement st = getConnection();
		SessionDAO _sessionDAO = new SessionDAO();
		if(_sessionDAO.deleteSessions(id))
		{
			String sql = "Delete from movie WHERE ID = '"+id+"'";
				int cpt;
				try {
					cpt = st.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("Error deleting the movie : "+ sql+" "+ e.getMessage());
				
					exitConnection(st);
					return true;
				}
				exitConnection(st);
				if(cpt == 0){
					System.out.println("Ok ");
					return true;
				}
				else {
					System.out.println("KO ");
					return false;
				}
		}
		else return false;

	}
	
	
}

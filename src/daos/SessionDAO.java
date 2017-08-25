package daos;

import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import entities.Movie;
import entities.Session;
import entities.Theatre;

public class SessionDAO {
	
	private final String adressBD = "jdbc:mysql://localhost";
	private final String nameBD = "allocinedb";
	private final String userBD = "root";
	private final String mdpBD = "root";
	private HttpServletRequest request;
	 
	
	private Connection connection;
	
	public SessionDAO(){
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

	
	
	public ArrayList<Session> findAll() {
		Statement st = getConnection();
		ArrayList<Session> sessionsFounded = new ArrayList<Session>();
		String sql;
		try {
			sql = "SELECT * From session s, movie m, theatre t WHERE m.ID = s.MovieID AND t.ID = s.RoomID";
			ResultSet resultat = st.executeQuery(sql);
			while(resultat.next())
			{
				Long s_id = resultat.getLong("IDsession");
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
				String t_name = resultat.getString("Name");
				String t_city = resultat.getString("City");
				Long t_zipcode = resultat.getLong ("ZIPCode");
				String s_date = resultat.getString("Begin");
				
				Movie movie = new Movie(m_id,m_title, m_genre, m_duration,m_releasedate, m_synopsis,
						m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
				Theatre theatre = new Theatre(t_name,t_city,t_zipcode);
				Session session = new Session (s_id,movie,theatre,s_date);
						sessionsFounded.add(session);
			}
			
			resultat.close();
			exitConnection(st);
			return sessionsFounded;
		} catch (SQLException e) {
			System.out.println("Erreur select "+e.getMessage());
			exitConnection(st);
			return new ArrayList<Session>();
		}		
		}


	public int create(Session session) {
		
		if(session.getBegindate().equals(""))
				return -1; //erreur
		
		else
		{
			Statement st = getConnection();
			String sql = "Insert into session(IDsession,MovieID,RoomID,Begin)"
						+ "values('0','"+Integer.parseInt( session.getMovie().getId())+"','"+session.getTheatre().getId()+"','"+session.getBegindate()+"')";
				int cpt;
				try {
					cpt = st.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("Error creating  the session : "+ sql+" "+ e.getMessage());
				
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


	public ArrayList<Session> search(Long movieid) {
		Statement st = getConnection();
		ArrayList<Session> sessionsFounded = new ArrayList<Session>();
		String sql;
		try {
			sql = "SELECT * From session s, movie m, theatre t WHERE m.ID ='"+ movieid+"' AND m.ID = s.MovieID AND t.ID = s.RoomID";
			ResultSet resultat = st.executeQuery(sql);
			while(resultat.next())
			{
				Long s_id = resultat.getLong("IDsession");
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
				String t_name = resultat.getString("Name");
				String t_city = resultat.getString("City");
				Long t_zipcode = resultat.getLong ("ZIPCode");
				String s_date = resultat.getString("Begin");
				
				Movie movie = new Movie(m_title, m_genre, m_duration,m_releasedate, m_synopsis,
						m_language, m_director, m_cast, m_age, m_starts, m_ends, m_link);
				Theatre theatre = new Theatre(t_name,t_city,t_zipcode);
				Session session = new Session (s_id,movie,theatre,s_date);
						sessionsFounded.add(session);
			}
			
			resultat.close();
			exitConnection(st);
			return sessionsFounded;
		} catch (SQLException e) {
			System.out.println("Erreur select "+e.getMessage());
			exitConnection(st);
			return new ArrayList<Session>();
		}		
	}
	
	
	public Session searchById(Long id) {
		Statement st = getConnection();
		Session sessionFounded = new Session();
		String sql;
		try {
			sql = "SELECT * From session WHERE ID ='"+ id+"";
			ResultSet resultat = st.executeQuery(sql);
			sessionFounded = new Session(id,((Session) resultat).getBegindate());
			resultat.close();
			exitConnection(st);
			return sessionFounded;
		} catch (SQLException e) {
			System.out.println("Erreur select "+e.getMessage());
			exitConnection(st);
			return new Session();
		}		
	}
	
	
	public boolean delete(Long id) {
		Statement st = getConnection();
			String sql = "Delete from session WHERE IDsession = '"+id+"'";
				int cpt;
				try {
					cpt = st.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("Error deleting the session : "+ sql+" "+ e.getMessage());
				
					exitConnection(st);
					return true;
				}
				exitConnection(st);
				if(cpt == 1){
					System.out.println("Ok ");
					return true;
				}
				else {
					System.out.println("KO ");
					return false;
				}
		}

	public boolean deleteSessions(String id){
		Statement st = getConnection();
		String sql = "Delete from session WHERE MovieID = '"+id+"'";
			int cpt; 
			try {
				cpt = st.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Error deleting the session : "+ sql+" "+ e.getMessage());
				exitConnection(st);
				return true;
			}
			exitConnection(st);
			if(cpt == 0){
				System.out.println("Ok");
				return true;
			}
			else {
				System.out.println("KO ");
				return false;
			}
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	


	
	
	
}


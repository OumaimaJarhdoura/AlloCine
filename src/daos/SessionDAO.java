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
	 
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
	
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
		return new ArrayList<Session>();
		}


	public int create(Session session) {
		
		if(session.getBegindate().equals(""))
				return -1; //erreur
		
		else
		{
			Statement st = getConnection();
			String sql = "Insert into session(ID,MovieID,RoomID,Begin,End)"
						+ "values('0','"+session.getMovie().getId()+"','"+session.getTheatre().getId()+"','"+session.getBegindate()
						+"','"+session.getBegindate()+"')";
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


	public ArrayList<Session> search(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}


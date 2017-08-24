package daos;

import java.sql.DriverManager; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import entities.Movie;
import entities.Theatre;

public class TheatreDAO {
	
	private final String adressBD = "jdbc:mysql://localhost";
	private final String nameBD = "allocinedb";
	private final String userBD = "root";
	private final String mdpBD = "root";
	private HttpServletRequest request;
	 
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
	
	private Connection connection;
	
	public TheatreDAO(){
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

	
	public ArrayList<Theatre> search(String city) {
		Statement st = getConnection();
			ArrayList<Theatre> theatreFounded = new ArrayList<Theatre>();
			String sql, sql1;
			try {
				if (city.equals("")){
					sql ="SELECT * FROM  Theatre ";
				}
				else {
					sql ="SELECT * FROM Theatre WHERE City ='"+city+"'";
				
				}
				ResultSet resultat = st.executeQuery(sql);
				while(resultat.next())
				{
					Long t_id = resultat.getLong("ID");
					String t_name = resultat.getString("Name");
					String t_city = resultat.getString("City");
					Long t_zipcode = resultat.getLong("ZIPCode");
					
					
					
					Theatre theatre = new Theatre(t_id,t_name,t_city,t_zipcode);
					
					theatreFounded.add(theatre);
				}
				
				resultat.close();
				exitConnection(st);
				return theatreFounded;
			} catch (SQLException e) {
				System.out.println("Erreur select "+e.getMessage());
				exitConnection(st);
				return new ArrayList<Theatre>();
			}		
		}
	public Theatre searchById(String id){
		Statement st = getConnection();
		String sql;
		Theatre theatrefounded = new Theatre();
		try {
			
			sql = "SELECT * From theatre WHERE ID ='"+id+"'";
			ResultSet resultat = st.executeQuery(sql);
			while(resultat.next())
			{
				Long t_id = resultat.getLong("ID");
				String t_name = resultat.getString("Name");
				String t_city = resultat.getString("City");
				Long t_zipcode = resultat.getLong("ZIPCode");
				
				
				theatrefounded = new Theatre (t_id,t_name,t_city,t_zipcode);
			}
			resultat.close();
			exitConnection(st);
			return theatrefounded;
		} catch (SQLException e) {
			System.out.println("Erreur select "+e.getMessage());
			exitConnection(st);
			return new Theatre();
		}		
	
	}
	public ArrayList<Theatre> findAll() {
		Statement st = getConnection();
			ArrayList<Theatre> theatreFounded = new ArrayList<Theatre>();
			String sql1;
			try {
				
				sql1 ="SELECT * FROM theatre GROUP BY t.City";
			
				
				ResultSet resultat1 = st.executeQuery(sql1);
				while(resultat1.next())
				{
					
					Long t_id = resultat1.getLong("ID");
					String t_name = resultat1.getString("Name");
					String t_city = resultat1.getString("City");
					Long t_zipcode = resultat1.getLong("ZIPCode");
					
					Theatre theatre = new Theatre(t_id,t_name,t_city,t_zipcode);
					
					theatreFounded.add(theatre);
					
				}
				
				resultat1.close();
				exitConnection(st);
				return theatreFounded;
			} catch (SQLException e) {
				System.out.println("Erreur select "+e.getMessage());
				exitConnection(st);
				return new ArrayList<Theatre>();
			}		
		}	
	
}

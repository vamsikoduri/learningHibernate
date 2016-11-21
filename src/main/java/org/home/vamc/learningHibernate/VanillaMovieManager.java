package org.home.vamc.learningHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VanillaMovieManager {

	private Connection connection = null;
	// Database properties
	private String url = "jdbc:derby://localhost:1527/db";
	private String driverClass = "org.apache.derby.jdbc.ClientDriver";
	/*
	 * private String username = "mkonda"; private String password = "mypass";
	 */

	private Connection getConnection() {
		try {
			Class.forName(driverClass).newInstance();
			connection = DriverManager.getConnection(url);
		} catch (Exception ex) {
			System.err.println("Exception:" + ex.getMessage());
		}
		return connection;
	}

	private void persistMovie()
	{
		String insertSql = "INSERT INTO MOVIES  values (?,?,?,?)";
		
		try
		{
			PreparedStatement st = getConnection().prepareStatement(insertSql);
			st.setInt(1, 3);
			st.setString(2, "The Last Action Hero");
			st.setString(3, "Vamsi");
			st.setString(4, "Krishna");
			st.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
		}
	}
	private void queryMovies() {
		try {
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM MOVIES");
			while (rs.next()) {
				System.out.println("Movie Found: " + rs.getInt("ID") + ", Title:" + rs.getString("TITLE"));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void main(String args[])
	{
		VanillaMovieManager vm = new VanillaMovieManager();
		vm.persistMovie();
		vm.queryMovies();
	}
}
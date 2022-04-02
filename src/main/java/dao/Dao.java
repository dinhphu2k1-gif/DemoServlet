package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.User;

public class Dao implements IDao {
	public Connection getConnection() {
		try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:mysql://localhost:3306/vcc";
            String username = "root";
            String password = "12012001";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
	}
	
	@Override
	public List<User> getAll(){
		List<User> results = new ArrayList<>();
		String sql = "select * from Users";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					User user = new User();
					System.out.println(resultSet.getLong("Id") + " " + resultSet.getString("email")+ " " + resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					user.setPasssword(resultSet.getString("password"));
					results.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e);
			}
			finally {
					try {
						if(connection != null) connection.close();
						if (statement != null) statement.close();
						if (resultSet != null) resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return results;
	}
	
	public boolean checkUser(String email, String password) {
		String sql = "select * from Users where email = '" + email + "' and password = '" + password;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		System.out.println(sql);
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				if (resultSet.next()) return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(connection != null) connection.close();
					if (statement != null) statement.close();
					if (resultSet != null) resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Dao dao = new Dao();
		List<User> results = new ArrayList<>();
		results = dao.getAll();
		System.out.println(dao.checkUser("admin@email.com", "' or 1=1--"));
	}
}

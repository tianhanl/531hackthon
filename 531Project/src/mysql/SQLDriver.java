package mysql;

import java.sql.*;

import data.User;

public class SQLDriver {
	
	// ALL constant statement for data query
	private final static String JDBC = "jdbc:mysql://localhost:3306/531Project?user=root&password=ericwang&useSSL=false";
	private final static String SELECTUSER = "SELECT * FROM UserLogin WHERE username = ?";
	private final static String SELECTUSERCARD = "SELECT * FROM UserInfo WHERE username = ?";
	private final static String ADDUSER = "INSERT INTO UserLogin(username, password, nickname) VALUES(?,?,?)";
	private final static String ADDUSERCARD = "INSERT INTO UserInfo(username, card_name, card_position) VALUES(?,?,?)";
	private final static String DELETECARD = "DELETE FROM userInfo WHERE username = ? AND card_position = ?";

	public static User findUser(String username){
		User newUser = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC);
			PreparedStatement ps = conn.prepareStatement(SELECTUSER);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String password = rs.getString("password");
				String nickname = rs.getString("nickname");
				newUser = new User(username, password, nickname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newUser;
	}
	
	public static boolean addUser(String username, String password, String nickname){
		if(findUser(username) != null) return false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC);
			PreparedStatement ps = conn.prepareStatement(ADDUSER);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, nickname);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	public static boolean checkPassword(String username, String password){
		User login = findUser(username);
		if(login == null) return false;
		if(login.getPassword().equals(password)) return true;
		return false;
	}
	
	public static boolean addCardToUser(String username, String cardName, int position){
		User user = findUser(username);
		if(user == null) return false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC);
			PreparedStatement ps = conn.prepareStatement(ADDUSERCARD);
			ps.setString(1, username);
			ps.setString(2, cardName);
			ps.setInt(3, position);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean deleteCardFromUser(String username, int position){
		User user = findUser(username);
		if(user == null) return false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC);
			PreparedStatement ps = conn.prepareStatement(DELETECARD);
			ps.setString(1, username);
			ps.setInt(2, position);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Delete card error!");
			return false;
		}
		return true;
	}
	
	
	
	
}

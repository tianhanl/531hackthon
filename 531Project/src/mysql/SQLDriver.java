package mysql;

import java.sql.*;

public class SQLDriver {
	
	// ALL constant statement for data query
	private final static String JDBC = "jdbc:mysql://localhost:3306/531Project?user=root&password=ericwang&useSSL=false";
	private final static String SELECTUSER = "SELECT * FROM UserLogin WHERE username = ?";
	private final static String SELECTUSERCARD = "SELECT * FROM UserInfo WHERE username = ?";
	private final static String ADDUSER = "INSERT INTO UserLogin(username, password, nickname) VALUES(?,?,?)";
	private final static String ADDUSERCARD = "INSERT INTO UserInfo(username, card_name, card_position) VALUES(?,?,?)";

	public static User findUser(String username){
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(JDBC);
		PreparedStatement ps = conn.prepareStatement(SELECTUSER);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		User newUser = null;
		while(rs.next()){
			String password = rs.getString("password");
			String nickname = rs.getString("nickname");
			newUser = new User(username, password, nickname);
		}
		return newUser;
	}
	
	public static boolean addUser(String username, String password, String nickname){
		if(findUser(username) != null) return false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(JDBC);
		PreparedStatement ps = conn.prepareStatement(ADDUSER);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, nickname);
		ps.executeUpdate();
		
		
	}
	
	
	
	
}

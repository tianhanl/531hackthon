package data;

import java.util.ArrayList;
import java.util.List;


public class User {
	private String username;
	private String password;
	private String nickname;
	private String[] cardList = new String[6];
	
	
	public User(){
		
	}
	
	public User(String usr, String pwd, String nck){
		this.setUsername(usr);
		this.setPassword(pwd);
		this.setNickname(nck);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void addOneCard(){
		
	}
	
	
	
}


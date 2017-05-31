package data;

import java.util.ArrayList;
import java.util.List;

import mysql.SQLDriver;


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
	
	public boolean addOneCard(String cardName, int position){
		return SQLDriver.addCardToUser(this.username, cardName, position);
	}
	
	public boolean addToCardList(String cardName, int position){
		if(cardList[position].isEmpty())
		{
			cardList[position] = cardName;
			return true;		
		}
		return false;
	}
	
	
}


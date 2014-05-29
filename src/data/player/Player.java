package data.player;


import java.awt.Image;

import jdbc.DataBase;

public class Player
{
	private String userToken;
	private Image picture;
	private int win,lose;
	private DataBase dataBase = new DataBase();
	
	public Player (String userToken) {
		this.userToken = userToken;
	}
	
	public String getUserToken() {
		return userToken;
	}
	
	public Image getPicture() {
		return picture;
	}
	
	public int getWin() {
		win = dataBase.selectWin(userToken);
		return win;
	}
	
	public int getLose() {
		lose = dataBase.selectLose(userToken);
		return lose;
	}
	
	
}
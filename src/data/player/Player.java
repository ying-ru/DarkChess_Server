package data.player;


import java.awt.Image;

public class Player
{
	private String userToken;
	private Image picture;
	private int win,lose;
	
	public String getUserToken() {
		return userToken;
	}
	public Image getPicture() {
		return picture;
	}
	public int getWin() {
		return win;
	}
	public int getLose() {
		return lose;
	}
	
}
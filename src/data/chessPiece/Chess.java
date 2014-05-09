package data.chessPiece;

public class Chess{
	private int color;//0¬°¬õ
	private boolean cover;
	private boolean dead;
	private String name;
	private int priority;//Åv­«§PÂ_
	private int x;
	private int y;
	
	public Chess(int color,boolean cover,boolean dead,String name,int x,int y){
		this.color = color;
		this.cover = cover;
		this.dead = dead;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	public int getColor(){
		return color;
	}
	public boolean getCover(){
		return cover;
	}
	public void setCover(boolean cover){
		this.cover = cover;
	}
	public boolean getDead(){
		return dead;
	}
	public void setDead(boolean dead){
		this.dead = dead;
	}
	public String getName(){
		return name;
	}
	public int getPriority(){
		return priority;
	}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
}
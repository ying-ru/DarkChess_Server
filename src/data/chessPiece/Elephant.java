package data.chessPiece;

public class Elephant extends Chess{
	private int priority = 5;
	public Elephant(int color,boolean cover,boolean dead,String name,int x,int y){
		super(color, cover, dead, name,x,y);
	}
}

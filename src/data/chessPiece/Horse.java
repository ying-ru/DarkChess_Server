package data.chessPiece;

public class Horse extends Chess{
	private int priority = 3;
	public Horse(int color,boolean cover,boolean dead,String name,int x,int y){
		super(color, cover, dead, name,x,y);
	}
}

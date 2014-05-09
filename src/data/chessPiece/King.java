package data.chessPiece;

public class King extends Chess{
	private int priority = 7;
	public King(int color,boolean cover,boolean dead,String name,int x,int y){
		super(color, cover, dead, name,x,y);
	}
}

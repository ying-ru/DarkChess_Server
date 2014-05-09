package data.chessPiece;

public class Pawn extends Chess{
	private int priority = 1;
	public Pawn(int color,boolean cover,boolean dead,String name,int x,int y){
		super(color, cover, dead, name ,x ,y);
	}

}

package data.chessPiece;

public class Rook extends Chess{
	private int priority = 4;
	public Rook(int color,boolean cover,boolean dead,String name,int x,int y){
		super(color, cover, dead, name,x,y);
	}

}

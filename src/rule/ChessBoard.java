package rule;
import data.chessPiece.Chess;



public class ChessBoard {
	private int length;
	private int width;
	private Chess[][] chessBoard;

	public ChessBoard(int length, int width) /** �ѽL��l �|����@ **/
	{
		this.length = length;
		this.width = width;
		chessBoard = new Chess[length][width];
		Random random = new Random();//???
	}

	public Chess[][] getChessBoard() {
		return chessBoard;
	}

	public Chess getChess(int x, int y) {
		return chessBoard[y][x];
	}
}

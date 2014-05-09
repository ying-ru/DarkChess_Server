package rule;
import data.chessPiece.Chess;

public class ChessBoard {
	private Chess[][] chessBoard;
	private String[][] chessName;
	
	public ChessBoard() /** �ѽL��l �|����@ **/
	{
		Random random = new Random();//???
		chessBoard = random.getChessBoard();
		chessName = random.getChessName();
	}

	public Chess[][] getChessBoard() {
		return chessBoard;
	}

	public Chess getChess(int x, int y) {
		return chessBoard[y][x];
	}
	
	public String[][] getChessName() {
		return chessName;
	}
}

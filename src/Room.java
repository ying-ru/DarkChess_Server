

import java.awt.Image;
import java.util.LinkedList;

import data.chessPiece.Chess;
import rule.ChessBoard;
import rule.temp;
/**  �ж������ɦ^�Ǹ�� �H�ΧR���ж����D     **/
public class Room 
{
	int roomNum;
	private ChessBoard chessBoard;
	private String player0UserToken;
	private String player1UserToken;
	private int nowPlay = 0;
	private LinkedList<String> chatMsg = new LinkedList<String>();
	
	public Room(int roomNum,String player0UserToken,String player1UserToken) 
	{
		this.roomNum = roomNum;
		this.chessBoard = new ChessBoard( 9 , 5 ); /**  ��ӴѽL���P  **/
		this.player0UserToken = player0UserToken;
		this.player1UserToken = player1UserToken;
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	
	public String getPlayer0UserToken() {
		return player0UserToken;
	}
	
	public String getPlayer1UserToken() {
		return player1UserToken;
	}
	
	private void changePlayer() //���ܲ{�b���a
	{
		nowPlay = ( nowPlay + 1 ) % 2;
	}
	
	public boolean moveChess(int roomNum , String UserToken,int xOfStart,int yOfStart,int xOfEnd,int yOfEnd)//�^�ǫ��A�ܤ�
	{
		boolean ActionSuccess = false;
		if (this.roomNum == roomNum) {//�T�{�ж��s��?
			// ��@ moveChess
			if ((nowPlay == 0 && UserToken.equals(player0UserToken))
					|| (nowPlay == 1 && UserToken.equals(player1UserToken))) {
				temp temp = new temp();
				ActionSuccess = temp.moveRule(chessBoard, xOfStart, yOfStart,
						xOfEnd, yOfEnd);
			} else {// ���a���Ǥ���
				ActionSuccess = false;
			}
		}else{
			ActionSuccess = false ;
		}
		return ActionSuccess;
	}
	
//	public boolean openChess(String UserToken,int x,int y)
//	{
//		boolean ActionSuccess = false ;
//		//��@ openChess
//		
//		return ActionSuccess;
//	}
	
	public boolean hasChess(ChessBoard chessBoard , int toX , int toY){
		boolean hasChess = false;
		
		return hasChess;
	}
	
	public Chess[][] updateChessBoardInfo(String UserToken) /** �P�B��T���D   **/
	{
		//��@ updateChessBoardInfo ��D�Ӫ��a�ɤ��n���L��s�ѽL (�����ݰʧ@)
		return chessBoard.getChessBoard();
	}
	
	public boolean chat(String UserToken,String msg)/** �P�B��T���D   **/
	{
		boolean ActionSuccess = false ;
		//��@ chat ��Y�@�誱�a�ϥΦ�method �ݳq���t�@�誱�a��s
		return ActionSuccess;
	}
}

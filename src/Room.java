

import java.awt.Image;
import java.util.LinkedList;

import data.chessPiece.Chess;
import rule.ChessBoard;
import rule.temp;
/**  房間結束時回傳資料 以及刪除房間問題     **/
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
		this.chessBoard = new ChessBoard( 9 , 5 ); /**  兩個棋盤不同  **/
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
	
	private void changePlayer() //改變現在玩家
	{
		nowPlay = ( nowPlay + 1 ) % 2;
	}
	
	public boolean moveChess(int roomNum , String UserToken,int xOfStart,int yOfStart,int xOfEnd,int yOfEnd)//回傳型態變化
	{
		boolean ActionSuccess = false;
		if (this.roomNum == roomNum) {//確認房間編號?
			// 實作 moveChess
			if ((nowPlay == 0 && UserToken.equals(player0UserToken))
					|| (nowPlay == 1 && UserToken.equals(player1UserToken))) {
				temp temp = new temp();
				ActionSuccess = temp.moveRule(chessBoard, xOfStart, yOfStart,
						xOfEnd, yOfEnd);
			} else {// 玩家順序不對
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
//		//實作 openChess
//		
//		return ActionSuccess;
//	}
	
	public boolean hasChess(ChessBoard chessBoard , int toX , int toY){
		boolean hasChess = false;
		
		return hasChess;
	}
	
	public Chess[][] updateChessBoardInfo(String UserToken) /** 同步資訊問題   **/
	{
		//實作 updateChessBoardInfo 當非該玩家時不要讓他更新棋盤 (做等待動作)
		return chessBoard.getChessBoard();
	}
	
	public boolean chat(String UserToken,String msg)/** 同步資訊問題   **/
	{
		boolean ActionSuccess = false ;
		//實作 chat 當某一方玩家使用此method 需通知另一方玩家更新
		return ActionSuccess;
	}
}

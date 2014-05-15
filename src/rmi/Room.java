package rmi;


import java.rmi.RemoteException;
import java.util.LinkedList;

import rule.ChessBoard;
import rule.Rule;
/**  �ж������ɦ^�Ǹ�� �H�ΧR���ж����D     **/
public class Room 
{
	int roomNum;
	private ChessBoard chessBoard;
	private String player0UserToken;
	private String player1UserToken;
	private int nowPlay = 0;
	private LinkedList<String> chatMsg = new LinkedList<String>();
	private boolean hasNewMsg = true;
	Rule temp = new Rule();
	
	public Room(int roomNum,String player0UserToken,String player1UserToken) 
	{
		this.roomNum = roomNum;
		this.chessBoard = new ChessBoard(); /**  ��ӴѽL���P  **/
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
				//Rule temp = new Rule();
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
	//�P�_��Ĺ���G
	public boolean isWin(String userToken) {
		if (getScore(userToken) == 16) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getScore(String userToken) {
		int player;
		if (userToken.equals(player0UserToken)) {
			player = 0;
		} else {
			player = 1;
		}
		return temp.score(player);
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
	
	public String[][] updateChessBoardInfo(String UserToken) /** �P�B��T���D   **/
	{	
		//��@ updateChessBoardInfo ��D�Ӫ��a�ɤ��n���L��s�ѽL (�����ݰʧ@)
		String[][] chessName;
		chessName = chessBoard.getChessName();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				if(chessBoard.getChessBoard()[i][j].getCover() == false) {
					chessName[i][j] = "Cover";
				}
			}
		}
		return chessName;
	}
	
	public boolean chat(String UserToken,String msg)/** �P�B��T���D   **/
	{
		boolean ActionSuccess = false ;
		//��@ chat ��Y�@�誱�a�ϥΦ�method �ݳq���t�@�誱�a��s
		
		chatMsg.add(UserToken + " > " + msg);
		return ActionSuccess;
	}
	
	public boolean isTurnUser(String UserToken)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean turnUser = (nowPlay == 0 && UserToken.equals(player0UserToken)) || (nowPlay == 1 && UserToken.equals(player1UserToken));
		return turnUser;
	}
	
	public String updateChat()
			throws RemoteException {
		// TODO Auto-generated method stub
		String msg;
		msg = "";
		if (hasNewMsg()) {
			msg = chatMsg.removeFirst();
		}
		return msg;
	}
	
	public boolean hasNewMsg()
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean hasNewMsg = !(chatMsg.isEmpty());
		return hasNewMsg;
	}
}

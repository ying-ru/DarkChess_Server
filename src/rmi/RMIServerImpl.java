package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import data.player.Player;

//import ChineseChess.Player;
//import ChineseChess.ChineseChessRoom;

public class RMIServerImpl extends UnicastRemoteObject implements
		ServerInterface {
	private int roomNum = 0;
	private LinkedList<Room> roomlist = new LinkedList<Room>();
	// private LinkedList<String> waitingPlayer = new LinkedList<String>();/**
	// 形態要改過? **/

	private HashMap<String, Integer> waitingPlayer = new HashMap<String, Integer>();
	private LinkedList<Player> online = new LinkedList<Player>();// 紀錄每個玩家屬於哪個房間

	// This implementation must have a public constructor.
	// The constructor throws a RemoteException.
	public RMIServerImpl() throws java.rmi.RemoteException {
		super(); // Use constructor of parent class
	}

	// Implementation of the service defended in the interface
	public String check(String APIToken, String SecretToken) {
		String startTime = getDateTime();
		return startTime;
	}

	// 以下為寫完的method
	private String getDateTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}

	public int connect(String userToken)// 隨機配對
	{
		String rivalToken = "";
		if (waitingPlayer.isEmpty()) {
			waitingPlayer.put(userToken, -1);
			return -1;
		} else {
			for (String key : waitingPlayer.keySet()) {
				if (waitingPlayer.get(key) == -1) {
					rivalToken = key;
					waitingPlayer.put(rivalToken, roomNum);
					break;
				}
			}
			// 隨機找尋等待玩家清單中的人
			Room room = new Room(roomNum, userToken, rivalToken);
			roomNum++;
			roomlist.add(room);
			return room.getRoomNum();
		}

	}

	public int getRoomNum(String userToken) {
		// 如果還沒有房間 就一直回傳-1
		int roomNum = waitingPlayer.get(userToken);
		if (roomNum != -1) {
			waitingPlayer.remove(userToken);
		}
		return roomNum;
	}

	// 配對成功後 對手1取得對手的Token
	public String getRivalToken(int roomNum) {
		return roomlist.get(getRoomIndex(roomNum)).getPlayer0UserToken();
	}

	public Player getRivalData(String rivalToken) {
		Player p = null;
		for (int i = 0; i < online.size(); i++) {
			if (online.get(i).getUserToken().equals(rivalToken)) {
				p = online.get(i);
			}
		}
		return p;
	}

	public int connect(String userToken, String rivalToken)// 選擇玩家
	{
		Room room = new Room(roomNum, userToken, rivalToken);
		roomNum++;
		roomlist.add(room);
		waitingPlayer.put(rivalToken, roomNum);

		// 給一個RoomNumber
		return room.getRoomNum();
	}

	private int getRoomIndex(int roomNum)// 找到實際的位址
	{
		int roomIndex = -1;
		for (int i = 0; i < roomlist.size(); i++) {
			if (roomlist.get(i).getRoomNum() == roomNum) {
				roomIndex = roomlist.get(i).getRoomNum();
			}
		}
		return roomIndex;
	}

	public boolean moveChess(int roomNum, String userToken, int xOfStart,
			int yOfStart, int xOfEnd, int yOfEnd) {
		boolean ActionSuccess = false;
		ActionSuccess = roomlist.get(getRoomIndex(roomNum)).moveChess(roomNum,
				userToken, xOfStart, yOfStart, xOfEnd, yOfEnd);
		return ActionSuccess;
	}

	// public boolean openChess(int roomNum,String userToken,int x,int y)
	// {
	// boolean ActionSuccess = false ;
	// ActionSuccess =
	// roomlist.get(getRoomIndex(roomNum)).openChess(userToken,x, y);
	// return ActionSuccess;
	// }
	public String[][] updateChessBoardInfo(int roomNum, String userToken) {
		return roomlist.get(getRoomIndex(roomNum)).updateChessBoardInfo(
				userToken);
	}

	public boolean chat(int roomNum, String userToken, String msg) {
		boolean ActionSuccess = false;
		ActionSuccess = roomlist.get(getRoomIndex(roomNum))
				.chat(userToken, msg);
		return ActionSuccess;
	}

	@Override
	public boolean isTurnUser(int roomNum, String userToken)
			throws RemoteException {
		// TODO Auto-generated method stub
		return roomlist.get(getRoomIndex(roomNum)).isTurnUser(userToken);
	}

	@Override
	public String updateChat(int roomNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return roomlist.get(getRoomIndex(roomNum)).updateChat();
	}

	@Override
	public boolean hasNewMsg(int roomNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return roomlist.get(getRoomIndex(roomNum)).hasNewMsg();
	}

	@Override
	public int getScore(int roomNum, String userToken) throws RemoteException {
		// TODO Auto-generated method stub
		return roomlist.get(getRoomIndex(roomNum)).getScore(userToken);
	}

	@Override
	public boolean isWin(int roomNum, String userToken) throws RemoteException {
		// TODO Auto-generated method stub
		return roomlist.get(getRoomIndex(roomNum)).isWin(userToken);
	}
}

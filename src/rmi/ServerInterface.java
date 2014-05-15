package rmi;

import java.rmi.Remote;

import data.player.Player;

public interface ServerInterface extends Remote{
public String check(String APIToken,String SecretToken) throws java.rmi.RemoteException;
	
	public int connect(String UserToken) throws java.rmi.RemoteException;
	public int getRoomNum(String userToken) throws java.rmi.RemoteException;
	public String getRivalToken(int roomNum) throws java.rmi.RemoteException;
	public Player getRivalData(String rivalToken) throws java.rmi.RemoteException;
	public int connect(String UserToken,String rivalToken) throws java.rmi.RemoteException;
	public boolean moveChess(int roomNum,String UserToken,int xOfStart,int yOfStart,int xOfEnd,int yOfEnd) throws java.rmi.RemoteException;
	//public boolean openChess(int roomNum,String UserToken,int x,int y) throws java.rmi.RemoteException;
	public String[][] updateChessBoardInfo(int roomNum,String UserToken) throws java.rmi.RemoteException;
	public boolean chat(int roomNum,String UserToken,String msg) throws java.rmi.RemoteException;
	public boolean isTurnUser(int roomNum,String UserToken) throws java.rmi.RemoteException;
	public boolean hasNewMsg(int roomNum) throws java.rmi.RemoteException;
	public String updateChat(int roomNum) throws java.rmi.RemoteException;
	public int getScore(int roomNum,String UserToken) throws java.rmi.RemoteException;
	public boolean isWin(int roomNum,String UserToken) throws java.rmi.RemoteException;
}

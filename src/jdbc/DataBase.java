package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private String user_token;
	private int win;
	private int lose;
	private Connection connection = null;
	private String createSQL = "CREATE TABLE player_info (" + "user_token char(100), "
			+ "win int(11), " + "lose int(11), " + "PRIMARY KEY (user_token))";
	private String insert = "INSERT INTO player_info VALUES ("
			+ "'" + user_token.toString() + "', 0, 0)";
	private String update = "UPDATE player_info "
			+ "SET win = " + win + "SET lose = " + lose
			+ "WHERE user_token = '" + user_token.toString() + "'";
	private String selectWin = "SELECT win FROM player_info "
			+ "WHERE user_token = '" + user_token.toString() + "'";
	private String selectLose = "SELECT lose FROM player_info "
			+ "WHERE user_token = '" + user_token.toString() + "'";
	private Statement stmt;

	public DataBase() {
		try {
			// Step 1: 載入JDBC驅動程式: 請將正確值填入 ""中
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Step 2: 取得資料庫連結: 請將正確值填入 ""中
			String url = "jdbc:mysql://sqadb.cuxcf7jbbgaj.ap-northeast-1.rds.amazonaws.com/"
					+ "game_server1?user=d0030683&password=d0030683&useUnicode=true"
					+ "&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
			connection = DriverManager.getConnection(url);
			createTable();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void createTable() {
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(createSQL);
		} catch (SQLException e) {
			System.out.println("CreateDB Exception :" + e.toString());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public void insert(String userToken) {
		this.user_token = userToken;
		try {
			stmt = connection.createStatement();
			int result = stmt.executeUpdate(insert);
			System.out.println(result + " data was insert");
		} catch (SQLException e) {
			System.out.println("CreateDB Exception :" + e.toString());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public void update(String userToken, int win, int lose) {
		this.user_token = userToken;
		this.win = win;
		this.lose = lose;
		try {
			stmt = connection.createStatement();
			int result = stmt.executeUpdate(update);
			System.out.println(result + " data was update");
		} catch (SQLException e) {
			System.out.println("CreateDB Exception :" + e.toString());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public int selectWin(String userToken) {
		this.user_token = userToken;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(selectWin);
			win = Integer.parseInt(rs.getString(1));
			System.out.println(userToken.toString() + " win: " + rs.getString(1));
		} catch (SQLException e) {
			System.out.println("CreateDB Exception :" + e.toString());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return win;
	}
	
	public int selectLose(String userToken) { 
		this.user_token = userToken;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(selectLose);
			lose = Integer.parseInt(rs.getString(1));
			System.out.println(userToken.toString() + " lose: " + rs.getString(1));
		} catch (SQLException e) {
			System.out.println("CreateDB Exception :" + e.toString());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		return lose;
	}
}

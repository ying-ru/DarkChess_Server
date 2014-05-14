package rule;

import data.chessPiece.Chess;

/*
 *炮可能在判斷是否可移動就被槓掉-----待解決 
 */
public class Rule {
	Chess[][] chessBoard = new Chess[5][9];
	int player0= 0 ;
	int player1= 0 ;
	public boolean moveRule(ChessBoard chessBoard1, int x, int y, int toX,
			int toY) {
		this.chessBoard = chessBoard1.getChessBoard();
		if (x == toX && y == toY) { // 不確定取得棋子沒
			// open
			if(chessBoard[y][x].getCover() == false){
				chessBoard[y][x].setCover(true);
				return true;
			}
			
		} else { // 棋子是翻開的
			// 炮另外處理
			if (chessBoard[y][x].getName().equalsIgnoreCase("pawn")) {
				if (chessBoard[toY][toX] == null) {
					if (((Math.abs(x - toX)) + (Math.abs(y - toY))) > 1) {
						return false;// 不能走
					} else {
						chessBoard[y][x].setX(toY);
						chessBoard[y][x].setY(toX);
						if(chessBoard[y][x].getColor() == 0){//0是紅色
							player0++;
						}else{//黑色
							player1++;
						}
						return true;
					}
				} else {
					if (chessBoard[y][x].getColor() == chessBoard[toY][toX]
							.getColor()) {
						return false;
					} else {
						if ((Math.abs(x - toX) == 0)
								|| (Math.abs(y - toY) == 0)) {
							int count = 0;// 計算中間有幾顆棋子
							if (x == toX) {// y座標方向移動
								for (int i = 0; i < Math.abs(y - toY); i++) {
									if (chessBoard[i][x] != null) {
										count++;
									}
								}
							} else if (y == toY) {// x座標方向移動
								for (int i = 0; i < Math.abs(x - toX); i++) {
									if (chessBoard[y][i] != null) {
										count++;
									}
								}
							}
							if (count == 1) {
								// 吃掉
								chessBoard[toY][toX].setDead(true);
								chessBoard[y][x].setX(toY);
								chessBoard[y][x].setY(toX);
								if(chessBoard[y][x].getColor() == 0){//0是紅色
									player0++;
								}else{//黑色
									player1++;
								}
								return true;
							}
						} else {
							return false;// 歪歪的吃子
						}
					}
				}
			} else {
				if (((Math.abs(x - toX)) + (Math.abs(y - toY))) != 1) {
					return false;// 不能走
				} else {
					// 能走的情況
					if (chessBoard[toY][toX] == null) {// 欲移動位置沒有棋子
						chessBoard[y][x].setX(toY);
						chessBoard[y][x].setY(toX);
						return true;// 判定可以移動
					} else {// 欲移動位置有棋子
						if (chessBoard[toY][toX].getColor() == chessBoard[y][x]
								.getColor()) {// 棋子是自己人
							return false;
						} else {// 棋子是敵人開始判斷權重
							if ((chessBoard[y][x].getPriority() == 1)
									&& (chessBoard[toY][toX].getPriority() == 7)) {
								chessBoard[toY][toX].setDead(true);
								chessBoard[y][x].setX(toY);
								chessBoard[y][x].setY(toX);
								if(chessBoard[y][x].getColor() == 0){//0是紅色
									player0++;
								}else{//黑色
									player1++;
								}
								return true;
							} else {
								if (chessBoard[toX][toY].getPriority() < chessBoard[y][x]
										.getPriority()) {
									chessBoard[toX][toY].setDead(true);
									chessBoard[y][x].setX(toY);
									chessBoard[y][x].setY(toX);
									if(chessBoard[y][x].getColor() == 0){//0是紅色
										player0++;
									}else{//黑色
										player1++;
									}
									return true;
								} else {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return false;//它加的QAQ
	}
	public int score(int nowPlay){
		if(nowPlay == 0){
			return player0;
		}else{
			return player1;
		}
	}
	
}

package rule;

import data.chessPiece.Chess;

/*
 *���i��b�P�_�O�_�i���ʴN�Q�b��-----�ݸѨM 
 */
public class Rule {
	Chess[][] chessBoard = new Chess[5][9];
	int player0= 0 ;
	int player1= 0 ;
	public boolean moveRule(ChessBoard chessBoard1, int x, int y, int toX,
			int toY) {
		this.chessBoard = chessBoard1.getChessBoard();
		if (x == toX && y == toY) { // ���T�w���o�Ѥl�S
			// open
			if(chessBoard[y][x].getCover() == false){
				chessBoard[y][x].setCover(true);
				return true;
			}
			
		} else { // �Ѥl�O½�}��
			// ���t�~�B�z
			if (chessBoard[y][x].getName().equalsIgnoreCase("pawn")) {
				if (chessBoard[toY][toX] == null) {
					if (((Math.abs(x - toX)) + (Math.abs(y - toY))) > 1) {
						return false;// ���ਫ
					} else {
						chessBoard[y][x].setX(toY);
						chessBoard[y][x].setY(toX);
						if(chessBoard[y][x].getColor() == 0){//0�O����
							player0++;
						}else{//�¦�
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
							int count = 0;// �p�⤤�����X���Ѥl
							if (x == toX) {// y�y�Ф�V����
								for (int i = 0; i < Math.abs(y - toY); i++) {
									if (chessBoard[i][x] != null) {
										count++;
									}
								}
							} else if (y == toY) {// x�y�Ф�V����
								for (int i = 0; i < Math.abs(x - toX); i++) {
									if (chessBoard[y][i] != null) {
										count++;
									}
								}
							}
							if (count == 1) {
								// �Y��
								chessBoard[toY][toX].setDead(true);
								chessBoard[y][x].setX(toY);
								chessBoard[y][x].setY(toX);
								if(chessBoard[y][x].getColor() == 0){//0�O����
									player0++;
								}else{//�¦�
									player1++;
								}
								return true;
							}
						} else {
							return false;// �n�n���Y�l
						}
					}
				}
			} else {
				if (((Math.abs(x - toX)) + (Math.abs(y - toY))) != 1) {
					return false;// ���ਫ
				} else {
					// �ਫ�����p
					if (chessBoard[toY][toX] == null) {// �����ʦ�m�S���Ѥl
						chessBoard[y][x].setX(toY);
						chessBoard[y][x].setY(toX);
						return true;// �P�w�i�H����
					} else {// �����ʦ�m���Ѥl
						if (chessBoard[toY][toX].getColor() == chessBoard[y][x]
								.getColor()) {// �Ѥl�O�ۤv�H
							return false;
						} else {// �Ѥl�O�ĤH�}�l�P�_�v��
							if ((chessBoard[y][x].getPriority() == 1)
									&& (chessBoard[toY][toX].getPriority() == 7)) {
								chessBoard[toY][toX].setDead(true);
								chessBoard[y][x].setX(toY);
								chessBoard[y][x].setY(toX);
								if(chessBoard[y][x].getColor() == 0){//0�O����
									player0++;
								}else{//�¦�
									player1++;
								}
								return true;
							} else {
								if (chessBoard[toX][toY].getPriority() < chessBoard[y][x]
										.getPriority()) {
									chessBoard[toX][toY].setDead(true);
									chessBoard[y][x].setX(toY);
									chessBoard[y][x].setY(toX);
									if(chessBoard[y][x].getColor() == 0){//0�O����
										player0++;
									}else{//�¦�
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
		return false;//���[��QAQ
	}
	public int score(int nowPlay){
		if(nowPlay == 0){
			return player0;
		}else{
			return player1;
		}
	}
	
}

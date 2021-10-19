package org.raf.battleship;

class Board {
	
	static final int boardsize = 10;
	static char[][] board = new char[boardsize][boardsize];
	
	static void createBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = '~';
			}
		}
	}
	
	static void printBoard() {
		System.out.println("\n\n  1 2 3 4 5 6 7 8 9 10");
		char letter = 'A';
		for (int i = 0; i < boardsize; i++) {
			System.out.println(Character.toString(letter) + " " 
					+ board[i][0] + " " + board[i][1] + " "
					+ board[i][2] + " " + board[i][3] + " "
					+ board[i][4] + " " + board[i][5] + " "
					+ board[i][6] + " " + board[i][7] + " "
					+ board[i][8] + " " + board[i][9]);
			letter += 1;
		}
		
	}
	
	static void updateBoard(String y, int x) {
		
	}
	
	static int convertLetter(char a) {
		switch(a) {
			case 'A': return 0;
			case 'B': return 1;
			case 'C': return 2;
			case 'D': return 3;
			case 'E': return 4;
			case 'F': return 5;
			case 'G': return 6;
			case 'H': return 7;
			case 'I': return 8;
			case 'J': return 9;
			default : return -1;
		}
	}
	
	static boolean isValidBoardCoord(String token) {
		char letterCoord = token.charAt(0);
		if (convertLetter(letterCoord) == -1) {return false;}
		if (token.charAt(1) < '1' || token.charAt(1) > '9') {return false;}
//		if (token.length() >= 3 && token.charAt(1) == '1') {
//			if (token.charAt(2) == '0') 
//		}
		return true;
		
	}
	
	static boolean isSameCoord(String a, String b) {
		char L1 = a.charAt(0);
		char L2 = b.charAt(0);
		char N1 = a.charAt(1);
		char N2 = b.charAt(1);
		if (L1 == L2 && N1 == N2) {
			if (a.length() >= 3 && b.length() >= 3
					&& a.charAt(2) == '0' && b.charAt(2) == '0') {
				return true;
			} else if ((a.length() >= 3 && b.length() >= 3)
					&& (a.charAt(2) != '0' && b.charAt(2) != '0')) {
				return true;
			}
		} 
		return false;		// false: not same coordinate
	}
	
	static boolean placeShip(String a, String b, int shipSize) {
		if (a.charAt(0) == b.charAt(0)) { // if rows the same
			int aval;
			int bval;
			if (isTen(a)) {
				aval = 10;
				bval = Character.getNumericValue(b.charAt(1));
			} else if (isTen(b)) {
				aval = Character.getNumericValue(a.charAt(1));
				bval = 10;
			} else {
				aval = Character.getNumericValue(a.charAt(1));
				bval = Character.getNumericValue(b.charAt(1));
			}
			if(Math.abs(aval - bval) + 1 == shipSize) {
				if (isFreeHorizontal(a.charAt(0), aval, bval)) { // a.charAt(0) == b.charAt(0)
					goodShipHorizontal(a.charAt(0), aval, bval);
				} else {
					System.out.println("Da Sea Be Not Free, Yarr");
					return false;
				}
			} else {
				System.out.println("Coordinated Don't Match Ship Size");
				return false;
			}
			
		} else if (a.charAt(1) == b.charAt(1)) { // if columns are the same
				int aval = convertLetter(a.charAt(0));
				int bval = convertLetter(b.charAt(0));
				if(Math.abs(aval - bval) + 1 == shipSize) {
					char isTen;
					if(isTen(a) && isTen(b)) {
						isTen = ':';
						System.out.println("isTen is :");
					} else {
						isTen = a.charAt(1);
					}
					if(isFreeVertical(isTen, aval, bval)) {
						goodShipVertical(isTen, aval, bval);
					} else {
						System.out.println("Da Sea Be Not Free, YarrYarr");
					}
				} else {
					System.out.println("Cordinates Don't Match Ship Size");
					return false;
				}
			} else {
				return false;
			}
		
		return true;  // tmp remove later
	} 
	
	static boolean isTen(String a) {
		if(a.length() >= 3) {
			if (a.charAt(1) == '1' && a.charAt(2) == '0') {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	static boolean isFreeHorizontal(char row, int a, int b) {
		int nrow = convertLetter(row);
		int tmp = a;
		if (a < b) {
			a = b;
			b = tmp;
		}
		for (int i = b-1; i < a; i++) {
			if(board[nrow][i] != '~') {
				System.out.println("Yarr the Sea be filled");
				return false;
			}
		}
		return true;
	}
	
	static void goodShipHorizontal(char row, int a, int b) {
		int nrow = convertLetter(row);
		int tmp = a;
		if (a < b) {
			a = b;
			b = tmp;
		}
		for (int i = b-1; i < a; i++) {
			board[nrow][i] = 'O';
		}
		System.out.println("Ship of size Placed");
	}

	static boolean isFreeVertical(char column, int a, int b) {
		int ncolumn = Character.getNumericValue(column);
		ncolumn -= 1;
		if(column == ':') {ncolumn = 9;}
		int tmp = a;
		if (a < b) {
			a = b;
			b = tmp;
		}
		System.out.println("a = " + a + "  b = " + b + "  ncolumn = " + ncolumn);
		for (int i = b; i <= a; i++) {
			if(board[i][ncolumn] != '~') {
				System.out.println("Yarr the Sea be filled");
				return false;
			}
		}
		return true;
	}
	
	
	static void goodShipVertical(char column, int a, int b) {
		int ncolumn = Character.getNumericValue(column);
		ncolumn -= 1;
		if(column == ':') {ncolumn = 9;}
		int tmp = a;
		if (a < b) {
			a = b;
			b = tmp;
		}
		for (int i = b; i <= a; i++) {
			board[i][ncolumn] = 'O';
		}
		System.out.println("Ship of size Placed");
	}
}

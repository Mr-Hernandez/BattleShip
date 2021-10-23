package org.raf.battleship;

class ship {
	int line;
	int a;
	int b;
	boolean isHorizontal = true;
	boolean isSunk = false;
	
	
	public void shipSet(int line, int a, int b, boolean isHorizontal) {
		this.line = line;
		this.a = a;
		this.b = b;
		this.isHorizontal = isHorizontal;
	}
	
	public boolean isSunk() {
		return this.isSunk;
	}
	
	public boolean check(char[][] board) {
		if(this.isHorizontal) {
			for (int i = b-1; i < a; i++) {
				if(board[line][i] != 'X') {
					return false;
				}
			}
		} else {
			for (int i = b; i <= a; i++) { // replace this.a with a
				if(board[i][line] != 'X') {
					return false;
				}
			}
		}
		this.isSunk = true;
		return true;
	}
	
	public static boolean isAllSunk(ship[] ships) {
		boolean allSunk = ships[0].isSunk() 
				&& ships[1].isSunk()
				&& ships[2].isSunk()
				&& ships[3].isSunk()
				&& ships[4].isSunk();
		return allSunk;
	}
}

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
	
	
	public boolean check() {
		if(this.isHorizontal) {
			for (int i = this.b-1; i < this.a; i++) {
				if(Board.board[this.line][i] != 'X') {
					return false;
				}
			}
		} else {
			for (int i = this.b; i <= this.a; i++) {
				if(Board.board[i][this.line] != 'X') {
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

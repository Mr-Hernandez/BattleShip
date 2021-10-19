package org.raf.battleship;

class TheMain {
	
	public static void main(String[] args){
		Board.createBoard();
		Board.printBoard();
		User.setShip();
		gameLoop.userInputFire();
	}
	
	
}


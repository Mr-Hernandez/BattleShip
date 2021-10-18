package org.raf.battleship;

class TheMain {
	
	public static void main(String[] args){
		Board.createBoard();
		Board.printBoard();
		//System.out.println("\nA is " + Board.convertLetter("C"));
		Board.printBoard();
		User.setShip();
		Board.printBoard();
	}
	
	
}


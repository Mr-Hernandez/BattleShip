package org.raf.battleship;

import java.io.IOException;
import java.util.Scanner;

class TheMain {
	
	public static void main(String[] args){
		Board board1 = new Board("Player 1");
		Board board2 = new Board("Player 2");
		board1.createBoard();
		board2.createBoard();
		
		User.autoShip(board1, board2);
		board1.printBoard();
		board2.printBoard();
//		board1.printBoard();
//		User.setShip(board1);
//		//waitForEnter();
//		board2.printBoard();
//		User.setShip(board2);
//		//waitForEnter();
		
		gameLoop.userInputFire(board1, board2);
	}	
	
	static void waitForEnter() {
		System.out.println("Press Enter and pass the move to another player\n");
//		System.out.println("...\n");
		Scanner keyboard = new Scanner(System.in);
		String enter =  keyboard.nextLine();
		while(!enter.isEmpty()) {
			enter = keyboard.nextLine();
		}
		clrscr();
	}
	
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	
}


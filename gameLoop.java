package org.raf.battleship;

import java.util.Scanner;

class gameLoop {
	

	static int gamemode = 0;
	static void userInputFire() {
		//Board.printBoard();
		//Board.printInstructions(n);
		//n--;
		System.out.println("\nThe game starts!\n");
		Board.printBoard();
		System.out.println("\nTake a shot!\n");
		Scanner scannerObj = new Scanner(System.in);
		String userInput = scannerObj.nextLine();
		while(true) {
			if(Board.fireFireFire(userInput)) {
				Board.printBoard();
				break;
			} else {
				
				//System.out.println("Coordinates not valid. Input Ex (F1 F5)");
				userInput = scannerObj.nextLine(); // user input
			}
		}
		//if(shipSize == 2) {
		//scannerObj.close();
		}
}

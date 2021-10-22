package org.raf.battleship;

import java.util.Scanner;

class gameLoop {
	

	static int gamemode = 0;
	static void userInputFire() {
		//Board.printBoard();
		//Board.printInstructions(n);
		//n--;
		System.out.println("\nThe game starts!\n");
		Board.printBoardI();
		System.out.println("\nTake a shot!\n");
		Scanner scannerObj = new Scanner(System.in);
		String userInput = scannerObj.nextLine();
		while(true) {
			if(Board.fireFireFire(userInput)) {
				//System.out.println("fire is true?");
				if(ship.isAllSunk(Board.ships)) {
					System.out.println("You sank the last ship. You won. Congratulations!");
					break;
				} else {
					userInput = scannerObj.nextLine();
				}
			} else {
				System.out.println("firefire else?");
				//System.out.println("Coordinates not valid. Input Ex (F1 F5)");
				userInput = scannerObj.nextLine(); // user input
			}
		}
		//if(shipSize == 2) {
		//scannerObj.close();
		}
}

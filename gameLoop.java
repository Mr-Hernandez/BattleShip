package org.raf.battleship;

import java.util.Scanner;

class gameLoop {
	

	static int gamemode = 0;
	static void userInputFire(Board board1, Board board2) {
//		Board.printBoard();
//		Board.printInstructions(n);
//		n--;
		System.out.println("\nThe game starts!\n");
//		board1.printBoardI();
//		board2.printBoardI();
//		System.out.println("\nTake a shot!\n");

		boolean isPlayerOne = true;
		Scanner scannerObj = new Scanner(System.in);
//		String userInput = scannerObj.nextLine();
		String userInput;
		while(true) {
			if(isPlayerOne) {
				board2.printBoardI();
				System.out.println("------------------------------");
				board1.printBoard();
				System.out.println("\n" + board1.name + ", it's your turn:");
				userInput = scannerObj.nextLine();
				if(board2.fireFireFire(userInput)) {
					isPlayerOne = !isPlayerOne;
					if(ship.isAllSunk(board2.ships)) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						break;
					} else {
						//userInput = scannerObj.nextLine();
					}
				} else {
					//System.out.println("firefire else?");
					//System.out.println("Coordinates not valid. Input Ex (F1 F5)");
					//userInput = scannerObj.nextLine(); // user input
				}
			} else {                       // not player one, or is player 2
				board1.printBoardI();
				System.out.println("------------------------------");
				board2.printBoard();
				System.out.println("\n" + board2.name + ", it's your turn:");
				userInput = scannerObj.nextLine();
				if(board1.fireFireFire(userInput)) {
					isPlayerOne = !isPlayerOne;
					if(ship.isAllSunk(board1.ships)) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						break;
					} else {
						//userInput = scannerObj.nextLine();
					}
				} else {
					//System.out.println("firefire else?");
					//System.out.println("Coordinates not valid. Input Ex (F1 F5)");
					//userInput = scannerObj.nextLine(); // user input
				}
			}
		}
		//if(shipSize == 2) {
		//scannerObj.close();
		}
}

package org.raf.battleship;

import java.util.Scanner;
import java.util.StringTokenizer;

class User {
	
	
	
	static void setShip(Board board) {
		int n = 5;
		shipSetter(board, 5, n);
		board.printBoard();
		n--;
		shipSetter(board, 4, n);
		board.printBoard();
		n--;
		shipSetter(board, 3, n);
		board.printBoard();
		n--;
		shipSetter(board, 3, n);
		board.printBoard();
		n--;
		shipSetter(board, 2, n);
		board.printBoard();
   }

	private static void shipSetter(Board board, int shipSize, int n) {
		//Board.printBoard();
		board.printInstructions(n);
		n--;
		Scanner scannerObj = new Scanner(System.in);
		String userInput = scannerObj.nextLine();
		while(true) {
			if(isValidShipCoord(board, userInput, shipSize)) {
				break;
			} else {
				
				//System.out.println("Coordinates not valid. Input Ex (F1 F5)");
				userInput = scannerObj.nextLine(); // user input
			}
		}
//		if(shipSize == 2) {
//		scannerObj.close();
//		}
	}
	
	private static boolean isValidShipCoord(Board board, String s, int shipSize) {
		if(s == null || s.isEmpty()) {return false;}
		StringTokenizer st = new StringTokenizer(s);
	    int i = 0;
	    String[] Token = new String[2];	
	    while (st.hasMoreTokens()) {
	    	Token[i] = st.nextToken();
	    	i++;
	    	//System.out.println("Num of Tokens read: " + i);  
	    	if (i >= 2) {break;}
	    }
	    //System.out.println(Token[0]);
	    //System.out.println(Token[1]);
	    if (i == 1 || Token[1] == null) {return false;}
	    
	    // currently working
	    if(board.isValidBoardCoord(Token[0]) && board.isValidBoardCoord(Token[1])) {
	    	//System.out.println("isvalidcoords");
	    	if (isValidPlacement(board, Token[0], Token[1], shipSize)) {
	    		return true;
	    	}
	    }   
	    
	    return false;
	}
	
	private static boolean isValidPlacement(Board board, String a, String b, int shipSize) {
		if(!board.isSameCoord(a,b)) {
			if(board.placeShip(a, b, shipSize)) {
				return true;
			}
		}
		return false; //tmp
	}
		
	static void autoShip(Board board1, Board board2) {
		board1.placeShip("A1", "E1", 5);
		board1.placeShip("A3", "D3", 4);
		board1.placeShip("A5", "C5", 3);
		board1.placeShip("A7", "C7", 3);
		board1.placeShip("A9", "B9", 2);
		board2.placeShip("A2", "E2", 5);
		board2.placeShip("A4", "D4", 4);
		board2.placeShip("A6", "C6", 3);
		board2.placeShip("A8", "C8", 3);
		board2.placeShip("A10", "B10", 2);
	}
}

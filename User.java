package org.raf.battleship;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class User {
	
	/*
	 * can only really handle one line at a time. multiple lines wouldn't
	 * break it though.
	 */
	static void setShip(){
		shipSetter(5);
		shipSetter(4);
		shipSetter(3);
		shipSetter(3);
		shipSetter(2);
//		System.out.println("Input Coordinates for ship of size 5:"
//				+ "Example: F1 F5");
//		Scanner scannerObj = new Scanner(System.in);
//		String userInput = scannerObj.nextLine();
//		while(true) {
//			if(isValidShipCoord(userInput)) {
//				break;
//			} else {
//				System.out.println("Coordinates not valid. Input Ex (F1 F5)");
//				userInput = scannerObj.nextLine(); // user input
//			}
//		}
	
   }

	private static void shipSetter(int shipSize) {
		Board.printBoard();
		System.out.println("Input Coordinates for ship of size "
				+ shipSize
				+ "Example: F1 F5");
		Scanner scannerObj = new Scanner(System.in);
		String userInput = scannerObj.nextLine();
		while(true) {
			if(isValidShipCoord(userInput, shipSize)) {
				break;
			} else {
				Board.printBoard();
				System.out.println("Coordinates not valid. Input Ex (F1 F5)");
				userInput = scannerObj.nextLine(); // user input
			}
		}
		if(shipSize == 2) {
		scannerObj.close();
		}
	}
	
	private static boolean isValidShipCoord(String s, int shipSize) {
		if(s == null || s.isEmpty()) {return false;}
		StringTokenizer st = new StringTokenizer(s);
	    int i = 0;
	    String[] Token = new String[2];	
	    while (st.hasMoreTokens()) {
	    	Token[i] = st.nextToken();
	    	i++;
	    	System.out.println("Num of Tokens read: " + i);  
	    	if (i >= 2) {break;}
	    }
	    System.out.println(Token[0]);
	    System.out.println(Token[1]);
	    if (i == 1 || Token[1] == null) {return false;}
	    
	    // currently working
	    if(Board.isValidBoardCoord(Token[0]) && Board.isValidBoardCoord(Token[1])) {
	    	System.out.println("isvalidcoords");
	    	if (isValidPlacement(Token[0], Token[1], shipSize)) {
	    		return true;
	    	}
	    }   
	    
	    return false;
	}
	
	private static boolean isValidPlacement(String a, String b, int shipSize) {
		if(!Board.isSameCoord(a,b)) {
			if(Board.placeShip(a, b, shipSize)) {
				return true;
			}
		}
		
		return false; //tmp
	}
	
}

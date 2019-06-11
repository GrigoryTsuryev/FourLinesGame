package com.connectfour;


import java.util.*;
import java.util.Arrays;

public class ConnectFour {

	static int[][] board = new int[7][7];
	
	
	 
	public static void main (String[] args) {
		
		
		
		Player player1 = new Player('x' , board);
		Player player2 = new Player('y', board);
		
		Game game = new Game(board);
		game.start();
		game.printBoard();

		boolean winner = false;
		while(!winner) {
				playMove(player1, game);
				
				winner = isWinner(player1);
				System.out.println(winner);
				if (winner) {
					System.out.println("Player 1 is a winner");
					break;
				};

				playMove(player2, game);
				winner = isWinner(player2);
				if (winner) {
					System.out.println("Player 2 is a winner");
					break;
				};
		}
		
	}

	


	private static void playMove(Player player1, Game game) {
		player1.makeMove();
		game.printBoard();
	}
	
	private static boolean isWinner(Player player) {
		boolean line =  checkline(player);
		boolean column =  checkColumn(player);
		boolean leftDiagonal =  checkLeftDiagonal(player);
		boolean rigthRiagonal =  checkRigthDiagonal(player);
		return column || line  || leftDiagonal || rigthRiagonal;
	}
	





	private static boolean checkRigthDiagonal(Player player) {
		int col = player.getColumn();
		int field = player.getField();
		int line = player.getLine();
		
		
		if(line-col>1) {
			int delta = 6 - line ;
			if(col - delta>0) {
				col = col - delta;
				line = line + delta;
			} else {
				line = line + col;
				col = 0;
				
			}
			
			
		} else if (line-col<=1){
			if (line + col<6) {
				line = line + col;
				col = 0;
				
			} else {
				int delta = 6 - line ;
				col = col - delta;
				line = line + delta;
			}
			
			
		}
		int amount = 0;
		
		if(line-col>0) {
			amount = line-col+1;
		} else {
			amount = line+col;
		}
		
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		System.out.println(amount);
		for (int i = 0; i <amount; i++) {
			int el = board[line-i][col+i];
			System.out.println(el);
			if(el==120) {
				x.add(el);
				y.clear();
				if (x.size()==4) return true;
			} else if (el==121) {
				y.add(el);
				x.clear();
				if (y.size()==4) return true;
			}
		}
		
		return false;
	}




	private static boolean checkLeftDiagonal(Player player) {
		int col = player.getColumn();
		int field = player.getField();
		int line = player.getLine();
		int startLine = 0;
		int startColumn = 0;
		if (col>line) {
			startColumn = col - line;
			startLine = 0;
		} else if (col<line){
			startLine = line - col;
			startColumn = 0;
		}
		int amount = Math.max(startLine, startColumn);
		
		amount = board.length-amount;
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			int el = board[startLine+i][startColumn+i];
			if(el==120) {
				x.add(el);
				y.clear();
				if (x.size()==4) return true;
			} else if (el==121) {
				y.add(el);
				x.clear();
				if (y.size()==4) return true;
			}
			
		}
		
		return false;
	}


	private static boolean checkColumn(Player player) {
		int count = 0;
		int temp = 0;
		int column = player.getColumn();
		for (int i = 0; i < board.length; i++) {
			if(board[i][column]!=temp||board[i][column]==0) {
				temp  = board[i][column]   ;
				
				count = 1;
			} else {
				count++;
				System.out.println(count);
				if (count==4) return true;
				System.out.println(temp);	
			}
		}
		
		return false;
		
	}




	private static boolean checkline(Player player) {
		int count = 0;
		int temp = 0;
		int line = player.getLine();
		for (int i = 0; i < board.length; i++) {
			if(board[line][i]!=temp||board[line][i]==0) {
				temp  = board[line][i]   ;
				count = 1;
			} else {
				count++;
				System.out.println(count);
				if (count==4) return true;
				System.out.println(temp);	
			}
		}
		
		return false;
		
}
}


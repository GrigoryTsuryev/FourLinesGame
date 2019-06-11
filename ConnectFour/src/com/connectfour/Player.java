package com.connectfour;

import java.util.Arrays;
import java.util.Scanner;



public class Player {
	
		
	private char field;
	private int[][] board;
	
	private int line;
	public int getLine() {
		return line;
	}



	public void setLine(int line) {
		this.line = line;
	}



	public int getColumn() {
		return column;
	}



	public void setColumn(int column) {
		this.column = column;
	}



	int column;
	
	public Player(char field, int[][] board) {
		this.field=field;
		this.board=board;
	}

	

	public void makeMove() {
		System.out.println("Please enter column");
		int[] counter = new int[7];
		Arrays.fill(counter, 0);
		
		boolean non = false;
		while(!non ) {
			Scanner input = new Scanner( System.in );
			int num = input.nextInt();
			if (num<=0||num>7) {
				System.out.println("Please enter from 1 to 7");
				
			} else {
				non = true;
				for (int i = board.length - 1 ; i >=0; i--) {
					if(counter[0]>7) {
						System.out.println("Cant add more to this column");
						break;
					} else if  (board[i][num-1] == 0) {
						board[i][num-1] = field ;
						line = i;
						column = num-1;
						break;
					}
				}
			}
			
		}
		
	}



	public int getField() {
		// TODO Auto-generated method stub
		return field;
	}
}

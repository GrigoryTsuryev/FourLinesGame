package com.connectfour;

import java.util.Arrays;

public class Game {
	
	private int[][] board;
	
	public Game(int[][] board) {
		this.board=board;
	}
	
	void printBoard() {
		System.out.println(Arrays.deepToString(board)
				.replace("], ", "]\n")
				.replace("[[", "[")
				.replace("]]", "]"));
		System.out.println("");
	}

	 void start() {
		 Arrays.stream(board).forEach(a -> Arrays.fill(a, 0));
	}

	
}

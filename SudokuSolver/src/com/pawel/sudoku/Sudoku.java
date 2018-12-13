package com.pawel.sudoku;

import java.util.List;

public class Sudoku {
	
	public int [][] sudokuBoard = new int[9][9];
	public static final int EMPTY = 0; 
	public static final int SIZE = 9; 
	
	
	public void printSudokuArray() {
		System.out.println("-------------------");
		for(int i=0; i<9; i++) {
			System.out.print("|");

			for(int j=0; j<SIZE; j++) {
				if( (j+1) % 3 == 0 ) {
					System.out.print(sudokuBoard[i][j]+"|");
				}else {
					System.out.print(sudokuBoard[i][j]+" ");
				}
			}
			System.out.println();
			if( (i+1) % 3 == 0 ) {
				System.out.println("-------------------");
			} 	
		}	
	}
	
	
	public void loadSudokuArray(List list) {
		for(int i=0; i<list.size(); i++) {
			String tmpStr = (String) list.get(i);
			String[] tmpArray = tmpStr.split(",");
			
			for(int j=0; j<tmpArray.length; j++) {
				this.sudokuBoard[i][j]=Integer.valueOf(tmpArray[j]);
			}
		}
	}
	
	
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++) {
			if (sudokuBoard[row][i] == number) {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++) {
			if (sudokuBoard[i][col] == number) {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (sudokuBoard[i][j] == number)
					return true;
		
		return false;
	}
	
	
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
	}
	
	
	public boolean solveSudoku() {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				
				if (sudokuBoard[row][col] == EMPTY) {
					
					for (int number = 1; number <= SIZE; number++) {
						if (isOk(row, col, number)) {
							
							sudokuBoard[row][col] = number;
							if (solveSudoku()) { 
								return true;
							} else { 
								sudokuBoard[row][col] = EMPTY;
							}
						}
					}
					return false; 
				}
			}
         }
         return true; 
	}
	
}

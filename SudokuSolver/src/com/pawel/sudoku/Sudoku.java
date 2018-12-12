package com.pawel.sudoku;

import java.util.List;

public class Sudoku {
	
	public int [][] sudokuAray = new int[9][9];
	
	public void printSudokuArray() {
		System.out.println("-------------------");
		for(int i=0; i<9; i++) {
			System.out.print("|");

			for(int j=0; j<9; j++) {
				if( (j+1) % 3== 0 ) {
					System.out.print(sudokuAray[i][j]+"|");
				}else {
					System.out.print(sudokuAray[i][j]+" ");
				}
			}
			System.out.println();
			if( (i+1) % 3== 0 ) {
				System.out.println("-------------------");
			} 	
		}	
	}
	
	public void loadSudokuArray(List list) {
		for(int i=0; i<list.size(); i++) {
			String tmpStr = (String) list.get(i);
			String[] tmpArray = tmpStr.split(",");
			
			for(int j=0; j<tmpArray.length; j++) {
				this.sudokuAray[i][j]=Integer.valueOf(tmpArray[j]);
			}
		}
	}
	
}

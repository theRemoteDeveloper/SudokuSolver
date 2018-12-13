package com.pawel.sudoku;

public class Main {

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		System.out.println("Empty Sudoku board");
		sudoku.printSudokuArray();
		
		CSVFileReader csvFile = new CSVFileReader("sudoku_board.csv");
		sudoku.loadSudokuArray(csvFile.read());
		
		System.out.println("\nInitialized Sudoku board");
		sudoku.printSudokuArray();
		
		System.out.println("\nSolved Sudoku board");
		sudoku.solveSudoku();
		sudoku.printSudokuArray();
	}
	
}

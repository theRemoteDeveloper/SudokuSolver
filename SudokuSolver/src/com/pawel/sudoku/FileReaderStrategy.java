package com.pawel.sudoku;

import java.util.List;

public interface FileReaderStrategy {
	public List<String> read() throws IncorrectSudokuArrayFormat;
}

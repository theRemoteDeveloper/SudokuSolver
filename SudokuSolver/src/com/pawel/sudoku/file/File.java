package com.pawel.sudoku.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.pawel.sudoku.Sudoku;

public class File {
	
	private String fileName;
	
	public File(String fileName) {
		this.fileName=fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	
	public void readFile(Sudoku sudoku) {
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

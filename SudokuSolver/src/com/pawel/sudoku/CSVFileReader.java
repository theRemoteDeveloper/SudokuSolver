package com.pawel.sudoku;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVFileReader implements FileReaderStrategy {

	private String fileName;
	
	CSVFileReader(String fileName){
		this.fileName=fileName;
	}

	@Override
	public List<String> read() {
		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(this.fileName))) {
			list = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

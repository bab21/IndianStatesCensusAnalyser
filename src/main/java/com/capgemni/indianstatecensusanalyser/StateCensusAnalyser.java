package com.capgemni.indianstatecensusanalyser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	
	public int loadCSVData(String csvFilePath) {
		int numOfEntries=0;
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBean<CSVStateCensus> csvToBean=new CsvToBeanBuilder(reader).withType(CSVStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			Iterable<CSVStateCensus> csvIterable = () -> censusCSVIterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return numOfEntries;
	}
	
}

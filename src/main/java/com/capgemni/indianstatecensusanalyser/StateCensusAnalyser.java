package com.capgemni.indianstatecensusanalyser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.capgemni.indianstatecensusanalyser.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	
	public int loadCSVData(String csvFilePath) throws CensusAnalyserException{
		int numOfEntries=0;
		String[] filePathComponents=csvFilePath.split("[.]");
		if(!filePathComponents[filePathComponents.length-1].equals("csv")) {
			throw new CensusAnalyserException("File type is not correct",ExceptionType.FILE_TYPE_INCORRECT);
		}
		
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBean<CSVStateCensus> csvToBean=new CsvToBeanBuilder(reader).withType(CSVStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			Iterable<CSVStateCensus> csvIterable = () -> censusCSVIterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		}
		catch(IOException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		
	}
	
}

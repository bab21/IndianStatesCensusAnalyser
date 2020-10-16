package com.capgemni.indianstatecensusanalyser;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemni.indianstatecensusanalyser.CensusAnalyserException.ExceptionType;

public class StateCensusAnalyserTester {

	@Test
	public void loadDataFromCsvShouldReturnCorrectNumberOfEntries() {
		try {
		String csvFilePath="./StateCensusData.csv";
		StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
		int numOfEntries = stateCensusAnalyser.loadCSVData(csvFilePath);
		assertEquals(36,numOfEntries);
		}
		catch(CensusAnalyserException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ForIncorrectFileShouldThrowException() {
		try {
			String csvFilePath="./StateCensusDataaa.csv";
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_INCORRECT,e.getExceptionType());
		}
	}
	
	@Test
	public void ForIncorrectFileTypeShouldThrowException() {
		try {
			String csvFilePath="./StateCensusData.txt";
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_TYPE_INCORRECT,e.getExceptionType());
		}
	}
	@Test
	public void ForFileWithIncorrectDelimiterShouldThrowException() {
		try {
			String csvFilePath="./StateCensusDataIncorrectDelimiter.csv";
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.DELIMITER_INCORRECT,e.getExceptionType());
		}
	}
	@Test
	public void ForFileWithIncorrectHeaderShouldThrowException() {
		try {
			String csvFilePath="./StateCensusDataIncorrectHeader.csv";
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.HEADER_INCORRECT,e.getExceptionType());
		}
	}
	
	

}

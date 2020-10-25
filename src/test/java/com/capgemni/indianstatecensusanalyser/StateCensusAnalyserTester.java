package com.capgemni.indianstatecensusanalyser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemni.indianstatecensusanalyser.CensusAnalyserException.ExceptionType;

public class StateCensusAnalyserTester {
	public static StateCensusAnalyser stateCensusAnalyser;
	@Before
	public void setUp() {
	    stateCensusAnalyser =new StateCensusAnalyser();
	}

	@Test
	public void loadDataFromCsvShouldReturnCorrectNumberOfEntries() {
		try {
		String csvFilePath="./StateCensusData.csv";
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
			stateCensusAnalyser.loadCSVData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.HEADER_INCORRECT,e.getExceptionType());
		}
	}
	
	@Test
	public void loadStateCodeDataFromCsvShouldReturnCorrectNumberOfEntries() {
		try {
		String csvFilePath="./IndianStateCodeData.csv";
		int numOfEntries = stateCensusAnalyser.loadStateCodeData(csvFilePath);
		assertEquals(36,numOfEntries);
		}
		catch(CensusAnalyserException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ForIncorrectStateCodeFileShouldThrowException() {
		try {
			String csvFilePath="./IndianStateCodeDataa.csv";
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_INCORRECT,e.getExceptionType());
		}
	}
	
	@Test
	public void ForIncorrectStateCodeFileTypeShouldThrowException() {
		try {
			String csvFilePath="./IndianStateCodeData.txt";
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_TYPE_INCORRECT,e.getExceptionType());
		}
	}
	
	@Test
	public void ForStateCodeFileWithIncorrectDelimiterShouldThrowException() {
		try {
			String csvFilePath="./IndianStateCodeDataIncorrectDelimiter.csv";
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.DELIMITER_INCORRECT,e.getExceptionType());
		}
	}
	@Test
	public void ForStateCodeFileWithIncorrectHeaderShouldThrowException() {
		try {
			String csvFilePath="./IndianStateCodeDataIncorrectHeader.csv";
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.HEADER_INCORRECT,e.getExceptionType());
		}
	}
	
	@Test
	public void GivenCensusCSVData_WhenSortedAccordingToStateName_ShouldReturnSortedList() {
		List<CSVStateCensus> returnedList=stateCensusAnalyser.sortStateCensusDataAccordingToStateInAlphabeticalOrder("./StateCensusData.csv");
		assertEquals("Andaman and Nicobar Islands",returnedList.get(0).state);
		assertEquals("West Bengal",returnedList.get(returnedList.size()-1).state);
		
	}
	

}

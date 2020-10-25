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
		assertEquals(37,numOfEntries);
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
	
	@Test
	public void loadStateCodeDataFromCsvShouldReturnCorrectNumberOfEntries() {
		try {
		String csvFilePath="./IndianStateCodeData.csv";
		StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
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
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
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
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
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
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
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
			StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		}
		catch(CensusAnalyserException e) {
			assertEquals(ExceptionType.HEADER_INCORRECT,e.getExceptionType());
		}
	}
	

}

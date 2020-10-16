package com.capgemni.indianstatecensusanalyser;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateCensusAnalyserTester {

	@Test
	public void loadDataFromCsvShouldReturnCorrectNumberOfEntries() {
		String csvFilePath="./StateCensusData.csv";
		StateCensusAnalyser stateCensusAnalyser =new StateCensusAnalyser();
		int numOfEntries = stateCensusAnalyser.loadCSVData(csvFilePath);
		assertEquals(36,numOfEntries);
	}

}

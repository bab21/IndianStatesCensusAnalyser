package com.capgemini.indianstatecensusanalyser.csv;

public class CSVBuilderFactory {
	public static ICSVBuilder createCSVBuilder() {
		return new CommonCSVBuilder();
	}
}

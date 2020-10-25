package com.capgemini.indianstatecensusanalyser.csv;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CommonCSVBuilder <E> implements ICSVBuilder<E>{

	@Override
	public Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		// TODO Auto-generated method stub
		
		CSVParser c = null;
		try {
			c = new CSVParser(reader, CSVFormat.RFC4180);
			System.out.println("Inside common CSV");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<CSVRecord> iterator = c.iterator();
		return (Iterator<E>) iterator;
	}

}

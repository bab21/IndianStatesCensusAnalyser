package com.capgemni.indianstatecensusanalyser;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder {
	public <E> Iterator<E> getCSVFileIterator(Reader reader,Class<E> csvClass) throws CensusAnalyserException{
		CsvToBean<E> csvToBean=new CsvToBeanBuilder(reader).withType(csvClass)
								.withIgnoreLeadingWhiteSpace(true)
								.build();
		return csvToBean.iterator();
	}
}

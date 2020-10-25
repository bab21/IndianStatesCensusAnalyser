package com.capgemni.indianstatecensusanalyser;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.capgemni.indianstatecensusanalyser.CensusAnalyserException.ExceptionType;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.google.gson.Gson;


public class StateCensusAnalyser {
	public  List<CSVStateCensus> CSVStateDataList;
	public  List<CSVStateCode> CSVStateCodeDataList;
	private static final String JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_STATENAME = "./sortedStateCensusAccordingToState.json";
	private static final String JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_STATECODE="./sortedStateCodeCensusAccordingToStateCode.json";
	private static final String JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_POPULATION = "./sortedStateCensusAccordingToPopulation.json";
	private static final String JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_POPULATIONDENSITY = "./sortedStateCensusAccordingToPopulationDensity.json";
	private static final String JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_AREA = "./sortedStateCensusAccordingToArea.json";
	
	public int loadCSVData(String csvFilePath) throws CensusAnalyserException{
		if(!this.checkFileExtention(csvFilePath)) {
			throw new CensusAnalyserException("File type is not correct",ExceptionType.FILE_TYPE_INCORRECT);
		}
		
		checkForWrongDelimiter(csvFilePath);
		try {
			BufferedReader br=Files.newBufferedReader(Paths.get(csvFilePath));
			String headerLine=br.readLine();
			String[] headerLineValues=headerLine.split(",");
			if(!(headerLineValues[0].equals("State") && headerLineValues[1].equals("Population") && headerLineValues[2].equals("AreaInSqKm") && headerLineValues[3].equals("DensityPerSqKm")))
				  throw new CensusAnalyserException("File headers are not correct",ExceptionType.HEADER_INCORRECT);  
		}
		catch(IOException e) {
			
		}
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));
			CSVStateDataList = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build().parse();
			return CSVStateDataList.size();
		}
		catch(IOException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		
	}
	
	public List<CSVStateCensus> sortStateCensusDataAccordingToStateInAlphabeticalOrder(String csvFilePath){
		
		Reader reader=null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		CSVStateDataList = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build().parse();
		List<CSVStateCensus> sortedList = CSVStateDataList.stream()
				.sorted((element1, element2) ->element1.state.compareTo(element2.state))
				.collect(Collectors.toList());
		
		Gson gson=new Gson();
		String json=gson.toJson(sortedList);
		FileWriter writer;
		
		try {
			writer = new FileWriter(JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_STATENAME);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sortedList;
	}
	
	public List<CSVStateCensus> sortStateCensusDataAccordingToPopulation(String csvFilePath){
		
		Reader reader=null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		CSVStateDataList = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build().parse();
		List<CSVStateCensus> sortedList = CSVStateDataList.stream()
				.sorted((element1, element2) ->Integer.compare(element1.population,element2.population))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		
		Gson gson=new Gson();
		String json=gson.toJson(sortedList);
		FileWriter writer;
		
		try {
			writer = new FileWriter(JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_POPULATION);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sortedList;
	}
	public List<CSVStateCensus> sortStateCensusDataAccordingToPopulationDensity(String csvFilePath){
		
		Reader reader=null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		CSVStateDataList = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build().parse();
		List<CSVStateCensus> sortedList = CSVStateDataList.stream()
				.sorted((element1, element2) ->Integer.compare(element1.densityPerSqKm,element2.densityPerSqKm))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		
		Gson gson=new Gson();
		String json=gson.toJson(sortedList);
		FileWriter writer;
		
		try {
			writer = new FileWriter(JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_POPULATIONDENSITY);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sortedList;
	}
	
	public List<CSVStateCensus> sortStateCensusDataAccordingToArea(String csvFilePath){
		
		Reader reader=null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		CSVStateDataList = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build().parse();
		List<CSVStateCensus> sortedList = CSVStateDataList.stream()
				.sorted((element1, element2) ->Integer.compare(element1.areaInSqKm,element2.areaInSqKm))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		
		Gson gson=new Gson();
		String json=gson.toJson(sortedList);
		FileWriter writer;
		
		try {
			writer = new FileWriter(JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_AREA);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sortedList);
		return sortedList;
	}
	
	public List<CSVStateCode> sortStateCodeCensusDataAccordingToStateCode(String csvFilePath){
		
		Reader reader=null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		CSVStateCodeDataList = new CsvToBeanBuilder(reader).withType(CSVStateCode.class).build().parse();
		List<CSVStateCode> sortedList = CSVStateCodeDataList.stream()
				.sorted((element1, element2) ->element1.stateCode.compareTo(element2.stateCode))
				.collect(Collectors.toList());
		
		Gson gson=new Gson();
		String json=gson.toJson(sortedList);
		FileWriter writer;
		
		try {
			writer = new FileWriter(JSON_FILE_FOR_SORTED_STATE_CENSUS_ACCORDINGTO_STATENAME);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sortedList;
	}
	
	
	public int loadStateCodeData(String csvFilePath) throws CensusAnalyserException{
		if(!this.checkFileExtention(csvFilePath)) {
			throw new CensusAnalyserException("File type is not correct",ExceptionType.FILE_TYPE_INCORRECT);
		}
		
		checkForWrongDelimiter(csvFilePath);
		try {
			BufferedReader br=Files.newBufferedReader(Paths.get(csvFilePath));
			String headerLine=br.readLine();
			String[] headerLineValues=headerLine.split(",");
			if(!(headerLineValues[0].equals("State Code") && headerLineValues[1].equals("TIN") && headerLineValues[2].equals("Population") && headerLineValues[3].equals("State Code")))
				  throw new CensusAnalyserException("File headers are not correct",ExceptionType.HEADER_INCORRECT); 
		}catch(IOException e) {
			
		}
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));
			CSVStateCodeDataList = new CsvToBeanBuilder(reader).withType(CSVStateCode.class).build().parse();
			return CSVStateCodeDataList.size();
		}
		catch(IOException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		
	}
	
		
	private boolean checkFileExtention(String csvFilePath) {
		String[] filePathComponents=csvFilePath.split("[.]");
		if(!filePathComponents[filePathComponents.length-1].equals("csv")) 
			return false;
		return true;
	}
	private void checkForWrongDelimiter(String csvFilePath) throws CensusAnalyserException{
		try {
			BufferedReader br=Files.newBufferedReader(Paths.get(csvFilePath));
			String line;
			while((line=br.readLine())!=null) {
				  String[] lineComponents=line.split(",");
				  if(lineComponents.length!=4)
					  throw new CensusAnalyserException("This file is having incorrect delimiter",ExceptionType.DELIMITER_INCORRECT);
			}
		}
		catch(IOException e) {
			throw new CensusAnalyserException("This file path is incorrect",ExceptionType.FILE_INCORRECT);
		}
	}
	
}

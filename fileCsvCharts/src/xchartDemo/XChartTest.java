package xchartDemo;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

public class XChartTest {
//	String dataPath = "E:\\ITI\\Module 1\\10-java & UML\\day5\\Data_to_use\\titanic.csv";
//	Table titanicData =  Table.read().file(dataPath);
//	
//	List<Column> dataStructure = titanicData.columns();
//	System.out.println(dataStructure);
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		TitanicDAO obj = new TitanicDAO();
		List<TitanicPassenger> allPassengers = obj.getPassengersFromJsonFile();
		allPassengers.forEach(k -> System.out.println(k));
		obj.graphPassengerAges(allPassengers);
		obj.graphPassengerClass(allPassengers);
		obj.graphPassengerSurvived(allPassengers);
		obj.graphPassengerSurvivedByGender(allPassengers);
	}

}

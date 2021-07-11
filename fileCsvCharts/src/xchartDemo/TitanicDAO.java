package xchartDemo;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.ChartColor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TitanicDAO {
	
	public List<TitanicPassenger> getPassengersFromJsonFile() throws JsonParseException, JsonMappingException, IOException {
		List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		InputStream input = new FileInputStream(
				"E:\\ITI\\Module 1\\10-java & UML\\day5\\Data_to_use\\titanic_csv.json");
		// Read JSON file
		allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>() {});
		return allPassengers;
	}

	public void graphPassengerAges(List<TitanicPassenger> passengerList) {
		List<Float> pAges = passengerList.stream().map(TitanicPassenger::getAge).limit(8).collect(Collectors.toList());
		List<String> pNames = passengerList.stream().map(TitanicPassenger::getName).limit(8).collect(Collectors.toList());

		CategoryChart chart = new CategoryChartBuilder().width (1024).height(768)
				.title("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build ();

		chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart.getStyler().setHasAnnotations (true);
		chart.getStyler().setStacked (true);

		chart.addSeries ("Passenger's Ages", pNames, pAges);

		new SwingWrapper(chart).displayChart ();
	}
	
	public void graphPassengerClass(List<TitanicPassenger> passengerList) {
		Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting()));
		
		PieChart chart = new PieChartBuilder().width(800).height(600).title("passenger class").build ();
		Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
		
		chart.getStyler ().setSeriesColors (sliceColors);
		chart.addSeries("First Class", result.get("1"));
		chart.addSeries("Second Class", result.get("2"));
		chart.addSeries("Third Class", result.get("3"));
		
		new SwingWrapper(chart).displayChart();
		
	}
	
	
	public void graphPassengerSurvived(List<TitanicPassenger> passengerList) {
		Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger::getSurvived, Collectors.counting()));
		
		PieChart chart = new PieChartBuilder().width(800).height(600).title("Survived").build ();
		Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
		
		chart.getStyler ().setSeriesColors (sliceColors);
		chart.addSeries("Survived Class", result.get("1"));
		chart.addSeries("Not Survived Class", result.get("0"));
		
		new SwingWrapper(chart).displayChart();
		
	}
	
	
	public void graphPassengerSurvivedByGender(List<TitanicPassenger> passengerList) {
		Map<String, Long> result = passengerList.stream().filter(s->s.getSurvived().equals("1")).collect(Collectors.groupingBy(TitanicPassenger::getSex, Collectors.counting()));
		
		PieChart chart = new PieChartBuilder().width(800).height(600).title("Survived by gender").build ();
		Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
		
		chart.getStyler ().setSeriesColors (sliceColors);
		chart.addSeries("female", result.get("female"));
		chart.addSeries("male", result.get("male"));
		
		new SwingWrapper(chart).displayChart();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pyramids.Pyramid;
import pyramids.PyramidComparator;
import pyramids.PyramidsCSVDAOImpl;

public class TestPyramids {
	public static void main(String[] args) {
		PyramidsCSVDAOImpl obj = new PyramidsCSVDAOImpl();
		
		// please define here the path of the CSV file
		String path = "E:\\ITI\\Module 1\\10-java & UML\\day3\\pyramids.csv";
		
		// create a list of pyramids
		List<Pyramid> l = obj.readPyramidsFromCSV(path);
		
		// print the list of pyramids
		for(Pyramid p: l) {
			System.out.println(p);
		}//*/
		
		// sort according to pyramid's height
		List<Pyramid> sortedPyramids = obj.sortPyramids(l);
		
		// print the sorted list of pyramids
		for(Pyramid p: sortedPyramids) {
			System.out.println(p);
		}//*/
		
		
		// get each location and the corresponding pyramids count
		Map<String, Integer> locCount = obj.getSiteCount(l);
		
		// print the result
		locCount.forEach((k, v) -> System.out.println("key="+ k+ ", value="+ v));

	}
}

package dataFrameDemo;

import java.io.IOException;

import joinery.DataFrame;

public class ReadFromFile {
	
	public static void main(String[] args) throws IOException {
		
		DataFrame<Object> df = DataFrame.readCsv("src/resources/titanic.csv");
		//System.out.println(df);
		
		DataFrame<Object> df1 = df.retain("age").mean();
		System.out.println("average age for passengers: \n"+df1);
	}
	
}

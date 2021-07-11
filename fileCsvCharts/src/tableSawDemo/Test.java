package tableSawDemo;

import java.io.IOException;
import java.util.List;

//import dataFrameDemo.TitanicPassenger;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

public class Test {
	public static void main(String[] args) throws IOException {
		Table titanicData;
		String dataPath = "src/resources/titanic.csv";
		titanicData = Table.read().csv(dataPath);
		
		System.out.println(titanicData.summary());
	}
}

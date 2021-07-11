package fileDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		Writer w = new FileWriter("E:\\test.txt");
		BufferedWriter buffer = new BufferedWriter(w);
		
		String input = "";
		while(!input.equals("stop")) {
			input = br.readLine();
			buffer.write(input+"\n");
		}
		buffer.close();
		br.close();
	}

}

package pyramids;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PyramidsCSVDAOImpl implements PyramidsCSVDAO{
	
	@Override
	public List<Pyramid> readPyramidsFromCSV(String filename) {
		List<Pyramid> pyramids = new LinkedList<Pyramid>();
		String[] splitted;
		File f = new File(filename);
		//System.out.println("file exists: "+f.exists());
		if(f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String line;
				br.readLine(); 			// reads the header line
				line = br.readLine();	// reads the first line of data
				while(line != null) {
					splitted = line.split(",");
					pyramids.add(createPyramid(splitted));
					line = br.readLine();
				}
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("file not found!");
		}
		return pyramids;
	}
	
	@Override
	public Pyramid createPyramid(String[] metadata) {
		//System.out.println(metadata[7]);
		double height = metadata[7].equals("") ? 0.0 : Double.parseDouble(metadata[7]);
		String modernName = metadata[2];
		String pharaoh = metadata[0];
		String site = metadata[4];
		return new Pyramid(height, modernName, pharaoh, site);
	}

	@Override
	public List<Pyramid> sortPyramids(List<Pyramid> list) {
		Collections.sort(list, new PyramidComparator());
		return list;
	}

	@Override
	public Map<String, Integer> getSiteCount(List<Pyramid> list) {
		Map<String, Integer> locCount = new HashMap<>();
		for(Pyramid p: list) {
			// if site exists in hashmap increment by 1
			// else add site to map with initial value of 1
			if(locCount.containsKey(p.getSite())){
				int count = locCount.get(p.getSite());
				locCount.put(p.getSite(), count+1);
			}else {
				locCount.put(p.getSite(), 1);
			}
		}
		return locCount;
	}

}

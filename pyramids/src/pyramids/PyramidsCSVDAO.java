package pyramids;

import java.util.List;
import java.util.Map;

public interface PyramidsCSVDAO {
	public Pyramid createPyramid(String[] metadata);
	public List<Pyramid> readPyramidsFromCSV(String filename);
	public List<Pyramid> sortPyramids(List<Pyramid> list);
	public Map<String, Integer> getSiteCount(List<Pyramid> list);
}

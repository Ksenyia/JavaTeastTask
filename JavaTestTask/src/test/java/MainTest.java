import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class MainTest {
	    @Test
	    public void fullChangesMapTest()  {
	    	String[] s = {"10:10","12:13"};
	    	Map<LocalTime, Boolean> testMap =new TreeMap<LocalTime, Boolean>();
	    	Map<LocalTime, Boolean> resultMap =new TreeMap<LocalTime, Boolean>();
	    	resultMap.put(LocalTime.parse(s[0]),true);
	    	resultMap.put(LocalTime.parse(s[1]),false);
	    	Main.fullChangesMap(testMap, s);
	        assertEquals(resultMap,testMap);
	    }
	    @Test
	    public void calculateMaxCountTest() {
	    	String[] s = {"10:10","12:13"};
	    	Map<LocalTime, Boolean> resultMap =new TreeMap<LocalTime, Boolean>();
	    	resultMap.put(LocalTime.parse(s[0]),true);
	    	resultMap.put(LocalTime.parse(s[1]),false);
	        assertEquals(1,Main.calculateMaxCount(resultMap));
	    }

}

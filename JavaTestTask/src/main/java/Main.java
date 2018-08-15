import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import java.util.TreeMap;

/**
 * Main class
 *
 * @author Akula Kseniya
 * @version 1.0
 */


public class Main {
	
	private static final Boolean INCREASE_COUNT_OF_EMPLOYEE_FLAG  = true;
	private static final Boolean DECREASE_COUNT_OF_EMPLOYEE_FLAG  = false;
	private static final Logger log = Logger.getLogger(Main.class);
	
	
	/**
	 * full ChangesMap.
	 * 
	 * @param Map<LocalTime, Boolean> 
	 * @param String[]
	 */

	public static void fullChangesMap(Map<LocalTime, Boolean> map,String[] s) {
		LocalTime employeeComingTime = LocalTime.parse(s[0]);
		LocalTime employeeLeavingTime = LocalTime.parse(s[1]);
		map.put(employeeComingTime, INCREASE_COUNT_OF_EMPLOYEE_FLAG);
		map.put(employeeLeavingTime,DECREASE_COUNT_OF_EMPLOYEE_FLAG);
	}
	
	/**
	 * calculateMaxCount
	 * @param Map<LocalTime, Boolean> 
	 * @return int
	 */

	public static int calculateMaxCount(Map<LocalTime, Boolean> map) {
		Iterator<Entry<LocalTime, Boolean>> iter = map.entrySet().iterator();
		int maxCount = 0;
		int currentCount = 0;
		while (iter.hasNext()) {
			Map.Entry<LocalTime, Boolean> entry = (Map.Entry<LocalTime, Boolean>) iter.next();
			if(entry.getValue()){
				currentCount++;
			}else{
				currentCount--;
			}
			if(currentCount>maxCount){
				maxCount = currentCount;
			}
		}

		return maxCount;
	}

	public static void main(String[] args) {
		String path = args[0].toString();
		Map<LocalTime,Boolean> changesMap = new TreeMap<LocalTime,Boolean>();
		BufferedReader br = null;
		try {   
			File obDir = new File(path);
			String fileName = "input.txt";
			File obFile1 = new File(obDir, fileName);
			br = new BufferedReader(new FileReader(obFile1)); 
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				String seperate = "\\s";
				String[] s = tmp.split(seperate);
			    fullChangesMap(changesMap, s);
			}
			int maxCount = calculateMaxCount(changesMap) ;
			System.out.println(maxCount);
		}catch (IOException e) {
			log.error(e);
		}
		finally {  
			if (br != null) {
				try {    
					br.close();   
				} catch (IOException e) {   
					log.error(e); 
				}   
			} 
		} 
	}

}

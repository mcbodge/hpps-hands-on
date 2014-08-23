package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataManager {
	
	private static final int NUM_TEMP_VALUES = 8;
	
	public static void fileCreator(int program, int emergency, int delay, int[] temperature, int target, int[] power){
		String path = System.getProperty("user.dir");

		try {
			DataManager d = new DataManager();
			int[] calendarData = d.checkCalendar();
			File file = new File(path + "/fileProva.ini");

			if (!file.exists())
				file.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.append("; The INI file looks like:\n\n");
			writer.append("[program]\n");
			writer.append("s=" + program + "\n\n");
			writer.append("[emergency]\n");
			writer.append("e=" + emergency + "\n\n");
			writer.append("[delay]\n");
			writer.append("d=" + delay + "\n\n");
			writer.append("[temperature]\n");
			for (int i = 0; i < NUM_TEMP_VALUES; i++) {
				writer.append(String.valueOf(i + 1) + "=" + temperature[i]);
				writer.append("\n");
			}			
			writer.append("t=" + target + "\n\n");
			writer.append("[power]\n");
			for (int i = 0; i < NUM_TEMP_VALUES; i++) {
				writer.append(String.valueOf(i + 1) + "=" + power[i]);
				writer.append("\n");
			}			
			writer.append("\n[version]\n");
			writer.append("y=" + calendarData[0] + "\n");
			writer.append("m=" + calendarData[1] + "\n");
			writer.append("d=" + calendarData[2] + "\n");
			writer.append("h=" + calendarData[3] + "\n");
			writer.append("p=" + calendarData[4] + "\n");
			writer.append("s=" + calendarData[5] + "\n\n");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private int[] checkCalendar(){
		GregorianCalendar calendar = new GregorianCalendar();
		int[] array = new int[6];
		array[0] = calendar.get(Calendar.YEAR);
		array[1] = (calendar.get(Calendar.MONTH) + 1);
		array[2] = calendar.get(Calendar.DAY_OF_MONTH);
		array[3] = calendar.get(Calendar.HOUR_OF_DAY);
		array[4] = calendar.get(Calendar.MINUTE);
		array[5] = calendar.get(Calendar.SECOND);
		return array;
	}
}

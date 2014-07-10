package logic;

import java.util.ArrayList;

import gui.TestOne;

public class DataManager {
	
	public static void putInTestOne(ArrayList<String> data){
		TestOne startTestOne = new TestOne(data.toString());
		startTestOne.setVisible(true);
	}
}

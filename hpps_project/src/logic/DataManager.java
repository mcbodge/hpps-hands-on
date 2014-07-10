package logic;

import java.util.ArrayList;

import gui.TestOne;

public class DataManager {
	
	public DataManager(ArrayList<String> a) {
		this.data = a;	
	}
	
	private ArrayList<String> data;
	
	public static void putInTestOne(ArrayList<String> data){
		TestOne startTestOne = new TestOne();
		startTestOne.setTestOne(data);
		startTestOne.setVisible(true);
	}
}

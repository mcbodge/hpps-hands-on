package logic;

import java.util.ArrayList;

import gui.TestOne;

public class DataManager {
	
	public DataManager(ArrayList<String> a) {
		this.data = a;	
	}
	
	private ArrayList<String> data;
	
	public void putInTestOne(){
		TestOne startTestOne = new TestOne();
		System.out.println("dataman 4" + data.get(0));
		startTestOne.setTestOne(data);
		System.out.println("dataman 5" + data.get(0));
		startTestOne.setVisible(true);
	}
}

package org.mql.java.ui;

public class Main {
	private Main() {
		for(DaysOfTheWeek item : DaysOfTheWeek.values()){
			System.out.println(item);
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}

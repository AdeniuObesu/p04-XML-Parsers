package org.mql.java.xml.model;

<<<<<<< HEAD
public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
=======
import java.util.GregorianCalendar;

public class Date {
	private int day, month, year;
	
	public Date() {
		GregorianCalendar gc = new GregorianCalendar();
		day = gc.get(GregorianCalendar.DAY_OF_MONTH);
		month = gc.get(GregorianCalendar.MONTH) + 1;
		year = gc.get(GregorianCalendar.YEAR);
	}
	
	public Date(int day, int month, int year){
>>>>>>> reference
		this.day = day;
		this.month = month;
		this.year = year;
	}
<<<<<<< HEAD
	
=======

>>>>>>> reference
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return (
				day+"/"+month+"/"+year
				);
				
	}
=======
		return day + "/" + month + "/" + year;
	}
	
	
>>>>>>> reference
}

package org.mql.java.xml.model;

public class Publisher {
	private int id;
	private String name;
	private String country;
	
	public Publisher(int id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
}

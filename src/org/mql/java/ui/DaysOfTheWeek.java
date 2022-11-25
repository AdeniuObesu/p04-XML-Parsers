package org.mql.java.ui;

public enum DaysOfTheWeek {
	SUNDAY(1, "Dimanche"), MONDAY(2, "Lundi"),
	TUESDAY(3, "Mardi"), WEDNESDAY(4, "Mercredi"),
	THURSDAY(5, "Jeudi"), FRIDAY(6, "Vendredi"),
	SATURDAY(7, "Samedi");
	private final int order;
	private final String description;
	private DaysOfTheWeek(int order, String description) {
		this.order = order;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Enum [name(En) : "+name()+", name(Fr) : "+description()
		+", ordinal : " + ordinal() +" , order : "+ order() +"]";
	}
	public int order() { return order; }
	public String description() { return description; }
}

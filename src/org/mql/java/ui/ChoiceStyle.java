package org.mql.java.ui;

public enum ChoiceStyle {
	RADIO(1, "radio"),
	COMBO(2, "combo"),
	CHECKBOX(3, "checkbox"),
	LIST(4, "list");
	private int id;
	private String name;
	private ChoiceStyle(int id, String name) {
		this.id = id;
	}
}

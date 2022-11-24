package org.mql.java.xml.sax;

import org.mql.java.ui.ChoiceStyle;

public class Examples {
	public Examples() {
		exp01();
	}
	
	void exp01() {
		System.out.println(ChoiceStyle.CHECKBOX);
		ChoiceStyle c = ChoiceStyle.COMBO;
		System.out.println(c.ordinal() + " : " + c.name());
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}

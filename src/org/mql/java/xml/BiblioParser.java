package org.mql.java.xml;

public class BiblioParser {
	public BiblioParser() {
		exp01();
	}
	
	void exp01(){
		XMLNode parser = new XMLNode("resources/biblio.xml");
	}
	
	public static void main(String[] args) {
		new BiblioParser();
	}
}

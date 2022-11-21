package org.mql.java.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.java.ui.Form;

public class FormSAXParser {
	private String source; //L'entree : le chemin vers un formulaire XML
	private Form form; //La sortie : un formulaire Swing
	public FormSAXParser(String source) {
		this.source = source;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
		} catch (Exception e) {
			System.out.println("Erreur - " + e.getMessage());;
		}
	}
}

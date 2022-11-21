package org.mql.java.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.java.ui.Form;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FormSAXParser extends DefaultHandler{
	private String source; //L'entree : le chemin vers un formulaire XML
	private Form form; //La sortie : un formulaire Swing
	public FormSAXParser(String source) {
		this.source = source;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			parser.parse(source, this);
		} catch (Exception e) {
			System.out.println("Erreur - " + e.getMessage());;
		}
		
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println(">> Start document");
		super.endDocument();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println(">> END document (well-formed)");
	}
}

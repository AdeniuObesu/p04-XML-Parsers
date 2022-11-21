package org.mql.java.xml.sax;

import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.java.ui.Form;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FormSAXParser extends DefaultHandler{
	private String source; //L'entree : le chemin vers un formulaire XML
	private Form form; //La sortie : un formulaire Swing
	private List<String> items;
	
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
	
	public Form getForm() {
		return form;
	}
	
	public void startDocument() throws SAXException {
		System.out.println(">> Start document");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		//qName : qualified name
		if("form".equals(qName)) {
			String title = attributes.getValue("title");
			int labelWidth = 100;
			try {
				labelWidth = Integer.parseInt(attributes.getValue("label-width"));
			}catch(Exception e) {
				System.out.println("Erreur - " + e.getMessage());
			}
			form = new Form(title, labelWidth);
		} else if("field".equals(qName)){
			String type = attributes.getValue("type");
			String label = attributes.getValue("label");
			if("text".equals(type)) {
				int size = Integer.parseInt(attributes.getValue("size"));
				form.addTextField(label, size);
			} else if("combo".equals(type) || "radio".equals(type)) {
				items = new Vector<>();
				
			}
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		
	}
	
	public void endDocument() throws SAXException {
		System.out.println(">> END document (well-formed)");
	}
}

package org.mql.java.xml.sax;

import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.java.ui.ChoiceStyle;
import org.mql.java.ui.Form;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FormSAXParser extends DefaultHandler{
	private String source; //L'entree : le chemin vers un formulaire XML
	private Form form; //La sortie : un formulaire Swing
	
	private List<String> items;
	
	private boolean item = false;
	
	private String type, label;
	
	
	public FormSAXParser(String source) {
		this.source = source;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			parser.parse(this.source, this);
		} catch (Exception e) {
			System.out.println("Erreur - " + e.getMessage());;
		}
		
	}
	
	public Form getForm() {
		return form;
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println(">> Start document");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
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
			type = attributes.getValue("type");
			label = attributes.getValue("label");
			if("text".equals(type)) {
				int size = Integer.parseInt(attributes.getValue("size"));
				form.addTextField(label, size);
			} else if("combo".equals(type) || "radio".equals(type)) {
				items = new Vector<>();
				
			} 
		}else if("item".equals(qName)) {
			item = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("item".equals(qName)) {
			item = false;
		} else if("field".equals(qName)) {
			if(items != null) {
				form.addChoicePanel(
						ChoiceStyle.valueOf(type.toUpperCase()),
						label,
						items.toArray(new String[items.size()])
						);
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		if(item) {
			String s = new String(ch, start, length);
			System.out.println(s);
			items.add(s);
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println(">> END document (well-formed)");
	}
}

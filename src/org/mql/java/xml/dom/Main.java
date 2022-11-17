package org.mql.java.xml.dom;

import java.util.List;

import org.mql.java.xml.model.Document;

public class Main {
	public Main() {
		exp01();
	}
	
	void exp01() {
		BiblioParser parser = new BiblioParser("resources/biblio.xml");
		List<Document> docs = parser.getDocuments();
		for(Document doc : docs) {
			System.out.println(doc);
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}

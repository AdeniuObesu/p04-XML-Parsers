package org.mql.java.xml.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.xml.model.Document;

public class BiblioParser {
	List<Document> documents;
	
	public BiblioParser(String source) {
		parse(source);
	}
	
	void parse(String source) {
		documents = new Vector<>();
		XMLNode root = new XMLNode(source);
		XMLNode children[] = root.children();
		for(XMLNode child : children) {
			int id = child.intAattribute("id");
			documents.add(new Document(id));
		}
	}

	public List<Document> getDocuments() {
		return documents;
	}
}

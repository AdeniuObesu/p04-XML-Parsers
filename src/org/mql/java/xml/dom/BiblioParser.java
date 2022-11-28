package org.mql.java.xml.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.crud.CrudOperations;
import org.mql.java.xml.model.Document;

public class BiblioParser implements CrudOperations<Document> {
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
			Document doc = new Document(id);
			documents.add(doc);
			doc.setTitle(child.child("title").value());
		}
	}

	public List<Document> getDocuments() {
		return documents;
	}

	@Override
	public boolean add(Document another) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Document get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document update(int i, Document element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document delete() {
		// TODO Auto-generated method stub
		return null;
	}
}

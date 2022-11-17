package org.mql.java.xml.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.xml.model.Author;
import org.mql.java.xml.model.Date;
import org.mql.java.xml.model.Document;
import org.mql.java.xml.model.Publisher;

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
			int id = child.intAttribute("id");
			Document doc = new Document(id);
			documents.add(doc);
			doc.setTitle(child.child("title").getvalue());
			XMLNode[] authors = child.child("authors").children();
			Author author;
			for(XMLNode item : authors) {
				author = new Author(item.intAttribute("id"));
				author.setCountry(item.child("country").getvalue());
				author.setName(item.child("country").getvalue());
				author.setDateOfBirth(
						new Date(item.child("date").intAttribute("day"),
								item.child("date").intAttribute("month"),
								item.child("date").intAttribute("year")
								)
					);
				doc.addAuthor(author);
			}
			id = child.child("publisher").intAttribute("id");
			Publisher publisher = new Publisher(id);
			publisher.setName(child.child("publisher").strAttribute("name"));
			publisher.setCountry(child.child("publisher").strAttribute("country"));
			doc.setPublisher(publisher);
		}
	}

	public List<Document> getDocuments() {
		return documents;
	}
}

package org.mql.java.xml.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.xml.model.Author;
import org.mql.java.xml.model.Date;
import org.mql.java.xml.model.Document;
import org.mql.java.xml.model.Publisher;

public class BiblioParser {
	private String source;
	List<Document> documents;
	private XMLNode root;
	
	public BiblioParser(String source) {
		this.source = source;
		this.root = parse();

		addAuthor(110, new Author(1));
	}
	
	// Adds an author to the document
	public void addAuthor(int documentId, Author author) {
		if(author == null) {
			System.out.println("WARNING : Author cannot be null !");
		} else {
			if(doesDocumentExist(documentId)) {
//				XMLNode node = new XMLNode();
//				root.child("authors").appendChild();
			} else {
				System.out.println("INFO : Document(id : "+documentId+") cannot be FOUND !");
			}
		}
	}
	// Checks either a document does exist or not
	private boolean doesDocumentExist(int id) {
		XMLNode children[] = root.children();
		for(XMLNode child : children) {
			if(child.intAttribute("id") == id)
			return true;
		}
		return false; //Document NOT FOUND
	}

	/* Parses an XML file
	 * @return the root
	 */
	private XMLNode parse() {
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
				author.setName(item.child("name").getvalue());
				author.setDateOfBirth(
						new Date(
								item.child("date").intAttribute("day"),
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
		return root;
	}

	public List<Document> getDocuments() {
		return documents;
	}
}

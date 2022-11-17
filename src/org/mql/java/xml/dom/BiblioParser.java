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
	public void addAuthor(int documentId, Author another) {
		if(another == null) {
			System.out.println("WARNING : Author cannot be null !");
		} else {
			Document target = documents.get(getDocumentIndex(documentId));
			if( target != null) {
				target.addAuthor(another);
				XMLNode[] children = root.children();
				System.out.println(target);
				System.out.println("INFO : Added Document(id : "+documentId+") successfully !");
			} else {
				System.out.println("INFO : Document(id : "+documentId+") cannot be FOUND !");
			}
		}
	}
	
	private XMLNode getDocument(int documentId) {
		for(XMLNode child : root.children()) {
			if(child.intAttribute("id") == documentId) {
				return child;
			}
		}
		System.out.println("INFO : Document node(id : "+documentId+") cannot be FOUND !");
		return null;
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
	
	public int getDocumentIndex(int id) {
		for(int i=0; i <documents.size(); i++) {
			if(documents.get(i).getId() == id)
				return i;
		}
		System.out.println("INFO : Document(id : "+id+") cannot be FOUND !");
		return -1;
	}
}

package org.mql.java.xml.dom;

import java.util.List;
import java.util.Vector;

import org.mql.java.xml.model.Author;
import org.mql.java.xml.model.Date;
import org.mql.java.xml.model.Document;
import org.mql.java.xml.model.Publisher;

public class BiblioParser {
	private String source;
	private List<Document> documents;
	private XMLNode root;
	
	public BiblioParser(String source) {
		this.source = source;
		this.root = parse();
		Document document;
		for(int i=0; i<4; i++) {
			document = new Document(i);
			document.setPublisher(new Publisher(i, "publisher" + i, "country" + i));
			for(int j=1; j<3; j++) {
				document.addAuthor(new Author(i, "Author"+i, new Date(1, i, 1980), "Country" + i));
			}
			addDocument(document);
		}
		
	}

	/* Parses an XML file
	 * @return the root
	 */
	private XMLNode parse() {
		documents = new Vector<>();
		XMLNode root = new XMLNode(source);
		XMLNode children[] = root.children();
		for(XMLNode child : children) {
			int id = Integer.parseInt(child.getAttribute("id"));
			Document doc = new Document(id);
			documents.add(doc);
			doc.setTitle(child.child("title").value());
			XMLNode[] authors = child.child("authors").children();
			Author author;
			for(XMLNode item : authors) {
				author = new Author(Integer.parseInt(item.getAttribute("id")));
				author.setCountry(item.child("country").value());
				author.setName(item.child("name").value());
				author.setDateOfBirth(
						new Date(
								Integer.parseInt(item.child("date").getAttribute("day")),
								Integer.parseInt(item.child("date").getAttribute("month")),
								Integer.parseInt(item.child("date").getAttribute("year"))
								)
					);
				doc.addAuthor(author);
			}
			id = Integer.parseInt(child.child("publisher").getAttribute("id"));
			Publisher publisher = new Publisher(id);
			publisher.setName(child.child("publisher").getAttribute("name"));
			publisher.setCountry(child.child("publisher").getAttribute("country"));
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
	
	public XMLNode getDocumentNode(int id) {
		for(XMLNode child : root.children()) {
			if(Integer.parseInt(child.getAttribute("id")) == id)
				return child;
		}
		System.out.println("INFO : Document(id : "+id+") cannot be FOUND !");
		return null;
	}
	
	public void addDocument(Document another) {
		if(another != null) {
			documents.add(another);
			XMLNode docNode = root.createElement("document");
			docNode.setAttribute("id", String.valueOf(another.getId()));
			System.out.println(docNode.getAttribute("id"));
		}
	}
}

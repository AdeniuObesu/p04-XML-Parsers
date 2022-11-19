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
		document = new Document(1);
		document.setTitle("Design patterns : Elements of reusable object oriented software");
		document.setPublisher(new Publisher(1, "Addison-Wesley", "USA"));
		document.addAuthor(new Author(20, "John Matthew Vlissides", new Date(2, 8, 1961), "USA"));
		document.addAuthor(new Author(21, "Richard Helm", new Date(1, 1, 1966), ""));
		document.addAuthor(new Author(22, "Ralph E. Johnson", new Date(7, 10, 1955), "USA"));
		document.addAuthor(new Author(23, "Erich Gamma", new Date(13, 3, 1961), "Suisse"));
		addDocument(document);
		root.save("resources/bibliotheque.xml");
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
	
	public int idToDocumentIndex(int id) {
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
			docNode.setAttribute("id", another.getId()+"");
			
			XMLNode titleNode = docNode.createElement("title");
			titleNode.setTextContent(another.getTitle());
			
			docNode.appendChild(titleNode);
			root.appendChild(docNode);
		}
	}
	
	
}

package org.mql.java.xml.dom;

public class BiblioParser {
	public BiblioParser(String source) {
		parse(source);
	}
	
	void parse(String source) {
		XMLNode root = new XMLNode(source);
		XMLNode children[] = root.children();
		for(XMLNode child : children) {
			int id = child.intAattribute("id");
			System.out.println(id);
		}
	}
	
	public static void main(String[] args) {
		new BiblioParser("resources/biblio.xml");
	}
}

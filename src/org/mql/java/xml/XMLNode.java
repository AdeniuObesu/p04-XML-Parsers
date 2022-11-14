package org.mql.java.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLNode {
	private Node node;
	
	public XMLNode(Node node) {
		this.node = node;
	}
	
	public XMLNode(String source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(source);
			node = document.getFirstChild();
			print(node);
			while(node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
			}
			print(node);
			NodeList children = node.getChildNodes();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public XMLNode[] children() {
		NodeList list = node.getChildNodes();
		
		for(int i=0; i<list.getLength(); i++) {
			print(list.item(i));
		}
		return null;
	}
	
	private void print(Node node) {
		System.out.println(node.getNodeName() + ", "
				+ node.getNodeType() + " " + node.getNodeValue());
	}
}

package org.mql.java.xml.dom;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLNode {
	private Node node;
	
	public XMLNode(Node node) {
		this.node = node;
	}
	
	public XMLNode(String source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		// pour rendre le parseur validant factory.setValidating(true);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(source);
			node = document.getFirstChild();
			while(node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
			}
//			NodeList children = node.getChildNodes();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public XMLNode[] children() {
		Vector<XMLNode> nodes = new Vector<>();
		
		NodeList list = node.getChildNodes();
		
		for(int i=0; i<list.getLength(); i++) {
			if(list.item(i).getNodeType() == Node.ELEMENT_NODE)
				nodes.add(new XMLNode(list.item(i)));
		}
		return nodes.toArray(new XMLNode[nodes.size()]);
	}
	
	public XMLNode child(String name) {
		NodeList list = node.getChildNodes();
		
		for(int i=0; i<list.getLength(); i++) {
			if(list.item(i).getNodeName().equals(name))
				return new XMLNode(list.item(i));
		}
		return null;
	}
	
	public String value() {
		if(node.getNodeType() == Node.ELEMENT_NODE)
			return node.getFirstChild().getNodeValue();
		return node.getNodeValue();
	}
	
	public String name() {
		return node.getNodeName();
	}
	
	public boolean isElement() {
		return (node.getNodeType() == Node.ELEMENT_NODE);
	}
	
	public int intAattribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		try {
			return Integer.parseInt(attributes.getNamedItem(name).getNodeValue());
		} catch (Exception e) {
			return -1;
		}
	}
	
	public void print() {
		System.out.println(node.getNodeName() + ", "
				+ node.getNodeType() + " " + node.getNodeValue());
	}
}

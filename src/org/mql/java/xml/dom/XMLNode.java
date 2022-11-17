package org.mql.java.xml.dom;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/*
 * DOM Parser is the easiest java xml parser to learn.
 * DOM parser loads the XML file into memory
 * and we can traverse it node by node to parse the XML.
 * DOM Parser is good for small files but when file size increases it performs slow
 * and consumes more memory. This is why there are other alternatives.
 * */
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
			while(node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
			}
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
	
	public String getvalue() {
		if(isElement())
			return node.getFirstChild().getNodeValue();
		return node.getNodeValue();
	}
	
	public void setValue(String value) {
		
	}
	
	public String name() {
		return node.getNodeName();
	}
	
	public boolean isElement() {
		return (node.getNodeType() == Node.ELEMENT_NODE);
	}
	
	public int intAttribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		try {
			return Integer.parseInt(attributes.getNamedItem(name).getNodeValue());
		} catch (Exception e) {
			System.out.println("INFO : Looking for Attribute : "+ name +" -> "+ e.getMessage());
			return -1;
		}
	}
	
	public String strAttribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		try {
			return attributes.getNamedItem(name).getNodeValue();
		} catch (Exception e) {
			System.out.println("INFO : Looking for Attribute : "+ name +" -> "+ e.getMessage());
			return null;
		}
	}
	
	public void appendChild(String content) {
		// TODO create child and add it to the current node
	}
	
	public void appendChild(XMLNode node) {
		// TODO add it to the current node
	}
	
	public XMLNode removeChild(String name) {
		// TODO remove the child by its name if it does exist
		return null;
	}
	public void print() {
		System.out.println(node.getNodeName() + ", "
				+ node.getNodeType() + " " + node.getNodeValue());
	}
}

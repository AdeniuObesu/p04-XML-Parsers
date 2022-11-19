package org.mql.java.xml.dom;

import java.io.File;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/*
 * DOM Parser is the easiest java XML parser to learn.
 * DOM parser loads the XML file into memory
 * and we can traverse it node by node to parse the XML.
 * DOM Parser is good for small files but when file size increases it performs slow
 * and consumes more memory. This is why there are other alternatives.
 * */
public class XMLNode {
	private Node node;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	private XMLNode(Node node) {
		this.node = node;
	}
	
	public XMLNode(String source) {
		factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(source);
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
	
	public String value() {
		if(isElement())
			return node.getFirstChild().getNodeValue();
		return node.getNodeValue();
	}
	
	public void value(String value) {
		node.setNodeValue(value);
	}
	
	public String name() {
		return node.getNodeName();
	}
	
	public boolean isElement() {
		return (node.getNodeType() == Node.ELEMENT_NODE);
	}
	
	public String getAttribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		try {
			return attributes.getNamedItem(name).getNodeValue();
		} catch (Exception e) {
			System.out.println("INFO : Looking for Attribute : "+ name +" -> "+ e.getMessage());
			return null;
		}
	}
	
	public void setAttribute(String name, String value) {
		if(isElement()) {
			Element element = (Element) node;
			element.setAttribute(name, value);
		}
	}
	
	public void setTextContent(String value) {
		node.setTextContent(value);
	}
	
	public void print() {
		System.out.println(node.getNodeName() + ", "
				+ node.getNodeType() + " " + node.getNodeValue());
	}

	public XMLNode createElement(String name) {
		if(isElement()) {
			Element another = (Element) document.createElement(name);
			XMLNode toReturn = new XMLNode(another);
			toReturn.document = document;
			return toReturn;
		}
		return null;
	}

	public void appendChild(XMLNode xmlNode) {
		node.appendChild(xmlNode.node);
	}
	
	public void save(String location) {
		try {
			System.out.println("Here, we save the file.");
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(location));
			transformer.transform(source, streamResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return node.getNodeName() + " - " + node.getTextContent();
	}
}

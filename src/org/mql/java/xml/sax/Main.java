package org.mql.java.xml.sax;

import javax.swing.JFrame;

import org.mql.java.ui.Form;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	public Main() {
		FormSAXParser parser = new FormSAXParser("resources/form.xml");
		exp01();
	}
	
	void exp01() {
		setTitle("Mon application");
		Form form = new Form("Formulaire");
		setContentPane(form);
		setSize(700, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}

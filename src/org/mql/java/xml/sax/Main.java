package org.mql.java.xml.sax;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.mql.java.ui.Form;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	public Main() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.err.println("Erreur - " + e.getMessage());
		}
		FormSAXParser parser = new FormSAXParser("resources/form.xml");
		setContentPane(parser.getForm());
		//exp01();
		setTitle("Mon application");
		//setSize(700, 300);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void exp01() {
		Form form = new Form("Formulaire");
		form.addTextField("Id", 10);
		form.addTextField("Titre", 30);
		setContentPane(form);
	}
	void exp02() {
		getContentPane().add("North", new JTextField(20));
		getContentPane().add("South", new JButton("Valider"));
	}
	
	public static void main(String[] args) {
		new Main();
	}
}

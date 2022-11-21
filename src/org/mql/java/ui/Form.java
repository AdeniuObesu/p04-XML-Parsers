package org.mql.java.ui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Form extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	
	public Form(String title) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(new LineBorder(Color.blue));
		container = new JPanel();
		container.setBorder(new TitledBorder(title));
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
	}
	
	public void addTextField(String label, int size) {
		
	}
}

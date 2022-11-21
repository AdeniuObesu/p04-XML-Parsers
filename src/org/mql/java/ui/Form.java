package org.mql.java.ui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Form extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	private int labelWidth;
	
	public Form(String title) {
		this(title, 100);
	}
	
	public Form(String title, int labelWidth) {
		this.labelWidth = labelWidth;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//setBorder(new LineBorder(Color.blue));
		
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBorder(new TitledBorder(title));
		add(container);
	}
	public void addTextField(LabeledTextField field) {
		container.add(field);
	}
	public void addTextField(String label, int size) {
		container.add(new LabeledTextField(label, size, labelWidth));
	}
}

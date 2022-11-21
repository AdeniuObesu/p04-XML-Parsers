package org.mql.java.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledTextField extends JPanel {
	private static final long serialVersionUID = 1L;

	public LabeledTextField(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":"))
			label +=" : ";
		add(new JLabel(label));
		add(new JTextField(size));
	}
	
	public LabeledTextField(String label, int size, int labelWidth) {
		this(label, size);
		JLabel l1 = (JLabel) getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
	}
}

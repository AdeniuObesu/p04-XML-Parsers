package org.mql.java.ui;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChoicePanel extends JPanel{
	private static final long serialVersionUID = 1l;
	
	public ChoicePanel(ChoiceStyle style, String label, String... items) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":"))
			label+=" : ";
		add(new JLabel(label));
		
		if(style == ChoiceStyle.RADIO) {
			ButtonGroup bg = new ButtonGroup();
			for(String item : items) {
				JRadioButton b = new JRadioButton(item);
				add(b);
				bg.add(b);
			}
		} else if (style == ChoiceStyle.COMBO) {
				add(new JComboBox<>(items));
		}
	}
}

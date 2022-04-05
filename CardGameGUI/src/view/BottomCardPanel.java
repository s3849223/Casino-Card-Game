package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class BottomCardPanel extends JPanel{
	
	
JLabel sLabel;
	
	public BottomCardPanel(CardFrame frame) {
		
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setBorder(BorderFactory.createTitledBorder("Game status"));
		setLayout(new BorderLayout());
		sLabel = new JLabel("Waiting...");
		add(sLabel, BorderLayout.WEST);
		
	
	}	
	
	public void setStatus(String s) {
		
		sLabel.setText(s);
		
	}

}

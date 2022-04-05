package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CenterCardPanel extends JPanel {

	
	private CardSummaryTable sTable; 
	private CardsPanel cPanel;  
  

	public CenterCardPanel(CardFrame frame) {
		
		setLayout(new BorderLayout()); 	
		cPanel = new CardsPanel(frame); 
		sTable = new CardSummaryTable(); 	
		add(cPanel, BorderLayout.CENTER);
		add(sTable, BorderLayout.SOUTH); 
		
		
		
		
	}

	public  CardSummaryTable getPlayerSummary() {
		
		return sTable;
	}

	public CardsPanel getCardPanel() {
		
		return cPanel; 
		
	}
	

}

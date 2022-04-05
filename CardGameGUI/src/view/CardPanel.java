package view;

import java.awt.*;
import javax.swing.*; 


public class CardPanel extends JPanel {

	CardToolBar bar; 
	

	public CardPanel(CardFrame frame) {
		 
		setLayout(new BorderLayout());
		setBackground(Color.PINK);	
		add(new CardToolBar(frame), BorderLayout.PAGE_START); 
		
		
	}
	
	public CardToolBar getBar() {
		return bar;
	}
	
	
	
	
	
}

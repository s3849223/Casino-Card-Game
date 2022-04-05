package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.BottomCardPanel;
import view.CardFrame;

public class CardPlayerBoxListener implements ItemListener {
	
	
	
	JComboBox<Player> PlayerComboBox;
	BottomCardPanel bottompanel; 
	
	public CardPlayerBoxListener(CardFrame frame, JComboBox<Player> pComboBox) {
		
		this.PlayerComboBox = pComboBox; 
		
		bottompanel = frame.getbottompannel();
		
	 
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Player p = (Player) PlayerComboBox.getSelectedItem();
		
		if (p != null) {
			
			bottompanel.setStatus(String.format("%s Selected", p.getPlayerName()));
			
		} else {
			
			bottompanel.setStatus("No one selected");
		}
	}
	
	

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.BottomCardPanel;
import view.CardFrame;
import view.CardSummaryTable;

public class CardResetBetListener implements ActionListener{
	
	JComboBox<Player> pComboBox;
	CardFrame frame;
	CardSummaryTable sTable;
	BottomCardPanel statuspanel;
	
	public CardResetBetListener(CardFrame frame, JComboBox<Player> pComboBox ) {
		
		this.frame = frame; 
		this.pComboBox = pComboBox; 
		
		sTable = frame.getCenterPanel().getPlayerSummary(); 
		statuspanel = frame.getbottompannel(); 	

	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
Player p = (Player) pComboBox.getSelectedItem();
		
		if (p != null) {
			if (!p.getPlayerId().equals("house")) {
				p.resetBet();
				sTable.PlayerBetUpdate(p);
				statuspanel.setStatus(String.format("%s reset bet", p.getPlayerName()));
			} else {
				statuspanel.setStatus("House cannot bet");
			}
		} else {
			statuspanel.setStatus("Invalid player");
		}
		
	}

}

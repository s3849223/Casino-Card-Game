package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.BottomCardPanel;
import view.CardFrame;
import view.CardSummaryTable;

public class CardRemovePlayerListener implements ActionListener {
	
	GameEngine game;
	JComboBox<Player> PlayerComboBox;
	CardSummaryTable summaryTable;
	BottomCardPanel bottompanel;

	public CardRemovePlayerListener(CardFrame frame, JComboBox<Player> PlayerComboBox) {
		
		game = frame.getgameengine();
		
		this.PlayerComboBox = PlayerComboBox; 
		
		summaryTable = frame.getCenterPanel().getPlayerSummary();
		bottompanel = frame.getbottompannel(); 
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Player p = (Player) PlayerComboBox.getSelectedItem();
		
		if (p != null && !p.getPlayerId().equals("house")) {
			
			game.removePlayer(p);
			PlayerComboBox.removeItem(p);
			summaryTable.RemovePlayers(p);
			bottompanel.setStatus(String.format("%s Removed", p.getPlayerName()));
			
		} else if (p.getPlayerId().equals("house")) {
			bottompanel.setStatus("Unable to remove house");
		} else {
			bottompanel.setStatus("Not a valid player");
		}
	}

}

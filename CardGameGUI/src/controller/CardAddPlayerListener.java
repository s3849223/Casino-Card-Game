package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.BottomCardPanel;
import view.CardFrame;
import view.CardSummaryTable;

public class CardAddPlayerListener implements ActionListener {

	
	JComboBox<Player> PlayerComboBox;
	String name;
	CardFrame frame; 
	GameEngine game; 
	CardSummaryTable summaryTable; 
	BottomCardPanel bottompanel; 
	
	public CardAddPlayerListener(CardFrame frame, JComboBox<Player> PlayerComboBox) {
	
		 				
		
	this.frame = frame; 
	this.PlayerComboBox = PlayerComboBox;
	
	 game = frame.getgameengine(); 
	 
	
	summaryTable = frame.getCenterPanel().getPlayerSummary();
	
	bottompanel = frame.getbottompannel(); 
	
	
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String playerID = (String) JOptionPane.showInputDialog("Player ID:");
		String playerName = (String) JOptionPane.showInputDialog("Player Name:");
		int playerPoints = Integer.parseInt(JOptionPane.showInputDialog("Player Points:"));
		
		if (!playerID.equals("house")) {
			Player p = new SimplePlayer(playerID, playerName, playerPoints);
			
			if (game.getPlayer(playerID) != null) {
				
				PlayerComboBox.removeItem(game.getPlayer(playerID));
				summaryTable.RemovePlayers(p);
				
			}
			
				
				game.addPlayer(p);
				
				
				
		
				PlayerComboBox.addItem(p);
				
				summaryTable.players(p);
			    bottompanel.setStatus(String.format("%s Added", p.getPlayerName()));
			
		} else {
			
			bottompanel.setStatus("Invalid Player ID");
		}
	}	

}

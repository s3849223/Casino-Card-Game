package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.CardPlayerStatus;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.BottomCardPanel;
import view.CardFrame;
import view.CardSummaryTable;


public class CardDealListener implements ActionListener {

	GameEngine gEngine;
	CardPlayerStatus pState;
	
	JComboBox<Player> PlayerComboBox;
	CardSummaryTable summaryTable;
	BottomCardPanel bottompanel;
	
	public CardDealListener(CardFrame frame, JComboBox<Player> pComboBox) {
		
		
		
		gEngine = frame.getgameengine(); 
		
		this.PlayerComboBox = pComboBox;
		
		summaryTable = frame.getCenterPanel().getPlayerSummary();
		
	
		bottompanel = frame.getbottompannel();
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	Player p = (Player) PlayerComboBox.getSelectedItem();
	int delay = 100;
	if(p.getPlayerId().equals("house")) {
		
		new Thread() {
			@Override
			public void run() {
			
			gEngine.dealHouse(delay);
			
				
			}
			
			
		}.start(); 
	}else {
		new Thread() {
			@Override
			public void run() {
			gEngine.dealPlayer(p, delay);
			summaryTable.PlayerResultUpdate(p); 
			
				
			}
			
			
		}.start(); 
	}
	
		
		}

}



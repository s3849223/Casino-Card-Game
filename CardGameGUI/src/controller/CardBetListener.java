package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.Player;
import view.BottomCardPanel;
import view.CardFrame;
import view.CardSummaryTable;
import view.CardToolBar;

public class CardBetListener implements ActionListener {
	
	JComboBox<Player> PlayerComboBox;
	CardFrame frame;
	CardSummaryTable summaryTable;
	BottomCardPanel bottompanel;
	
	
	
	public CardBetListener(CardFrame frame, JComboBox<Player> pComboBox) {
		
		this.frame = frame; 
		
		this.PlayerComboBox = pComboBox; 
		
		summaryTable = frame.getCenterPanel().getPlayerSummary(); 
		bottompanel = frame.getbottompannel(); 	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player p = (Player) PlayerComboBox.getSelectedItem();
		
		
		if (p!= null) {
			if (!p.getPlayerId().equals("house")) {
				int bet = Integer.parseInt(JOptionPane.showInputDialog("Insert Bet Amount:"));

				if (p.setBet(bet)) {
					summaryTable.PlayerBetUpdate(p);
					bottompanel.setStatus(String.format("%s set bet of %d", p.getPlayerName(), bet));
				} else {
					bottompanel.setStatus(String.format("%s has insufficient funds", p.getPlayerName()));
				} 
			} else {
				bottompanel.setStatus("House cannot bet");
			}
		} else {
			bottompanel.setStatus("Invalid player");
		}
		
	}

}

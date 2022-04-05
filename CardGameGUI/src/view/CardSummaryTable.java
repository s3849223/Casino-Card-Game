package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CardAddPlayerListener;
import model.interfaces.Player;

public class CardSummaryTable extends JPanel {
	
	JTable jtable;
	CardAddPlayerListener cardaddplayerlistner;
	DefaultTableModel tableModel; 
	
	
	public CardSummaryTable() {
		setLayout(new BorderLayout()); 
		
		
		Object[] columnNames = {"ID", "Name", "Bet", "Points" , "Result", "Winnings"}; 
	
		
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setBorder(BorderFactory.createTitledBorder("Summary Table"));
		
		tableModel = new DefaultTableModel(columnNames, 0);  
		jtable = new JTable(tableModel); 
		
		JScrollPane scrollPane = new JScrollPane(jtable);
		
		jtable.setFillsViewportHeight(true); 
		add(scrollPane, BorderLayout.PAGE_START); 
		
	
		
	}
	
	public void dimensions (CardFrame cardframe){
		
		setBorder(BorderFactory.createTitledBorder("Summary Panel")); 
		setLayout(new BorderLayout()); 
		setPreferredSize(new Dimension(cardframe.getWidth(), cardframe.getHeight() / 3 ));
		
		setBackground(Color.PINK); 
		
		
	}
	
	
	public void players(Player player) {
		
		Object[] Row = {
				player.getPlayerId(), player.getPlayerName(), player.getBet(), player.getPoints(), player.getResult(), "-"
				
		};
		tableModel.addRow(Row); 
	}
	
	
	public void RemovePlayers(Player p) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(tableModel.getValueAt(i, 0)))
				tableModel.removeRow(i);
		}
	}
	
	public void PlayerBetUpdate(Player p) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(tableModel.getValueAt(i, 0))) {
				tableModel.setValueAt(p.getBet(), i, 2);
			}
		}
	}
	
	public void PlayerPointsUpdate(Player p) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(tableModel.getValueAt(i, 0))) {
				tableModel.setValueAt(p.getPoints(), i, 3);
			}
		}
	}
	
	public void PlayerResultUpdate(Player p) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(tableModel.getValueAt(i, 0))) {
				tableModel.setValueAt(p.getResult(), i, 4);
			}
		}
	}
	
	public void PlayerOverallUpdate(Player p, String s) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(tableModel.getValueAt(i, 0))) {
				tableModel.setValueAt(s, i, 5);
			}
		}
	}
	

}

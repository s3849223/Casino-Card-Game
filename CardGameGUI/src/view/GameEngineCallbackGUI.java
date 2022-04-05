package view;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	CardFrame frame; 
	CardsPanel panel; 
	CardSummaryTable sumTable; 
	
	
	public GameEngineCallbackGUI(CardFrame frame) {
		
		this.frame = frame;
		sumTable = frame.getCenterPanel().getPlayerSummary();
		panel = frame.getCenterPanel().getCardPanel(); 
		
		
		
	}
	
	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
	
	
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			
				
				panel.ImageCreator(card);
			}
		}); 
	
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		
			}
		});
	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		
				sumTable.PlayerResultUpdate(player);
				
			}
		});
		
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		
			}
		});
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
		
			}
		});
		
	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
	

				for (Player p : engine.getAllPlayers()) {
					sumTable.PlayerPointsUpdate(p);
					sumTable.PlayerBetUpdate(p);

					if (p.getResult() > result) {
						sumTable.PlayerOverallUpdate(p, "win");
					} else if (p.getResult() < result) {
						sumTable.PlayerOverallUpdate(p, "loss");
					} else {
						sumTable.PlayerOverallUpdate(p, "draw");
					}
				}
			}
		});
	}

}

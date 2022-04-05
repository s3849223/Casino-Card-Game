package view;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java
 * logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */

public class GameEngineCallbackImpl implements GameEngineCallback {
	public static final Logger logger = Logger.getLogger(GameEngineCallbackImpl.class.getName());

	// utility method to set output level of logging handlers
	public static Logger setAllHandlers(Level level, Logger logger, boolean recursive) {
		// end recursion?
		if (logger != null) {
			logger.setLevel(level);
			for (Handler handler : logger.getHandlers())
				handler.setLevel(level);
			// recursion
			setAllHandlers(level, logger.getParent(), recursive);
		}
		return logger;
	}

	public GameEngineCallbackImpl() {
		// NOTE can also set the console to FINE in %JRE_HOME%\lib\logging.properties
		setAllHandlers(Level.INFO, logger, true);
	}
	
	//Logs the card dealt to the player
	@Override
   public void nextCard(Player player, PlayingCard card, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
      logger.log(Level.FINE,String.format("Card Dealt to %s .. %s \n", player.getPlayerName(), card.toString())); 
      
   }

	//Logs the result of the player
	@Override
	public void result(Player player, int result, GameEngine engine) {
		// final results logged at Level.INFO
		logger.log(Level.FINE, String.format("Result data to %s .. %s \n", player.getPlayerName(), result));
		
	}

	//Logs the bustcard for player
	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		logger.log(Level.FINE, String.format("bustCard data to %s .. %s \n .. YOU BUSTED! \n", player.getPlayerName(), card.toString()));
	}

	//Logs the next card dealt to the house 
	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		logger.log(Level.FINE, String.format("Card Dealt to House %s ..  \n", card.toString()));
	}

	//Logs the next bustcard for house
	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		logger.log(Level.FINE, String.format("Card Dealt to House %s \n .. HOUSE BUSTED!  \n", card.toString()));
	}

	//Logs the house result
	@Override
	public void houseResult(int result, GameEngine engine) {
		StringBuilder join = new StringBuilder("Final Player Results ");
		logger.log(Level.FINE, String.format("houseResult data to %d .. \n", result));
		for (Player winplayer : engine.getAllPlayers()) {
		
		join.append("\n" + winplayer.toString()); 
			
		}
		logger.log(Level.FINE, String.format(join.toString())); 
	
	
	}

	

}

package model;

import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;


import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.GameEngineCallbackImpl; //added
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	private LinkedList<Player> newplayers = new LinkedList<Player>();
	GameEngineCallbackImpl game = new GameEngineCallbackImpl();
	private Collection<GameEngineCallback> addgameengine = new LinkedList<GameEngineCallback>();
	private Deque<PlayingCard> adddeck = new LinkedList<PlayingCard>();

	@Override
	public void dealPlayer(Player player, int delay) throws IllegalArgumentException {

		//Results for the player is set to 0 so that the score from each card can be incremented later on.
		//GetShuffledHalfDeck is equated the adddeck collection so that the deck of playing cards can get 
		//shuffled before being drawn and handed to the player.
		//Bustcard is initialized to aid with getting the final result.
		
		player.setResult(0);
		adddeck = getShuffledHalfDeck(); 
		PlayingCard cards = null;
		PlayingCard bustcard;
		
		//While loop which continues dealing cards until player's score exceeds BUST LEVEL.
		//If players result doesn't exceed the bust level the nextCard method is called and the player 
		//is dealt another card which is displayed on the console.
		//If players result exceeds the bust level the the bustCard method is called. 
		//Delay is applied to each set of results.
		
		while (player.getResult() <= BUST_LEVEL) { 			 
			
			//Nextcard change to fine.
			//Nexthousecard change to fine.
			
			cards = adddeck.pollFirst(); 					
			player.setResult(cards.getScore() + player.getResult());

			for (GameEngineCallback call : addgameengine) {


				if (player.getResult() > BUST_LEVEL) {

					bustcard = cards;
					call.bustCard(player, bustcard, this);

				} else {
					
					call.nextCard(player, cards, this);

				}

			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
			
			}
		}

		//Calculates player results by the player result and their cards score to give the pre - bust total.
		
		player.setResult(player.getResult() - cards.getScore());
		for (GameEngineCallback call : addgameengine)
		call.result(player, player.getResult(), this);
	
			
		
		
	}

	
	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {
		
		//Since player isn't a parameter in deal house, sumscore is initialized in order to keep a track of house score.
		int sumscore = 0;
		adddeck = getShuffledHalfDeck();
		PlayingCard cards = null;
		PlayingCard bustcard;
		
		//While loop which continues dealing cards until house exceeds BUST LEVEL.
		//If players result doesn't exceed the bust level the nextHouseCard method is called and the house
		//is dealt another card which is displayed and updated on the console.
		//If house result exceeds the bust level the the houseBustCard method is called.
		//Delay is applied to each set of results.
		
		while (sumscore <= BUST_LEVEL) {

			cards = adddeck.pollFirst();
			sumscore += cards.getScore();

			for (GameEngineCallback use : addgameengine) {

				use.nextHouseCard(cards, this);

			}

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {

			}

		}

		if (sumscore > BUST_LEVEL) {

			for (GameEngineCallback call : addgameengine) {

				bustcard = cards;
				call.houseBustCard(bustcard, this);
				sumscore -= bustcard.getScore();
			}

		}
		
		//Applies the win loss method to determine who won.
		
		for (Player player : newplayers) {

			applyWinLoss(player, sumscore);

		}
		
		//Calculates house result by invoking the houseResult method .
		
		for (GameEngineCallback call : addgameengine)
			call.houseResult(sumscore, this);

		for (Player player1 : newplayers) {

			player1.resetBet();
		}

	}

	@Override
	public void applyWinLoss(Player player, int houseResult) {
		
		// Winloss is determined by comparing the house result and the player result, 
		//if the player result is greater than the house result than the player has won and is calulated by summing
		// his points and bet ammount.
		//Otherwise, the player has lost and his points are determined by subtracting the bet ammount from his points
		
		if (player.getResult() > houseResult) {

			int W = player.getPoints() + player.getBet();
			player.setPoints(W);

		} else if (player.getResult() < houseResult) {
			int L = player.getPoints() - player.getBet();
			player.setPoints(L);
		}
	}

	@Override
	public void addPlayer(Player player) {
		
		// Adds a player 
		
		newplayers.add(player);
		
	}

	@Override
	public Player getPlayer(String id) {
	
		// Retrieves player id.
		
		for (Player player : newplayers) {

			if (player.getPlayerId().equals(id)) {

				return player;
			}

		}

		return null;

	}

	@Override
	public boolean removePlayer(Player player) {
		
		// Removes an existing player from the game.
		
		newplayers.remove(player);
		return true;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		
		//  Bet is set per player and bet must be greater than 0 and player points must 
		//  be greater than bet
		
		if (bet > 0 && player.getPoints() > bet) {
			player.setBet(bet);
			return true;
		}

		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		
		// Adds the game engine class so Callbacks can be called and updates can be performed.
		
		addgameengine.add(gameEngineCallback);

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		
		// If an instance exists and is no longer needed, it is removed.
		
		if (addgameengine.contains(gameEngineCallback)) {
			addgameengine.remove(gameEngineCallback);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		// Sorts the collection of players.
		// Creates the collection unmodifiable and returns it.
		
		Collections.sort(newplayers);
		Collections.unmodifiableCollection(newplayers);

		return newplayers;
	}

	@Override
	public Deque<PlayingCard> getShuffledHalfDeck() {
		
		// Iterates through the deck of cards and randomly selects different 
		// enum values of Suits and Values.
		
		LinkedList<PlayingCard> newdeck = new LinkedList<PlayingCard>();
		for (int a = 0; a < Suit.values().length; a++) 
			for (int b = 0; b < Value.values().length; b++)
				
		newdeck.add(new PlayingCardImpl(Suit.values()[a], Value.values()[b]));
		Collections.shuffle(newdeck);
		return newdeck;
		
		
	}

}

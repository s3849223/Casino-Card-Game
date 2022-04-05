package model;
import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {

	private Suit suits;
	private Value values;
	private int score;

	//Contains the possible selection of suits and values for the cards that are dealt 
	// to the player.
	public PlayingCardImpl(Suit suit, Value value) {

		this.suits = suit;
		this.values = value;
		if (value == Value.EIGHT) {
			score = 8;

		} else if (value == Value.NINE) {
			score = 9;

		} else if (value == Value.TEN) {
			score = 10;

		} else if (value == Value.JACK) {
			score = 10;

		} else if (value == Value.QUEEN) {
			score = 10;

		} else if (value == Value.KING) {
			score = 10;

		} else if (value == Value.ACE) {
			score = 11;

		}

	}

	//Returns the value of the suit selected.
	public Suit getSuit() {

		return this.suits;
	}

	//Returns the value of the card selected.
	@Override
	public Value getValue() {

		return this.values;
	}

	//Returns the score value of the card.
	@Override
	public int getScore() {

		return score;
	}

	// A String format which displays the values the playing card.
	@Override
	public String toString() {
		return String.format("Suit: %s, Value: %s, Score: %s", suits, values, score).toString();
	}

	// Checks if values and suits equal.
	@Override	
	public boolean equals(PlayingCard card) {

		if (values.equals(card) && suits.equals(card)) {
			return true;
		}
		return false;
	}
	
	// Returns hash code of values and suits.
	@Override
	public int hashCode() {

		return values.hashCode() + suits.hashCode();
	}

	// Returns value of card values and suits.
	@Override
	public boolean equals(Object equalcard) {
		if (equalcard instanceof PlayingCard) {
			
			Boolean returnValue = this.getSuit().equals(((PlayingCard) equalcard).getSuit()) && this.getValue().equals(((PlayingCard) equalcard).getValue()); 

			return returnValue;
		}
			return false; 
	}

}

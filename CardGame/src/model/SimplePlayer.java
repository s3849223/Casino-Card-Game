package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {

    //Variables are initialized so that they can later be used within methods.
	
	private String PlayerName; 
	private String id; 
	private int result; 
	private int bet;
	private int initialPoints; 
	
	//Constructor which contains the id, player name and initial points
	public SimplePlayer(String id, String playerName, int initialPoints) {
		// TODO Auto-generated constructor stub
		if (id == null)
		throw new IllegalArgumentException("null args"); 
		this.id = id; 
		this.PlayerName = playerName; 
		this.initialPoints = initialPoints; 
		
	}
	
	//Get the player name.
	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return this.PlayerName;
	}

	//Set the player name.
	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub
		this.PlayerName = playerName; 
	}
	
	//Get the points.
	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return this.initialPoints;
	}

	//Set the points.
	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub
		this.initialPoints = points; 
	}

	//Get the player Id
	@Override
	public String getPlayerId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	//Set the player id 
	@Override
	public boolean setBet(int bet) {
		// TODO Auto-generated method stub
		if(bet > 0 && this.getPoints() - bet >= 0) {
		this.bet = bet; 
		return true;
		
		}

		return false;
	}

	//Get the bet 
	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return this.bet;
	}

	//Reset the bet to 0
	@Override
	public void resetBet() {
		// TODO Auto-generated method stub
		this.bet = 0; 
	}

	//Get the result 
	@Override
	public int getResult() {
		// TODO Auto-generated method stub
		return this.result;
	}

	//Set the result
	@Override
	public void setResult(int result) {
		// TODO Auto-generated method stub
		this.result = result; 
	}

	// Checks if player id is equal
	@Override
	public boolean equals(Player player) {
	
		return (id.equals(getPlayerId()));
		
	}
	
	//Returns if id equals
	@Override 
	public boolean equals(Object Player) { 
	
	if(Player instanceof Player) 
	{	
		Player player = (Player)Player;
		return (id.equals(player.getPlayerId()));		
	}
	return false; 
	}
	
	//Hashcode of id
	@Override 
	public int hashCode() {
	
	return id.hashCode(); 
	
	}
	
	//Compares based on player id 
	@Override
	public int compareTo(Player player) {
		// TODO Auto-generated method stub
		
		return Integer.parseInt(this.id) - Integer.parseInt(player.getPlayerId());
	}
	
	//Returns a readable string for 
	@Override 
	public String toString() {
		return String.format("Player:, id=%s, name=%s, bet=%d, point=%d, RESULT .. %d", 
				id, PlayerName, bet, initialPoints, result);
				
	}

}

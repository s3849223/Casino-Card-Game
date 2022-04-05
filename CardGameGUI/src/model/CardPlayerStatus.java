package model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CardFrame;

public class CardPlayerStatus {
	
	GameEngine gEngine;
	
	Player dealing = null;
	Player lastDealt = null;
	Collection<Player> dealtPlayers = new ArrayList<>();
	
	public CardPlayerStatus(CardFrame frame) {
		gEngine = frame.getgameengine(); 
		
	}
	
	public void AddPlayer(Player p) {
		dealtPlayers.add(p);
	}
	
	public boolean CurrentlyDealing(Player p) {
		return dealing != null && p.equals(dealing);
	}
	
	public void setPDealing(Player p) {
		dealing = p;
	}
	
	public boolean PreviouslyDealtPlayer(Player p) {
		return dealtPlayers.contains(p);
	}
	
	public boolean DealtLast(Player p) {
		return p.equals(lastDealt);
	}
	
	public void setDealtLast(Player p) {
		lastDealt = p;
	}
	
	public boolean AllPlayersDealt() {
		return dealtPlayers.containsAll(gEngine.getAllPlayers()) && !dealtPlayers.isEmpty();
	}
	
	public void DealtPlayersClear() {
		dealtPlayers.clear();
	}
	
	
	
}


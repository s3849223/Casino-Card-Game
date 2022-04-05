package controller;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.logging.Level;

import view.CardFrame;
import view.GameEngineCallbackImpl;

public class CardFrameListener implements ComponentListener {

CardFrame cardframe; 
	
	public CardFrameListener(CardFrame cardFrame) {
		this.cardframe = cardFrame; 
		
	}
	
	
	@Override
	public void componentResized(ComponentEvent e) {
		
		cardframe.getCenterPanel().getCardPanel().setPreferredSize(new Dimension(cardframe.getWidth(), cardframe.getCenterPanel().getHeight() * 2/3));
        cardframe.getCenterPanel().getCardPanel().repaint();
        cardframe.getCenterPanel().getCardPanel().revalidate();
        
        cardframe.getCenterPanel().getPlayerSummary().setPreferredSize(new Dimension(cardframe.getWidth(), cardframe.getCenterPanel().getHeight() /3));
        cardframe.getCenterPanel().getPlayerSummary().repaint();
        cardframe.getCenterPanel().getPlayerSummary().revalidate(); 
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
		
	}

}

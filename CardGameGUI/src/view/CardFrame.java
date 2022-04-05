package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.CardFrameListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.interfaces.GameEngineCallback;


public class CardFrame extends JFrame {

	 
	CenterCardPanel ccp;  
	CardPanel topPanel; 
	BottomCardPanel bottompanel; 
	
	GameEngine gameengine = new GameEngineImpl(); 
	
	 public CardFrame()
	   {
		
		  
		  setBounds(100, 100, 960, 600); 
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	      setLayout(new BorderLayout());	
	     
	       
	   }
	 
	 public void build() {
		 
		 ccp = new CenterCardPanel(this);
	      bottompanel = new BottomCardPanel(this);
	      add(bottompanel, BorderLayout.SOUTH);
	      add(ccp, BorderLayout.CENTER); 
	      add(new CardPanel(this), BorderLayout.NORTH); 
	      CardFrameListener cardframeListener = new CardFrameListener(this);
	      addComponentListener(cardframeListener);
	      revalidate();
	      GameEngineCallback callback = new GameEngineCallbackGUI(this); 
		 gameengine.addGameEngineCallback(callback);
		 
	 }

	public CardPanel gettopPanel() {
		
		return topPanel; 
	}
	

	 public CenterCardPanel getCenterPanel() {
	
		return ccp;
	}
	
	public BottomCardPanel getbottompannel() {
		
		return bottompanel; 
		
	} 
	 
	public GameEngine getgameengine() {
	 
		return gameengine; 
	}


}

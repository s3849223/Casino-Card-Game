package app;

import java.util.logging.Level;

import javax.swing.SwingUtilities;

import view.CardFrame;
import view.GameEngineCallbackImpl;

public class CardTest {

	public static void main(String[] args)
	   {
			
		
		
	      SwingUtilities.invokeLater(new Runnable()
	      {
	         @Override
	         public void run()
	         {
	        	
	        	
	        	  
	        	 CardFrame frame = new CardFrame();  
	        	 frame.build(); 
	        	
	         }
	      });
	   }

}

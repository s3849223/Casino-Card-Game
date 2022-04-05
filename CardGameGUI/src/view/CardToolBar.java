package view;

import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToolBar;

import controller.CardAddPlayerListener;
import controller.CardBetListener;
import controller.CardDealListener;
import controller.CardPlayerBoxListener;
import controller.CardRemovePlayerListener;
import controller.CardResetBetListener;
import model.SimplePlayer;
import model.interfaces.Player;
 



public class CardToolBar extends JToolBar {
	
	
	CardFrame frame;
	JComboBox<Player> PlayerComboBox; 
	
	
	public CardToolBar(CardFrame frame) {
		
		
		
		AbstractButton button = new JButton("Deal Player");
		add(button); 
		
		AbstractButton button1 = new JButton("Place Bet");
		add(button1); 
		
		
		PlayerComboBox = new JComboBox<Player>();
		PlayerComboBox.addItem(new SimplePlayer("house", "House", -1)); 
		PlayerComboBox.setRenderer(new DefaultListCellRenderer() {
		public Component getListCellRendererComponent(JList<?> list,
				Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
			if (value != null)
				setText(((Player) value).getPlayerName());
			return this;
		}		
		});
		
		add(PlayerComboBox);
						
		AbstractButton button3 = new JButton("Remove Player");
		add(button3); 
		
		AbstractButton button4 = new JButton("Add Player");
		add(button4); 
		
		AbstractButton button5 = new JButton("Reset Bet");
		add(button5); 
		
		button.addActionListener(new CardDealListener(frame, PlayerComboBox));
		button1.addActionListener(new CardBetListener(frame, PlayerComboBox));
		PlayerComboBox.addItemListener(new CardPlayerBoxListener(frame,PlayerComboBox));
		button3.addActionListener(new CardRemovePlayerListener(frame, PlayerComboBox));
		button4.addActionListener(new CardAddPlayerListener(frame, PlayerComboBox));
		button5.addActionListener(new CardResetBetListener(frame, PlayerComboBox));
		
	} 
	
	public void addtoCBox(Player player) {
		
		PlayerComboBox.addItem(player);
		
	}
	
	
	
	public JComboBox<Player> getpComboBox() {
		return PlayerComboBox; 
	}

		
	
}

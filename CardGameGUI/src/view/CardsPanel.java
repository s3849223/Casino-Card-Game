package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.PlayingCard;


public class CardsPanel extends JPanel {
	
	JPanel cardspanel = new JPanel(); 
	File[] imageFile;
	CardFrame frame;
	
	public CardsPanel(CardFrame frame) {
		this.frame = frame; 
		imageFile = new File(String.format("cards")).listFiles();
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setBorder(BorderFactory.createTitledBorder("Card Panel"));
		add(cardspanel); 
	}
	
	public void ImageCreator(PlayingCard pc)
    {
        String imageFileName = pc.getSuit().toString() + "_" + pc.getValue().toString() + ".PNG";
        for (int i = 0; i < imageFile.length; i++) {
            
            if (imageFile[i].toString().contains(imageFileName)) {
                ImageIcon currentCard = new ImageIcon(imageFile[i].toString());
                
                Image imageCard = currentCard.getImage();
                 
                Image scaledCard = imageCard.getScaledInstance((int) (frame.getWidth() / 7), (int) (frame.getHeight()  / 3), java.awt.Image.SCALE_SMOOTH);
                
                currentCard = new ImageIcon(scaledCard);
                JLabel cardLabel = new JLabel();
                cardLabel.setIcon(currentCard);
                add(cardLabel);
                repaint();
                revalidate();
          
            }
        } 
    }

}

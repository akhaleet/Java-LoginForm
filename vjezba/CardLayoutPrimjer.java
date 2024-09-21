package vjezba;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardLayoutPrimjer extends Frame {
	
	private static final int cardsCount = 5;
	
	private void populateWindow() {
		
		CardLayout cardLayout = new CardLayout();
		Panel cardPanel = new Panel();
		cardPanel.setLayout(cardLayout);
		
		Panel card;
		for (int i=0; i < cardsCount; i++) {
			card = new Panel();
			card.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			cardPanel.add(card);
		}
		
		add(cardPanel, BorderLayout.CENTER);
		
		Button next = new Button("-> Next"), previous = new Button("Previous <-");
		
		next.addActionListener((ae) -> {
			cardLayout.next(cardPanel);
		});
		
		previous.addActionListener((ae) -> {
			cardLayout.previous(cardPanel);
		});
		
		Panel southPanel = new Panel();
		southPanel.add(previous);
		southPanel.add(next);
		add(southPanel, BorderLayout.SOUTH);
				
	}
	
	public CardLayoutPrimjer() {
		setTitle("Karte");
		
		populateWindow();
		
		setBounds(700,200,400,300);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {	
		new CardLayoutPrimjer();
	}
}

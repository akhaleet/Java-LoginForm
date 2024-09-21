package vjezba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BasicWindow extends Frame {
	
	private void populateWindow() {
		
		Label west = new Label("west"),
			  south = new Label("south"),
			  east = new Label("east"),
			  north = new Label("north"),
			  center = new Label("center");
		
		south.setAlignment(Label.RIGHT);
		center.setAlignment(Label.CENTER);
		
		west.setBackground(Color.MAGENTA);
		south.setBackground(Color.GREEN);
		east.setBackground(Color.YELLOW);
		north.setBackground(Color.RED);
		center.setBackground(Color.ORANGE);
		
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
	}

	public BasicWindow () {
		
		//setResizable(false);
		
		setBounds(700,200,400,300);
		
		setTitle("Basic window");
		
		populateWindow();
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// setVisible(false);
				dispose();
			
			}
		});
		
		setVisible(true);
	}
	
public static void main(String[] args) {
	
		new BasicWindow();

	}
}

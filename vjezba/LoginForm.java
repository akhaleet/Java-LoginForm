package vjezba;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginForm extends Frame {
	
	private class QuitDialog extends Dialog {
		
		private Button ok = new Button("OK"), cancel = new Button("Cancel");
		
		public void paint(Graphics g) {
			g.drawString("Are you sure you want to quit?", 20, 70);
			super.paint(g);
		}

		public QuitDialog(Frame owner) {
			super(owner);
			setTitle("Quit");
			setBounds(owner.getX() + owner.getWidth() / 2, owner.getY() + owner.getHeight() / 2, 200,150);
			setResizable(false);
			setModalityType(ModalityType.APPLICATION_MODAL);
		
			Panel buttons = new Panel();
			
			ok.addActionListener((ae) -> {
				LoginForm.this.dispose();
			});
			
			cancel.addActionListener((ae) -> {
				QuitDialog.this.dispose();
			});
			
			buttons.add(ok);
			buttons.add(cancel);
			
			add(buttons, BorderLayout.SOUTH);
			
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			setVisible(true);
		}	
		
	}
	
	private TextField username = new TextField(10);
	private TextField password = new TextField(10);
	private Button submit = new Button("Submit");
	private Label passStrength = new Label("");
	
	private void populateWindow() {
		
		Panel content = new Panel(new GridLayout(0, 1, 0, 5));
		
		Panel userPanel = new Panel();
		userPanel.setBackground(Color.RED);
		userPanel.add(new Label("Username: "));
		userPanel.add(username);
		
		content.add(userPanel);
		
		Panel passPanel = new Panel();	
		
		password.addTextListener((te) -> {
			
			int passLen = password.getText().length();
			if (passLen == 0) {
				passStrength.setText("");
			}
			else if (passLen < 5) {
				passStrength.setText("Weak password");
				passStrength.setForeground(Color.RED);
			}		
			else if (passLen < 10) {
				passStrength.setText("Good password");
				passStrength.setForeground(Color.YELLOW);
			}
			else {
				passStrength.setText("Excelent password");
				passStrength.setForeground(Color.GREEN);
			}
			
			passStrength.revalidate();
			
			
		});
		
		password.setEchoChar('*');
		passPanel.setBackground(Color.YELLOW);
		passPanel.add(new Label("Password: "));
		passPanel.add(password);
		
		content.add(passPanel);
		
		Panel genderPanel = new Panel();	
		genderPanel.setBackground(Color.GREEN);
		genderPanel.add(new Label("Gender: "));
		
		CheckboxGroup genderGroup = new CheckboxGroup();
		
		Checkbox maleCb = new Checkbox("Male", true, genderGroup);
		Checkbox femaleCb = new Checkbox("Female", false, genderGroup);
		genderPanel.add(maleCb);
		genderPanel.add(femaleCb);
		content.add(genderPanel);
		
		Panel termsPanel = new Panel();
		Checkbox termsCb = new Checkbox("I agree with terms and conditions.");
		termsPanel.add(termsCb);
		content.add(termsPanel);
		
		termsCb.addItemListener((ie) -> {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				submit.setEnabled(true);
			}
			else {
				submit.setEnabled(false);
			}
			
		});
		
		submit.setEnabled(false);
		
		submit.addActionListener((ae) -> {
			System.out.println("====================");
			System.out.println("Username: " + username.getText());
			System.out.println("Password: " + password.getText());
			System.out.println("Gender: " + genderGroup.getSelectedCheckbox().getLabel());
		
		});
		
		Panel submitPanel = new Panel();
		submitPanel.add(submit);
		content.add(submitPanel);
		
		passStrength.setFont(new Font("Arial", Font.BOLD, 20));
		Panel passStrengthPanel = new Panel();
		passStrengthPanel.setBackground(Color.LIGHT_GRAY);
		passStrengthPanel.add(passStrength);
		content.add(passStrengthPanel);
		
		add(content, BorderLayout.CENTER);
		
	}
	
	public LoginForm() {
		
		// setBounds(700,200,400,600);
		
		setLocation(700,200);
		
		setResizable(true);
		
		setTitle("Login form");
		
		populateWindow();
		
		pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// dispose();
				new QuitDialog(LoginForm.this);
			}
		});
		
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {	
		new LoginForm();
	}

}

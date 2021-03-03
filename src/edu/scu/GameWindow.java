package edu.scu;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	public GameWindow() {
		this.initFrame();
	}
	
	private void initFrame() {
		this.setName("2048 Game");
		this.setSize(820, 650); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		setContentPane(new StartPanel(this));
		
		setVisible(true);
	}

}

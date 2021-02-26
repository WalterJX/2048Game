package edu.scu;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	public GameWindow() {
		this.initFrame();
	}
	
	private void initFrame() {
		this.setName("2048 Game");
		this.setSize(500, 600); //500,600 
		this.setResizable(true);//false
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		setContentPane(new StartPanel(this));
		
		setVisible(true);
	}

}

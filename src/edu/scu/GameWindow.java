package edu.scu;

import javax.swing.JFrame;

/*
 * base frame of all project
 * */
public class GameWindow extends JFrame{
	
	// constructor of GameWindow frame
	public GameWindow() {
		this.initFrame();
	}
	
	// init frame and set contentpanel
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

package edu.scu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
	
	private JFrame mainBoard;
	private JPanel menu;
	private JButton btn_start;
	private JButton btn_continue;
	private JButton btn_scores;
	private JButton btn_exit;
	
	public StartPanel(JFrame mainBoard) {
		this.mainBoard = mainBoard; 
		initUI();
		addActionListener();
	}
	
	private void initUI() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(newLine(Box.createVerticalStrut(25)));
		
		JLabel label = new JLabel("2048");
		label.setForeground(new java.awt.Color(0x776e65));
		label.setFont(new java.awt.Font("Dialog", 1, 92));
		add(newLine(label));
		
		add(newLine(Box.createVerticalStrut(50)));
		
		btn_start = new JButton("New Game");
		btn_start.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_start.setMaximumSize(new Dimension(100, 40));
		btn_start.setPreferredSize(new Dimension(100, 40));
		
		add(newLine(btn_start));

		add(newLine(Box.createVerticalStrut(50)));
		
		btn_continue = new JButton("Continue");
		btn_continue.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_continue.setMaximumSize(new Dimension(100, 40));
		btn_continue.setPreferredSize(new Dimension(100, 40));
		
		add(newLine(btn_continue));
		
		add(newLine(Box.createVerticalStrut(50)));
		
		btn_scores = new JButton("Scores");
		btn_scores.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_scores.setMaximumSize(new Dimension(100, 40));
		btn_scores.setPreferredSize(new Dimension(100, 40));
		
		
		add(newLine(btn_scores));
		add(newLine(Box.createVerticalStrut(50)));
		
		btn_exit = new JButton("Exit");
		btn_exit.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_exit.setMaximumSize(new Dimension(100, 40));
		btn_exit.setPreferredSize(new Dimension(100, 40));
		
		
		add(newLine(btn_exit));
		
		
		
	}
	
	private void addActionListener() {
		btn_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
			}
			
		});
		btn_continue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				continueGame();
				mainBoard.dispose();
			}
			
		});
		btn_scores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seeRanking();
				mainBoard.dispose();
			}
			
		});
		btn_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
				mainBoard.dispose();
			}
			
		});
	}
	
	
	private void startNewGame() {
		this.setEnabled(false);
		this.setVisible(false);
		mainBoard.setContentPane(new ContinueGame());
	}
	private void continueGame() {
		
	}
	private void seeRanking() {
		
	}
	private void exit() {
		System.exit(0);
	}

	private JPanel newLine(Component c) {
		
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
		jp.add(Box.createHorizontalGlue());
		jp.add(c);
		jp.add(Box.createHorizontalGlue());
		jp.setOpaque(false);
		
		return jp;
	}

}

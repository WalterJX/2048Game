package edu.scu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu {
	public Menu() {this.createBoard();}
	
	JFrame mainBoard;
	private void createBoard() {
		mainBoard = new JFrame("2048 Game");
		mainBoard.setSize(500, 600);
		mainBoard.setResizable(false);
		mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainBoard.setLocationRelativeTo(null);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		jPanel.add(newLine(Box.createVerticalStrut(25)));
		
		JLabel label = new JLabel("2048");
		label.setForeground(new java.awt.Color(0x776e65));
		label.setFont(new java.awt.Font("Dialog", 1, 92));
		jPanel.add(newLine(label));
		
		jPanel.add(newLine(Box.createVerticalStrut(50)));
		
		JButton btn_start = new JButton("New Game");
		btn_start.setFont(new java.awt.Font("Font.BOLD", 1, 13));

		btn_start.setMaximumSize(new Dimension(100, 40));
		btn_start.setPreferredSize(new Dimension(100, 40));
		btn_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewGame();
				mainBoard.dispose();
			}
			
		});
		jPanel.add(newLine(btn_start));

		jPanel.add(newLine(Box.createVerticalStrut(50)));
		
		JButton btn_continue = new JButton("Continue");
		btn_continue.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_continue.setMaximumSize(new Dimension(100, 40));
		btn_continue.setPreferredSize(new Dimension(100, 40));
		btn_continue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ContinueGame();
				mainBoard.dispose();
			}
			
		});
		jPanel.add(newLine(btn_continue));
		
		jPanel.add(newLine(Box.createVerticalStrut(50)));
		
		JButton btn_scores = new JButton("Scores");
		btn_scores.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_scores.setMaximumSize(new Dimension(100, 40));
		btn_scores.setPreferredSize(new Dimension(100, 40));
		btn_scores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jPanel.add(newLine(btn_scores));
		jPanel.add(newLine(Box.createVerticalStrut(50)));
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		btn_exit.setMaximumSize(new Dimension(100, 40));
		btn_exit.setPreferredSize(new Dimension(100, 40));
		btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jPanel.add(newLine(btn_exit));
		
		
		
		
		
		
		mainBoard.add(jPanel);
		mainBoard.setVisible(true);
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

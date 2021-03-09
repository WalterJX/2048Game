package edu.scu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import edu.scu.Dao.Score;
import edu.scu.Dao.ScoreDao;

public class CheckRankingPanel extends JPanel{
	private JFrame frame;
	private List<Score> scores;
	private JPanel gridContentPanel;
	private JLabel label;
	private JButton exit;
	private JPanel leftSpace;
	private JPanel rightSpace;
	
	public CheckRankingPanel(JFrame frame) {
		this.frame = frame;
		//scores = new ArrayList<>();
		scores = new ScoreDao().getAllScores();
		init();
	}
	
	
	private void init() {
		setBackground(Color.WHITE);
		
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        exit = new JButton("Menu");
        //exit.setBorder(null);
        exit.setFont(new java.awt.Font("Font.BOLD", 1, 15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        add(exit, gbc);
        
        exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setEnabled(false);
				frame.getContentPane().setVisible(false);
				frame.setContentPane(new StartPanel(frame));
				frame.getContentPane().requestFocus();
			}
			
		});
        
        label = new JLabel("Rank", SwingConstants.CENTER); 
        label.setFont(new java.awt.Font("Font.BOLD", 1, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        gbc.weighty = 0.1;
        add(label, gbc);
        
        JPanel btn1 = new JPanel();
        btn1.setBackground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 0.1;
        add(btn1, gbc);
        
        JPanel btn3 = new JPanel();
        btn3.setBackground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.6;
        add(btn3, gbc);
        
        
        gridContentPanel = new JPanel(new GridLayout(11, 3));
        gridContentPanel.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(
        		gridContentPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setWheelScrollingEnabled(true);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.8;
        gbc.weighty = 0.6;
        add(scrollPane, gbc);
        
        JPanel btn5 = new JPanel();
        btn5.setBackground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.6;
        add(btn5, gbc);

		
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addLabel(gridContentPanel);
		
		
		
	}
	
	
	private void addLabel(JPanel panel) {
		Collections.sort(scores, (a, b) -> (b.getScore() - a.getScore()));
		scores = scores.subList(0, Math.min(10, scores.size()));
		panel.add(getLabel("name"));
		panel.add(getLabel("score"));
		panel.add(getLabel("date"));
		for (Score score : scores) {
			panel.add(getLabel(score.getName()));
			panel.add(getLabel(score.getScore()+""));
			panel.add(getLabel(score.getDate().toString()));
		}
		for (int i = 0; i < 10 - scores.size(); i++) {
			panel.add(getLabel(""));
			panel.add(getLabel(""));
			panel.add(getLabel(""));
		}
			
	}
	
	private JLabel getLabel(String message) {
		JLabel label = new JLabel(message, SwingConstants.CENTER);
		label.setFont(new java.awt.Font("Font.BOLD", 1, 13));
		if (!message.isEmpty())
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setBounds(0,0,100,100);
		return label;
	}
}

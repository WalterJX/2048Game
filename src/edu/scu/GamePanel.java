package edu.scu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private class Color{
		int fontColor;
		int backGroundColor;
		Color(int f, int b){
			fontColor=f;
			backGroundColor=b;
		}
	}
	
	private final int WIN=1;
	private final int LOSE=2;
	private final int PLAYING=0;
	
	int frameWidth=800;//???????????????
	int frameHeight=600;//???????????????????
	int blockBorderWidth=6;
	
	JFrame frame;
	Game game;
	Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
	JPanel gameMapPanel = new JPanel();
	JPanel scoreAndButtonPanel = new JPanel();
	JPanel scorePanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JLabel blocks[][];
	JLabel score;
	
	GamePanel(JFrame frame){
		this.frame=frame;
		game = new Game();
		initGUI();
		refresh();
		
		
	}
	GamePanel(JFrame frame, int[][] map){
		this.frame=frame;
		game = new Game(map);
		initGUI();
		refresh();
	}
	//要不要加上一个对胜利条件的设置？????????????????????????????????
	
	private void initGUI() {
		colorMap.put(0, new Color(0x776e65, 0xCDC1B4));
        colorMap.put(2, new Color(0x776e65, 0xeee4da));
        colorMap.put(4, new Color(0x776e65, 0xede0c8));
        colorMap.put(8, new Color(0xf9f6f2, 0xf2b179));
        colorMap.put(16, new Color(0xf9f6f2, 0xf59563));
        colorMap.put(32, new Color(0xf9f6f2, 0xf67c5f));
        colorMap.put(64, new Color(0xf9f6f2, 0xf65e3b));
        colorMap.put(128, new Color(0xf9f6f2, 0xedcf72));
        colorMap.put(256, new Color(0xf9f6f2, 0xedcc61));
        colorMap.put(512, new Color(0xf9f6f2, 0xe4c02a));
        colorMap.put(1024, new Color(0xf9f6f2, 0xe2ba13));
        colorMap.put(2048, new Color(0xf9f6f2, 0xecc400));
		
		//set layout, add in content. add listener
		this.setBackground(new java.awt.Color(0xCDC1B4)); // background color
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		gameMapPanel.setLayout(new GridLayout(4,4));// 这里怎么搞个尺寸，最好是比例的。
		gameMapPanel.setPreferredSize(new Dimension(frameWidth*2/3,frameHeight));
		blocks = new JLabel[4][4];
		JLabel block;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				blocks[i][j]=new JLabel("0",JLabel.CENTER);
				blocks[i][j].setOpaque(true);//?????????????????????????
				blocks[i][j].setBorder(BorderFactory.createMatteBorder(blockBorderWidth, blockBorderWidth, blockBorderWidth, blockBorderWidth, new java.awt.Color(0xBBADA0)));
				blocks[i][j].setFont(new java.awt.Font("Dialog", 1, 52));
				gameMapPanel.add(blocks[i][j]);
			}
		}
		
		scoreAndButtonPanel.setLayout(new GridLayout(2,1));
		
		scorePanel.setLayout(new GridLayout(2,1));//怎么使得上面的“Score”小，下面的分数大？
		scorePanel.setPreferredSize(new Dimension(frameWidth/3,frameHeight/2));
		JLabel scoreTitle = new JLabel("Score: ", JLabel.CENTER);
		score = new JLabel("0", JLabel.CENTER);
		scoreTitle.setOpaque(true);//这有啥用？？？？？？
		score.setOpaque(true);//????????????
		scoreTitle.setFont(new java.awt.Font("Dialog", 1, 52));//字体大小不一样有用吗？
		score.setFont(new java.awt.Font("Dialog", 1, 52));
		scorePanel.add(scoreTitle);
		scorePanel.add(score);
		
		buttonsPanel.setLayout(new GridLayout(3,3));
		
		JButton up = new JButton(new ImageIcon("image/up.jpg"));
		up.setPreferredSize(new Dimension(-1,frameHeight/6));
		up.setBorderPainted(false);
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movup();
				frame.getContentPane().requestFocus();
			}
		});
		JButton down = new JButton(new ImageIcon("image/down.jpg"));
		down.setPreferredSize(new Dimension(-1,frameHeight/6));
		down.setBorderPainted(false);
		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movdown();
				frame.getContentPane().requestFocus();
			}
		});
		JButton left = new JButton(new ImageIcon("image/left.jpg"));
		left.setPreferredSize(new Dimension(-1,frameHeight/6));
		left.setBorderPainted(false);
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movleft();
				frame.getContentPane().requestFocus();
			}
		});
		JButton right = new JButton(new ImageIcon("image/right.jpg"));
		right.setPreferredSize(new Dimension(-1,frameHeight/6));
		right.setBorderPainted(false);
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movright();
				frame.getContentPane().requestFocus();
			}
		});
		/*
		buttonsPanel.add(up,BorderLayout.NORTH);
		buttonsPanel.add(down, BorderLayout.SOUTH);
		buttonsPanel.add(left, BorderLayout.WEST);
		buttonsPanel.add(right,BorderLayout.EAST);
		*/
		
		for(int i=0;i<9;i++) {
			switch(i) {
				case 1:
					buttonsPanel.add(up);
					break;
				case 3:
					buttonsPanel.add(left);
					break;
				case 5:
					buttonsPanel.add(right);
					break;
				case 7:
					buttonsPanel.add(down);
					break;
				default:
					buttonsPanel.add(new JPanel());
			}
		}
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
	                    movup();
	                    break;
	
	                case KeyEvent.VK_DOWN:
	                    movdown();
	                    break;
	
	                case KeyEvent.VK_LEFT:
	                    movleft();
	                    break;
	
	                case KeyEvent.VK_RIGHT:
	                	movright();
	                    break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		scoreAndButtonPanel.add(scorePanel);
		scoreAndButtonPanel.add(buttonsPanel);
		this.add(gameMapPanel);
		this.add(scoreAndButtonPanel);
		
		//this.setVisible(true);
		//this.setEnabled(true);
		this.setFocusable(true);
	}
	
	private void refresh() {
		//update map and score
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(game.map[i][j]!=0)
					blocks[i][j].setText(""+game.map[i][j]);
				else
					blocks[i][j].setText("");
				blocks[i][j].setBackground(new java.awt.Color(colorMap.get(game.map[i][j]).backGroundColor));
				blocks[i][j].setForeground(new java.awt.Color(colorMap.get(game.map[i][j]).fontColor));
			}
		}
		game.updateScore();
		score.setText(game.score+"");
	}
	
	private int checkResult() {
		//check if the game has ended
		if(game.isGameWin()) 
			return WIN;
		else if(game.isGameLose())
			return LOSE;
		else return PLAYING;
	}
	
	private void movup() {
		game.moveUp();
        refresh();
        int res = checkResult();
        if(res!=PLAYING) {
        	inputNameAndReturn(res);
        }
	}
	private void movdown() {
		game.moveDown();
        refresh();
        int res = checkResult();
        if(res!=PLAYING) {
        	inputNameAndReturn(res);
        }
	}
	private void movleft() {
		game.moveLeft();
        refresh();
        int res = checkResult();
        if(res!=PLAYING) {
        	inputNameAndReturn(res);
        }
	}
	private void movright() {
		game.moveRight();
    	refresh();
    	int res = checkResult();
        if(res!=PLAYING) {
        	inputNameAndReturn(res);
        }
	}
	private void inputNameAndReturn(int res) {
		String playerName="";
		if(res==WIN) {
			playerName = JOptionPane.showInputDialog("You win! Please input your name."); 
		}
		else if(res==LOSE) {
			playerName = JOptionPane.showInputDialog("Game over. Please input your name.");  
		}
		//后续优化，可以在用户选择“取消cancell”时，不记录到数据库中。
		
		//在这里将String playerName，int score 还有系统当前日期。加入到数据库中。
		int score = game.score;
		
		this.setEnabled(false);
		this.setVisible(false);
		frame.setContentPane(new StartPanel(frame));
	}
}

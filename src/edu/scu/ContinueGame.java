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

	public class ContinueGame extends JPanel{
		
		public ContinueGame() {
			initUI();
		}
		
		private void initUI() {
			
			
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(newLine(Box.createVerticalStrut(25)));
			
			JLabel label = new JLabel("2049");
			label.setForeground(new java.awt.Color(0x776e65));
			label.setFont(new java.awt.Font("Dialog", 1, 92));
			add(newLine(label));
			
			
			
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

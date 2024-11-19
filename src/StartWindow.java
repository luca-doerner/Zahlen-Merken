import java.awt.*;

import javax.swing.*;

public class StartWindow extends JPanel {
	private JLabel welcomeLabel;
	private JButton startBtn;
	
	public StartWindow() {
		this.initWindow();
		
	}
	
	private void initWindow() {
		this.setSize(600, 500);
		this.setLayout(new GridLayout(2, 1, 20, 200));
		
		this.welcomeLabel = new JLabel("Willkommen zu unserem Experiment!!!");
		this.welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.welcomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		this.add(welcomeLabel);
		
		this.startBtn = new JButton("Start");
		this.startBtn.setPreferredSize(new Dimension(100, 100));
		this.add(startBtn);

	}
	
	public JButton getStartButton() {
		return this.startBtn;
	}
}

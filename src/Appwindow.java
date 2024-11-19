import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Appwindow extends JFrame {
	StartWindow startWindow;
	GameWindow gameWindow;
	QuestionWindow questionWindow;
	
	public Appwindow() {
		this.setTitle("Zahlen merken");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.initWindow();
	}
	
	private void initWindow() {
		startWindow = new StartWindow();
		this.setSize(startWindow.getSize());
		this.add(startWindow);
		questionWindow = new QuestionWindow(new ArrayList<String>());
		this.setContentPane(startWindow);

		gameWindow = new GameWindow(this);
		
		startWindow.getStartButton().addActionListener((ActionEvent e) -> {
			this.setContentPane(gameWindow);
        });
		
		this.setVisible(true);
	}
}

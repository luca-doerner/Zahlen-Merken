import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class GameWindow extends JPanel{
	JLabel label;
	ArrayList<String> nums;
	Random rand = new Random();
	final Timer timer = new Timer(2000, null);
	ActionListener listener;
	QuestionWindow questionWindow;
	
	public GameWindow(JFrame appwindow) {
		initWindow();
		nums = new ArrayList<String>();

		for(int i = 0; i < 9; i++){
			nums.add((rand.nextInt(99)) + "");
		}
		nums.add("In einer Minute werden dann die Zahlen nochmal abgefragt!");

		listener = new ActionListener() {
			private Iterator<String> it = nums.iterator();
			@Override
			public void actionPerformed(ActionEvent e) {
				if (it.hasNext()) {
					label.setText(it.next());
				}
				else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
					timer.stop();

					questionWindow = new QuestionWindow(nums);
					appwindow.setContentPane(questionWindow);
					questionWindow.startTimer();
                }
			}
		};

		timer.addActionListener(listener);
	}
	
	private void initWindow() {
		this.setSize(600, 500);
		this.setLayout(new GridLayout(1,1));
		
		this.label = new JLabel("<html><body>Sie bekommen nun 9 Zahlen "
				+ "<br>hintereinander angezeigt und müssen "
				+ "<br>sich diese einprägen. Danach warten sie "
				+ "<br>eine Minute und müssen die Zahlen dann in der richtigen "
				+ "<br>Reihenfolge zurückgeben. Viel Erfolg!!!<body><html>"
				+ "<br>klicken Sie auf den Bildschirm um zu starten");
		this.label.setHorizontalAlignment(SwingConstants.CENTER);
		this.label.setVerticalAlignment(SwingConstants.CENTER);
		this.label.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startGame();
            }

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		this.add(label);
	}
	
	public void startGame() {
		timer.start();

		this.label.setText("LOS!");
	}
}

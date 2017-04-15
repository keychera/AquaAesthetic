package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame {
	public MainView() {
		JFrame frame = new JFrame("Play AquaAesthetic");
		int aquariumWidth = 400;
		int aquariumHeight = 400;
		frame.setSize(aquariumWidth,aquariumHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();

		frame.setVisible(true);
	}
}

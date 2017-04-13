package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame {
	public MainView() {
		JFrame frame = new JFrame("Play AquaAesthetic");
		frame.setSize(400,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();

		frame.setVisible(true);
	}

}

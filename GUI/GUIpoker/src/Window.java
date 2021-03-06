import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Just defualt settings for buttons, jframe and static veriable 
 * 
 */
public abstract class Window {
	public static int x = 0;
	public static int y = 0;
	public static String[] numbersPlayers = {"2","3","4","5","6","7","8","9","10"};
	public static String[] numbersBots = {"1"};
	
	public static void windowDefault(JFrame frame) {
	frame.setTitle("Poker Texas");
	frame.setSize(800, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new BorderLayout());	
	frame.setResizable(false);
	}
	public static void buttonDefault(JButton button) {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setForeground(Color.white);
		button.setContentAreaFilled(false);
		button.setFont(new Font("SansSerif", Font.BOLD, 15));
		button.setBorderPainted(true);
	}
	public static void labelSettings(JLabel label, int y) {
		label.setFont(new Font("SansSerif", Font.BOLD, 15));
		label.setForeground(Color.white);
		label.setBounds(10,30+ y,210,30);
		label.setLayout(null);
	}

	public static void checkResolution(GameMenu gm, JFrame frame ) {
		if(gm.getResolution() == 2) {
			frame.setSize(1024,768);
			Window.x = 224;
			Window.y = 168;
		}
		else {
			Window.x = 0;
			Window.y = 0;
		}
	}
}

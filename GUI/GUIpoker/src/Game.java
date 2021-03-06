
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author Tomek
 *
 */
public class Game extends JFrame implements ActionListener {
	/**
	 * Game interface until game
	 */
	private static final long serialVersionUID = 1L;
	private GameMenu menu;
	private ImageIcon img;
	private JLabel background;
	private JButton bBack;
	private JButton bPass, bCheck, bRaise, bBet, bCall, bAll;
	private JPanel panel;

	Game(GameMenu gm) {
		Window.windowDefault(this);
		menu = gm;
		Window.checkResolution(gm, this);
		
		java.net.URL url = GameMenu.class.getResource("/resources/tableB.jpg");
		img =  new ImageIcon(url);
		background = new JLabel(img);
		add(background);
		background.setLayout(null);
		
		bBack = new JButton("Back");
		Window.buttonDefault(bBack);
		bBack.addActionListener(this);
		
		bPass = new JButton("Fold");
		Window.buttonDefault(bPass);
		bPass.setEnabled(false);
		
		bCheck = new JButton("Check");
		Window.buttonDefault(bCheck);
		bCheck.setEnabled(false);
		
		bRaise = new JButton("Raise");
		Window.buttonDefault(bRaise);
		bRaise.setEnabled(false);
		
		bBet = new JButton("Bet");
		Window.buttonDefault(bBet);
		bBet.setEnabled(false);
		
		bCall = new JButton("Call");
		Window.buttonDefault(bCall);
		bCall.setEnabled(false);
		
		bAll = new JButton("All");
		Window.buttonDefault(bAll);
		bAll.setEnabled(false);

		

		panel = new JPanel();
		panel.setBounds(500 + Window.x  , 500 + Window.y, 300, 200);
		panel.setOpaque(false);
		background.add(panel);
		
		panel.add(bBet);
		panel.add(bRaise);
		panel.add(bCall);
		panel.add(bCheck);
		panel.add(bAll);
		panel.add(bPass);
		panel.add(bBack);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == bBack) {
			menu.setVisible(true);
			dispose();
			}
	
	}
}

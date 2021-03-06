
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * 
 * @author Tomek
 *
 */
public class  ButtonsMenu implements ActionListener{
	private JPanel container;
	private JButton bSettings,bStart,bExit;
	private JLabel lTitle;
	private GameMenu menu;


	ButtonsMenu(GameMenu gm) {
		menu = gm;
		container = new JPanel();
		//container.setBorder(BorderFactory.createTitledBorder("Menu"));
		container.setBorder(BorderFactory.createEmptyBorder());
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);
		container.setOpaque(false);

		bStart = new JButton("Join Game");
		Window.buttonDefault(bStart);
		bStart.addActionListener(this);
		
		bSettings = new JButton("New Game");
		Window.buttonDefault(bSettings);
		bSettings.addActionListener(this);
		
		bExit = new JButton("Exit");
		Window.buttonDefault(bExit);
		bExit.addActionListener(this);
		
		java.net.URL url = GameMenu.class.getResource("/resources/title.jpg");
		lTitle = new JLabel(new ImageIcon(url), SwingConstants.CENTER);
		lTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lTitle.setLayout(new FlowLayout());
		container.add(lTitle);
		container.add(Box.createVerticalStrut(50));
		container.add(bStart);
	    container.add(Box.createVerticalStrut(15));
	    container.add(bSettings);
	    container.add(Box.createVerticalStrut(15));
	    container.add(bExit);

	}
	
	JPanel getMenu() {
		return container;
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == bStart) {
			Game game = new Game(menu);
			game.setVisible(true);
			menu.setVisible(false);
		}
		if(source == bSettings) {
			
			GameSettings settings = new GameSettings(menu);
			settings.setVisible(true);
			menu.setVisible(false);
		}
		if(source == bExit){
			menu.dispose();
		}

	}

}

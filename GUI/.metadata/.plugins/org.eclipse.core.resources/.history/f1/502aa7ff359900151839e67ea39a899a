
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * 
 * @author Tomek
 *
 */

public class GameMenu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu mResolution, mInfo;
	private JMenuItem iResolution1, iResolution2, 
	iInfo;
	private JLabel background;
	private ButtonsMenu bm;
	private ImageIcon img;
	private JPanel pButtons;
	private int resolution;

	//boolean first = true;
	
		GameMenu(int res) {
		
		Window.windowDefault(this);
		resolution = 1;
		if(res == 2) {
			setSize(1024,768);
		}
		
		// #Background //
		img =  new ImageIcon("images/bg1024.jpg");
		background = new JLabel(img);
		add(background);
		background.setLayout(new FlowLayout());
		
		add(background);

		// #MenuButtons //
		bm = new ButtonsMenu(this);
		pButtons = bm.getMenu();
		background.add(pButtons);
		
		// #Menubar 
		menu = new JMenuBar();
		
		mResolution = new JMenu("Resolution");
		iResolution1 = new JMenuItem("800 x 600");
		iResolution1.addActionListener(this);
		iResolution2 = new JMenuItem("1024 x 768");
		iResolution2.addActionListener(this);
		
		mResolution.add(iResolution1);
		mResolution.add(iResolution2);
		
		mInfo = new JMenu("Info");
		iInfo = new JMenuItem("About us");
		mInfo.add(iInfo);
		iInfo.addActionListener(this);

		setJMenuBar(menu);
		menu.add(mResolution);
		menu.add(mInfo);

	}

		public int getResolution() {
			return resolution;
		}
	@Override
	public void actionPerformed(ActionEvent aObj) {
		
		Object source = aObj.getSource();
		
		if(source == iResolution1) {
			setSize(800, 600);
			resolution = 1;
		}
		if(source == iResolution2) {
			setSize(1024, 768);
			resolution = 2;
		}
		if(source == iInfo) {
			JOptionPane.showMessageDialog(this, "Tomek product.");
		}
	}
	public static void main(String[] args) {
		GameMenu menu = new GameMenu(1);
		menu.setVisible(true);
	}
}

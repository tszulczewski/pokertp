

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Tomek
 *
 */
public class GameSettings extends JFrame implements ActionListener {

	/**
	 * New game by hoster
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon img;
	JLabel background, lNumberOfPlayers, lNumberOfBots, lMoney;
	JButton bBack, bCreateGame, bMoneyEdit;
	GameMenu menu;
	JPanel panel;
	JComboBox<Object> cNofPlayers,cNofBots;
	JTextField tMoney;
	
	GameSettings(GameMenu gm) {
		Window.windowDefault(this);
		menu = gm;
		Window.checkResolution(gm, this);

		// #Background
		img =  new ImageIcon("images/bg1024.jpg");
		background = new JLabel(img);
		add(background);
		background.setLayout(null);
		
		bBack = new JButton("Back");
		Window.buttonDefault(bBack);
		bBack.setForeground(Color.red);
		bBack.addActionListener(this);
		
		bCreateGame = new JButton("Create Game");
		Window.buttonDefault(bCreateGame);
		bCreateGame.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(0, 500, 300, 200);
		panel.setOpaque(false);
		panel.add(bCreateGame);
		panel.add(bBack);
		background.add(panel);
		
		// #Settings for hosted game
		lNumberOfPlayers = new JLabel("Number of players: ");
		Window.labelSettings(lNumberOfPlayers, 0);
		background.add(lNumberOfPlayers);
		
		cNofPlayers = new JComboBox<Object>(Window.numbersPlayers);
		cNofPlayers.setBounds(220, 35, 110, 20);
		cNofPlayers.addActionListener(this);	
		background.add(cNofPlayers);
		
		lNumberOfBots = new JLabel("How many bots: ");
		Window.labelSettings(lNumberOfBots, 30);
		background.add(lNumberOfBots);
		
		cNofBots = new JComboBox<Object>();
		cNofBots.addItem("1");
		cNofBots.setBounds(220,65,110,20);
		cNofBots.addActionListener(this);
		background.add(cNofBots);
		
		
		lMoney = new JLabel("How much money on start: ");
		Window.labelSettings(lMoney, 60);
		background.add(lMoney);
		
		tMoney = new JTextField();
		tMoney.setText("4000");
		tMoney.setEditable(false);
		tMoney.setBounds(220, 95, 110,20);
		background.add(tMoney);
		
		bMoneyEdit = new JButton("Change");
		Window.buttonDefault(bMoneyEdit);
		bMoneyEdit.setBounds(335, 95, 90, 20);
		bMoneyEdit.addActionListener(this);
		background.add(bMoneyEdit);
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		Object source = a.getSource();
		
		if(source == bBack) {
			menu.setVisible(true);
			dispose();
		}
		if(source == cNofPlayers) {
			int temp = cNofPlayers.getSelectedIndex() + 1;
			cNofBots.removeAllItems();
			for(int i = 0; i < temp; i++) {
				cNofBots.addItem(Integer.toString(i+1));
			}
		}
		if(source == bMoneyEdit) {
			if(!tMoney.isEditable()) {
				tMoney.setEditable(true);
				bMoneyEdit.setText("Confirm");
			}
			else {
				tMoney.setEditable(false);
				bMoneyEdit.setText("Change");
			}
		}
		if(source == bCreateGame) {
			HostingSettings.setNumberOfPlayer(cNofPlayers.getSelectedItem());
			HostingSettings.setNumberOfBots(cNofBots.getSelectedItem());
			HostingSettings.setMoney(tMoney.getText());
		}

	}

}

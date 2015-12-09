

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	JLabel background, lNumberOfPlayers, lNumberOfBots, lMoney, lRaiseStyle, lRaiseLimit;
	JButton bBack, bCreateGame, bMoneyEdit;
	GameMenu menu;
	JPanel panel;
	JComboBox<Object> cNofPlayers,cNofBots,cRaiseStyle;
	JTextField tMoney,tPotLimit, tRaiseLimit, tRaiseValue;
	JRadioButton rRaiseBet, rRaiseBet2;
	ButtonGroup bGroup;
	
	GameSettings(GameMenu gm) {
		Window.windowDefault(this);
		menu = gm;
		Window.checkResolution(gm, this);

		// #Background
		java.net.URL url = GameMenu.class.getResource("/resources/bg1024.jpg");
		img =  new ImageIcon(url);
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
		cNofBots.addItem("0");
		cNofBots.addItem("1");
		cNofBots.setBounds(220,65,110,20);
		cNofBots.addActionListener(this);
		background.add(cNofBots);

		lMoney = new JLabel("How much tokens: ");
		Window.labelSettings(lMoney, 60);
		background.add(lMoney);
		
		tMoney = new JTextField();
		tMoney.setText("4000");
		tMoney.setEditable(false);
		tMoney.setBounds(220, 95, 110,20);
		background.add(tMoney);
		
		bMoneyEdit = new JButton("Change");
		Window.buttonDefault(bMoneyEdit);
		bMoneyEdit.setFont(new Font("SansSerif", Font.BOLD, 12));
		bMoneyEdit.setBounds(335, 95, 90, 20);
		bMoneyEdit.addActionListener(this);
		background.add(bMoneyEdit);
		
		lRaiseStyle = new JLabel("Raise style: ");
		Window.labelSettings(lRaiseStyle, 90);
		background.add(lRaiseStyle);
		
		cRaiseStyle = new JComboBox<Object>();
		cRaiseStyle.addItem("no-limit");
		cRaiseStyle.addItem("pot-limit");
		cRaiseStyle.addItem("fixed-limit");
		cRaiseStyle.setBounds(220, 125, 110, 20);
		cRaiseStyle.addActionListener(this);
		background.add(cRaiseStyle);
		
		lRaiseLimit = new JLabel("Raise limit: ");
		Window.labelSettings(lRaiseLimit, 0);
		lRaiseLimit.setBounds(30, 150, 120, 20);
		lRaiseLimit.setFont(new Font("SansSerif", Font.BOLD, 12));
		lRaiseLimit.setForeground(Color.DARK_GRAY);
		background.add(lRaiseLimit);
		
		tRaiseLimit = new JTextField();
		tRaiseLimit.setBounds(110, 150, 50, 20);
		tRaiseLimit.setEditable(false);
		background.add(tRaiseLimit);
		
		tRaiseValue = new JTextField();
		tRaiseValue.setBounds(30, 180, 35, 20);
		tRaiseValue.setEditable(false);
		background.add(tRaiseValue);
		
		
		rRaiseBet = new JRadioButton();
		rRaiseBet.setBounds(80, 180, 160, 20);
		rRaiseBet.setOpaque(false);
		rRaiseBet.addActionListener(this);
		rRaiseBet.setText("Own raise value");
		rRaiseBet.setFont(new Font("SansSerif", Font.BOLD, 12));
		rRaiseBet.setForeground(Color.DARK_GRAY);
		rRaiseBet.setEnabled(false);
		background.add(rRaiseBet);
		
		rRaiseBet2 = new JRadioButton();
		rRaiseBet2.setBounds(230, 180, 100, 20);
		rRaiseBet2.setOpaque(false);
		rRaiseBet2.setText("Default");
		rRaiseBet2.setEnabled(false);
		rRaiseBet.setFont(new Font("SansSerif", Font.BOLD, 12));
		rRaiseBet2.setForeground(Color.DARK_GRAY);
		rRaiseBet2.addActionListener(this);
		background.add(rRaiseBet2);
		
		bGroup = new ButtonGroup();
		bGroup.add(rRaiseBet);
		bGroup.add(rRaiseBet2);
	/*
	 * 
	 * TODO 
	 * Big blind, small blind
	 */
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		Object source = a.getSource();
		
		if(source == bBack) {
			menu.setVisible(true);
			dispose();
		}
		if(source == cNofPlayers) {
			int temp = cNofPlayers.getSelectedIndex() + 2;
			cNofBots.removeAllItems();
			for(int i = 0; i < temp; i++) {
				cNofBots.addItem(Integer.toString(i));
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
			HostingSettings.setStyle(cRaiseStyle.getSelectedItem());
			if(cRaiseStyle.getSelectedIndex() == 2) {
				HostingSettings.setRaiseLimit(tRaiseLimit.getText());
				HostingSettings.setRaiseValue(tRaiseValue.getText());
			}
		}
		if(source == cRaiseStyle) {
			if(cRaiseStyle.getSelectedIndex() == 2) {
				tRaiseLimit.setEditable(true);
				tRaiseLimit.setText("10");
				lRaiseLimit.setForeground(Color.white);
				rRaiseBet2.setEnabled(true);
				rRaiseBet.setEnabled(true);
				rRaiseBet.setForeground(Color.white);
				rRaiseBet2.setForeground(Color.white);
				rRaiseBet2.setSelected(true);
			}
			else {
				tRaiseLimit.setEditable(false);
				tRaiseLimit.setText("");
				tRaiseValue.setText("");
				lRaiseLimit.setForeground(Color.DARK_GRAY);
				rRaiseBet.setForeground(Color.DARK_GRAY);
				rRaiseBet2.setForeground(Color.DARK_GRAY);
				rRaiseBet2.setEnabled(false);
				rRaiseBet.setEnabled(false);
			}
		}
		if(source == rRaiseBet) {
			tRaiseValue.setEditable(true);
		}
		else
			tRaiseValue.setEditable(false);
			tRaiseValue.setText(null);

	}

}

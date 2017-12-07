package UserPages;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import data.User;
import ebank.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JEditorPane;

public class user_main {
	private JFrame frame;
	private User activeuser;
	private JPanel panel = new JPanel();
	private JPanel panelsetting = new JPanel();
	private JPanel accountpanel = new JPanel();
	private JPanel moneytransferpanel = new JPanel();
	private JPanel userinformation = new JPanel();
	private JEditorPane editorPane=new JEditorPane();
	private JEditorPane editorPane2=new JEditorPane();
	private JEditorPane foreign = new JEditorPane();

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void main(User activeuser) {
		this.activeuser=activeuser;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(260, 80, 900, 600);
		ImageIcon img = new ImageIcon("D:\\javaworks\\ebank\\image\\logo1.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("User Page");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		try {
			URL url = new URL("https://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
		} catch (IOException e) {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Ethernet connection failed!");
			Login x=new Login();
			x.process();
		}
		
		Timer t=new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				try {
					editorPane.setPage("file:///D:/javaworks/ebank/webpages/second2.html");
					editorPane.setPage("file:///D:/javaworks/ebank/webpages/second.html");
					editorPane2.setPage("file:///D:/javaworks/ebank/webpages/first2.html");
					editorPane2.setPage("file:///D:/javaworks/ebank/webpages/first.html");
					foreign.setPage("file:///D:/javaworks/ebank/webpages/third2.html");
					foreign.setPage("file:///D:/javaworks/ebank/webpages/third.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				editorPane.revalidate();
				editorPane2.revalidate();
				foreign.revalidate();
				frame.validate();
				System.out.println("Web Pages Read");
			}
		}, 0, 60000);

		
		user_account account=new user_account(frame,activeuser,panel,accountpanel);
		
		user_moneytransfer moneytransfer=new user_moneytransfer(frame,activeuser,panel,moneytransferpanel);
		
		user_card cardpage=new user_card(frame,activeuser,panel,userinformation);

		user_settings cardsetting2=new user_settings(frame,activeuser,panel,panelsetting);

		user_stockmarket stockmarket=new user_stockmarket(editorPane,editorPane2,foreign,frame);


		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 11;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 128, 128));
		frame.setJMenuBar(menuBar);

		JLabel userinf = new JLabel(this.activeuser.getUsername());
		userinf.setForeground(Color.WHITE);
		menuBar.add(userinf);

		JMenu menu_main = new JMenu("Main Page");
		menu_main.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				foreign.hide();
				userinformation.hide();
				panel.hide();
				panelsetting.hide();
				editorPane.hide();
				editorPane2.hide();
				accountpanel.hide();
				moneytransferpanel.hide();
				frame.validate();
			}
		});
		menu_main.setForeground(Color.WHITE);
		menu_main.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\icon_anasayfa.png"));
		menuBar.add(menu_main);

		JMenu mnAccount = new JMenu("Account");
		mnAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				user_account.refresh(activeuser.getSocialsecuritynumber());
				accountpanel.show();
				foreign.hide();
				userinformation.hide();
				panel.hide();
				panelsetting.hide();
				editorPane.hide();
				editorPane2.hide();
				moneytransferpanel.hide();
				frame.validate();
			}
		});
		mnAccount.setForeground(Color.WHITE);
		mnAccount.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\icon_hesaplarim.png"));
		menuBar.add(mnAccount);

		JMenu menu_moneytransfer = new JMenu("Money Transfer");
		menu_moneytransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				user_moneytransfer.refresh();
				accountpanel.hide();
				foreign.hide();
				userinformation.hide();
				panel.hide();
				panelsetting.hide();
				editorPane.hide();
				editorPane2.hide();
				moneytransferpanel.show();
				frame.validate();
			}
		});
		menu_moneytransfer.setForeground(Color.WHITE);
		menu_moneytransfer.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\icon_paraaktarma.png"));
		menuBar.add(menu_moneytransfer);

		userinformation.hide();
		panel.hide();
		panelsetting.hide();
		editorPane.hide();
		editorPane2.hide();
		foreign.hide();
		accountpanel.hide();
		moneytransferpanel.hide();

		JMenu menu_cards = new JMenu("Card");
		menu_cards.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				foreign.hide();
				userinformation.show();
				panel.show();
				panelsetting.hide();
				editorPane.hide();
				accountpanel.hide();
				editorPane2.hide();
				moneytransferpanel.hide();
				frame.validate();
			}
		});
		menu_cards.setForeground(Color.WHITE);
		menu_cards.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\icon_kartlarim.png"));
		menuBar.add(menu_cards);

		JMenu menu_foreign = new JMenu("Foreign Currency");
		menu_foreign.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				foreign.show();
				userinformation.hide();
				panel.hide();
				accountpanel.hide();
				panelsetting.hide();
				editorPane.show();
				editorPane2.show();
				moneytransferpanel.hide();
				frame.validate();
			}
		});
		menu_foreign.setForeground(Color.WHITE);
		menu_foreign.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\icon_doviz.png"));
		menuBar.add(menu_foreign);

		JMenu menu_settings = new JMenu("Settings");
		menu_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				user_settings.refresh();
				userinformation.hide();
				panel.hide();
				accountpanel.hide();
				panelsetting.show();
				editorPane.hide();
				editorPane2.hide();
				foreign.hide();
				moneytransferpanel.hide();
				frame.validate();
			}
		});
		menu_settings.setForeground(Color.WHITE);
		menu_settings.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\icon_ayarlar.png"));
		menuBar.add(menu_settings);

		JMenu mnNewMenu = new JMenu("Logout");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Login x=new Login();
					x.process();
					frame.dispose();
				}
			}
		});
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\logouticon.png"));
		menuBar.add(mnNewMenu);
	}
}

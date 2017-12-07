package ebank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UserPages.user_main;
import database.DBConnect;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame LoginFrame;
	private JTextField usernametext;
	private JPasswordField passwordField;
	private Panel panel;
	private Panel userpanel;
	private Panel passwordpanel;
	private Panel loginpanel;
	private JButton loginbutton;
	private JLabel label;
	private Panel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * @wbp.nonvisual location=71,19
	 */

	/**
	 * Launch the application.
	 */
	public void process() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.LoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoginFrame = new JFrame();
		LoginFrame.getContentPane().setBackground(new Color(0, 102, 102));
		LoginFrame.setBackground(Color.WHITE);
		LoginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		LoginFrame.setBounds(300, 100, 800, 600);
		LoginFrame.setTitle("Login Page");
		ImageIcon img = new ImageIcon("D:\\javaworks\\ebank\\image\\logo1.png");
		LoginFrame.setIconImage(img.getImage());
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 72, 0, 82, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		LoginFrame.getContentPane().setLayout(gridBagLayout);

		panel = new Panel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 0;
		LoginFrame.getContentPane().add(panel, gbc_panel);

		panel_1 = new Panel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 6;
		gbc_panel_1.gridy = 1;
		LoginFrame.getContentPane().add(panel_1, gbc_panel_1);


		lblNewLabel_3 = new JLabel("                            ");
		panel_1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\logo1.png"));
		panel_1.add(lblNewLabel_4);

		usernametext = new JTextField();
		usernametext.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernametext.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\userlogo.png"));


		userpanel = new Panel();
		userpanel.add(lblNewLabel_1);
		userpanel.add(usernametext);
		GridBagConstraints gbc_userpanel = new GridBagConstraints();
		gbc_userpanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_userpanel.insets = new Insets(0, 0, 5, 5);
		gbc_userpanel.gridx = 6;
		gbc_userpanel.gridy = 2;
		LoginFrame.getContentPane().add(userpanel, gbc_userpanel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\password.png"));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.setColumns(20);

		passwordpanel = new Panel();
		GridBagConstraints gbc_passwordpanel = new GridBagConstraints();
		gbc_passwordpanel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordpanel.gridx = 6;
		gbc_passwordpanel.gridy = 3;
		passwordpanel.add(lblNewLabel_2);
		passwordpanel.add(passwordField);
		LoginFrame.getContentPane().add(passwordpanel, gbc_passwordpanel);

		loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				DBConnect x=new DBConnect();
				if(x.getData(usernametext.getText(), passwordField.getText()) && usernametext.getText().compareTo("admin")==0){
					LoginFrame.dispose();
					AdminPanel.main();
				}
				else if(x.getData(usernametext.getText(), passwordField.getText()) && usernametext.getText().compareTo("admin")!=0){
					LoginFrame.dispose();
					user_main mainuser=new user_main();
					mainuser.main(x.finduserusername(usernametext.getText()));
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
				}
			}
		});

		loginpanel = new Panel();

		label = new JLabel("                         ");
		loginpanel.add(label);
		loginpanel.add(loginbutton);
		GridBagConstraints gbc_loginpanel = new GridBagConstraints();
		gbc_loginpanel.insets = new Insets(0, 0, 5, 5);
		gbc_loginpanel.gridx = 6;
		gbc_loginpanel.gridy = 4;
		LoginFrame.getContentPane().add(loginpanel, gbc_loginpanel);

	}

}

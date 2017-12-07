package ebank;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import data.Wants;
import database.DBConnect;

public class AdminPanel {

	private JFrame frame;
	private JMenu mnMainPage;
	private JMenu mnNewMenu;
	private JPanel panel1;
	private JLabel lbl_username;
	private JTextField username;
	private JPanel panel2;
	private JLabel lbl_password;
	private JTextField password;
	private JPanel panel3;
	private JLabel lbl_name;
	private JTextField name;
	private JPanel panel4;
	private JLabel lbl_surname;
	private JTextField surname;
	private JPanel panel5;
	private JLabel lbl_ssn;
	private JTextField ssn;
	private JPanel panel6;
	private JLabel lbl_telephone;
	private JTextField telephone;
	private JPanel panel7;
	private JLabel lbl_birth;
	private JTextField birthdate;
	private JPanel panel8;
	private JLabel lbl_mail;
	private JTextField mail;
	private JPanel panel9;
	private JLabel lblAdress;
	private TextArea adress;
	private JPanel panel11;
	private JLabel lblCreateUser;
	private JPanel panel10;
	private JButton button_create;
	private JLabel label;
	private JMenu mnShowUsers;
	private JTable userinf;
	private DefaultTableModel model,model2;
	private JButton btnNewButton;
	private JMenu mnNewMenu_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param loginFrame 
	 */
	public AdminPanel() {
		initialize();
	}


	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				ArrayList<data.User> userinfo=new ArrayList<data.User>();
				database.DBConnect x=new database.DBConnect();
				userinfo=x.getUserinformation();

				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				model.addRow(new Object[]{"Username","Membership Date","Social Security Number"});


				for(int i=1;i<userinfo.size()+1;i++){
					model.addRow(new Object[]{userinfo.get(i-1).getUsername(),userinfo.get(i-1).getMembershipdate(),userinfo.get(i-1).getSocialsecuritynumber()});
				}
				
				ArrayList<Wants> wantlist=new ArrayList<Wants>();
				wantlist=x.findwants();

				for (int i = model2.getRowCount() - 1; i >= 0; i--) {
					model2.removeRow(i);
				}
				
				model2.addRow(new Object[]{"Id","Who","Wants"});


				for(int i=1;i<wantlist.size()+1;i++){
					model2.addRow(new Object[]{wantlist.get(i-1).getId(),wantlist.get(i-1).getWhoid(),wantlist.get(i-1).getWant()});
				}
				
				frame.validate();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(new Color(255, 255, 255));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(300, 100, 850, 650);
		ImageIcon img = new ImageIcon("D:\\javaworks\\ebank\\image\\logo1.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("Admin Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(0, 128, 128));
		frame.setJMenuBar(menuBar);

		mnMainPage = new JMenu("Main Page");
		mnMainPage.setForeground(Color.WHITE);
		mnMainPage.setBackground(Color.WHITE);
		mnMainPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				for (int i = model2.getRowCount() - 1; i >= 0; i--) {
					model2.removeRow(i);
				}
				
				DBConnect x=new DBConnect();
				ArrayList<data.Wants> wantlist=new ArrayList<data.Wants>();
				wantlist=x.findwants();
				
				model2.addRow(new Object[]{"Id","Who","Wants"});
				
				for(int i=1;i<wantlist.size()+1;i++){
					model2.addRow(new Object[]{wantlist.get(i-1).getId(),wantlist.get(i-1).getWhoid(),wantlist.get(i-1).getWant()});
				}
				
				panel1.hide();
				panel2.hide();
				panel3.hide();
				panel4.hide();
				panel5.hide();
				panel6.hide();
				panel7.hide();
				panel8.hide();
				panel9.hide();
				panel10.hide();
				panel11.hide();
				userinf.hide();
				table.show();
				frame.validate();
			}
		});
		mnMainPage.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\homepagelogo.png"));
		menuBar.add(mnMainPage);

		mnNewMenu = new JMenu("Add New User");
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\adduserlogo.png"));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel1.show();
				panel2.show();
				panel3.show();
				panel4.show();
				panel5.show();
				panel6.show();
				panel7.show();
				panel8.show();
				panel9.show();
				panel10.show();
				panel11.show();
				userinf.hide();
				table.hide();
				frame.validate();
			}
		});
		menuBar.add(mnNewMenu);



		model = new DefaultTableModel();
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Social Security Number");
		
		model2 = new DefaultTableModel();
		model2.addColumn("Id");
		model2.addColumn("Who");
		model2.addColumn("Wants");


		ArrayList<data.User> userinfo=new ArrayList<data.User>();
		database.DBConnect x=new database.DBConnect();
		userinfo=x.getUserinformation();
		
		
		for(int i=1;i<userinfo.size()+1;i++){
			model.addRow(new Object[]{userinfo.get(i-1).getUsername(),userinfo.get(i-1).getMembershipdate(),userinfo.get(i-1).getSocialsecuritynumber()});
		}
		
		ArrayList<data.Wants> wantlist=new ArrayList<data.Wants>();
		wantlist=x.findwants();

		
		for(int i=1;i<wantlist.size()+1;i++){
			model2.addRow(new Object[]{wantlist.get(i-1).getId(),wantlist.get(i-1).getWhoid(),wantlist.get(i-1).getWant()});
		}


		mnShowUsers = new JMenu("User Settings");
		mnShowUsers.setForeground(Color.WHITE);
		mnShowUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ArrayList<data.User> userinfo=new ArrayList<data.User>();
				database.DBConnect x=new database.DBConnect();
				userinfo=x.getUserinformation();

				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				model.addRow(new Object[]{"Username","Membership Date","Social Security Number"});


				for(int i=1;i<userinfo.size()+1;i++){
					model.addRow(new Object[]{userinfo.get(i-1).getUsername(),userinfo.get(i-1).getMembershipdate(),userinfo.get(i-1).getSocialsecuritynumber()});
				}
				
				userinf.show();
				panel1.hide();
				panel2.hide();
				panel3.hide();
				panel4.hide();
				panel5.hide();
				panel6.hide();
				panel7.hide();
				panel8.hide();
				panel9.hide();
				panel10.hide();
				panel11.hide();
				table.hide();
				frame.validate();
			}
		});


		mnShowUsers.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\usermenulogo.png"));
		mnShowUsers.setBackground(Color.WHITE);
		menuBar.add(mnShowUsers);
		
		mnNewMenu_1 = new JMenu("Logout");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Login x=new Login();
					x.process();
					frame.dispose();
				}
			}
		});
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\logouticon2.png"));
		menuBar.add(mnNewMenu_1);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		panel11 = new JPanel();
		panel11.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel11 = new GridBagConstraints();
		gbc_panel11.anchor = GridBagConstraints.NORTH;
		gbc_panel11.insets = new Insets(0, 0, 5, 0);
		gbc_panel11.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel11.gridx = 0;
		gbc_panel11.gridy = 0;
		frame.getContentPane().add(panel11, gbc_panel11);


		lblCreateUser = new JLabel("Create User");
		lblCreateUser.setForeground(new Color(0, 128, 128));
		lblCreateUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCreateUser.setIcon(null);
		panel11.add(lblCreateUser);
		
		btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
				name.setText("");
				surname.setText("");
				ssn.setText("");
				telephone.setText("");
				birthdate.setText("Year-Month-Day");
				mail.setText("");
				adress.setText(" ");
			}
		});
		panel11.add(btnNewButton);

		panel1 = new JPanel();
		panel1.setBorder(null);
		panel1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.insets = new Insets(0, 0, 5, 0);
		gbc_panel1.anchor = GridBagConstraints.NORTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 1;
		frame.getContentPane().add(panel1, gbc_panel1);

		lbl_username = new JLabel("Username:                             ");
		lbl_username.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_username.setForeground(new Color(0, 128, 128));
		panel1.add(lbl_username);

		username = new JTextField();
		username.setForeground(new Color(0, 0, 0));
		panel1.add(username);
		username.setColumns(20);

		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.anchor = GridBagConstraints.NORTH;
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 2;
		frame.getContentPane().add(panel2, gbc_panel2);

		lbl_password = new JLabel("Password:                             ");
		lbl_password.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_password.setForeground(new Color(0, 128, 128));
		panel2.add(lbl_password);

		password = new JTextField();
		password.setForeground(new Color(0, 0, 0));
		panel2.add(password);
		password.setColumns(20);

		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel3 = new GridBagConstraints();
		gbc_panel3.insets = new Insets(0, 0, 5, 0);
		gbc_panel3.anchor = GridBagConstraints.NORTH;
		gbc_panel3.gridx = 0;
		gbc_panel3.gridy = 3;
		frame.getContentPane().add(panel3, gbc_panel3);

		lbl_name = new JLabel("Name:                                     ");
		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_name.setForeground(new Color(0, 128, 128));
		panel3.add(lbl_name);

		name = new JTextField();
		name.setForeground(new Color(0, 0, 0));
		name.setColumns(20);
		panel3.add(name);

		panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel4 = new GridBagConstraints();
		gbc_panel4.insets = new Insets(0, 0, 5, 0);
		gbc_panel4.anchor = GridBagConstraints.NORTH;
		gbc_panel4.gridx = 0;
		gbc_panel4.gridy = 4;
		frame.getContentPane().add(panel4, gbc_panel4);

		lbl_surname = new JLabel("Surname:                               ");
		lbl_surname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_surname.setForeground(new Color(0, 128, 128));
		panel4.add(lbl_surname);

		surname = new JTextField();
		surname.setForeground(new Color(0, 0, 0));
		surname.setColumns(20);
		panel4.add(surname);

		panel5 = new JPanel();
		panel5.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel5 = new GridBagConstraints();
		gbc_panel5.insets = new Insets(0, 0, 5, 0);
		gbc_panel5.anchor = GridBagConstraints.NORTH;
		gbc_panel5.gridx = 0;
		gbc_panel5.gridy = 5;
		frame.getContentPane().add(panel5, gbc_panel5);

		lbl_ssn = new JLabel("Social Security Number:    ");
		lbl_ssn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_ssn.setForeground(new Color(0, 128, 128));
		panel5.add(lbl_ssn);

		ssn = new JTextField();
		ssn.setForeground(new Color(0, 0, 0));
		ssn.setColumns(20);
		panel5.add(ssn);

		panel6 = new JPanel();
		panel6.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel6 = new GridBagConstraints();
		gbc_panel6.insets = new Insets(0, 0, 5, 0);
		gbc_panel6.anchor = GridBagConstraints.NORTH;
		gbc_panel6.gridx = 0;
		gbc_panel6.gridy = 6;
		frame.getContentPane().add(panel6, gbc_panel6);

		lbl_telephone = new JLabel("Telephone Number:             ");
		lbl_telephone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_telephone.setForeground(new Color(0, 128, 128));
		panel6.add(lbl_telephone);

		telephone = new JTextField();
		telephone.setForeground(new Color(0, 0, 0));
		telephone.setColumns(20);
		panel6.add(telephone);

		panel7 = new JPanel();
		panel7.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel7 = new GridBagConstraints();
		gbc_panel7.insets = new Insets(0, 0, 5, 0);
		gbc_panel7.anchor = GridBagConstraints.NORTH;
		gbc_panel7.gridx = 0;
		gbc_panel7.gridy = 7;
		frame.getContentPane().add(panel7, gbc_panel7);

		lbl_birth = new JLabel("Birth Date:                             ");
		lbl_birth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_birth.setForeground(new Color(0, 128, 128));
		panel7.add(lbl_birth);

		birthdate = new JTextField("Year-Month-Day");
		birthdate.setForeground(new Color(0, 0, 0));
		birthdate.setColumns(20);
		panel7.add(birthdate);
		
		panel8 = new JPanel();
		panel8.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel8 = new GridBagConstraints();
		gbc_panel8.insets = new Insets(0, 0, 5, 0);
		gbc_panel8.anchor = GridBagConstraints.NORTH;
		gbc_panel8.gridx = 0;
		gbc_panel8.gridy = 9;
		frame.getContentPane().add(panel8, gbc_panel8);

		lbl_mail = new JLabel("Mail:                                        ");
		lbl_mail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_mail.setForeground(new Color(0, 128, 128));
		panel8.add(lbl_mail);

		mail = new JTextField();
		mail.setForeground(new Color(0, 0, 0));
		mail.setColumns(20);
		panel8.add(mail);

		panel9 = new JPanel();
		panel9.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel9 = new GridBagConstraints();
		gbc_panel9.insets = new Insets(0, 0, 5, 0);
		gbc_panel9.anchor = GridBagConstraints.NORTH;
		gbc_panel9.gridx = 0;
		gbc_panel9.gridy = 10;
		frame.getContentPane().add(panel9, gbc_panel9);

		lblAdress = new JLabel("  Adress:                                   ");
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdress.setForeground(new Color(0, 128, 128));
		panel9.add(lblAdress);

		adress = new TextArea();
		adress.setForeground(new Color(0, 0, 0));
		adress.setColumns(30);
		adress.setRows(4);
		panel9.add(adress);

		panel10 = new JPanel();
		panel10.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel10 = new GridBagConstraints();
		gbc_panel10.insets = new Insets(0, 0, 5, 0);
		gbc_panel10.fill = GridBagConstraints.VERTICAL;
		gbc_panel10.gridx = 0;
		gbc_panel10.gridy = 11;
		frame.getContentPane().add(panel10, gbc_panel10);

		label = new JLabel("                    ");
		panel10.add(label);

		button_create = new JButton("Create");
		button_create.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					Date date = new Date();
					database.DBConnect dbcon=new database.DBConnect();
					data.User newuser=new data.User();
					newuser.setUsername(username.getText());
					newuser.setPassword(password.getText());
					newuser.setName(name.getText());
					newuser.setSurname(surname.getText());
					newuser.setSocialsecuritynumber(ssn.getText());
					newuser.setTelephonenumber(telephone.getText());

					SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

					newuser.setBirthdate(birthdate.getText());
					

					newuser.setMail(mail.getText());
					newuser.setAdress(adress.getText());
					newuser.setMembershipdate(dateformat.format(date));
					if(ssn.getText().compareTo("")!=0 && ssn.getText().length()==11){
						try{
							Double.parseDouble(ssn.getText());
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure add user?", "Add User", dialogButton);
							
							if(dialogResult == 0) {
								dbcon.insertData(newuser);
								username.setText("");
								password.setText("");
								name.setText("");
								surname.setText("");
								ssn.setText("");
								telephone.setText("");
								birthdate.setText("");
								mail.setText("");
								adress.setText(" ");
								JOptionPane.showMessageDialog(null, "User add successfully!");
							}
							
						}
						catch(Exception inte){
							JOptionPane.showMessageDialog(null, "Social security number format is wrong!");
						}
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Social security number format is wrong!");
					}
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Birth Date Format is wrong!");
				}
				
				frame.validate();
			}
		});
		button_create.setIcon(new ImageIcon("D:\\javaworks\\ebank\\image\\adduserlogo.png"));
		panel10.add(button_create);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		table = new JTable(model2);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.getColumnModel().getColumn(0).setPreferredWidth(width/40);
		table.getColumnModel().getColumn(1).setPreferredWidth(width/20);
		table.getColumnModel().getColumn(2).setPreferredWidth((width*17)/20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setDefaultEditor(Object.class, null);
		table.show();
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getClickCount() == 2 & table.rowAtPoint(evt.getPoint())!=0) {
					database.DBConnect dbcon=new database.DBConnect();
					int row = table.rowAtPoint(evt.getPoint());
					int col = table.columnAtPoint(evt.getPoint());
					if (row >= 0 && col >= 0) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to approve this request?", "Approve Dialog", dialogButton);
						if(dialogResult == 0) {
							dbcon.execute(table.getValueAt(row, 2).toString());
							dbcon.removewant(table.getValueAt(row, 1).toString(),table.getValueAt(row, 0).toString());
						}
					}
				}
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		frame.getContentPane().add(table, gbc_table);

		userinf = new JTable(model);
		userinf.setBorder(new LineBorder(new Color(0, 0, 0)));
		userinf.getColumnModel().getColumn(0).setPreferredWidth(width/6);
		userinf.getColumnModel().getColumn(1).setPreferredWidth(width/9);
		userinf.getColumnModel().getColumn(2).setPreferredWidth(width/9);
		userinf.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);


		GridBagConstraints userinfpanel = new GridBagConstraints();
		userinfpanel.insets = new Insets(0, 0, 5, 0);
		userinfpanel.anchor = GridBagConstraints.NORTHWEST;
		userinfpanel.gridx = 0;
		userinfpanel.gridy = 0;
		frame.getContentPane().add(userinf, userinfpanel);
		userinf.hide();
		userinf.setDefaultEditor(Object.class, null);
		userinf.setFont(new Font("Arial", Font.PLAIN, 14));
		userinf.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getClickCount() == 2 & userinf.rowAtPoint(evt.getPoint())!=0) {
					database.DBConnect dbcon=new database.DBConnect();
					int row = userinf.rowAtPoint(evt.getPoint());
					int col = userinf.columnAtPoint(evt.getPoint());
					if (row >= 0 && col >= 0) {
						UserInformation.main(dbcon.finduser(userinf.getValueAt(row, 2).toString()),frame);
					}
				}
			}
		});



		panel1.hide();
		panel2.hide();
		panel3.hide();
		panel4.hide();
		panel5.hide();
		panel6.hide();
		panel7.hide();
		panel8.hide();
		panel9.hide();
		panel10.hide();
		panel11.hide();
	}
}
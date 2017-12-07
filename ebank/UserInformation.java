package ebank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import database.DBConnect;

import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class UserInformation {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private JTextField membershipdate;
	private JTextField ssn;
	private JTextField name;
	private JTextField surname;
	private JTextField mail;
	private JTextField telephone;
	private JTextField birthdate;
	private TextArea adress;
	private static data.User user;

	/**
	 * Launch the application.
	 */
	public static void main(data.User fuser,JFrame adminframe) {
		user=fuser;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInformation window = new UserInformation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {

			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(500, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		ImageIcon img = new ImageIcon("D:\\javaworks\\ebank\\image\\logo1.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("User Informarion");
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 74, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 128, 128));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 40, 72, 20);
		frame.getContentPane().add(lblPassword);

		JLabel lblMembershipDate = new JLabel("Membership Date:");
		lblMembershipDate.setForeground(new Color(0, 128, 128));
		lblMembershipDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMembershipDate.setBounds(10, 70, 125, 20);
		frame.getContentPane().add(lblMembershipDate);

		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number:");
		lblSocialSecurityNumber.setForeground(new Color(0, 128, 128));
		lblSocialSecurityNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocialSecurityNumber.setBounds(10, 100, 164, 20);
		frame.getContentPane().add(lblSocialSecurityNumber);

		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 128, 128));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 130, 74, 20);
		frame.getContentPane().add(lblName);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setForeground(new Color(0, 128, 128));
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSurname.setBounds(10, 160, 74, 20);
		frame.getContentPane().add(lblSurname);

		JLabel lblMail = new JLabel("Mail:");
		lblMail.setForeground(new Color(0, 128, 128));
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMail.setBounds(10, 190, 74, 20);
		frame.getContentPane().add(lblMail);

		JLabel lblTelephoneNumber = new JLabel("Telephone Number:");
		lblTelephoneNumber.setForeground(new Color(0, 128, 128));
		lblTelephoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelephoneNumber.setBounds(10, 220, 137, 20);
		frame.getContentPane().add(lblTelephoneNumber);

		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setForeground(new Color(0, 128, 128));
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthDate.setBounds(10, 250, 75, 20);
		frame.getContentPane().add(lblBirthDate);

		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setForeground(new Color(0, 128, 128));
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdress.setBounds(10, 280, 52, 20);
		frame.getContentPane().add(lblAdress);

		username = new JTextField();
		username.setBounds(184, 12, 180, 20);
		frame.getContentPane().add(username);
		username.setText(user.getUsername());
		username.setColumns(10);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(184, 42, 180, 20);
		password.setText(user.getPassword());
		frame.getContentPane().add(password);

		membershipdate = new JTextField();
		membershipdate.setEditable(false);
		membershipdate.setColumns(10);
		membershipdate.setBounds(184, 72, 180, 20);
		membershipdate.setText(user.getMembershipdate());
		frame.getContentPane().add(membershipdate);

		ssn = new JTextField();
		ssn.setEditable(false);
		ssn.setColumns(10);
		ssn.setBounds(184, 102, 180, 20);
		ssn.setText(user.getSocialsecuritynumber());
		frame.getContentPane().add(ssn);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(184, 132, 180, 20);
		name.setText(user.getName());
		frame.getContentPane().add(name);

		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(184, 162, 180, 20);
		surname.setText(user.getSurname());
		frame.getContentPane().add(surname);

		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(184, 192, 180, 20);
		mail.setText(user.getMail());
		frame.getContentPane().add(mail);

		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(184, 222, 180, 20);
		telephone.setText(user.getTelephonenumber());
		frame.getContentPane().add(telephone);

		birthdate = new JTextField();
		birthdate.setColumns(10);
		birthdate.setBounds(184, 252, 180, 20);
		birthdate.setText(user.getBirthdate());
		frame.getContentPane().add(birthdate);

		adress = new TextArea();
		adress.setBounds(184, 280, 200, 100);
		adress.setText(user.getAdress());
		frame.getContentPane().add(adress);

		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the user information?", "Update User", dialogButton);

				if(dialogResult == 0) {
					DBConnect dbcon=new DBConnect();
					dbcon.updateUser("username", username.getText(), ssn.getText());
					dbcon.updateUser("password", password.getText(), ssn.getText());
					dbcon.updateUser("name", name.getText(), ssn.getText());
					dbcon.updateUser("surname", surname.getText(), ssn.getText());
					dbcon.updateUser("telephonenumber", telephone.getText(), ssn.getText());
					dbcon.updateUser("mail", mail.getText(), ssn.getText());
					dbcon.updateUser("adress", adress.getText(), ssn.getText());
					dbcon.updateUser("membershipdate", membershipdate.getText(), ssn.getText());
					dbcon.updateUser("birthdate", birthdate.getText(), ssn.getText());
					JOptionPane.showMessageDialog(null, "User information changed.");
					frame.validate();
				}
			}
		});
		update.setBounds(60, 414, 110, 23);
		frame.getContentPane().add(update);

		JButton remove = new JButton("Remove User");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure delete user?", "Remove User", dialogButton);

				if(dialogResult == 0) {
					DBConnect dbcon=new DBConnect();
					dbcon.removeUser(user.getSocialsecuritynumber());
					JOptionPane.showMessageDialog(null, "User successfully removed.");
					frame.dispose();
				}
			}
		});
		remove.setBounds(240, 414, 110, 23);
		frame.getContentPane().add(remove);
	}
}

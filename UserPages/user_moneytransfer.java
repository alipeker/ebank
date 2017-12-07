package UserPages;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.User;
import database.DBConnect;

public class user_moneytransfer {
	static JTextField namedb,accountid,amount;

	public user_moneytransfer(JFrame frame,final User activeuser,JPanel panel,JPanel userinformation){
		userinformation.setBackground(Color.WHITE);
		GridBagConstraints gbc_userinformation = new GridBagConstraints();
		gbc_userinformation.weightx = 1.0;
		gbc_userinformation.anchor = GridBagConstraints.NORTH;
		gbc_userinformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_userinformation.insets = new Insets(0, 0, 5, 5);
		gbc_userinformation.gridx = 10;
		gbc_userinformation.gridy = 1;
		frame.getContentPane().add(userinformation, gbc_userinformation);
		GridBagLayout gbl_userinformation = new GridBagLayout();
		gbl_userinformation.columnWidths = new int[]{56, 0};
		gbl_userinformation.rowHeights = new int[]{17, 17, 17, 0, 0, 0, 0, 0};
		gbl_userinformation.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_userinformation.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		userinformation.setLayout(gbl_userinformation);

		JLabel name = new JLabel("Account Owner Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.NORTHWEST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 0;
		userinformation.add(name, gbc_name);
		name.setForeground(new Color(0, 128, 128));

		namedb = new JTextField("");
		namedb.setColumns(12);
		namedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_namedb = new GridBagConstraints();
		gbc_namedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_namedb.insets = new Insets(0, 0, 5, 0);
		gbc_namedb.gridx = 1;
		gbc_namedb.gridy = 0;
		userinformation.add(namedb, gbc_namedb);

		JButton update = new JButton("Money Transfer Confirmation");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DBConnect dbcon=new DBConnect();

				if((dbcon.findAccount(activeuser.getSocialsecuritynumber()).getAccountid()+"").compareTo(accountid.getText())!=0 && activeuser.getUsername().compareTo(namedb.getText())!=0){
					boolean result=dbcon.moneytransfer(namedb.getText(),accountid.getText(),Double.parseDouble(amount.getText()),activeuser.getSocialsecuritynumber()+"",dbcon.findAccount(activeuser.getSocialsecuritynumber()).getTotalmoney());
					if(result){
						refresh();
						JOptionPane.showMessageDialog(null, "Money Transfer Successful!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Account information is wrong!");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "This account is already yours!");
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_update = new GridBagConstraints();
		gbc_update.insets = new Insets(0, 0, 5, 0);
		gbc_update.anchor = GridBagConstraints.NORTHWEST;
		gbc_update.gridx = 3;
		gbc_update.gridy = 0;
		userinformation.add(update, gbc_update);

		JLabel space = new JLabel("      ");
		space.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_space = new GridBagConstraints();
		gbc_space.insets = new Insets(0, 0, 5, 0);
		gbc_space.anchor = GridBagConstraints.NORTHWEST;
		gbc_space.gridx = 2;
		gbc_space.gridy = 0;
		userinformation.add(space, gbc_space);

		JLabel surname = new JLabel("Account Id:");
		surname.setForeground(new Color(0, 128, 128));
		surname.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 5);
		gbc_surname.anchor = GridBagConstraints.NORTHWEST;
		gbc_surname.gridx = 0;
		gbc_surname.gridy = 1;
		userinformation.add(surname, gbc_surname);

		accountid = new JTextField("");
		accountid.setColumns(12);
		accountid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		accountid.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_accountid = new GridBagConstraints();
		gbc_accountid.anchor = GridBagConstraints.NORTHWEST;
		gbc_accountid.insets = new Insets(0, 0, 5, 0);
		gbc_accountid.gridx = 1;
		gbc_accountid.gridy = 1;
		userinformation.add(accountid, gbc_accountid);

		JLabel mail = new JLabel("Amount:");
		mail.setFont(new Font("Tahoma", Font.BOLD, 16));
		mail.setForeground(new Color(0, 128, 128));
		GridBagConstraints gbc_mail = new GridBagConstraints();
		gbc_mail.anchor = GridBagConstraints.NORTHWEST;
		gbc_mail.insets = new Insets(0, 0, 5, 5);
		gbc_mail.gridx = 0;
		gbc_mail.gridy = 2;
		userinformation.add(mail, gbc_mail);

		amount = new JTextField("");
		amount.setColumns(12);
		amount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_amount = new GridBagConstraints();
		gbc_amount.insets = new Insets(0, 0, 5, 0);
		gbc_amount.anchor = GridBagConstraints.NORTHWEST;
		gbc_amount.gridx = 1;
		gbc_amount.gridy = 2;
		userinformation.add(amount, gbc_amount);
	}

	public static void refresh(){
		namedb.setText("");
		accountid.setText("");
		amount.setText("");
	}
}

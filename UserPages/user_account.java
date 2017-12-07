package UserPages;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Account;
import data.User;
import database.DBConnect;

public class user_account {
	static JTextField debtdb;
	static Account account;

	public user_account(JFrame frame,User activeuser,JPanel panel,JPanel accountinformation){
		accountinformation.setBackground(Color.WHITE);
		GridBagConstraints gbc_accountinformation = new GridBagConstraints();
		gbc_accountinformation.weightx = 1.0;
		gbc_accountinformation.anchor = GridBagConstraints.NORTH;
		gbc_accountinformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountinformation.insets = new Insets(0, 0, 5, 5);
		gbc_accountinformation.gridx = 10;
		gbc_accountinformation.gridy = 1;
		frame.getContentPane().add(accountinformation, gbc_accountinformation);
		GridBagLayout gbl_userinformation = new GridBagLayout();
		gbl_userinformation.columnWidths = new int[]{56, 0};
		gbl_userinformation.rowHeights = new int[]{17, 17, 17, 0, 0, 0, 0, 0};
		gbl_userinformation.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_userinformation.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		accountinformation.setLayout(gbl_userinformation);

		DBConnect dbcon=new DBConnect();
		account=dbcon.findAccount(activeuser.getSocialsecuritynumber());

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.NORTHWEST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 0;
		accountinformation.add(name, gbc_name);
		name.setForeground(new Color(0, 128, 128));

		JTextField namedb = new JTextField(activeuser.getName());
		namedb.setColumns(15);
		namedb.setEditable(false);
		namedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_namedb = new GridBagConstraints();
		gbc_namedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_namedb.insets = new Insets(0, 0, 5, 0);
		gbc_namedb.gridx = 1;
		gbc_namedb.gridy = 0;
		accountinformation.add(namedb, gbc_namedb);

		JLabel surname = new JLabel("Surname:");
		surname.setForeground(new Color(0, 128, 128));
		surname.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 5);
		gbc_surname.anchor = GridBagConstraints.NORTHWEST;
		gbc_surname.gridx = 0;
		gbc_surname.gridy = 1;
		accountinformation.add(surname, gbc_surname);

		JTextField surnamedb = new JTextField(activeuser.getSurname());
		surnamedb.setColumns(15);
		surnamedb.setEditable(false);
		surnamedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surnamedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_surnamedb = new GridBagConstraints();
		gbc_surnamedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_surnamedb.insets = new Insets(0, 0, 5, 0);
		gbc_surnamedb.gridx = 1;
		gbc_surnamedb.gridy = 1;
		accountinformation.add(surnamedb, gbc_surnamedb);

		JLabel mail = new JLabel("Mail:");
		mail.setFont(new Font("Tahoma", Font.BOLD, 16));
		mail.setForeground(new Color(0, 128, 128));
		GridBagConstraints gbc_mail = new GridBagConstraints();
		gbc_mail.anchor = GridBagConstraints.NORTHWEST;
		gbc_mail.insets = new Insets(0, 0, 5, 5);
		gbc_mail.gridx = 0;
		gbc_mail.gridy = 2;
		accountinformation.add(mail, gbc_mail);

		JTextField maildb = new JTextField(activeuser.getMail());
		maildb.setColumns(15);
		maildb.setEditable(false);
		maildb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_maildb = new GridBagConstraints();
		gbc_maildb.insets = new Insets(0, 0, 5, 0);
		gbc_maildb.anchor = GridBagConstraints.NORTHWEST;
		gbc_maildb.gridx = 1;
		gbc_maildb.gridy = 2;
		accountinformation.add(maildb, gbc_maildb);

		JLabel carddate = new JLabel("Membership Date:");
		carddate.setForeground(new Color(0, 128, 128));
		carddate.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_carddate = new GridBagConstraints();
		gbc_carddate.anchor = GridBagConstraints.NORTHWEST;
		gbc_carddate.insets = new Insets(0, 0, 5, 5);
		gbc_carddate.gridx = 0;
		gbc_carddate.gridy = 3;
		accountinformation.add(carddate, gbc_carddate);

		JTextField carddatedb = new JTextField(activeuser.getMembershipdate());
		carddatedb.setEditable(false);
		carddatedb.setColumns(15);
		carddatedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_carddatedb = new GridBagConstraints();
		gbc_carddatedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_carddatedb.insets = new Insets(0, 0, 5, 0);
		gbc_carddatedb.gridx = 1;
		gbc_carddatedb.gridy = 3;
		accountinformation.add(carddatedb, gbc_carddatedb);

		JLabel lblCardLimit = new JLabel("Account Number:");
		lblCardLimit.setForeground(new Color(0, 128, 128));
		lblCardLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCardLimit = new GridBagConstraints();
		gbc_lblCardLimit.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCardLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardLimit.gridx = 0;
		gbc_lblCardLimit.gridy = 4;
		accountinformation.add(lblCardLimit, gbc_lblCardLimit);

		JTextField cardlimitdb = new JTextField("");
		if(account!=null){
			cardlimitdb.setText(account.getAccountid()+"");
		}
		cardlimitdb.setColumns(15);
		cardlimitdb.setEditable(false);
		cardlimitdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cardlimitdb = new GridBagConstraints();
		gbc_cardlimitdb.anchor = GridBagConstraints.NORTHWEST;
		gbc_cardlimitdb.insets = new Insets(0, 0, 5, 0);
		gbc_cardlimitdb.gridx = 1;
		gbc_cardlimitdb.gridy = 4;
		accountinformation.add(cardlimitdb, gbc_cardlimitdb);

		JLabel lblCard = new JLabel("Account Number:");
		lblCard.setForeground(new Color(0, 128, 128));
		lblCard.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCard = new GridBagConstraints();
		gbc_lblCard.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCard.insets = new Insets(0, 0, 5, 5);
		gbc_lblCard.gridx = 0;
		gbc_lblCard.gridy = 5;
		accountinformation.add(lblCard, gbc_lblCard);

		JTextField cardpaymentdate = new JTextField("");
		if(account!=null){
			cardpaymentdate.setText(account.getAccountid()+"");
		}
		cardpaymentdate.setColumns(15);
		cardpaymentdate.setEditable(false);
		cardpaymentdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cardpaymentdate = new GridBagConstraints();
		gbc_cardpaymentdate.insets = new Insets(0, 0, 5, 0);
		gbc_cardpaymentdate.anchor = GridBagConstraints.NORTHWEST;
		gbc_cardpaymentdate.gridx = 1;
		gbc_cardpaymentdate.gridy = 5;
		accountinformation.add(cardpaymentdate, gbc_cardpaymentdate);

		JLabel lblDebt = new JLabel("Total Money:");
		lblDebt.setForeground(new Color(0, 128, 128));
		lblDebt.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDebt = new GridBagConstraints();
		gbc_lblDebt.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDebt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt.gridx = 0;
		gbc_lblDebt.gridy = 6;
		accountinformation.add(lblDebt, gbc_lblDebt);

		debtdb = new JTextField("");
		debtdb.setColumns(15);
		if(account!=null){
			cardpaymentdate.setText(account.getTotalmoney()+"$");
		}
		debtdb.setEditable(false);
		debtdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_debtdb = new GridBagConstraints();
		gbc_debtdb.insets = new Insets(0, 0, 5, 0);
		gbc_debtdb.anchor = GridBagConstraints.NORTHWEST;
		gbc_debtdb.gridx = 1;
		gbc_debtdb.gridy = 6;
		accountinformation.add(debtdb, gbc_debtdb);

		JLabel lblLimit = new JLabel("Account Opening Date:");
		lblLimit.setForeground(new Color(0, 128, 128));
		lblLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblLimit = new GridBagConstraints();
		gbc_lblLimit.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimit.gridx = 0;
		gbc_lblLimit.gridy = 7;
		accountinformation.add(lblLimit, gbc_lblLimit);

		JTextField limit = new JTextField("");
		if(account!=null){
			cardpaymentdate.setText(account.getAccountdate());
		}
		limit.setColumns(15);
		limit.setEditable(false);
		limit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_limit = new GridBagConstraints();
		gbc_limit.insets = new Insets(0, 0, 5, 0);
		gbc_limit.anchor = GridBagConstraints.NORTHWEST;
		gbc_limit.gridx = 1;
		gbc_limit.gridy = 7;
		accountinformation.add(limit, gbc_limit);
	}

	public static void refresh(String ssn){
		DBConnect dbcon=new DBConnect();
		account=dbcon.findAccount(ssn);
		if(account!=null){
			debtdb.setText(account.getTotalmoney()+"$");
		}
	}
}

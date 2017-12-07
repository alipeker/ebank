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

public class user_settings {
	static JTextField namedb,surnamedb,maildb,carddatedb,cardlimitdb,cardpaymentdate,debtdb,limit;
	static String sname,ssurname,smail,scarddate,scardlimit,scardpaymentdate,sdebt,slimit;
	
	public user_settings(JFrame frame,User activeuser,JPanel panel,JPanel userinformation){
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
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.NORTHWEST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 0;
		userinformation.add(name, gbc_name);
		name.setForeground(new Color(0, 128, 128));

		namedb = new JTextField(activeuser.getName());
		namedb.setColumns(12);
		namedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_namedb = new GridBagConstraints();
		gbc_namedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_namedb.insets = new Insets(0, 0, 5, 0);
		gbc_namedb.gridx = 1;
		gbc_namedb.gridy = 0;
		userinformation.add(namedb, gbc_namedb);
		sname=activeuser.getName();
		
		JButton update = new JButton("Update");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DBConnect dbcon=new DBConnect();
				dbcon.insertWant("update userinformation set name='"+namedb.getText()+"', surname='"+surnamedb.getText()+"',mail='"+maildb.getText()+"',telephonenumber='"+cardpaymentdate.getText()+"' where socialsecuritynumber="+cardlimitdb.getText()+";",cardlimitdb.getText());
				JOptionPane.showMessageDialog(null, "Your request has been sent to the administrator.!");
			}
		});
		update.setFont(new Font("Tahoma", Font.PLAIN, 16));
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

		JLabel surname = new JLabel("Surname:");
		surname.setForeground(new Color(0, 128, 128));
		surname.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 5);
		gbc_surname.anchor = GridBagConstraints.NORTHWEST;
		gbc_surname.gridx = 0;
		gbc_surname.gridy = 1;
		userinformation.add(surname, gbc_surname);

		surnamedb = new JTextField(activeuser.getSurname());
		surnamedb.setColumns(12);
		surnamedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surnamedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_surnamedb = new GridBagConstraints();
		gbc_surnamedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_surnamedb.insets = new Insets(0, 0, 5, 0);
		gbc_surnamedb.gridx = 1;
		gbc_surnamedb.gridy = 1;
		userinformation.add(surnamedb, gbc_surnamedb);
		ssurname=activeuser.getSurname();

		JLabel mail = new JLabel("Mail:");
		mail.setFont(new Font("Tahoma", Font.BOLD, 16));
		mail.setForeground(new Color(0, 128, 128));
		GridBagConstraints gbc_mail = new GridBagConstraints();
		gbc_mail.anchor = GridBagConstraints.NORTHWEST;
		gbc_mail.insets = new Insets(0, 0, 5, 5);
		gbc_mail.gridx = 0;
		gbc_mail.gridy = 2;
		userinformation.add(mail, gbc_mail);

		maildb = new JTextField(activeuser.getMail());
		maildb.setColumns(12);
		maildb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_maildb = new GridBagConstraints();
		gbc_maildb.insets = new Insets(0, 0, 5, 0);
		gbc_maildb.anchor = GridBagConstraints.NORTHWEST;
		gbc_maildb.gridx = 1;
		gbc_maildb.gridy = 2;
		userinformation.add(maildb, gbc_maildb);
		smail=activeuser.getMail();

		JLabel carddate = new JLabel("Membership Date:");
		carddate.setForeground(new Color(0, 128, 128));
		carddate.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_carddate = new GridBagConstraints();
		gbc_carddate.anchor = GridBagConstraints.NORTHWEST;
		gbc_carddate.insets = new Insets(0, 0, 5, 5);
		gbc_carddate.gridx = 0;
		gbc_carddate.gridy = 3;
		userinformation.add(carddate, gbc_carddate);

		carddatedb = new JTextField(activeuser.getMembershipdate());
		carddatedb.setEditable(false);
		carddatedb.setColumns(12);
		carddatedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_carddatedb = new GridBagConstraints();
		gbc_carddatedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_carddatedb.insets = new Insets(0, 0, 5, 0);
		gbc_carddatedb.gridx = 1;
		gbc_carddatedb.gridy = 3;
		userinformation.add(carddatedb, gbc_carddatedb);
		scarddate=activeuser.getMembershipdate();

		JLabel lblCardLimit = new JLabel("Social Security Number:");
		lblCardLimit.setForeground(new Color(0, 128, 128));
		lblCardLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCardLimit = new GridBagConstraints();
		gbc_lblCardLimit.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCardLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardLimit.gridx = 0;
		gbc_lblCardLimit.gridy = 4;
		userinformation.add(lblCardLimit, gbc_lblCardLimit);

		cardlimitdb = new JTextField(activeuser.getSocialsecuritynumber());
		cardlimitdb.setColumns(12);
		cardlimitdb.setEditable(false);
		cardlimitdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cardlimitdb = new GridBagConstraints();
		gbc_cardlimitdb.anchor = GridBagConstraints.NORTHWEST;
		gbc_cardlimitdb.insets = new Insets(0, 0, 5, 0);
		gbc_cardlimitdb.gridx = 1;
		gbc_cardlimitdb.gridy = 4;
		userinformation.add(cardlimitdb, gbc_cardlimitdb);
		scardlimit=activeuser.getSocialsecuritynumber();

		JLabel lblCard = new JLabel("Telephone Nuber:");
		lblCard.setForeground(new Color(0, 128, 128));
		lblCard.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCard = new GridBagConstraints();
		gbc_lblCard.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCard.insets = new Insets(0, 0, 5, 5);
		gbc_lblCard.gridx = 0;
		gbc_lblCard.gridy = 5;
		userinformation.add(lblCard, gbc_lblCard);

		cardpaymentdate = new JTextField(activeuser.getTelephonenumber());
		cardpaymentdate.setColumns(12);
		cardpaymentdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cardpaymentdate = new GridBagConstraints();
		gbc_cardpaymentdate.insets = new Insets(0, 0, 5, 0);
		gbc_cardpaymentdate.anchor = GridBagConstraints.NORTHWEST;
		gbc_cardpaymentdate.gridx = 1;
		gbc_cardpaymentdate.gridy = 5;
		userinformation.add(cardpaymentdate, gbc_cardpaymentdate);
		scardpaymentdate=activeuser.getTelephonenumber();
		
		JLabel lblDebt = new JLabel("Birth Date:");
		lblDebt.setForeground(new Color(0, 128, 128));
		lblDebt.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDebt = new GridBagConstraints();
		gbc_lblDebt.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDebt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt.gridx = 0;
		gbc_lblDebt.gridy = 6;
		userinformation.add(lblDebt, gbc_lblDebt);

		debtdb = new JTextField(activeuser.getBirthdate());
		debtdb.setColumns(12);
		debtdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_debtdb = new GridBagConstraints();
		gbc_debtdb.insets = new Insets(0, 0, 5, 0);
		gbc_debtdb.anchor = GridBagConstraints.NORTHWEST;
		gbc_debtdb.gridx = 1;
		gbc_debtdb.gridy = 6;
		userinformation.add(debtdb, gbc_debtdb);
		sdebt=activeuser.getBirthdate();
		
		JLabel lblLimit = new JLabel("Remaining Limit:");
		lblLimit.setForeground(new Color(0, 128, 128));
		lblLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblLimit = new GridBagConstraints();
		gbc_lblLimit.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimit.gridx = 0;
		gbc_lblLimit.gridy = 7;
		userinformation.add(lblLimit, gbc_lblLimit);

		limit = new JTextField("");
		limit.setColumns(12);
		limit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_limit = new GridBagConstraints();
		gbc_limit.insets = new Insets(0, 0, 5, 0);
		gbc_limit.anchor = GridBagConstraints.NORTHWEST;
		gbc_limit.gridx = 1;
		gbc_limit.gridy = 7;
		userinformation.add(limit, gbc_limit);
		slimit="";
	}
	
	public static void refresh(){
		namedb.setText(sname);
		surnamedb.setText(ssurname);
		maildb.setText(smail);
		carddatedb.setText(scarddate);
		cardlimitdb.setText(scardlimit);
		cardpaymentdate.setText(scardpaymentdate);
		debtdb.setText(sdebt);
		limit.setText(slimit);
	}
}

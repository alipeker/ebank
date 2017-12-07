package UserPages;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Chart.PieChart;
import data.Card;
import data.User;
import database.DBConnect;

public class user_card {
	public user_card(JFrame frame,User activeuser,JPanel panel,JPanel userinformation){
		DBConnect db=new DBConnect();
		Card card=db.findCard(activeuser.getSocialsecuritynumber());

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

		if(card!=null){
			ArrayList<Double> values = new ArrayList<Double>();
			double debtrate=(card.getCardlimit()-card.getDebt())/card.getCardlimit();

			values.add(100.4-(debtrate*100));
			values.add(debtrate*100);

			ArrayList<Color> colors = new ArrayList<Color>();
			colors.add(Color.red);
			colors.add(Color.blue);


			panel.setBackground(Color.WHITE);
			FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
			flowLayout_1.setHgap(20);
			flowLayout_1.setVgap(20);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.anchor = GridBagConstraints.WEST;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.VERTICAL;
			gbc_panel.gridx = 3;
			gbc_panel.gridy = 1;
			frame.getContentPane().add(panel, gbc_panel);

			JLabel lbl_limit = new JLabel("Limit: "+(card.getCardlimit()-card.getDebt())+"$");
			lbl_limit.setForeground(Color.BLUE);
			panel.add(lbl_limit);
			PieChart pieChart = new PieChart(values, colors);
			panel.add(pieChart);
			FlowLayout flowLayout = (FlowLayout) pieChart.getLayout();
			flowLayout.setAlignment(FlowLayout.LEADING);
			flowLayout.setVgap(100);
			flowLayout.setHgap(100);

			JLabel lbl_debt = new JLabel("Debt: "+card.getDebt()+"$");
			lbl_debt.setForeground(Color.RED);
			panel.add(lbl_debt);

		}

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.NORTHWEST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 0;
		userinformation.add(name, gbc_name);
		name.setForeground(new Color(0, 128, 128));

		JLabel namedb = new JLabel(activeuser.getName());
		namedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_namedb = new GridBagConstraints();
		gbc_namedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_namedb.insets = new Insets(0, 0, 5, 0);
		gbc_namedb.gridx = 1;
		gbc_namedb.gridy = 0;
		userinformation.add(namedb, gbc_namedb);

		JLabel surname = new JLabel("Surname:");
		surname.setForeground(new Color(0, 128, 128));
		surname.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 5);
		gbc_surname.anchor = GridBagConstraints.NORTHWEST;
		gbc_surname.gridx = 0;
		gbc_surname.gridy = 1;
		userinformation.add(surname, gbc_surname);

		JLabel surnamedb = new JLabel(activeuser.getSurname());
		surnamedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surnamedb.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_surnamedb = new GridBagConstraints();
		gbc_surnamedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_surnamedb.insets = new Insets(0, 0, 5, 0);
		gbc_surnamedb.gridx = 1;
		gbc_surnamedb.gridy = 1;
		userinformation.add(surnamedb, gbc_surnamedb);

		JLabel mail = new JLabel("Mail:");
		mail.setFont(new Font("Tahoma", Font.BOLD, 16));
		mail.setForeground(new Color(0, 128, 128));
		GridBagConstraints gbc_mail = new GridBagConstraints();
		gbc_mail.anchor = GridBagConstraints.NORTHWEST;
		gbc_mail.insets = new Insets(0, 0, 5, 5);
		gbc_mail.gridx = 0;
		gbc_mail.gridy = 2;
		userinformation.add(mail, gbc_mail);

		JLabel maildb = new JLabel(activeuser.getMail());
		maildb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_maildb = new GridBagConstraints();
		gbc_maildb.insets = new Insets(0, 0, 5, 0);
		gbc_maildb.anchor = GridBagConstraints.NORTHWEST;
		gbc_maildb.gridx = 1;
		gbc_maildb.gridy = 2;
		userinformation.add(maildb, gbc_maildb);

		JLabel carddate = new JLabel("Card Delivery Date:");
		carddate.setForeground(new Color(0, 128, 128));
		carddate.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_carddate = new GridBagConstraints();
		gbc_carddate.anchor = GridBagConstraints.NORTHWEST;
		gbc_carddate.insets = new Insets(0, 0, 5, 5);
		gbc_carddate.gridx = 0;
		gbc_carddate.gridy = 3;
		userinformation.add(carddate, gbc_carddate);

		JLabel carddatedb = new JLabel("");
		if(card!=null){
			carddatedb.setText(card.getDeliverydate());
		}
		carddatedb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_carddatedb = new GridBagConstraints();
		gbc_carddatedb.anchor = GridBagConstraints.NORTHWEST;
		gbc_carddatedb.insets = new Insets(0, 0, 5, 0);
		gbc_carddatedb.gridx = 1;
		gbc_carddatedb.gridy = 3;
		userinformation.add(carddatedb, gbc_carddatedb);


		JLabel lblCardLimit = new JLabel("Card Limit:");
		lblCardLimit.setForeground(new Color(0, 128, 128));
		lblCardLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCardLimit = new GridBagConstraints();
		gbc_lblCardLimit.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCardLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardLimit.gridx = 0;
		gbc_lblCardLimit.gridy = 4;
		userinformation.add(lblCardLimit, gbc_lblCardLimit);

		JLabel cardlimitdb = new JLabel("");
		if(card!=null){
			cardlimitdb.setText(card.getCardlimit()+"$");
		}
		cardlimitdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cardlimitdb = new GridBagConstraints();
		gbc_cardlimitdb.anchor = GridBagConstraints.NORTHWEST;
		gbc_cardlimitdb.insets = new Insets(0, 0, 5, 0);
		gbc_cardlimitdb.gridx = 1;
		gbc_cardlimitdb.gridy = 4;
		userinformation.add(cardlimitdb, gbc_cardlimitdb);

		JLabel lblCard = new JLabel("Card Payment Date:");
		lblCard.setForeground(new Color(0, 128, 128));
		lblCard.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCard = new GridBagConstraints();
		gbc_lblCard.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCard.insets = new Insets(0, 0, 5, 5);
		gbc_lblCard.gridx = 0;
		gbc_lblCard.gridy = 5;
		userinformation.add(lblCard, gbc_lblCard);

		JLabel cardpaymentdate = new JLabel("");
		if(card!=null){
			cardpaymentdate.setText(card.getPaymentdate());
		}
		cardpaymentdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cardpaymentdate = new GridBagConstraints();
		gbc_cardpaymentdate.insets = new Insets(0, 0, 5, 0);
		gbc_cardpaymentdate.anchor = GridBagConstraints.NORTHWEST;
		gbc_cardpaymentdate.gridx = 1;
		gbc_cardpaymentdate.gridy = 5;
		userinformation.add(cardpaymentdate, gbc_cardpaymentdate);
		
		JLabel lblDebt = new JLabel("Debt:");
		lblDebt.setForeground(new Color(0, 128, 128));
		lblDebt.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDebt = new GridBagConstraints();
		gbc_lblDebt.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDebt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt.gridx = 0;
		gbc_lblDebt.gridy = 6;
		userinformation.add(lblDebt, gbc_lblDebt);

		JLabel debtdb = new JLabel("");
		if(card!=null){
			debtdb.setText(card.getDebt()+"$");
		}
		debtdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_debtdb = new GridBagConstraints();
		gbc_debtdb.insets = new Insets(0, 0, 5, 0);
		gbc_debtdb.anchor = GridBagConstraints.NORTHWEST;
		gbc_debtdb.gridx = 1;
		gbc_debtdb.gridy = 6;
		userinformation.add(debtdb, gbc_debtdb);
		
		JLabel lblLimit = new JLabel("Remaining Limit:");
		lblLimit.setForeground(new Color(0, 128, 128));
		lblLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblLimit = new GridBagConstraints();
		gbc_lblLimit.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimit.gridx = 0;
		gbc_lblLimit.gridy = 7;
		userinformation.add(lblLimit, gbc_lblLimit);

		JLabel limit = new JLabel("");
		if(card!=null){
			limit.setText((card.getCardlimit()-card.getDebt())+"$");
		}
		limit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_limit = new GridBagConstraints();
		gbc_limit.insets = new Insets(0, 0, 5, 0);
		gbc_limit.anchor = GridBagConstraints.NORTHWEST;
		gbc_limit.gridx = 1;
		gbc_limit.gridy = 7;
		userinformation.add(limit, gbc_limit);
	}
}

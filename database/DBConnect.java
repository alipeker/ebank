package database;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import data.Wants;

public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs,rs2;

	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebank?autoReconnect=true&useSSL=false", "root", "test");
			st = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);

		}
	}

	public void insertWant(String want,String ssn) {
		try {
			String query = "insert into permissionlist(want,whoid) values (\""+want+"\""+","+ssn+");";
			System.out.println(query);
			st.executeUpdate(query);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public boolean moneytransfer(String username,String accountid,double money,String whoaccount,Double totalmoney){
		try {
			String query = "select userinformation.socialsecuritynumber,account.totalmoney from userinformation,account where account.whoaccount=userinformation.socialsecuritynumber and account.id="+accountid+";";
			rs=st.executeQuery(query);
			rs.next();

			query = "select * from userinformation where socialsecuritynumber="+rs.getString("socialsecuritynumber")+";";
			rs2=st.executeQuery(query);
			rs2.next();

			if(rs2.getString("username").compareTo(username)==0){
				query = "select userinformation.socialsecuritynumber,account.totalmoney from userinformation,account where account.whoaccount=userinformation.socialsecuritynumber and account.id="+accountid+";";
				rs=st.executeQuery(query);
				rs.next();

				query = "update account set totalmoney="+(Double.parseDouble(rs.getString("totalmoney"))+money)+" where whoaccount="+rs.getString("socialsecuritynumber")+";";
				st.executeUpdate(query);

				query = "update account set totalmoney="+(totalmoney-money)+" where whoaccount="+whoaccount+";";
				st.executeUpdate(query);

				return true;
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	public void updateUser(String what,String newkey,String ssn){
		try {
			String query = "update userinformation set "+what+"='"+newkey+"' where socialsecuritynumber='"+ssn+"'";
			st.executeUpdate(query);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void execute(String want){
		try {
			String query = want;
			st.executeUpdate(query);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void removewant(String ssn,String id){
		try {
			String query = "delete from permissionlist where whoid="+ssn+" and id="+id;
			st.executeUpdate(query);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void removeUser(String ssn){
		try {
			String query = "delete from userinformation where socialsecuritynumber='"+ssn+"'";
			st.executeUpdate(query);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public data.User finduser(String ssn){
		try {
			String query = "select * from userinformation where socialsecuritynumber="+ssn;
			rs = st.executeQuery(query);
			while (rs.next()) {
				if(rs.getString("socialsecuritynumber").compareTo(ssn)==0){
					data.User user=new data.User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setSurname(rs.getString("surname"));
					user.setSocialsecuritynumber(rs.getString("socialsecuritynumber"));
					user.setMail(rs.getString("mail"));
					user.setTelephonenumber(rs.getString("telephonenumber"));
					user.setAdress(rs.getString("adress"));
					user.setBirthdate(rs.getString("birthdate"));
					user.setMembershipdate(rs.getString("membershipdate"));
					return user;
				}
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public data.Account findAccount(String ssn){
		try {
			BigInteger number = new BigInteger(ssn);
			String query = "select * from account where whoaccount="+number;
			rs = st.executeQuery(query);
			while (rs.next()) {
				data.Account account=new data.Account();
				account.setAccountdate(rs.getString("accountdate"));
				account.setAccountid(new BigInteger(rs.getString("id")));
				account.setTotalmoney(Double.parseDouble(rs.getString("totalmoney")));
				return account;
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public data.Card findCard(String ssn){
		try {
			BigInteger number = new BigInteger(ssn);
			String query = "select * from card where whoaccount="+number;
			rs = st.executeQuery(query);
			while (rs.next()) {
				data.Card card=new data.Card();
				card.setDebt(Double.parseDouble(rs.getString("debt")));
				card.setCardlimit(Double.parseDouble(rs.getString("cardlimit")));
				card.setDeliverydate(rs.getString("deliverydate"));
				card.setPaymentdate(rs.getString("paymentdate"));
				return card;
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public data.User finduserusername(String username){
		try {
			String query = "select * from userinformation where username="+"'"+username+"'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if(rs.getString("username").compareTo(username)==0){
					data.User user=new data.User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setSurname(rs.getString("surname"));
					user.setSocialsecuritynumber(rs.getString("socialsecuritynumber"));
					user.setMail(rs.getString("mail"));
					user.setTelephonenumber(rs.getString("telephonenumber"));
					user.setAdress(rs.getString("adress"));
					user.setBirthdate(rs.getString("birthdate"));
					user.setMembershipdate(rs.getString("membershipdate"));
					return user;
				}
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public ArrayList<Wants> findwants(){
		try {
			String query = "select * from permissionlist";
			rs = st.executeQuery(query);
			ArrayList<Wants> wantlist=new ArrayList<Wants>();
			while (rs.next()) {
				data.Wants want=new data.Wants();
				want.setId(rs.getString("id"));
				want.setWant(rs.getString("want"));
				want.setWhoid(rs.getString("whoid"));
				wantlist.add(want);
			}
			return wantlist;
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public boolean getData(String username,String password) {
		try {
			String query = "select * from userinformation";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if(rs.getString("username").compareTo(username)==0 && rs.getString("password").compareTo(password)==0){
					return true;
				}
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	public ArrayList<data.User> getUserinformation() {
		ArrayList<data.User> userinf=new ArrayList<data.User>();
		try {
			String query = "select * from userinformation";
			rs = st.executeQuery(query);
			while (rs.next()){
				if(rs.getString("username").compareTo("admin")!=0){
					data.User x=new data.User();
					x.setUsername(rs.getString("username"));
					x.setPassword(rs.getString("password"));
					x.setName(rs.getString("name"));
					x.setSurname(rs.getString("surname"));
					x.setSocialsecuritynumber(rs.getString("socialsecuritynumber"));
					x.setMail(rs.getString("mail"));
					x.setTelephonenumber(rs.getString("telephonenumber"));
					x.setAdress(rs.getString("adress"));
					x.setBirthdate(rs.getString("birthdate"));
					x.setMembershipdate(rs.getString("membershipdate"));
					userinf.add(x);
				}
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return userinf;
	}

	public boolean insertData(data.User newuser) {
		try {
			String query = "insert into userinformation values ('"+newuser.getName()+"','"+newuser.getSurname()+"','"+newuser.getUsername()+"','"+newuser.getPassword()+"','"+newuser.getSocialsecuritynumber()+"','"+newuser.getTelephonenumber()+"','"+newuser.getMail()+"','"+newuser.getAdress()+"','"+newuser.getMembershipdate()+"','"+newuser.getBirthdate()+"');";
			st.executeUpdate(query);
			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
}

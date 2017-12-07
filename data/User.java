package data;

public class User {
	private String username,password,socialsecuritynumber,name,surname,telephonenumber,mail,adress,birthdate,membershipdate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSocialsecuritynumber() {
		return socialsecuritynumber;
	}
	public void setSocialsecuritynumber(String socialsecuritynumber) {
		this.socialsecuritynumber = socialsecuritynumber;
	}
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adres) {
		this.adress = adres;
	}
	public String getMembershipdate() {
		return membershipdate;
	}
	public void setMembershipdate(String membershipdate) {
		this.membershipdate = membershipdate;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String string) {
		this.birthdate = string;
	}
	
}

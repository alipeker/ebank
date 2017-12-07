package data;

import java.math.BigInteger;

public class Account {
	private double totalmoney;
	private BigInteger accountid;
	private String accountdate;
	public double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}
	public String getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(String accountdate) {
		this.accountdate = accountdate;
	}
	public BigInteger getAccountid() {
		return accountid;
	}
	public void setAccountid(BigInteger accountid) {
		this.accountid = accountid;
	}
	
}

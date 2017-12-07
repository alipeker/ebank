package data;

public class Card {
	private double debt,cardlimit;
	private String deliverydate,paymentdate;

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	public double getCardlimit() {
		return cardlimit;
	}

	public void setCardlimit(double cardlimit) {
		this.cardlimit = cardlimit;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}
}

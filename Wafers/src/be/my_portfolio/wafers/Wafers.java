package be.my_portfolio.wafers;

import java.util.Scanner;

public class Wafers {
	static final int PRODUCTION_COST = 35;
	static final int SEL_PRICE = 50;
	static final int DONATION_VALUE = 5;
	
	private int wafersToBake;
	private int wafersSelled = 0;
	private float revenue = 0;
	private float donation = 0;
	private float profit = 0;
	private float totalCost = 0;
	
	static Scanner kbd = new Scanner(System.in);
	
	public void wafersToBake() {
		System.out.println("How many wafers do you want?");
		this.wafersToBake = kbd.nextInt();
		this.sellWafers();
		this.setRevenue();
		this.setDonation();
		this.setTotalCost();
		this.calculateProfit();
	}
	
	public void getData() {
		System.out.println("Amount of wafers sold: " + this.wafersSelled);
		System.out.println("Revenue: " + this.getRevenue());
		System.out.println("Profit: " + this.getProfit());
		System.out.println("Donation: " + this.getDonation());
	}
	
	private void sellWafers() {
		this.wafersSelled += this.wafersToBake;
	}
	
	public void setRevenue() {
		this.revenue += this.wafersToBake * SEL_PRICE;
	}
	
	public void setDonation() {
		int donation = DONATION_VALUE;
		if (this.wafersSelled > 1000) {
			int difference = this.wafersToBake - 1000;
			this.donation += (this.wafersToBake - difference) * donation;
			this.donation += difference * (donation + 1);
		} else {
			this.donation += this.wafersToBake * donation;
		}
	}
	
	public void setTotalCost() {
		this.totalCost = PRODUCTION_COST * this.wafersSelled;
	}
	
	public void calculateProfit() {
		this.profit = this.revenue - this.totalCost - this.donation;
	}
	
	public float getProfit() {
		return this.profit / 100;
	}
	
	public float getRevenue() {
		return this.revenue / 100;
	}
	
	public float getDonation() {
		return this.donation /100;
	}
	
	public int getWafersSelled() {
		return this.wafersSelled;
	}
	
	public static void test() {
		System.out.println("test");
	}
}

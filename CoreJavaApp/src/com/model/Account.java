package com.model;

public class Account implements Comparable<Account>{
	private int id;
	private String type;
	private double balance;


	public Account(int id, String type, double balance) {
		super(); //this is calling Object class constructor and so can be ignored. 
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance + "]";
	}

	@Override
	public int compareTo(Account a2) { 
		return (int) (this.balance - a2.balance);
	}

}

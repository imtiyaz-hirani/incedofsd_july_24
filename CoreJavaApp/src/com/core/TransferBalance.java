package com.core;

import com.model.Account;

public abstract class TransferBalance {
	public abstract boolean validateBalance(Account account);
	public abstract boolean validateInfo(Account account);
	public abstract boolean validateTransferAmount(Account account, double amount);
	public abstract void transferAmount(Account sender,Account reciever,double amount);
}
/* 
 * Rule 1: 
 * If a method does not have a body, then it is abstract method 
 * An anstract method should be in an abstract class. 
 * 
 * ctrl + shft + O
 */
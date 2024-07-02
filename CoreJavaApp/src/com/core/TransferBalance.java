package com.core;

import com.model.Account;

public interface TransferBalance {
	 boolean validateBalance(Account account);
	 boolean validateInfo(Account account) ;
	 boolean validateTransferAmount(Account account, double amount);
	 void transferAmount(Account sender,Account reciever,double amount);
    
}
/* 
 * Rule 1: 
 * If a method does not have a body, then it is abstract method 
 * An anstract method should be in an abstract class. 
 * 
 * ctrl + shft + O
 */
package com.service;

import com.core.TransferBalance;
import com.model.Account;

public class TransferService extends TransferBalance{

	@Override
	public boolean validateBalance(Account account) {
		if(account.getBalance() > 0)
			return true; 
		return false;
	}

	@Override
	public boolean validateInfo(Account account) {
		if(account.getType().equals("SAVINGS") 
				|| account.getType().equals("CURRENT"))
			return true; 
		
		return false;
	}

	@Override
	public boolean validateTransferAmount(Account account, double amount) {
		if(account.getBalance() >= amount)
			return true; 
		return false;
	}

	@Override
	public void transferAmount(Account sender, Account reciever, double amount) {
		  sender.setBalance(sender.getBalance() - amount);
		  reciever.setBalance(reciever.getBalance() + amount);
	}

	
}

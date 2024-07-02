package com.service;

import java.util.List;

import com.core.TransferBalance;
import com.model.Account;
import com.repository.AccountRepository;

public class TransferService extends TransferBalance{

	AccountRepository accountRepository = new AccountRepository(); 
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

	public boolean transfer(int senderId, int receiverId, double amount) {
		boolean isSuccess = true; 
		//fetch account object(details) based on id 
		List<Account> list = accountRepository.getList();
 		Account senderAccount = null;
		for(Account a : list) { //[a1,a2,a3,a4,a5] 
			if(a.getId() == senderId) {
				senderAccount = a; 
				isSuccess = true;
				break; 
			}
			else {
				isSuccess = false;
			}
		}
 		Account receiverAccount = null;
		 
		for(Account a1 : list) {  
 			if(a1.getId() == receiverId) {
				receiverAccount = a1; 
				isSuccess = true;
				break; 
			}
			else {
				isSuccess = false;
			}
		}
 		boolean status = validateBalance(senderAccount);
		if(status == false)
			isSuccess = false; 
		
		
		status  = validateInfo(senderAccount);
		if(status == false)
			isSuccess = false; 
		
		status  = validateInfo(receiverAccount);
		if(status == false)
			isSuccess = false; 
		
		status  = validateTransferAmount(senderAccount, amount);
		if(status == false)
			isSuccess = false; 
		
		transferAmount(senderAccount, receiverAccount, amount);
		return isSuccess;
	}

	
}

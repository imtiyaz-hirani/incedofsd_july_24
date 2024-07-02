package com.service;

import java.util.List;

import com.core.TransferBalance;
import com.exception.TransferException;
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

	public void transfer(int senderId, int receiverId, double amount) 
	throws TransferException{
		  
		//fetch account object(details) based on senderId 
		List<Account> list = accountRepository.getList();
 		
		Account senderAccount = null;
		for(Account a : list) { //[a1,a2,a3,a4,a5] 
			if(a.getId() == senderId) {
				senderAccount = a; 
				break; 
			}
		} //if senderAccount is null after going thru this entire for then ID is invalid
		if(senderAccount == null)
			throw new TransferException("Sender account id is invalid");
		 
 		Account receiverAccount = null;
		for(Account a1 : list) {  
 			if(a1.getId() == receiverId) {
				receiverAccount = a1; 
				break; 
			}
		} ////if receiverAccount is null after going thru this entire for loop then ID is invalid
		 
		if(receiverAccount == null)
			throw new TransferException("Receiver account id is invalid");
		
		
 		boolean status = validateBalance(senderAccount);
 		//after validateBalance check, if the status is still false, i vl throw exception
		if(status == false) 
			throw new TransferException("Sender account balance is insufficient for transfer");
		 
		
		status  = validateInfo(senderAccount);
 		//after validateInfo check of sender, if the status is still false, i vl throw exception
		if(status == false) 
			throw new TransferException("Sender account type should be either SAVINGS OR CURRENT for transfer");
 
		status  = validateInfo(receiverAccount);
 		//after validateInfo check of receiver, if the status is still false, i vl throw exception
		if(status == false) 
			throw new TransferException("Reciever account type should be either SAVINGS OR CURRENT for transfer");
		 
		
		status  = validateTransferAmount(senderAccount, amount);
 		//after validateTransferAmount check of sender, if the status is still false, i vl throw exception

		if(status == false) 
			throw new TransferException("Amount to be transfered is more than the balance in sender account");
 
		
		transferAmount(senderAccount, receiverAccount, amount);
		 
	}

	
}

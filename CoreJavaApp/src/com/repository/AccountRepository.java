package com.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.Account;

public class AccountRepository {

	List<Account> list = new ArrayList<>();  //polymorphic object 
	{
		Account account1 = new Account(134,"SAVINGS",5000.0); 
		Account account2 = new Account(156,"CURRENT",12000.0);
		Account account3 = new Account(234,"SAVINGS",7000.0);
		Account account4 = new Account(674,"CURRENT",25000.0);
		Account account5 = new Account(267,"DEMAT",15000.0);
		list = Arrays.asList(account1,account2,account3,account4,account5);
	}
 
	public List<Account> getList() {
		return list;
	}
	
}
//AccountRepository accountRepo = new AccountRepository(); 


/*
 * java.util
 * ---------
 * 
 * List   -  super    List l = new ArrayList(); //both - polymorphic 
 *  |
 *ArrayList    -- sub 
 * */
 
package com.controller;

import java.util.Set;
import java.util.TreeSet;

import com.model.Account;

public class TreeSetDemo {
	public static void main(String[] args) {
		/* TreeSet is a sorted collection. 
		 * It means that, the elements inside treeset are by default sorted. */
	   
		Set<Integer> set  = new TreeSet<>(); 
		set.add(5);
		set.add(6);
		set.add(4);
		set.add(7);
		
		System.out.println(set); //[4,5,6,7]
		
		Account account1 = new Account(134,"SAVINGS",5000.0); 
		Account account2 = new Account(156,"CURRENT",12000.0);
		Account account3 = new Account(234,"SAVINGS",7000.0);
		 
		Set<Account> setAccount = new TreeSet<>(); 
		setAccount.add(account1);
		setAccount.add(account2);
		setAccount.add(account3);
		
		System.out.println(setAccount);
	}
}

/* 
 *  Set   <interface>   super-entity
 *   |
 *  TreeSet <class>     sub-entity 
 */
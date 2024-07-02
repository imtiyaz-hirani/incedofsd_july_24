package com.controller;

import java.util.Scanner;

import com.exception.TransferException;
import com.service.TransferService;

public class TransferController {
	public static void main(String[] args) {
		//take I/P 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account ID of sender: ");
		int senderId = sc.nextInt();
		System.out.println("Enter account ID of reciever: ");
		int receiverId = sc.nextInt();
		System.out.println("Enter amount to transfer [sender-->reciever]");
		double amount = sc.nextDouble();
		
		//Reach out to service 
		TransferService transferService = new TransferService();
		boolean isSuccess;
		try {
			transferService.transfer(senderId,receiverId,amount);
			System.out.println("Transfer successful");
		} catch (TransferException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}

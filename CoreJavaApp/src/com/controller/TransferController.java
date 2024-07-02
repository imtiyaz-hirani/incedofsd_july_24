package com.controller;

import java.util.Scanner;

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
		boolean isSuccess = transferService.transfer(senderId,receiverId,amount);
		System.out.println(isSuccess?"Transfer successful":"Transfer failed");
		sc.close();
	}
}

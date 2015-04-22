package com.zhaos.synchronization;

public class AppTicket {

	public static void main(String[] args){
		TicketSeller ticketSeller = new TicketSeller();
		Thread thread1 = new Thread(ticketSeller);
		Thread thread2 = new Thread(ticketSeller);
		Thread thread3 = new Thread(ticketSeller);
		Thread thread4 = new Thread(ticketSeller);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}

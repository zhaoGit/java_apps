package com.zhaos.memberfunctionsynchronized;

public class AppTicket {

	public static void main(String[] args) throws InterruptedException{
		TicketSeller ticketSeller = new TicketSeller();
		Thread thread1 = new Thread(ticketSeller);
		Thread thread2 = new Thread(ticketSeller);

		
		thread1.start();
		Thread.sleep(15);
		ticketSeller.flag = false;
		thread2.start();

	}
}

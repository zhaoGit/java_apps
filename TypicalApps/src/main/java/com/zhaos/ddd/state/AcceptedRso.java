package com.zhaos.ddd.state;

public class AcceptedRso implements ReservationStatusOperations {

	@Override
	public ReservationStatus accept(Reservation reservation) {
		throw new RuntimeException("accept" +
				ReservationStatus.ACCEPTED);
	}

	@Override
	public ReservationStatus charge(Reservation reservation) {
		// charge client's credit card
		// send e-mail
		// print ticket
		System.out.println("charge client's credit card");
		System.out.println("send e-mail");
		System.out.println("print ticket");
		return ReservationStatus.PAID;
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		// send cancellation e-mail
		return ReservationStatus.CANCELLED;
	}

}
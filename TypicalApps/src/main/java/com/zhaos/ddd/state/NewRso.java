package com.zhaos.ddd.state;

public class NewRso implements ReservationStatusOperations {

	@Override
	public ReservationStatus accept(Reservation reservation) {
		// TODO Auto-generated method stub
		System.out.println("The reservation is in accepted state");
		return ReservationStatus.ACCEPTED;
	}

	@Override
	public ReservationStatus charge(Reservation reservation) {
		// TODO Auto-generated method stub
		System.out.println("The reservation is in new state, Can not charge");
		return ReservationStatus.NEW;
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		// TODO Auto-generated method stub
		System.out.println("The reservation will become CANCELLED state from NEW");
		return ReservationStatus.CANCELLED;
	}
}

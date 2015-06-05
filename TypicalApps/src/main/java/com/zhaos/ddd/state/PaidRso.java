package com.zhaos.ddd.state;

public class PaidRso implements ReservationStatusOperations {

	@Override
	public ReservationStatus accept(Reservation reservation) {
		// TODO Auto-generated method stub
		return ReservationStatus.PAID;
	}

	@Override
	public ReservationStatus charge(Reservation reservation) {
		// TODO Auto-generated method stub
		return ReservationStatus.PAID;
	}

	@Override
	public ReservationStatus cancel(Reservation reservation) {
		// TODO Auto-generated method stub
		return ReservationStatus.CANCELLED;
	}

}

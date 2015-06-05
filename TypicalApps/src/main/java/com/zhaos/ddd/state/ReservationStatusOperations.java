package com.zhaos.ddd.state;

public interface ReservationStatusOperations {
	ReservationStatus accept(Reservation reservation);

	ReservationStatus charge(Reservation reservation);

	ReservationStatus cancel(Reservation reservation);
}
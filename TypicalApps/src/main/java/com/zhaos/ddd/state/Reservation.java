package com.zhaos.ddd.state;

import java.math.BigDecimal;
import java.util.Calendar;

public class Reservation {
	private int id;
	private String name;
	private Calendar date;
	private BigDecimal price;
	private ReservationStatus status = ReservationStatus.NEW;

	public void accept() {
		setStatus(status.accept(this));
	}

	public void charge() {
		setStatus(status.charge(this));
	}

	public void cancel() {
		setStatus(status.cancel(this));
	}

	public void setStatus(ReservationStatus status) {
		if (status != null && status != this.status) {
			System.out.println("Reservation#" + id + ": changing status from "
					+ this.status + " to " + status);
			this.status = status;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ReservationStatus getStatus() {
		return status;
	}
}
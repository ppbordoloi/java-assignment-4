package com.zaloni.dao;

import java.util.Date;
import java.util.List;

import com.zaloni.entity.Booking;

public interface BookingDAO {
	
	public void addBooking(Booking booking);
	public void addCheckout(Date date, int rId);
	public void deleteBooking(int id);
	public void updateBooking(Booking booking);
	public Booking getBookingById(int id);
	public List<Booking> getAllBookings();
	public List<Booking> getAllInactiveBookings();
	public List<Booking> getAllActiveBookings();
	public void cancelBooking(int id);
}

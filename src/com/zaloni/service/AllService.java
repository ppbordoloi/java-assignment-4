package com.zaloni.service;

import java.util.Date;
import java.util.List;

import com.zaloni.entity.Booking;
import com.zaloni.entity.Customer;
import com.zaloni.entity.Room;

public interface AllService {
	
	public List<Customer> getCustomer();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomerById(int theId);

	public void addRoom(Room theRoom);
	
	public List<Room> getRoom();
	
	public Room getRoomById(int theId);
	
	public List<Room> getAllVacantRooms();
	
	public List<Room> getAllUsedRooms();
	
	public void addBooking(Booking booking);
	
	public void addCheckout(Date date, int rId);
	
	public void deleteBooking(int id);
	
	public void updateBooking(Booking booking);
	
	public List<Booking> listAllInactiveBookings();
	
	public Booking getBookingById(int id);
	
	public List<Booking> getAllActiveBookings();
	
	public void cancelBooking(int id);
}

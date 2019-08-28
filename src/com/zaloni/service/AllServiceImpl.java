package com.zaloni.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaloni.dao.BookingDAO;
import com.zaloni.dao.CustomerDAO;
import com.zaloni.dao.RoomDAO;
import com.zaloni.entity.Booking;
import com.zaloni.entity.Customer;
import com.zaloni.entity.Room;

@Service
public class AllServiceImpl implements AllService {

	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	RoomDAO roomDAO;
	@Autowired
	BookingDAO bookingDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		
		customerDAO.addCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		
		return customerDAO.getCustomerById(theId);
		
	}

	@Override
	@Transactional
	public void addRoom(Room theRoom) {
		roomDAO.addRoom(theRoom);
	}

	@Override
	@Transactional
	public List<Room> getRoom() {
		return roomDAO.getRoom();
	}

	@Override
	@Transactional
	public Room getRoomById(int theId) {
		return roomDAO.getRoomById(theId);
	}

	@Override
	@Transactional
	public List<Room> getAllVacantRooms() {
		return roomDAO.getAllVacantRooms();
	}
	
	@Override
	@Transactional
	public List<Room> getAllUsedRooms() {
		return roomDAO.getAllUsedRooms();
	}

	@Override
	@Transactional
	public void addBooking(Booking booking) {
		bookingDAO.addBooking(booking);
		
	}

	@Override
	@Transactional
	public void deleteBooking(int id) {
		bookingDAO.deleteBooking(id);
		
	}

	@Override
	@Transactional
	public void updateBooking(Booking booking) {
		bookingDAO.updateBooking(booking);
	}

	@Override
	@Transactional
	public void addCheckout(Date date, int rId) {
		bookingDAO.addCheckout(date, rId);
	}

	@Override
	@Transactional
	public List<Booking> listAllInactiveBookings() {
		return bookingDAO.getAllInactiveBookings();
	}

	@Override
	@Transactional
	public Booking getBookingById(int id) {
		return bookingDAO.getBookingById(id);
	}

	@Override
	@Transactional
	public List<Booking> getAllActiveBookings() {
		return bookingDAO.getAllActiveBookings();
	}

	@Override
	@Transactional
	public void cancelBooking(int id) {
		bookingDAO.cancelBooking(id);
		
	}
	
	

}

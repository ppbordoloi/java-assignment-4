package com.zaloni.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaloni.entity.Booking;
import com.zaloni.entity.Room;

@Repository
public class BookingDAOImpl implements BookingDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addBooking(Booking booking) {
	sessionFactory.getCurrentSession().save(booking);
	Room room = sessionFactory.getCurrentSession().get(Room.class, booking.getRoom().getRoomId());
	room.setVacant_status(true);
	sessionFactory.getCurrentSession().merge(room);
	}

	@Override
	public void addCheckout(Date date, int rId) {
		Session session = sessionFactory.getCurrentSession();
		Room room = session.get(Room.class, rId);
		room.setVacant_status(false);
		String hql = "SELECT BK FROM Booking BK where room=:room1 and checkOutDate=null";
		Query<Booking> q = session.createQuery(hql);
		q.setParameter("room1", room);
		List<Booking> list = q.getResultList();
		Booking booking = session.get(Booking.class, list.get(0).getId());
		booking.setCheckOutDate(date);
		session.merge(booking);
		session.merge(room);
	}

	@Override
	public void deleteBooking(int id) {
		Booking booking = sessionFactory.getCurrentSession().get(Booking.class,id);
		sessionFactory.getCurrentSession().delete(booking);
	}

	@Override
	public void updateBooking(Booking booking) {
		sessionFactory.getCurrentSession().merge(booking);
	}

	@Override
	public Booking getBookingById(int id) {
		return sessionFactory.getCurrentSession().get(Booking.class, id);
	}

	@Override
	public List<Booking> getAllBookings() {
		String hql = "SELECT BK FROM Booking BK";
		Query<Booking> q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.getResultList();
	}

	@Override
	public List<Booking> getAllInactiveBookings() {
		String hql = "SELECT BK FROM Booking BK WHERE checkOutDate!=null";
		Query<Booking> q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.getResultList();
	}

	@Override
	public List<Booking> getAllActiveBookings() {
		String hql = "SELECT BK FROM Booking BK WHERE checkOutDate=null";
		Query<Booking> q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.getResultList();
	}

	@Override
	public void cancelBooking(int id) {
		Session session = sessionFactory.getCurrentSession();
		Booking book = session.get(Booking.class, id);
		book.getRoom().setVacant_status(false);
		session.delete(book);
		
	}

}

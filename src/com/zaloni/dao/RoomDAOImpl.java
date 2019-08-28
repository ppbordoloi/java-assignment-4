package com.zaloni.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaloni.entity.Room;

@Repository
public class RoomDAOImpl implements RoomDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Room> getRoom() {
		Session session = sessionFactory.getCurrentSession();
		Query<Room> theQuery =session.createQuery("from Room", Room.class);
		List<Room> theRoom = theQuery.getResultList();
		return theRoom;
	}

	@Override
	public void addRoom(Room theRoom) {
		Session session = sessionFactory.getCurrentSession();
		session.save(theRoom);
	}

	@Override
	public Room getRoomById(int theId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Room.class, theId);
	}

	@Override
	public List<Room> getAllVacantRooms() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT RM FROM Room RM WHERE vacant_status=:vs";
		Query q = session.createQuery(hql);
		q.setParameter("vs", false);
		List<Room> list = q.getResultList();
		return list;
		
	}
	
	@Override
	public List<Room> getAllUsedRooms() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT RM FROM Room RM WHERE vacant_status=:vs";
		Query q = session.createQuery(hql);
		q.setParameter("vs", true);
		List<Room> list = q.getResultList();
		return list;
		
	}

}

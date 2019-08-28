package com.zaloni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room22")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="room_id")
	int roomId;
	@Column(name="flor")
	int flor;
	@Column(name="descrp")
	String descrp;
	@Column(name="v_status")
	boolean vacant_status;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomNo) {
		this.roomId = roomNo;
	}
	public boolean isVacant_status() {
		return vacant_status;
	}
	public void setVacant_status(boolean vacant_status) {
		this.vacant_status = vacant_status;
	}
	public int getFlor() {
		return flor;
	}
	public void setFlor(int flor) {
		this.flor = flor;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	
	

}

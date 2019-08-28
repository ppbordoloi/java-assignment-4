package com.zaloni.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zaloni.entity.Booking;
import com.zaloni.entity.Customer;
import com.zaloni.entity.Room;
import com.zaloni.service.AllService;

@Controller
public class CustomerController {
	
	@Autowired
	AllService allService;
	Room room;
	Customer customer;
	Booking booking;
	boolean logg=false;
	
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(@RequestParam String id, @RequestParam String pass) {
		if(id.equals("admin") && pass.equals("admin")) {
			this.logg=true;
			return "redirect:/bookRoom";
		}
		else
		{
			return "login";
		}
		
	}
	
	@RequestMapping("/listCustomer")
	public String customerList(Model model)
	{
		if(this.logg==false)
		{
			return "login";
		}
		List<Customer> theCustomer = allService.getCustomer();
		
		model.addAttribute("custList", theCustomer);
		return "listCustomer";
	}
	
	@RequestMapping("/showAddForm")
	public String saveCustomer(Model themodel)
	{
		if(this.logg==false)
		{
			return "login";
		}
		Customer theCustomer = new Customer();
		themodel.addAttribute("customer", theCustomer);
		return "saveCustomer";
	}
	
	@PostMapping("/saveCust")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		if(this.logg==false)
		{
			return "login";
		}
		allService.addCustomer(theCustomer);
		return "redirect:/listCustomer";
	}
	
	@RequestMapping("/showRoomForm")
	public String saveRoom()
	{
		if(this.logg==false)
		{
			return "login";
		}
		return "saveRoom";
	}
	
	@PostMapping("/saveRoom")
	public String addRoom(@RequestParam String flor, @RequestParam String descrp)
	{
		if(this.logg==false)
		{
			return "login";
		}
		Room theRoom = new Room();
		theRoom.setFlor(Integer.parseInt(flor));
		theRoom.setDescrp(descrp);
		allService.addRoom(theRoom);
		return "redirect:/listRoom";
	}
	
	@RequestMapping("/listRoom")
	public String roomList(Model model)
	{
		if(this.logg==false)
		{
			return "login";
		}
		List<Room> theRoom = allService.getRoom();
		model.addAttribute("roomList", theRoom);
		return "listRoom";
	}
	
	@RequestMapping("/bookRoom")
	public String bookRoom(Model model)
	{
		if(this.logg==false)
		{
			return "login";
		}
		List<Room> theRoom = allService.getAllVacantRooms();
		model.addAttribute("bookRoomM", theRoom);
		return "bookRoom";
	}
	
	@RequestMapping("/showCustomerForBooking")
	public String bookRoomForCustomer(@RequestParam int roomId, Model model)
	{
		if(this.logg==false)
		{
			return "login";
		}
		this.room=allService.getRoomById(roomId);
		List<Customer> list = allService.getCustomer();
		model.addAttribute("cust1", list);
		return "bookRoomCustomer";
	}
	
	@RequestMapping("/showBookedRoom")
	public String bookedRoom(@RequestParam int customerId)
	{
		if(this.logg==false)
		{
			return "login";
		}
		this.customer = allService.getCustomerById(customerId);
		Booking booking = new Booking();
		booking.setCustomer(customer);
		booking.setRoom(room);
		
		Date date = new Date();  
		booking.setCheckInDate(date);
		allService.addBooking(booking);
		return "redirect:/showUsedRooms";
		
	}
	
	@RequestMapping("/showUsedRooms")
	public String showUsedRooms(Model model) {
		if(this.logg==false)
		{
			return "login";
		}
		List<Room> theRoom = allService.getAllUsedRooms();
		model.addAttribute("bookRoomM2", theRoom);
		return "usedRoom";
	}
	
	@RequestMapping("/checkoutCustomer")
	public String checkoutCust(@RequestParam int roomId) {
		if(this.logg==false)
		{
			return "login";
		}
		Date date = new Date();
		allService.addCheckout(date, roomId);
		System.out.println(roomId);
		return "redirect:/listInactiveBookings";
	}
	
	@RequestMapping("/listInactiveBookings")
	public String listInactiveBookings(Model model) {
		if(this.logg==false)
		{
			return "login";
		}
		List<Booking> listb = allService.listAllInactiveBookings();
		model.addAttribute("book11", listb);
		return "listInactiveBookings";
	}
	
	@RequestMapping("/showBookingDelete")
	public String deleteBooking(@RequestParam int bookingId) {
		if(this.logg==false)
		{
			return "login";
		}
		allService.deleteBooking(bookingId);
		return "redirect:/listInactiveBookings";
	}
	
	@RequestMapping("/showBookingUpdate")
	public String updateBooking(@RequestParam int bookingId, Model model) {
		if(this.logg==false)
		{
			return "login";
		}
		Booking book22 = allService.getBookingById(bookingId);
		model.addAttribute("book22", book22);
		return "showUpdateForm";
	}
	
	@RequestMapping("/bookingUpdate")
	public String updateBooking1(@RequestParam int bookingId, @RequestParam int cId , @RequestParam int rId, @RequestParam String ciDate, 
			@RequestParam String coDate) throws ParseException {
		if(this.logg==false)
		{
			return "login";
		}
		Booking book33 = allService.getBookingById(bookingId);
		book33.setCustomer(allService.getCustomerById(cId));
		book33.setRoom(allService.getRoomById(rId));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(ciDate);  	
		book33.setCheckInDate(date);
		date = format.parse(coDate);
		book33.setCheckOutDate(date);
		allService.updateBooking(book33);
		return "redirect:/listInactiveBookings";
	}
	
	@RequestMapping("/listActiveBookings")
	public String listActiveBookings(Model model) {
		if(this.logg==false)
		{
			return "login";
		}
		List<Booking> listb = allService.getAllActiveBookings();
		model.addAttribute("book33", listb);
		return "listActiveBookings";
	}
	
	@RequestMapping("/updateActiveBooking")
	public String updateActiveBooking(@RequestParam int bookingId, Model model) {
		if(this.logg==false)
		{
			return "login";
		}
		Booking book44 = allService.getBookingById(bookingId);
		model.addAttribute("book44", book44);
		return "showActiveUpdateForm";
	}
	
	@RequestMapping("/bookingActiveUpdate")
	public String updateActiveBooking(@RequestParam int bookingId, @RequestParam int cId , @RequestParam int rId, @RequestParam String ciDate) throws ParseException {
		if(this.logg==false)
		{
			return "login";
		}
		Booking book33 = allService.getBookingById(bookingId);
		book33.setCustomer(allService.getCustomerById(cId));
		book33.setRoom(allService.getRoomById(rId));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(ciDate);  	
		book33.setCheckInDate(date);
		allService.updateBooking(book33);
		return "redirect:/listActiveBookings";
	}
	
	@RequestMapping("/deleteActiveBooking")
	public String deleteActiveBooking(@RequestParam int bookingId) {
		if(this.logg==false)
		{
			return "login";
		}
		allService.cancelBooking(bookingId);
		return "redirect:/listActiveBookings";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		this.logg=false;
		return "login";
	}

}

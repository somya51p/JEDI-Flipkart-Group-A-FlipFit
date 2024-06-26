package com.flipkart.client;
import com.flipkart.business.BookingInterface;
import com.flipkart.business.BookingService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;
public class FlipFlitCustomerClient {
   
	public static void main(String[] Args){

		FlipFitCustomerInterface userService = new FlipFitCustomerService();
		BookingInterface bookingService = new BookingService();
		userService.createCustomer(101,"Sarthak","sarthak.vats@gmail.com", "987","ABC", "XYZ" );
		userService.editProfile();
		userService.viewGyms();
		userService.viewSlots();
		userService.filterSlots();
		bookingService.bookSlots();
		bookingService.makePayment();
		bookingService.viewBookings();
		bookingService.cancelBookings();
	  }
}

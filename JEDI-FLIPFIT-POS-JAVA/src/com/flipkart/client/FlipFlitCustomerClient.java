package com.flipkart.client;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.business.BookingGymService;
import com.flipkart.business.FlipFitCustomerInterface;
import com.flipkart.business.FlipFitCustomerService;
public class FlipFlitCustomerClient {
   
	public static void main(String[] Args){

		FlipFitCustomerInterface userService = new FlipFitCustomerService();
		BookingGymInterface bookingService = new BookingGymService();
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

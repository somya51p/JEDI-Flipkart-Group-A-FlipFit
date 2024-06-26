package com.flipkart.client;
import com.flipkart.business.FlipFitCustomerService;
public class FlipFlitCustomerClient {
   
	public static void main(String[] Args){
		  
		 
		FlipFitCustomerService service=new FlipFitCustomerService();
		service.createCustomer();
		System.out.println(service.getCustomerId());
		service.editProfile();
		service.viewGyms();
		service.viewSlots();
		service.filterSlots();
		service.bookSlots();
		service.viewBookings();
		service.cancelBookings();
	  }
}

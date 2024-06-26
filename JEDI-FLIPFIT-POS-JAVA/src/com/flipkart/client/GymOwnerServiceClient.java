package com.flipkart.client;

import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitGymOwnerService;

public class GymOwnerServiceClient {

	public static void main(String[] args) {
		FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();

		gymOwnerService.createGymOwner(1, "John Doe", "john.doe@example.com", "9876543210", "123 Street, City",
				"ABCDE1234F", "GST1234567", "Pending");

		gymOwnerService.editProfile(1, "John Doe", "john.doe@example.com", "9876543210", "password", "123 Street, City",
				"ABCDE1234F","GST1234567","Approved");

		gymOwnerService.registerGym(101, "Fitness Center A", "Downtown");

		gymOwnerService.editGym(101);

		gymOwnerService.removeGym(101);

		gymOwnerService.viewAllRegisteredGymCenters();

		gymOwnerService.viewAllBookings();

		gymOwnerService.viewBookings(101);

		gymOwnerService.viewAvailableSlots(101);

		gymOwnerService.addSlot(101, 1);

		gymOwnerService.removeSlot(101, 1);
	}
}
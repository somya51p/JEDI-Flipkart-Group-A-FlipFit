package com.flipkart.client;

import com.flipkart.business.FlipfitAdminInterface;
import com.flipkart.business.FlipfitAdminService;

public class GymFlipFitAdminMenu {

	public static void main(String[] args) {
		FlipfitAdminInterface adminService = new FlipfitAdminService();

		adminService.createAdmin(1, "admin@example.com", "admin@123");

		adminService.viewGymOwnerDetails(101);

		adminService.viewGymOwnerRequests();

		adminService.approveGymOwnerRequests(101);

		adminService.removeGymOwner(102);

		adminService.cancelRequest(103);
	}
}
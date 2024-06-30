package com.flipkart.client;

import com.flipkart.business.FlipfitAdminService;

public class AdminServiceClient {

	public static void main(String[] args) {
		FlipfitAdminService adminService = new FlipfitAdminService();

		adminService.createAdmin(1, "admin@example.com", "admin@123");

		adminService.viewGymOwnerDetails(101);

		adminService.viewGymOwnerRequests();

		adminService.approveGymOwnerRequests(101);

		adminService.removeGymOwner(102);

		adminService.cancelRequest(103);
	}
}
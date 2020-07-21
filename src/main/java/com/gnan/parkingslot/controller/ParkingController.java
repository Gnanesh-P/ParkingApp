package com.gnan.parkingslot.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnan.parkingslot.businesslogic.ParkingBL;
import com.gnan.parkingslot.entities.VehicleDetails;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ParkingController {
	@Autowired
	private ParkingBL parkingService;

	@GetMapping("/vehicleList")
	public Collection<VehicleDetails> getParkedVehiclesList() {
		System.out.println("Get Vehicle List");
		return parkingService.getVehiclesData();
	}

	@GetMapping("/initializeFreeSlots")
	public void initializeFreeslots(@RequestParam("slots") int slots) {
		System.out.println("Initlaize vehicle "+slots);
		parkingService.initializeFreeslots(slots);
	}

	@GetMapping("/searchVehicles")
	public void searchVehicles(@RequestParam("slots") int slots) {
		parkingService.initializeFreeslots(slots);
	}

	@GetMapping("/exitVehicle")
	public void exitVehicle(@RequestParam("vehicleId") int id) {
		parkingService.exitVehicles(id);
	}
	//@RequestParam("registerNumber") String regNumber,@RequestParam("color") String carColor
	
	@PostMapping("/entryVehicle")
	public String entryVehicle( @RequestBody VehicleDetails details) {
		/*VehicleDetails details=new VehicleDetails();
		details.setColor(carColor);
		details.setRegisterNumber(regNumber);
		System.out.println("Vehicle Entered"+carColor);*/
		System.out.println("Vehciled Entered" + details.getColor());
		return parkingService.entryVehicle(details);
	}


	@GetMapping("/getVehicleByColor")
	public List<String> getVehicleByColor(@RequestParam("vehicleColor") String carColor) {
		return parkingService.getVehicleByColor(carColor);
	}

	@GetMapping("/getParkingSlotsByColor")
	public List<Integer> getParkingSlotsByColor(@RequestParam("vehicleColor") String carColor) {
		return parkingService.getParkingSlotsByColor(carColor);
	}
	@GetMapping("/getSlotNumberByRegisterNumber")
	public List<Integer> getSlotNumberByRegisterNumber(@RequestParam("registerNumber") String regNumber) {
		return parkingService.getSlotNumberByRegisterNumber(regNumber);
	}
}

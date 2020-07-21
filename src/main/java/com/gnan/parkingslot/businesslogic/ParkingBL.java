package com.gnan.parkingslot.businesslogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import com.gnan.parkingslot.entities.VehicleDetails;

@Component
public class ParkingBL {
	private HashMap<Integer, VehicleDetails> parkingSlot;
	private LinkedBlockingQueue<Integer> freeSlots;

	public Collection<VehicleDetails> getVehiclesData() {
		Collection<VehicleDetails> details=new ArrayList<>();
       if(parkingSlot!=null&&!parkingSlot.isEmpty())
    	   details=   parkingSlot.values();
       return  details;
	}

	public void initializeFreeslots(int capacity) {
		freeSlots = new LinkedBlockingQueue<>(capacity);
		parkingSlot=new HashMap<Integer, VehicleDetails>();
		for (int i = 1; i <= capacity; i++)
			freeSlots.offer(i);
	}

	public void exitVehicles(int id) {
		parkingSlot.remove(id);
		freeSlots.offer(id);
	}

	public List<String> getVehicleByColor(String color) {
		List<String> vechileNumber = new ArrayList<>();
		parkingSlot.forEach((k, v) -> {
			if (v.getColor().equals(color)) {
				vechileNumber.add(v.getRegisterNumber());
			}
		});
		return vechileNumber;

	}
	public List<Integer> getSlotNumberByRegisterNumber(String regNumber) {
		List<Integer> vechileNumber = new ArrayList<>();
		int slotNo = 0;
		parkingSlot.forEach((k, v) -> {
			if (v.getRegisterNumber().equals(regNumber)) {
				vechileNumber.add(v.getSlotNo());
			}
		});
		return vechileNumber;

	}
	

	public List<Integer> getParkingSlotsByColor(String color) {
		List<Integer> vechileNumber = new ArrayList<>();
		int slotNo = 0;
		parkingSlot.forEach((k, v) -> {
			if (v.getColor().equals(color)) {
				vechileNumber.add(v.getSlotNo());
			}
		});
		return vechileNumber;


	}

	public String entryVehicle(VehicleDetails vehicleInfo) {
		if(freeSlots.size()>0) {
		int slotNo = freeSlots.poll();
		vehicleInfo.setSlotNo(slotNo);
		parkingSlot.put(slotNo, vehicleInfo);
		return "Vehicle Parked";
		}
		return "Parking Full";
	}
}

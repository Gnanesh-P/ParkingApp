package com.gnan.parkingslot.entities;

import java.util.Date;

public class VehicleDetails {
	private String registerNumber;
    private int slotNo;
	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	private String color;

}

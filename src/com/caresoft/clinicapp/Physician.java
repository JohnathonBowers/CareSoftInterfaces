package com.caresoft.clinicapp;

import java.util.Date;

import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {

	private ArrayList<String> patientNotes = new ArrayList<String>();
	
	// TO DO: Constructor that takes an ID
	
	public Physician (Integer id) {
		super();
		this.id = id;
	}

	// TO DO: Implement HIPAACompliantUser!
	
	@Override
	public boolean assignPin(int pin) {
		if (pin > 999 && pin < 10000) {
			setPin(pin);
			return true;
		} else {
		return false;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (id == confirmedAuthID) {
			return true;
		} else {
		return false;
		}
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s\n", date);
		report += String.format("Reported By ID: %s", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s\n", notes);
		this.patientNotes.add(report);
	}
	
	// TO DO: Getters & Setters
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
}
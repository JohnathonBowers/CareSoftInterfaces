package com.caresoft.clinicapp;

import java.util.Date;

import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();
	
	// TO DO: Implement a constructor that takes an ID and a role
	
	public AdminUser (Integer id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	
	// Class Methods
	
	public void newIncident(String notes) {
		String report = String.format("\n\nDatetime Submitted: %s\nReported By ID: %s\nNotes: %s", new Date(), this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("\n\nDatetime Submitted: %s\nID: %s\nNotes: %s", new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}
	
	
	// TO DO: Implement HIPAA CompliantUser!
	
	@Override
	public boolean assignPin(int pin) {
		if (pin > 99999 && pin < 1000000) {
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
			authIncident();
			return false;
		}
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
	
	
	// TO DO: Getters & Setters
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
}

package com.gratex.docs.dtos;

import java.util.HashMap;
import java.util.Map;

public class GastroDTO {

	private String fullName;
	private String address;
	private String birthDate;
	// TODO: add selection type
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Map<String, String> getAsMap() {
		Map<String, String> gastroMap = new HashMap<>();
		gastroMap.put("fullName", this.fullName);
		gastroMap.put("address", this.address);
		gastroMap.put("birthDate", this.birthDate);
		return gastroMap;
	}
}
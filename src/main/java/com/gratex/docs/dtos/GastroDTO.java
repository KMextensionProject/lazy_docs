package com.gratex.docs.dtos;

import com.gratex.docs.utils.StringMap;

public class GastroDTO {

	private String fullName;
	private String address;
	private String birthDate;
	private String option;

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

	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public StringMap getAsMap() {
		StringMap gastroMap = new StringMap();
		gastroMap.put("fullName", this.fullName);
		gastroMap.put("address", this.address);
		gastroMap.put("birthDate", this.birthDate);
		gastroMap.put("option", this.option);
		return gastroMap;
	}
}

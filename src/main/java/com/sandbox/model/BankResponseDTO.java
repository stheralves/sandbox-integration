package com.sandbox.model;

import java.util.List;

public class BankResponseDTO {
	private List<BankDto> banks;

	public List<BankDto> getBanks() {
		return banks;
	}

	public void setBanks(List<BankDto> banks) {
		this.banks = banks;
	}
}

class BankDto {
	private String id;
	private String shortName;
	private String fullName;
	private String logo;
	private String website;
	private List<BankRoutingDto> bankRoutings;
	private List<Object> attributes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<BankRoutingDto> getBankRoutings() {
		return bankRoutings;
	}

	public void setBankRoutings(List<BankRoutingDto> bankRoutings) {
		this.bankRoutings = bankRoutings;
	}

	public List<Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Object> attributes) {
		this.attributes = attributes;
	}
}

class BankRoutingDto {
	private String scheme;
	private String address;

	// Getters e Setters
	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

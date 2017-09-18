package com.emids.empDTO;

public class EmpAddress {
	private int addrId;
	private String street;
	private String area;
	private int pincode;
	
	
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "EmpAddress [addrId=" + addrId + ", street=" + street + ", area=" + area + ", pincode=" + pincode + "]";
	}
	
	public EmpAddress(int addrId, String street, String area, int pincode) {
		super();
		this.addrId = addrId;
		this.street = street;
		this.area = area;
		this.pincode = pincode;
	}
	public EmpAddress() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}

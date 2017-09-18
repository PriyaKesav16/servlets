package com.emids.empDTO;

public class EmpSalary {
	
	private int salId;
	private int totalSal;
	private int basic;
	private int hra;
	private int splPay;
	
	public int getSalId() {
		return salId;
	}
	public void setSalId(int salId) {
		this.salId = salId;
	}
	public int getTotalSal() {
		return totalSal;
	}
	public void setTotalSal(int totalSal) {
		this.totalSal = totalSal;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getSplPay() {
		return splPay;
	}
	public void setSplPay(int splPay) {
		this.splPay = splPay;
	}
	
	@Override
	public String toString() {
		return "EmpSalary [salId=" + salId + ", totalSal=" + totalSal + ", basic=" + basic + ", hra=" + hra
				+ ", splPay=" + splPay + "]";
	}
	
	public EmpSalary(int salId, int totalSal, int basic, int hra, int splPay) {
		super();
		this.salId = salId;
		this.totalSal = totalSal;
		this.basic = basic;
		this.hra = hra;
		this.splPay = splPay;
	}
	

}

package com.emids.empDTO;

public class Employee {
	
	private int empId;
	private String empName;
	private int deptId;
	private int mgrId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", mgrId=" + mgrId + "]";
	}
	public Employee(int empId, String empName, int deptId, int mgrId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.mgrId = mgrId;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}

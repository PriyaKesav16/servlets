package com.emids.Dao;

import java.util.List;

import com.emids.empDTO.City;
import com.emids.empDTO.Country;
import com.emids.empDTO.Department;
import com.emids.empDTO.State;

public interface EmpDao {
	
	public List<Department> getAllDepartments(); 
	public List<State> getAllStates(); 
	public List<Country> getAllCountries(); 
	public List<City> getAllCities(); 
	 
	
}

package com.emids.daoImpln;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emids.Dao.EmpDao;
import com.emids.config.ConnectionProvider;
import com.emids.empDTO.City;
import com.emids.empDTO.Country;
import com.emids.empDTO.Department;
import com.emids.empDTO.State;

public class CommonDaoImpln implements EmpDao  {
	 
	public  List<Department> getAllDepartments(){  
	        List<Department> deptList  = new ArrayList<Department>();  
	        try{  
	        	
	            Connection con = ConnectionProvider.getConnection();  
	            Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from department");
	            while(rs.next()){
	            	
	            	int i = rs.getInt("Department_id");
					String str = rs.getString("Department_Name");
					
					Department  dept = new Department(i, str);  
	                deptList.add(dept);  
	            }  
	           
	        }catch(Exception e){
	        	System.out.println("error in getAllDepartment() " + e.getMessage());
	        	e.printStackTrace();}  
	          
	        return deptList;  
	    }  
	  
	  public List<State> getAllStates(){
		  List<State> stateList = new ArrayList<State>();
		  try{
			  Connection con = ConnectionProvider.getConnection();
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery("select * from state");
			  
			  while(rs.next()){
				  int i = rs.getInt("State_id");
				  String str = rs.getString("State_name");
				  
				  State state = new State(i, str);
				  stateList.add(state);
				  
			  }
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  return stateList;
	  }
	  
	  public List<Country> getAllCountries(){
		  List<Country> countryList = new ArrayList<Country>();
		  
		  try{
			  Connection con = ConnectionProvider.getConnection();
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery("select * from countries");
			  
			  while(rs.next()){
				  int i = rs.getInt("Country_id");
				  String str = rs.getString("Country_name");
				  
				  Country country = new Country(i, str);
				  countryList.add(country);
			  }
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  return countryList;
		  
	  }
	  
	  public List<City> getAllCities(){
		  List<City> cityList = new ArrayList<City>();
		  
		  try{
			  Connection con = ConnectionProvider.getConnection();
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery("select * from cities");
			  
			  while(rs.next()){
				  int i = rs.getInt("City_id");
				  String str = rs.getString("City_name");
				  
				  City city = new City(i, str);
				  cityList.add(city);
				  
			  }
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  return cityList;
		  
	  }

}

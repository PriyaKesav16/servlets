package com.emids.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emids.config.ConnectionProvider;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet(name = "AddEmpServlet", urlPatterns = { "/addEmployee" })
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		//System.out.println("inside post");
		
		String empName = request.getParameter("empName");
		int dept = Integer.parseInt(request.getParameter("empDept"));
		int basic = Integer.parseInt(request.getParameter("basic"));
		int hra = Integer.parseInt(request.getParameter("hra"));
		int splpay = Integer.parseInt(request.getParameter("splPay"));
		int total = Integer.parseInt(request.getParameter("total"));
		String street = request.getParameter("street");
		String area = request.getParameter("area");
		int city = Integer.parseInt(request.getParameter("city"));
		int state = Integer.parseInt(request.getParameter("state"));
		int country = Integer.parseInt(request.getParameter("country"));
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		
		try{  
			int insertedId = 0;
		
			Connection con=ConnectionProvider.getConnection();
			  
			PreparedStatement ps=con.prepareStatement("insert into employee (Emp_name, Dept_id) values(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);  
			  
			ps.setString(1,empName);  
			ps.setInt(2,dept);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
             if(rs.next())
             {
            	 insertedId = rs.getInt("Emp_id");
             }
             
             
             if(insertedId > 0){
     			PreparedStatement ps1=con.prepareStatement("insert into emp_sal (total_sal, basic, hra, special_pay, emp_id) values(?,?,?,?,?)");  
     			  
     			ps1.setInt(1,total);  
     			ps1.setInt(2,basic);
     			ps1.setInt(3,hra);
     			ps1.setInt(4,splpay);
     			ps1.setInt(5,insertedId);
     			ps1.executeUpdate();
     			ps1.close();
     			
     			PreparedStatement ps2 = con.prepareStatement("insert into emp_address (street, area, city_id, state_id, country_id, emp_id, pin_code) values(?,?,?,?,?,?,?)");  
     			  
     			ps2.setString(1,street);  
     			ps2.setString(2,area);
     			ps2.setInt(3,city);
     			ps2.setInt(4,state);
     			ps2.setInt(5,country);
     			ps2.setInt(6,insertedId);
     			ps2.setInt(7,pincode);
     			ps2.executeUpdate();
     			ps2.close();
     		}
     			ps.close();
     			con.close();
     			out.println("Saved Successfuly");
     			}
     		catch (SQLException e) { e.printStackTrace(); }
		}
		
	
	}



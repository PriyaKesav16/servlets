package com.emids.servlets;

import static com.emids.common.CommonConst.DEPT_ID;
import static com.emids.common.CommonConst.EMP_ID;
import static com.emids.common.CommonConst.EMP_NAME;
import static com.emids.common.CommonConst.MGR_ID;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emids.config.ConnectionProvider;
import com.emids.empDTO.Employee;

/**
 * Servlet implementation class ViewEmpServlet
 */
@WebServlet(name = "ViewEmpServlet", urlPatterns = { "/viewAllEmp" })
public class ViewEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * String str = "this is me"; char s[] = str.toCharArray(); int len =
		 * s.length;
		 * 
		 * int count = 1; for(int i = 0; i < len; i++ ){ if(s[i] == ' '){
		 * count++; } } System.out.println(count);
		 */
		List<Employee> empList = new ArrayList<Employee>();

		try {
			int total = 0;
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select sum(total_sal) as total_salary  from emp_sal");
			while (rs.next()) {
				total = rs.getInt("total_salary");
			}
			request.setAttribute("totalSal", total);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			// System.out.println(rs);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(EMP_ID));
				emp.setEmpName(rs.getString(EMP_NAME));
				emp.setDeptId(rs.getInt(DEPT_ID));
				emp.setMgrId(rs.getInt(MGR_ID));

				empList.add(emp);

			}
			String EmployeeNames = " ";
			for (Employee e : empList) {
				String s = e.getEmpName();
				EmployeeNames += s + ", ";

			}

			if (EmployeeNames.endsWith(", ")) {
				EmployeeNames = EmployeeNames.substring(0, EmployeeNames.length() - 2);

			}
			request.setAttribute("empNames", EmployeeNames);
			request.setAttribute("empList", empList);
			request.getRequestDispatcher("employee/viewAllEmployee.jsp").forward(request, response);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

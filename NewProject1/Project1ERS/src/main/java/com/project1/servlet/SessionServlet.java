package com.project1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.beans.Employee;

@WebServlet("/session")
public class SessionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//grab current session, if it exists
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if(session != null) {
			try {
				int empid = Integer.parseInt(session.getAttribute("empId").toString());
				String title = session.getAttribute("title").toString();
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				boolean ismanager = Boolean.parseBoolean(session.getAttribute("ismanager").toString());
				String phonenumber = session.getAttribute("phonenumber").toString();
				String address = session.getAttribute("address").toString();
				int zipcode = Integer.parseInt(session.getAttribute("zipcode").toString());
				int reportsto = Integer.parseInt(session.getAttribute("reportsto").toString());
				int age = Integer.parseInt(session.getAttribute("age").toString());
				Employee e = new Employee(empid, firstname, lastname, title, phonenumber, age, reportsto, address, zipcode, ismanager);
				String managedEmps=session.getAttribute("managedEmps").toString();
				//response.getWriter().write((new ObjectMapper()).writeValueAsString(managedEmps));
				response.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			}catch(Exception e) {
				response.getWriter().write("{\"session\":null}");
			}
		}else {
			response.getWriter().write("{\"session\":null}");
		}
	}
}
package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.AddressService;
import com.ajax.test.service.Impl.AddressSerivceImpl;
import com.google.gson.Gson;


@WebServlet(name="TestController",urlPatterns= {"/test/*"})
public class testController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressService as = new AddressSerivceImpl();
	private Gson g = new Gson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		
		  PrintWriter pw = response.getWriter();
		  //pw.print("[\"서울\",\"광주\",\"대전\",\"부산\"]");
		  
		  List<Map<String,String>> sidoList = as.selectSidoList(null);
		  //Map<String,String> sido = as.selectSido(sidoList);
		  pw.print(g.toJson(sidoList));
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

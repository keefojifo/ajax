package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.dao.OnkeyDAO;
import com.ajax.test.dao.Impl.OnkeyDAOImpl;
import com.google.gson.Gson;

@WebServlet(name = "FindController", urlPatterns = { "/onkey/*" })
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OnkeyDAO os = new OnkeyDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();

		List<String> findList = os.selectOnkeyList(null);
		System.out.println(findList);
		String id = request.getParameter("id");
		Gson g = new Gson();

		/*
		 * if(id==null) { pw.print(g.toJson(findList)); }else { List<String> TmpList =
		 * new ArrayList<String>(); for(int i=0; i<findList.size();i++) {
		 * if(findList.get(i).indexOf(id)== -1) {
		 * 
		 * TmpList.remove(TmpList.get(i)); } } System.out.println(g.toJson(TmpList)); }
		 * }
		 */

		if (id == null) {
			System.out.println(g.toJson(findList));
		} else {
			List<String> TmpList = new ArrayList<String>();

			for (int i = 0; i < findList.size(); i++) {
				if (findList.get(i).indexOf(id) != -1) {
					TmpList.add(findList.get(i));
				}
			}

			/*
			 * for (String str : findList) { if (str.indexOf(id) != -1) { TmpList.add(str);
			 * } }
			 */
			System.out.println(g.toJson(TmpList));
			pw.println(g.toJson(TmpList));
		}

	}

	// response.getWriter().append("Served at: ").append(request.getContextPath());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void main(String args[]) {
	
	}

}

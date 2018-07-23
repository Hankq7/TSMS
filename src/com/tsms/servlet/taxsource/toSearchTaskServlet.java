package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tax_SourceDaoImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class toSearchTaskServlet
 */
@WebServlet("/toSearchTaskServlet.action")
public class toSearchTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toSearchTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
       
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		String industryName = request.getParameter("industryName");
		String executeTime = request.getParameter("executeTime");
		String recordTaskDate = request.getParameter("recordTaskDate");
		String organName = request.getParameter("organName");
		Tax_SourceDaoImpl tsdi = new Tax_SourceDaoImpl();
		List<Map<String, String>> list = tsdi.getAllTax_Sources(Integer.parseInt(pageNo), Integer.parseInt(pageSize),payerCode,payerName,industryName,executeTime,recordTaskDate,organName);
		int count = tsdi.getAllTax_SourceByCount();
		JSONObject jsonObject = new JSONObject();
		if(list.size() < 0 || list == null){
			return;
		}
		jsonObject.put("rows", JSONArray.fromObject(list));
		jsonObject.put("total", count);
		response.getWriter().println(jsonObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

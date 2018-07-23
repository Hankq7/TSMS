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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class toGetAddTaskServlet
 */
@WebServlet("/toGetAddTaskServlet.action")
public class toGetAddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toGetAddTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String payerCode = request.getParameter("payerCode");
		List<Map<String, String>>  list = new Tax_SourceDaoImpl().getTax_SourceByPayerCode(payerCode);
		
		if(list.size()<0 || list == null){
			request.setAttribute("msg", "查无此号");
		}else{
			request.setAttribute("list", list.get(0));
		}
		request.getRequestDispatcher("manage/jsp/addTask.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

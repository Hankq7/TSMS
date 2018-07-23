package com.tsms.servlet.taxpayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tax_SourceDaoImpl;
import com.tsms.entity.Tax_Payer;
import com.tsms.entity.Tax_Source;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class payerAddTaskSaveServlet
 */
@WebServlet("/payerAddTaskSaveServlet.action")
public class payerAddTaskSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payerAddTaskSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String payerId = request.getParameter("payerId");
		String recordUserId = request.getParameter("recordUserId");
		String taskName = request.getParameter("taskName");
		String subOrganId = request.getParameter("subOrganId");
		String approverId = request.getParameter("approverId");
		String executeId = request.getParameter("executeId");
		String executeTime = request.getParameter("executeTime");
		String taskState = request.getParameter("taskState");
		
		Tax_Source ts = new Tax_Source(Integer.parseInt(payerId), taskName, Integer.parseInt(subOrganId), Integer.parseInt(approverId), Integer.parseInt(executeId), executeTime, taskState,Integer.parseInt(recordUserId));
		boolean b = new Tax_SourceDaoImpl().addTax_Source(ts);
		JSONObject jsonObject = new JSONObject();
		System.out.println(b);
		if(b){
			jsonObject.put("msg", "添加成功");
			jsonObject.put("success", true);
		}else{
			jsonObject.put("msg", "添加失败");
			jsonObject.put("success", false);
		}
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

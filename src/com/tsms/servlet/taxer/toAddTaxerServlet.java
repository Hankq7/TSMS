package com.tsms.servlet.taxer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxerDaoImpl;
import com.tsms.entity.Taxer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class toAddTaxerServlet
 */
@WebServlet("/toAddTaxerServlet.action")
public class toAddTaxerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toAddTaxerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String taxerCode = request.getParameter("taxerCode");
		String taxerName = request.getParameter("taxerName");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String organId = request.getParameter("organId");
		
		Taxer t = new Taxer(taxerCode, taxerName, mobile, address, sex, birthday, email, Integer.parseInt(organId));
		boolean b = new TaxerDaoImpl().updateTaxer(t);
		JSONObject jsonObject = new JSONObject();
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

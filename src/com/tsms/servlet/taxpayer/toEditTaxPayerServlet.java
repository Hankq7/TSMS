package com.tsms.servlet.taxpayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.Tax_PayerVODaoImpl;
import com.tsms.entity.Tax_Payer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class toEditTaxPayerServlet
 */
@WebServlet("/toEditTaxPayerServlet.action")
public class toEditTaxPayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toEditTaxPayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String id = request.getParameter("id");
		String payerName = request.getParameter("payerName");
		String bizAddress = request.getParameter("bizAddress");
		String bizAddressPhone = request.getParameter("bizAddressPhone");
		String taxOrganId = request.getParameter("taxOrganId");
		String industryId = request.getParameter("industryId");
		String bizScope = request.getParameter("bizScope");
		String invoiceType = request.getParameter("invoiceType");
		String legalPerson = request.getParameter("legalPerson");
		String legalIdCard = request.getParameter("legalIdCard");
		String finaceName = request.getParameter("finaceName");
		String finaceIdCard = request.getParameter("finaceIdCard");
		Tax_Payer tp = new Tax_Payer(Integer.parseInt(id), payerName, bizAddress, Integer.parseInt(taxOrganId), Integer.parseInt(industryId), bizScope, invoiceType, legalPerson, legalIdCard, finaceName, finaceIdCard, bizAddressPhone);
		JSONObject jsonObject = new JSONObject();
		boolean b = new Tax_PayerVODaoImpl().updateTax_PayerVOById(tp);
		System.out.println(b);
		if(b){
			jsonObject.put("msg", "修改成功");
			jsonObject.put("success", true);
		}else{
			jsonObject.put("msg", "修改成功");
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

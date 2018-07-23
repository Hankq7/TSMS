package com.tsms.servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsms.dao.impl.TaxerDaoImpl;
import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;

/**
 * Servlet implementation class toGetUserInfoServlet
 */
@WebServlet("/toGetUserInfoServlet.action")
public class toGetUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toGetUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
//		List<Map<String, String>> list= new UserDaoImpl().getUserById(username);
//		request.setAttribute("list", list.get(0));
//		if(list.size()<0 || list==null){
//		return;	
//		}
		request.getRequestDispatcher("manage/jsp/userInfo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

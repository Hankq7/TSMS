package com.tsms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class User_LoginServlet
 */
@WebServlet("/User_LoginServlet.do")
public class User_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		Object validate = request.getSession().getAttribute("validate");
		HttpSession session = request.getSession();
		JSONObject jsonObject = new JSONObject();
		if(validate.toString().equalsIgnoreCase(captcha)){
			User user = new UserDaoImpl().getUserByUsername(username);
			if(user != null){
				String pwd = EncryptUtil.encryptMD5(password+user.getSalt());
				if(pwd.equals(user.getPassword())){
					session.setAttribute("user", user);
					session.setAttribute("userId", user.getId());
					session.setAttribute("username", username);
					jsonObject.put("msg", "登陆成功！！！");
					jsonObject.put("success", true);
				}else{
					jsonObject.put("msg", "密码有误！！！");
					jsonObject.put("success", false);
				}
			}else{
				jsonObject.put("msg", "账号有误！！！");
				jsonObject.put("success", false);
			}
		}else{
			jsonObject.put("msg", "验证码有误！！！");
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

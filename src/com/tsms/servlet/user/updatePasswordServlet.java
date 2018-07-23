package com.tsms.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class updatePasswordServlet
 */
@WebServlet("/updatePasswordServlet.do")
public class updatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
	
		UserDaoImpl udi = new UserDaoImpl();
		User user = udi.getUserByUsername(username);
		String pwd = EncryptUtil.encryptMD5(oldPassword+user.getSalt());
		JSONObject jsonObject = new JSONObject();
		if(pwd.equals(user.getPassword())){
			String npwd = EncryptUtil.encryptMD5(newPassword+user.getSalt());
			boolean b = udi.updateUserPasswordByUsername(npwd,username);
			if(b){
				jsonObject.put("msg", "修改成功");
				jsonObject.put("success", true);
			}else{
				jsonObject.put("msg", "修改失败");
				jsonObject.put("success", false);
			}
		}else{
			jsonObject.put("msg", "原密码错误，请重新输入");
			jsonObject.put("success", false);
		}
		response.getWriter().print(jsonObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

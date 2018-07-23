package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.User;

public interface UserDao {

	/**
	 * 根据用户名获得一条数据
	 * @param username
	 * @return User 对象
	 */
	User getUserByUsername(String username);
	
	/**
	 * 根据用户名获得一条数据
	 * @param username
	 * @return list 集合
	 */
	List<Map<String,String>> getUser_TaxerByUsername(String username);
	
	/**
	 * 根据用户名修改密码
	 * @param username
	 * @return
	 */
	boolean updateUserPasswordByUsername(String password,String username);
	
}

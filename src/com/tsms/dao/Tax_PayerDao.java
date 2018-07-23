package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Tax_Payer;

public interface Tax_PayerDao {

	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getAllTax_PayerVOs(int pageNo, int pageSize,String payerCode,String payerName);
	
	/**
	 * 查询总记录条数
	 * @return
	 */
	int getAllTax_PayerVOByCount();
	
	/**
	 * 根据ID查询一条记录
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getTax_PayerVOById(int id);
	
	/**
	 * 根据ID删除一条记录（并没有从数据库删除只是修改字段removeState的数值来达到删除的效果 0为正常，1为删除）
	 * @param id
	 * @return
	 */
	boolean deleteTax_PayerVOById(int id);
	
	/**
	 * 根据ID修改一条记录
	 * @param id
	 * @return
	 */
	boolean updateTax_PayerVOById(Tax_Payer tp);
	
	/**
	 * 添加
	 * @param tp
	 * @return
	 */
	boolean updateTax_PayerVO(Tax_Payer tp);
}

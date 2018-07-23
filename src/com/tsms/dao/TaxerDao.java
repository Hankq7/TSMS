package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Taxer;

public interface TaxerDao {

	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getAllTaxers(int pageNo, int pageSize,String taxerName);
	
	/**
	 * 查询总记录条数
	 * @return
	 */
	int getAllTaxerByCount();
	
	/**
	 * 添加
	 * @param tp
	 * @return
	 */
	boolean updateTaxer(Taxer t);
	
	/**
	 * 根据ID查询一条记录
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getTaxerById(int id);
	
	/**
	 * 根据ID删除一条记录（并没有从数据库删除只是修改字段removeState的数值来达到删除的效果 0为正常，1为删除）
	 * @param id
	 * @return
	 */
	boolean deleteTaxerById(int id);
	
	/**
	 * 根据ID修改
	 * @param t
	 * @return
	 */
	boolean updateTaxerById(Taxer t);
}

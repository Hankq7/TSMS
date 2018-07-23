package com.tsms.dao;

import java.util.List;
import java.util.Map;

import com.tsms.entity.Tax_Source;

public interface Tax_SourceDao {

	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getAllTax_Sources(int pageNo, int pageSize,String payerCode,String payerName,String industryName,String executeTime,String recordTaskDate,String organName);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Map<String, String>> getNotInTax_Source(int pageNo, int pageSize,String payerCode,String payerName);
	
	/**
	 * 查询总记录条数
	 * @return
	 */
	int getAllTax_SourceByCount();
	
	/**
	 * 查询总记录条数
	 * @return
	 */
	int getNotInTax_SourceByCount();
	
	/**
	 * 根据ID查询一条记录
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getTax_SourceById(int id);
	
	/**
	 * 根据识别号查询一条记录
	 * @param id
	 * @return
	 */
	List<Map<String, String>> getTax_SourceByPayerCode(String payerCode);
	
	/**
	 * 根据ID修改一条记录
	 * @param ts
	 * @return
	 */
	boolean updateTax_SourceById(Tax_Source ts);
	
	/**
	 * 根据ID删除一条记录（并没有从数据库删除只是修改字段removeState的数值来达到删除的效果 0为正常，1为删除）
	 * @param id
	 * @return
	 */
	boolean deleteTax_SourceById(int id);
	
	/**
	 * 添加
	 * @param ts
	 * @return
	 */
	boolean addTax_Source(Tax_Source ts);
}

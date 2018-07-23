package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.Tax_PayerDao;
import com.tsms.entity.Tax_Payer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class Tax_PayerVODaoImpl implements Tax_PayerDao {

	private DBUtil db = DBUtil.getInstance();
	@Override
	public List<Map<String, String>> getAllTax_PayerVOs(int pageNo, int pageSize,String payerCode,String payerName) {
		List<Map<String, String>> list=null;
		if(StringUtil.isNotBlank(payerCode)){
			 list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0 and payerCode=? limit ?,?",payerCode,(pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isNotBlank(payerName)){
			 list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0  and payerName=? limit ?,?",payerName,(pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isNotBlank(payerCode) && StringUtil.isNotBlank(payerName)){
			 list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0 and payerCode=? and payerName=? limit ?,?",payerCode,payerName,(pageNo - 1)*pageSize,pageSize);

		}else if(StringUtil.isBlank(payerCode) && StringUtil.isBlank(payerName)){
			list = db.query("select * from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0  limit ?,?",(pageNo - 1)*pageSize,pageSize);
			
		}
		return list;
	}
	@Override
	public int getAllTax_PayerVOByCount() {
		List<Map<String, String>> list = db.query("select count(*) cou from tb_tax_payer p, tb_tax_organ o, tb_industry i, tb_user u where p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id and p.removeState=0");
		return Integer.parseInt(list.get(0).get("cou"));
	}
	@Override
	public List<Map<String, String>> getTax_PayerVOById(int id) {
		List<Map<String, String>> list = db.query("select p.id,p.payerCode,p.payerName,p.bizAddress,p.bizAddressPhone,p.taxOrganId,o.organName,p.industryId,i.industryName,p.bizScope,p.invoiceType,p.legalPerson,p.legalIdCard,p.finaceName,p.finaceIdCard,t.taxerName as tn,p.recordDate from tb_tax_payer p,tb_tax_organ o,tb_industry i,tb_taxer t where p.taxOrganId=o.id and p.industryId=i.id and o.leaderId=t.id and p.id=?", id);
		return list;
	}
	@Override
	public boolean deleteTax_PayerVOById(int id) {
		return db.update("update tb_tax_payer set removeState=1 where id = ?;", id);
	}
	@Override
	public boolean updateTax_PayerVOById(Tax_Payer tp) {
		String sql = "update tb_tax_payer set payerName=?,bizAddress=?,bizAddressPhone=?,taxOrganId=?,industryId=?,bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,finaceName=?,finaceIdCard=? where id =?";
		return db.update(sql, tp.getPayerName(),tp.getBizAddress(),tp.getBizAddressPhone(),tp.getTaxOrganId(),tp.getIndustryId(),tp.getBizScope(),tp.getInvoiceType(),tp.getLegalPerson(),tp.getLegalIdCard(),tp.getFinaceName(),tp.getFinaceIdCard(),tp.getId());
	}
	@Override
	public boolean updateTax_PayerVO(Tax_Payer tp) {
		String sql = "insert into tb_tax_payer(payerCode,payerName,bizAddress,bizAddressPhone,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,recordDate,userId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return db.update(sql, tp.getPayerCode(),tp.getPayerName(),tp.getBizAddress(),tp.getBizAddressPhone(),tp.getTaxOrganId(),tp.getIndustryId(),tp.getBizScope(),tp.getInvoiceType(),tp.getLegalPerson(),tp.getLegalIdCard(),tp.getFinaceName(),tp.getFinaceIdCard(),tp.getRecordDate(),tp.getUserId());
	}

	
	
}

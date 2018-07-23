package com.tsms.dao.impl;

import java.util.List;
import java.util.Map;

import com.tsms.dao.TaxerDao;
import com.tsms.entity.Taxer;
import com.tsms.util.DBUtil;
import com.tsms.util.StringUtil;

public class TaxerDaoImpl implements TaxerDao {

	private DBUtil db = DBUtil.getInstance();
	@Override
	public List<Map<String, String>> getAllTaxers(int pageNo, int pageSize,String taxerName) {
		List<Map<String, String>> list =null;
		if(StringUtil.isNotBlank(taxerName)){
			list = db.query("select * from tb_taxer where state=0 and taxerName=? limit ?,?",taxerName,(pageNo - 1)*pageSize,pageSize);
		}else if(StringUtil.isBlank(taxerName)){
			list = db.query("select * from tb_taxer where state=0 limit ?,?", (pageNo - 1)*pageSize,pageSize);
		}
		return list;
	}

	@Override
	public int getAllTaxerByCount() {
		List<Map<String, String>> list = db.query("select count(*) cou from tb_taxer where state=0");
		return Integer.parseInt(list.get(0).get("cou"));
	}

	@Override
	public boolean updateTaxer(Taxer t) {
		boolean b = db.update("insert into tb_taxer (taxerCode,taxerName,mobile,address,sex,birthday,email,organId) values(?,?,?,?,?,?,?,?)", t.getTaxerCode(),t.getTaxerName(),t.getMobile(),t.getAddress(),t.getSex(),t.getBirthday(),t.getEmail(),t.getOrganId());
		return b;
	}

	@Override
	public List<Map<String, String>> getTaxerById(int id) {
		List<Map<String, String>> list = db.query("select * from tb_taxer t,tb_tax_organ o where t.organId=o.id and t.state=0 and t.id =?", id);
		return list;
	}

	@Override
	public boolean deleteTaxerById(int id) {
		boolean b = db.update("update tb_taxer set state=1 where id=?", id);
		return b;
	}

	@Override
	public boolean updateTaxerById(Taxer t) {
		boolean b = db.update("update tb_taxer set taxerCode=?,taxerName=?,mobile=?,address=?,sex=?,birthday=?,email=?,organId=? where id=?", t.getTaxerCode(),t.getTaxerName(),t.getMobile(),t.getAddress(),t.getSex(),t.getBirthday(),t.getEmail(),t.getOrganId(),t.getId());
		return b;
	}



}

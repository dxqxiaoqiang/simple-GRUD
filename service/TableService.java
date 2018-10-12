package com.web.usr.service;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import com.app.home.base.SimpleDao;
import com.ssc.system.page.Page;
import com.web.lottery.entity.LotteryInfo;
import com.web.sysuser.entity.SystemUser;
import com.web.usr.entity.Table;
@Service
public class TableService {
	@Autowired
    private SimpleDao simpleDao;
//	  展示内容
//   需要判断查询的内容是否为空

	public Page<Table> findNotice(Page<Table>page ,Table table) {
		table.setCreateTimel(table.getCreateTimeStr());
		String sql= "select * from b_notice where 1=1";
		SqlParameterSource params = new BeanPropertySqlParameterSource(table);
		if(StringUtils.isNotBlank(table.getId())) {
			table.setId("%"+ table.getId()+"%");
           sql += " and id like :id";
          }
		page=simpleDao.queryAndPaging(sql, page, new BeanPropertyRowMapper<Table>(Table.class), params);
	    return page;
	}

	//获取视图的时候需要 
	public Table find(Table table) {
		String sql = "select * from b_notice t where t.id=:id";
        SqlParameterSource params = new BeanPropertySqlParameterSource(table);
        return simpleDao.queryForObject(sql, new BeanPropertyRowMapper<Table >(Table .class), params);
	}
	//增加内容
	public void  addTable(Table table){

		table.setCreateTimel(table.getCreateTimeStr());
		String sql="insert into b_notice(title,content,createTime,istohome)values(:title,:content,:createTime,:istohome)";
		 SqlParameterSource params = new BeanPropertySqlParameterSource(table);
	      simpleDao.update(sql,params);
	}
	//减少内容
	public void deleTable(Table table) {
		String sql ="delete from b_notice where id=:id";
		 SqlParameterSource params = new BeanPropertySqlParameterSource(table);
		 simpleDao.update(sql, params);
	}
	//更新内容 
	public void updateTable(Table table) {
		table.setCreateTimel(table.getCreateTimeStr());
		String sql = "update b_notice set title=:title,content=:content,createTime=:createTime,istohome=:istohome where id=:id";
	    SqlParameterSource params = new BeanPropertySqlParameterSource(table);
	    simpleDao.update(sql, params);
	}

}

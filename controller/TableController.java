package com.web.usr.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.ssc.system.page.Page;
import com.web.usr.entity.Table;
import com.web.usr.service.TableService;
@Controller
@RequestMapping("table")
public class TableController {
	 @Autowired
	 private TableService tableService;
	 
	 //展示空表格
	 @RequestMapping("/tableList")
	 public String noticeList() {
		 return "merchandise/home";
	 }
	 
	//获取到添加视图 跳转页面的框架
	  @RequestMapping("tableInsert")
	 public String insertTable(Table table, Model model){
	        if (table.getId() != null){
	        	table=tableService.find(table);  
	        }
	        model.addAttribute("table", table);
	        return "merchandise/tableInsert";
	    }

	//ajax请求接口 展示的数据都在这里包括查询
	 @RequestMapping("list")
	 @ResponseBody
	 public Page<Table> listNotice(Page<Table>page,Table table){
		 
		 tableService.findNotice(page, table); 
		return page;
	 } 
	
	 //增加
	 @RequestMapping("insertTable")
	 @ResponseBody
	 public JSONObject insertTable( Table table) {
     JSONObject fd = new JSONObject();
     if ( table.getId() != null && table.getId() !="" )//关键 
//     if (StringUtils.isNotBlank(table.getId()))
     {
    	 tableService.updateTable( table);
         fd.put("id",  table.getId());
     } else {
    	 tableService.addTable(table);
    	 
     }
     return fd;
 }
	
	 //减少
	 @RequestMapping("dele")
	 @ResponseBody
	 public JSONObject deleTable(Table table) {
		 tableService.deleTable(table);
		 JSONObject fd = new JSONObject();
	        return fd;
	 }

}

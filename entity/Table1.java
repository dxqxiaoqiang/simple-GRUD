package com.web.usr.entity;
import java.util.Date;
import com.ssc.base.utils.DateUtil;
public class Table1 {
	public String id;
	public String content;
	public String title;
	public String istohome;
	public Date createTime;
	private String createTimeStr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIstohome() {
		return istohome;
	}
	public void setIstohome(String istohome) {
		this.istohome = istohome;
	}
	//createTime
	 public String getCreateTimeStr(){
	        return createTimeStr;
	    }

    public void setCreateTimeStr(Date createTime){
        this.createTimeStr = DateUtil.format(createTime, "yyyy-MM-dd");
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeStr = DateUtil.format(createTime,"yyyy-MM-dd");
    }
	
	 public void setCreateTimel(String createTimeStr){
	        this.createTime = DateUtil.parse(createTimeStr, "yyyy-MM-dd");
	    }
}

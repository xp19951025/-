package com.xp.pojo;

import java.util.Arrays;

public class Cost {

	/**
	 * costId 费用编号
	 */
	private Integer costId;
	/**
	 * costName 费用名称
	 */
	private String costName;
	/**
	 * costIdDesc 费用描述
	 */
	private String costIdDesc;
	/**
	 * costIdMark 费用标识
	 */
	private String costIdMark;
	private String ck;
	private Integer[] ids;
	
	
	
	public String getCk() {
		ck="<input type='checkbox' name='ids' value='"+this.getCostId()+"'  />";
		return ck;
	}
	public void setCk(String ck) {
		
		this.ck = ck;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getCostIdDesc() {
		return costIdDesc;
	}
	public void setCostIdDesc(String costIdDesc) {
		this.costIdDesc = costIdDesc;
	}
	public String getCostIdMark() {
		return costIdMark;
	}
	public void setCostIdMark(String costIdMark) {
		this.costIdMark = costIdMark;
	}
	@Override
	public String toString() {
		return "Cost [costId=" + costId + ", costName=" + costName + ", costIdDesc=" + costIdDesc + ", costIdMark="
				+ costIdMark + ", ck=" + ck + ", ids=" + Arrays.toString(ids) + "]";
	}
	
	
	
}

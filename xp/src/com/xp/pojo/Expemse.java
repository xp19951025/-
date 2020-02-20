package com.xp.pojo;

import java.util.Arrays;
import java.util.Date;

public class Expemse {

	private Integer expemseId;//报销编号
	private Integer usersId;//用户编号
	private String expemseName;//报销名称
	private String expemseDesc;//报销描述
	private Float expemseToltel;//报销总金额
	private Date expemseDate;//报销时间
	private String expemseState;//报销状态
	private String expemseMark;//报销标识
	private String expemseMark2;//报销标识
	
	public String getExpemseMark2() {
		return expemseMark2;
	}
	public void setExpemseMark2(String expemseMark2) {
		this.expemseMark2 = expemseMark2;
	}


	//报销单的详细信息
	private Integer [] costIds;
	private String [] detailMoneys;
	private String [] detailDescs;
	private String  usersName;
	private String  auditSugg;
	private Date startDate;
	private Date endDate;
	private String updateUrl;
	
	
	
	
	public String getAuditSugg() {
		return auditSugg;
	}
	public void setAuditSugg(String auditSugg) {
		this.auditSugg = auditSugg;
	}
	public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer[] getCostIds() {
		return costIds;
	}
	public void setCostIds(Integer[] costIds) {
		this.costIds = costIds;
	}
	public String[] getDetailMoneys() {
		return detailMoneys;
	}
	public void setDetailMoneys(String[] detailMoneys) {
		this.detailMoneys = detailMoneys;
	}
	public String[] getDetailDescs() {
		return detailDescs;
	}
	public void setDetailDescs(String[] detailDescs) {
		this.detailDescs = detailDescs;
	}
	public Integer getExpemseId() {
		return expemseId;
	}
	public void setExpemseId(Integer expemseId) {
		this.expemseId = expemseId;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getExpemseName() {
		return expemseName;
	}
	public void setExpemseName(String expemseName) {
		this.expemseName = expemseName;
	}
	public String getExpemseDesc() {
		return expemseDesc;
	}
	public void setExpemseDesc(String expemseDesc) {
		this.expemseDesc = expemseDesc;
	}
	public Float getExpemseToltel() {
		return expemseToltel;
	}
	public void setExpemseToltel(Float expemseToltel) {
		this.expemseToltel = expemseToltel;
	}
	public Date getExpemseDate() {
		return expemseDate;
	}
	public void setExpemseDate(Date expemseDate) {
		this.expemseDate = expemseDate;
	}
	public String getExpemseState() {
		return expemseState;
	}
	public void setExpemseState(String expemseState) {
		this.expemseState = expemseState;
	}
	public String getExpemseMark() {
		return expemseMark;
	}
	public void setExpemseMark(String expemseMark) {
		this.expemseMark = expemseMark;
	}
	
	
	@Override
	public String toString() {
		return "Expemse [expemseId=" + expemseId + ", usersId=" + usersId + ", expemseName=" + expemseName
				+ ", expemseDesc=" + expemseDesc + ", expemseToltel=" + expemseToltel + ", expemseDate=" + expemseDate
				+ ", expemseState=" + expemseState + ", expemseMark=" + expemseMark + ", costIds="
				+ Arrays.toString(costIds) + ", detailMoneys=" + Arrays.toString(detailMoneys) + ", detailDescs="
				+ Arrays.toString(detailDescs) + ", usersName=" + usersName + ", auditSugg=" + auditSugg
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", updateUrl=" + updateUrl + "]";
	}
	
	
	
}

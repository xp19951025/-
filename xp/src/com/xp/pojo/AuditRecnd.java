package com.xp.pojo;

import java.util.Date;

public class AuditRecnd {

	private Integer auditId;
	private Integer expemseId;
	private Integer usersId;
	private String auditState;
	private String auditSugg;
	private Date auditDate;
	private String usersName;
	
	
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
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
	public String getAuditState() {
		return auditState;
	}
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	public String getAuditSugg() {
		return auditSugg;
	}
	public void setAuditSugg(String auditSugg) {
		this.auditSugg = auditSugg;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	
	@Override
	public String toString() {
		return "AuditRecnd [auditId=" + auditId + ", expemseId=" + expemseId + ", usersId=" + usersId + ", auditState="
				+ auditState + ", auditSugg=" + auditSugg + ", auditDate=" + auditDate + ", usersName=" + usersName
				+ "]";
	}
	
	
}

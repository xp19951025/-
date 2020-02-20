package com.xp.pojo;

import java.util.Date;

//薪资
public class Salary {

	private Integer salaryId;
	private Integer usersId;
	private Date salaryDate;
	private Date salaryMonth;
	private Float salaryBasic;
	private Float salaryComm;
	private String usersName;
	
	
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public Integer getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public Date getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(Date salaryDate) {
		this.salaryDate = salaryDate;
	}
	public Date getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(Date salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public Float getSalaryBasic() {
		return salaryBasic;
	}
	public void setSalaryBasic(Float salaryBasic) {
		this.salaryBasic = salaryBasic;
	}
	public Float getSalaryComm() {
		return salaryComm;
	}
	public void setSalaryComm(Float salaryComm) {
		this.salaryComm = salaryComm;
	}
	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", usersId=" + usersId + ", salaryDate=" + salaryDate + ", salaryMonth="
				+ salaryMonth + ", salaryBasic=" + salaryBasic + ", salaryComm=" + salaryComm + ", usersName="
				+ usersName + "]";
	}
	
	
}

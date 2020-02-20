package com.xp.pojo;

import java.util.Date;
//图形报表
public class SalaryChar {

	private Date salaryMonth;
	private Float salaryBasicTotal;
	private Float salaryCommTotal;
	
	public Date getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(Date salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public Float getSalaryBasicTotal() {
		return salaryBasicTotal;
	}
	public void setSalaryBasicTotal(Float salaryBasicTotal) {
		this.salaryBasicTotal = salaryBasicTotal;
	}
	public Float getSalaryCommTotal() {
		return salaryCommTotal;
	}
	public void setSalaryCommTotal(Float salaryCommTotal) {
		this.salaryCommTotal = salaryCommTotal;
	}
	@Override
	public String toString() {
		return "SalaryChar [salaryMonth=" + salaryMonth + ", salaryBasicTotal=" + salaryBasicTotal
				+ ", salaryCommTotal=" + salaryCommTotal + "]";
	}	

}

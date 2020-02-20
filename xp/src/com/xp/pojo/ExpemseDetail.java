package com.xp.pojo;

//报销明细
public class ExpemseDetail {

	private Integer detailId;
	private Integer expemseId;
	private Integer costId;
	private String detailDesc;
	private Float detailMoney;
	private String detailMark;
	private String costName;
	
	
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public Integer getExpemseId() {
		return expemseId;
	}
	public void setExpemseId(Integer expemseId) {
		this.expemseId = expemseId;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getDetailDesc() {
		return detailDesc;
	}
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}
	public Float getDetailMoney() {
		return detailMoney;
	}
	public void setDetailMoney(Float detailMoney) {
		this.detailMoney = detailMoney;
	}
	public String getDetailMark() {
		return detailMark;
	}
	public void setDetailMark(String detailMark) {
		this.detailMark = detailMark;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	
	@Override
	public String toString() {
		return "ExpemseDetail [detailId=" + detailId + ", expemseId=" + expemseId + ", costId=" + costId
				+ ", detailDesc=" + detailDesc + ", detailMoney=" + detailMoney + ", detailMark=" + detailMark
				+ ", costName=" + costName + "]";
	}
	
}

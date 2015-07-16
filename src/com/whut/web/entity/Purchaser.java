package com.whut.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchaser")
public class Purchaser extends BaseEntity {

	private static final long serialVersionUID = -558266817334853787L;

	private int id;
	private String name;
	private String IDcard;
	private String address;
	private boolean foreign;
	private String mobile;
	private String workunit;
	private String unitmobile;
	private String nowhousingnature;
	private Float nowhousearea;
	private Float familyincome;
	private String prehouseaddr;
	private Float prehousearea;
	private String prestandard;
	private String prehousetype;
	private String projectname;
	private String projectaddr;
	private String projectmobile;
	private Float pretotalloan;
	private Integer mortgageterm;
	private Float downpayment;
	private String preloanbank;
	private String bankaddr;
	private String bankphonel;
	private Float providentfund;
	private String remark;
	private String localcheck;
	private String lejucheck;
	private Date filldate;

	public Purchaser() {
		super();
	}

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIDcard() {
		return IDcard;
	}

	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isForeign() {
		return foreign;
	}

	public void setForeign(boolean foreign) {
		this.foreign = foreign;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWorkunit() {
		return workunit;
	}

	public void setWorkunit(String workunit) {
		this.workunit = workunit;
	}

	public String getUnitmobile() {
		return unitmobile;
	}

	public void setUnitmobile(String unitmobile) {
		this.unitmobile = unitmobile;
	}

	public String getNowhousingnature() {
		return nowhousingnature;
	}

	public void setNowhousingnature(String nowhousingnature) {
		this.nowhousingnature = nowhousingnature;
	}

	public Float getNowhousearea() {
		return nowhousearea;
	}

	public void setNowhousearea(Float nowhousearea) {
		this.nowhousearea = nowhousearea;
	}

	public Float getFamilyincome() {
		return familyincome;
	}

	public void setFamilyincome(Float familyincome) {
		this.familyincome = familyincome;
	}

	public String getPrehouseaddr() {
		return prehouseaddr;
	}

	public void setPrehouseaddr(String prehouseaddr) {
		this.prehouseaddr = prehouseaddr;
	}

	public Float getPrehousearea() {
		return prehousearea;
	}

	public void setPrehousearea(Float prehousearea) {
		this.prehousearea = prehousearea;
	}

	public String getPrestandard() {
		return prestandard;
	}

	public void setPrestandard(String prestandard) {
		this.prestandard = prestandard;
	}

	public String getPrehousetype() {
		return prehousetype;
	}

	public void setPrehousetype(String prehousetype) {
		this.prehousetype = prehousetype;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectaddr() {
		return projectaddr;
	}

	public void setProjectaddr(String projectaddr) {
		this.projectaddr = projectaddr;
	}

	public String getProjectmobile() {
		return projectmobile;
	}

	public void setProjectmobile(String projectmobile) {
		this.projectmobile = projectmobile;
	}

	public Float getPretotalloan() {
		return pretotalloan;
	}

	public void setPretotalloan(Float pretotalloan) {
		this.pretotalloan = pretotalloan;
	}

	public Integer getMortgageterm() {
		return mortgageterm;
	}

	public void setMortgageterm(Integer mortgageterm) {
		this.mortgageterm = mortgageterm;
	}

	public Float getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(Float downpayment) {
		this.downpayment = downpayment;
	}

	public String getPreloanbank() {
		return preloanbank;
	}

	public void setPreloanbank(String preloanbank) {
		this.preloanbank = preloanbank;
	}

	public String getBankaddr() {
		return bankaddr;
	}

	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public String getBankphonel() {
		return bankphonel;
	}

	public void setBankphonel(String bankphonel) {
		this.bankphonel = bankphonel;
	}

	public Float getProvidentfund() {
		return providentfund;
	}

	public void setProvidentfund(Float providentfund) {
		this.providentfund = providentfund;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLocalcheck() {
		return localcheck;
	}

	public void setLocalcheck(String localcheck) {
		this.localcheck = localcheck;
	}

	public String getLejucheck() {
		return lejucheck;
	}

	public void setLejucheck(String lejucheck) {
		this.lejucheck = lejucheck;
	}

	public Date getFilldate() {
		return filldate;
	}

	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}

}

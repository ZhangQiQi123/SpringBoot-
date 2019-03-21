package com.zqq.bean;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Product {

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pId;
	@Column(name="pname")
	private String pName;
	@Column(name="type")
	private String pType;
	@Column(name="price")
	private double price;
	//默认当前时间
	@Column(name="create_time")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Transient
	private Timestamp createTime;
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Product(Integer pId, String pName, String pType, double price, Timestamp createTime) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pType = pType;
		this.price = price;
		this.createTime = createTime;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pType=" + pType + ", price=" + price + ", createTime="
				+ createTime + "]";
	}

	
	
	
}

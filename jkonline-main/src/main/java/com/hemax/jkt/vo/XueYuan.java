/**
 * 
 */
package com.hemax.jkt.vo;

import java.util.Date;

/** 
 * 学员
 * created by quan.zhang@msxf.com
 */
public class XueYuan {
	private Integer id;
	private String name;
	private Integer age;
	private String cert;
	private String phone;
	private Integer step;//考试进行到哪一步
	private Integer access;//学员访问次数
	private Integer memo;//学员访问次数
	private Date time;//学员访问次数
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public Integer getAccess() {
		return access;
	}
	public void setAccess(Integer access) {
		this.access = access;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemo() {
		return memo;
	}
	public void setMemo(Integer memo) {
		this.memo = memo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}

package com.hemax.jkt.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the xueyuan database table.
 * 
 */
@Entity
@Table(name="xueyuan")
@NamedQuery(name="Xueyuan.findAll", query="SELECT x FROM Xueyuan x")
public class Xueyuan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private int access;

	private int age;

	private String cert;

	@Column(name="examin_four")
	private Date examinFour;

	@Column(name="examin_one")
	private Date examinOne;

	@Column(name="examin_three")
	private Date examinThree;

	@Column(name="examin_two")
	private Date examinTwo;

	private String memo;

	private String name;

	private String phone;

	private int step;
	
	private int sex;

	private Date time;

	public Xueyuan() {
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public Date getExaminFour() {
		return examinFour;
	}

	public void setExaminFour(Date examinFour) {
		this.examinFour = examinFour;
	}

	public Date getExaminOne() {
		return examinOne;
	}

	public void setExaminOne(Date examinOne) {
		this.examinOne = examinOne;
	}

	public Date getExaminThree() {
		return examinThree;
	}

	public void setExaminThree(Date examinThree) {
		this.examinThree = examinThree;
	}

	public Date getExaminTwo() {
		return examinTwo;
	}

	public void setExaminTwo(Date examinTwo) {
		this.examinTwo = examinTwo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	

	
}
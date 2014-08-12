/**
 * 
 */
package kr.cloudsc.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.admin.entity
 * AdminUser.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 11.
 * @Version : 
 */
@Entity
@Table(name="TB_ADMIN")
public class AdminUser implements Serializable{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="ADMIN_SEQ")
	private Long id;
	
	@Column(name="ADMIN_NM")
	private String name;
	
	@Column(name="CORP_NM")
	private String corpName;
	
	private String email;
	private String passwd;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DT", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updateTime = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DT", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date insertTime = new Date();
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCorpName() {
		return corpName;
	}



	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public Date getInsertTime() {
		return insertTime;
	}



	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	/**
	 * 
	 */
	public AdminUser() {
		this.insertTime = new Date();
		this.updateTime = new Date();
		
	}

}

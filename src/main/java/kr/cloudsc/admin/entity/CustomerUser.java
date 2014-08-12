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
 * CustomerUser.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 12.
 * @Version : 
 */
@Entity
@Table(name="tb_user")
public class CustomerUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CustomerUser() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="USER_SEQ")
	private Long id;
	
	@Column(name="PUBLIC_NM", length=100)
	private String publicNm;
	
	@Column(name="MOBILE_NUM", length=11)
	private String mobileNum;
	
	@Column(name="EMAIL", length=100)
	private String email;
	@Column(name="PASSWD", length=100)
	private String passwd;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DT", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updateTime = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DT", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date insertTime = new Date();
	
	@Column(name="STATUS", length=1)
	private char status;
	
	@Column(name="CHARGE_NM",length=100)
	private String chargeNm;
	
	@Column(name="GEAR_KIND", length=1)
	private String gearKind;
	
	@Column(name="GEAR_CNT", precision=0)
	private int gearCnt;
	
	@Column(name="SECRETKEY", length=100)
	private String secretkey;	
	@Column(name="AUTHCODE", length=100)
	private String authcode;
	@Column(name="USERTYPE", length=20)
	private String usertype;
	@Column(name="LOGIN_FAIL_CNT", precision=0)
	private int loginFailCnt;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPublicNm() {
		return publicNm;
	}
	public void setPublicNm(String publicNm) {
		this.publicNm = publicNm;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
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
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getChargeNm() {
		return chargeNm;
	}
	public void setChargeNm(String chargeNm) {
		this.chargeNm = chargeNm;
	}
	public String getGearKind() {
		return gearKind;
	}
	public void setGearKind(String gearKind) {
		this.gearKind = gearKind;
	}
	public int getGearCnt() {
		return gearCnt;
	}
	public void setGearCnt(int gearCnt) {
		this.gearCnt = gearCnt;
	}
	public String getSecretkey() {
		return secretkey;
	}
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}
	public String getAuthcode() {
		return authcode;
	}
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getLoginFailCnt() {
		return loginFailCnt;
	}
	public void setLoginFailCnt(int loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}
	
	
	
	
	
	
	
	
	

}

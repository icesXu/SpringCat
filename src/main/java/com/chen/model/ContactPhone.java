package com.chen.model;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 
 */

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017��6��8�� ����2:21:00
 */
public class ContactPhone {
	private String UUID;
	private String contactorName;
	private String companyName;
	private String relation;
	private String phoneNo;
	private String phoneType;
	private String phoneLocation;
	private String isEffect;
	private String callTimes;
	private String smsTimes;
	private String detectMessage;
	private String detectDate;
	private Date ADD_TIME;

	public static void main(String[] args) {
		Class<?> clazz = ContactPhone.class;
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.print(":t" + field.getName() + ",");
		}
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID
	 *            the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the contactorName
	 */
	public String getContactorName() {
		return contactorName;
	}

	/**
	 * @param contactorName
	 *            the contactorName to set
	 */
	public void setContactorName(String contactorName) {
		this.contactorName = contactorName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * @param relation
	 *            the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType
	 *            the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @return the phoneLocation
	 */
	public String getPhoneLocation() {
		return phoneLocation;
	}

	/**
	 * @param phoneLocation
	 *            the phoneLocation to set
	 */
	public void setPhoneLocation(String phoneLocation) {
		this.phoneLocation = phoneLocation;
	}

	/**
	 * @return the isEffect
	 */
	public String getIsEffect() {
		return isEffect;
	}

	/**
	 * @param isEffect
	 *            the isEffect to set
	 */
	public void setIsEffect(String isEffect) {
		this.isEffect = isEffect;
	}

	/**
	 * @return the callTimes
	 */
	public String getCallTimes() {
		return callTimes;
	}

	/**
	 * @param callTimes
	 *            the callTimes to set
	 */
	public void setCallTimes(String callTimes) {
		this.callTimes = callTimes;
	}

	/**
	 * @return the smsTimes
	 */
	public String getSmsTimes() {
		return smsTimes;
	}

	/**
	 * @param smsTimes
	 *            the smsTimes to set
	 */
	public void setSmsTimes(String smsTimes) {
		this.smsTimes = smsTimes;
	}

	/**
	 * @return the detectMessage
	 */
	public String getDetectMessage() {
		return detectMessage;
	}

	/**
	 * @param detectMessage
	 *            the detectMessage to set
	 */
	public void setDetectMessage(String detectMessage) {
		this.detectMessage = detectMessage;
	}

	/**
	 * @return the detectDate
	 */
	public String getDetectDate() {
		return detectDate;
	}

	/**
	 * @param detectDate
	 *            the detectDate to set
	 */
	public void setDetectDate(String detectDate) {
		this.detectDate = detectDate;
	}

	/**
	 * @return the aDD_TIME
	 */
	public Date getADD_TIME() {
		return ADD_TIME;
	}

	/**
	 * @param aDD_TIME
	 *            the aDD_TIME to set
	 */
	public void setADD_TIME(Date aDD_TIME) {
		ADD_TIME = aDD_TIME;
	}

}

package com.chen.model;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 
 */

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017��6��8�� ����2:35:57
 */
public class UrgeRecord {
	private String UUID;
	private String urgeUserName;
	private String contactorName;
	private String ifUrgePromise;
	private String phoneNum;
	private String urgeTime;
	private String nextUrgeTime;
	private String urgeType;
	private String callStatus;
	private String urgeStatus;
	private String callType;
	private String urgeDesc;
	private Date ADD_TIME;

	public static void main(String[] args) {
		Class<?> clazz = UrgeRecord.class;
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.print(field.getName() + ",");
		}

		System.out.println();
		for (Field field : declaredFields) {
			System.out.print(":t." + field.getName() + ",");
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
	 * @return the urgeUserName
	 */
	public String getUrgeUserName() {
		return urgeUserName;
	}

	/**
	 * @param urgeUserName
	 *            the urgeUserName to set
	 */
	public void setUrgeUserName(String urgeUserName) {
		this.urgeUserName = urgeUserName;
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
	 * @return the ifUrgePromise
	 */
	public String getIfUrgePromise() {
		return ifUrgePromise;
	}

	/**
	 * @param ifUrgePromise
	 *            the ifUrgePromise to set
	 */
	public void setIfUrgePromise(String ifUrgePromise) {
		this.ifUrgePromise = ifUrgePromise;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum
	 *            the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the urgeTime
	 */
	public String getUrgeTime() {
		return urgeTime;
	}

	/**
	 * @param urgeTime
	 *            the urgeTime to set
	 */
	public void setUrgeTime(String urgeTime) {
		this.urgeTime = urgeTime;
	}

	/**
	 * @return the nextUrgeTime
	 */
	public String getNextUrgeTime() {
		return nextUrgeTime;
	}

	/**
	 * @param nextUrgeTime
	 *            the nextUrgeTime to set
	 */
	public void setNextUrgeTime(String nextUrgeTime) {
		this.nextUrgeTime = nextUrgeTime;
	}

	/**
	 * @return the urgeType
	 */
	public String getUrgeType() {
		return urgeType;
	}

	/**
	 * @param urgeType
	 *            the urgeType to set
	 */
	public void setUrgeType(String urgeType) {
		this.urgeType = urgeType;
	}

	/**
	 * @return the callStatus
	 */
	public String getCallStatus() {
		return callStatus;
	}

	/**
	 * @param callStatus
	 *            the callStatus to set
	 */
	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	/**
	 * @return the urgeStatus
	 */
	public String getUrgeStatus() {
		return urgeStatus;
	}

	/**
	 * @param urgeStatus
	 *            the urgeStatus to set
	 */
	public void setUrgeStatus(String urgeStatus) {
		this.urgeStatus = urgeStatus;
	}

	/**
	 * @return the callType
	 */
	public String getCallType() {
		return callType;
	}

	/**
	 * @param callType
	 *            the callType to set
	 */
	public void setCallType(String callType) {
		this.callType = callType;
	}

	/**
	 * @return the urgeDesc
	 */
	public String getUrgeDesc() {
		return urgeDesc;
	}

	/**
	 * @param urgeDesc
	 *            the urgeDesc to set
	 */
	public void setUrgeDesc(String urgeDesc) {
		this.urgeDesc = urgeDesc;
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

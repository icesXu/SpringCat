package com.chen.model;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 
 */

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017��6��8�� ����2:32:07
 */
public class ContactAddress {
	private String UUID;
	private String contactorName;
	private String companyName;
	private String relation;
	private String address;
	private String isResolved;
	private String addressType;
	private String isAddrEffect;
	private String sendLetterTimes;
	private String visitTimes;
	private Date ADD_TIME;

	public static void main(String[] args) {
		Class<?> clazz = ContactAddress.class;
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.print("" + field.getName() + ",");
		}
		System.out.println("");
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the isResolved
	 */
	public String getIsResolved() {
		return isResolved;
	}

	/**
	 * @param isResolved
	 *            the isResolved to set
	 */
	public void setIsResolved(String isResolved) {
		this.isResolved = isResolved;
	}

	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType
	 *            the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the isAddrEffect
	 */
	public String getIsAddrEffect() {
		return isAddrEffect;
	}

	/**
	 * @param isAddrEffect
	 *            the isAddrEffect to set
	 */
	public void setIsAddrEffect(String isAddrEffect) {
		this.isAddrEffect = isAddrEffect;
	}

	/**
	 * @return the sendLetterTimes
	 */
	public String getSendLetterTimes() {
		return sendLetterTimes;
	}

	/**
	 * @param sendLetterTimes
	 *            the sendLetterTimes to set
	 */
	public void setSendLetterTimes(String sendLetterTimes) {
		this.sendLetterTimes = sendLetterTimes;
	}

	/**
	 * @return the visitTimes
	 */
	public String getVisitTimes() {
		return visitTimes;
	}

	/**
	 * @param visitTimes
	 *            the visitTimes to set
	 */
	public void setVisitTimes(String visitTimes) {
		this.visitTimes = visitTimes;
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

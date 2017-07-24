package com.chen.model;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 
 */

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017��6��8�� ����2:28:19
 */
public class BasicInfo {

	private String UUID;
	private String nationalCaseAmt;
	private String paidAmt;
	private String debtAmt;
	private String principleAmt;
	private String remainPrincipleAmt;
	private String interestAmt;
	private String penalty;
	private String latefeeAmt;
	private String overrunAmt;
	private String serviceAmt;
	private String minPaymentAmt;
	private String name;
	private String pinyin;
	private String shareDebitCount;
	private String customName;
	private String batchCode;
	private String entrustDate;
	private String identityCardNo;
	private String bankCardNo;
	private String caseArea;
	private String caseStatus;
	private String overDueAge;
	private String cardStopDate;
	private String urgeName;
	private String advanceReclaimDate;
	private String cardOwnerCompany;
	private String cardOwnerEmail;
	private String reclaimDate;
	private String billingDate;
	private String accountNo;
	private String issuingBank;
	private String issuingDate;
	private String lastPaidDate;
	private String lastPaidAmt;
	private String lastConsumeDate;
	private String lastWithdrawDate;
	private String creditLimit;
	private String caseNo;
	private String creditClass;
	private String handTimes;
	private String repaymentTime;
	private String billDeadlineDate;
	private String cardOwnerJob;
	private String commercialTenant;
	private String caseProduct;
	private String nextUrgeTime;
	private String urgeStatus;
	private String sex;
	private String censusAddress;
	private String caseLevel;
	private String cashedStatus;
	private String reclaimStatus;
	private String remark1;
	private String ADD_TIME;

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
	 * @return the nationalCaseAmt
	 */
	public String getNationalCaseAmt() {
		return nationalCaseAmt;
	}

	/**
	 * @param nationalCaseAmt
	 *            the nationalCaseAmt to set
	 */
	public void setNationalCaseAmt(String nationalCaseAmt) {
		this.nationalCaseAmt = nationalCaseAmt;
	}

	/**
	 * @return the paidAmt
	 */
	public String getPaidAmt() {
		return paidAmt;
	}

	/**
	 * @param paidAmt
	 *            the paidAmt to set
	 */
	public void setPaidAmt(String paidAmt) {
		this.paidAmt = paidAmt;
	}

	/**
	 * @return the debtAmt
	 */
	public String getDebtAmt() {
		return debtAmt;
	}

	/**
	 * @param debtAmt
	 *            the debtAmt to set
	 */
	public void setDebtAmt(String debtAmt) {
		this.debtAmt = debtAmt;
	}

	/**
	 * @return the principleAmt
	 */
	public String getPrincipleAmt() {
		return principleAmt;
	}

	/**
	 * @param principleAmt
	 *            the principleAmt to set
	 */
	public void setPrincipleAmt(String principleAmt) {
		this.principleAmt = principleAmt;
	}

	/**
	 * @return the remainPrincipleAmt
	 */
	public String getRemainPrincipleAmt() {
		return remainPrincipleAmt;
	}

	/**
	 * @param remainPrincipleAmt
	 *            the remainPrincipleAmt to set
	 */
	public void setRemainPrincipleAmt(String remainPrincipleAmt) {
		this.remainPrincipleAmt = remainPrincipleAmt;
	}

	/**
	 * @return the interestAmt
	 */
	public String getInterestAmt() {
		return interestAmt;
	}

	/**
	 * @param interestAmt
	 *            the interestAmt to set
	 */
	public void setInterestAmt(String interestAmt) {
		this.interestAmt = interestAmt;
	}

	/**
	 * @return the penalty
	 */
	public String getPenalty() {
		return penalty;
	}

	/**
	 * @param penalty
	 *            the penalty to set
	 */
	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	/**
	 * @return the latefeeAmt
	 */
	public String getLatefeeAmt() {
		return latefeeAmt;
	}

	/**
	 * @param latefeeAmt
	 *            the latefeeAmt to set
	 */
	public void setLatefeeAmt(String latefeeAmt) {
		this.latefeeAmt = latefeeAmt;
	}

	/**
	 * @return the overrunAmt
	 */
	public String getOverrunAmt() {
		return overrunAmt;
	}

	/**
	 * @param overrunAmt
	 *            the overrunAmt to set
	 */
	public void setOverrunAmt(String overrunAmt) {
		this.overrunAmt = overrunAmt;
	}

	/**
	 * @return the serviceAmt
	 */
	public String getServiceAmt() {
		return serviceAmt;
	}

	/**
	 * @param serviceAmt
	 *            the serviceAmt to set
	 */
	public void setServiceAmt(String serviceAmt) {
		this.serviceAmt = serviceAmt;
	}

	/**
	 * @return the minPaymentAmt
	 */
	public String getMinPaymentAmt() {
		return minPaymentAmt;
	}

	/**
	 * @param minPaymentAmt
	 *            the minPaymentAmt to set
	 */
	public void setMinPaymentAmt(String minPaymentAmt) {
		this.minPaymentAmt = minPaymentAmt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pinyin
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * @param pinyin
	 *            the pinyin to set
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * @return the shareDebitCount
	 */
	public String getShareDebitCount() {
		return shareDebitCount;
	}

	/**
	 * @param shareDebitCount
	 *            the shareDebitCount to set
	 */
	public void setShareDebitCount(String shareDebitCount) {
		this.shareDebitCount = shareDebitCount;
	}

	/**
	 * @return the customName
	 */
	public String getCustomName() {
		return customName;
	}

	/**
	 * @param customName
	 *            the customName to set
	 */
	public void setCustomName(String customName) {
		this.customName = customName;
	}

	/**
	 * @return the batchCode
	 */
	public String getBatchCode() {
		return batchCode;
	}

	/**
	 * @param batchCode
	 *            the batchCode to set
	 */
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	/**
	 * @return the entrustDate
	 */
	public String getEntrustDate() {
		return entrustDate;
	}

	/**
	 * @param entrustDate
	 *            the entrustDate to set
	 */
	public void setEntrustDate(String entrustDate) {
		this.entrustDate = entrustDate;
	}

	/**
	 * @return the identityCardNo
	 */
	public String getIdentityCardNo() {
		return identityCardNo;
	}

	/**
	 * @param identityCardNo
	 *            the identityCardNo to set
	 */
	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	/**
	 * @return the bankCardNo
	 */
	public String getBankCardNo() {
		return bankCardNo;
	}

	/**
	 * @param bankCardNo
	 *            the bankCardNo to set
	 */
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	/**
	 * @return the caseArea
	 */
	public String getCaseArea() {
		return caseArea;
	}

	/**
	 * @param caseArea
	 *            the caseArea to set
	 */
	public void setCaseArea(String caseArea) {
		this.caseArea = caseArea;
	}

	/**
	 * @return the caseStatus
	 */
	public String getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @param caseStatus
	 *            the caseStatus to set
	 */
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @return the overDueAge
	 */
	public String getOverDueAge() {
		return overDueAge;
	}

	/**
	 * @param overDueAge
	 *            the overDueAge to set
	 */
	public void setOverDueAge(String overDueAge) {
		this.overDueAge = overDueAge;
	}

	/**
	 * @return the cardStopDate
	 */
	public String getCardStopDate() {
		return cardStopDate;
	}

	/**
	 * @param cardStopDate
	 *            the cardStopDate to set
	 */
	public void setCardStopDate(String cardStopDate) {
		this.cardStopDate = cardStopDate;
	}

	/**
	 * @return the urgeName
	 */
	public String getUrgeName() {
		return urgeName;
	}

	/**
	 * @param urgeName
	 *            the urgeName to set
	 */
	public void setUrgeName(String urgeName) {
		this.urgeName = urgeName;
	}

	/**
	 * @return the advanceReclaimDate
	 */
	public String getAdvanceReclaimDate() {
		return advanceReclaimDate;
	}

	/**
	 * @param advanceReclaimDate
	 *            the advanceReclaimDate to set
	 */
	public void setAdvanceReclaimDate(String advanceReclaimDate) {
		this.advanceReclaimDate = advanceReclaimDate;
	}

	/**
	 * @return the cardOwnerCompany
	 */
	public String getCardOwnerCompany() {
		return cardOwnerCompany;
	}

	/**
	 * @param cardOwnerCompany
	 *            the cardOwnerCompany to set
	 */
	public void setCardOwnerCompany(String cardOwnerCompany) {
		this.cardOwnerCompany = cardOwnerCompany;
	}

	/**
	 * @return the cardOwnerEmail
	 */
	public String getCardOwnerEmail() {
		return cardOwnerEmail;
	}

	/**
	 * @param cardOwnerEmail
	 *            the cardOwnerEmail to set
	 */
	public void setCardOwnerEmail(String cardOwnerEmail) {
		this.cardOwnerEmail = cardOwnerEmail;
	}

	/**
	 * @return the reclaimDate
	 */
	public String getReclaimDate() {
		return reclaimDate;
	}

	/**
	 * @param reclaimDate
	 *            the reclaimDate to set
	 */
	public void setReclaimDate(String reclaimDate) {
		this.reclaimDate = reclaimDate;
	}

	/**
	 * @return the billingDate
	 */
	public String getBillingDate() {
		return billingDate;
	}

	/**
	 * @param billingDate
	 *            the billingDate to set
	 */
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the issuingBank
	 */
	public String getIssuingBank() {
		return issuingBank;
	}

	/**
	 * @param issuingBank
	 *            the issuingBank to set
	 */
	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	/**
	 * @return the issuingDate
	 */
	public String getIssuingDate() {
		return issuingDate;
	}

	/**
	 * @param issuingDate
	 *            the issuingDate to set
	 */
	public void setIssuingDate(String issuingDate) {
		this.issuingDate = issuingDate;
	}

	/**
	 * @return the lastPaidDate
	 */
	public String getLastPaidDate() {
		return lastPaidDate;
	}

	/**
	 * @param lastPaidDate
	 *            the lastPaidDate to set
	 */
	public void setLastPaidDate(String lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}

	/**
	 * @return the lastPaidAmt
	 */
	public String getLastPaidAmt() {
		return lastPaidAmt;
	}

	/**
	 * @param lastPaidAmt
	 *            the lastPaidAmt to set
	 */
	public void setLastPaidAmt(String lastPaidAmt) {
		this.lastPaidAmt = lastPaidAmt;
	}

	/**
	 * @return the lastConsumeDate
	 */
	public String getLastConsumeDate() {
		return lastConsumeDate;
	}

	/**
	 * @param lastConsumeDate
	 *            the lastConsumeDate to set
	 */
	public void setLastConsumeDate(String lastConsumeDate) {
		this.lastConsumeDate = lastConsumeDate;
	}

	/**
	 * @return the lastWithdrawDate
	 */
	public String getLastWithdrawDate() {
		return lastWithdrawDate;
	}

	/**
	 * @param lastWithdrawDate
	 *            the lastWithdrawDate to set
	 */
	public void setLastWithdrawDate(String lastWithdrawDate) {
		this.lastWithdrawDate = lastWithdrawDate;
	}

	/**
	 * @return the creditLimit
	 */
	public String getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit
	 *            the creditLimit to set
	 */
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return the caseNo
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @param caseNo
	 *            the caseNo to set
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @return the creditClass
	 */
	public String getCreditClass() {
		return creditClass;
	}

	/**
	 * @param creditClass
	 *            the creditClass to set
	 */
	public void setCreditClass(String creditClass) {
		this.creditClass = creditClass;
	}

	/**
	 * @return the handTimes
	 */
	public String getHandTimes() {
		return handTimes;
	}

	/**
	 * @param handTimes
	 *            the handTimes to set
	 */
	public void setHandTimes(String handTimes) {
		this.handTimes = handTimes;
	}

	/**
	 * @return the repaymentTime
	 */
	public String getRepaymentTime() {
		return repaymentTime;
	}

	/**
	 * @param repaymentTime
	 *            the repaymentTime to set
	 */
	public void setRepaymentTime(String repaymentTime) {
		this.repaymentTime = repaymentTime;
	}

	/**
	 * @return the billDeadlineDate
	 */
	public String getBillDeadlineDate() {
		return billDeadlineDate;
	}

	/**
	 * @param billDeadlineDate
	 *            the billDeadlineDate to set
	 */
	public void setBillDeadlineDate(String billDeadlineDate) {
		this.billDeadlineDate = billDeadlineDate;
	}

	/**
	 * @return the cardOwnerJob
	 */
	public String getCardOwnerJob() {
		return cardOwnerJob;
	}

	/**
	 * @param cardOwnerJob
	 *            the cardOwnerJob to set
	 */
	public void setCardOwnerJob(String cardOwnerJob) {
		this.cardOwnerJob = cardOwnerJob;
	}

	/**
	 * @return the commercialTenant
	 */
	public String getCommercialTenant() {
		return commercialTenant;
	}

	/**
	 * @param commercialTenant
	 *            the commercialTenant to set
	 */
	public void setCommercialTenant(String commercialTenant) {
		this.commercialTenant = commercialTenant;
	}

	/**
	 * @return the caseProduct
	 */
	public String getCaseProduct() {
		return caseProduct;
	}

	/**
	 * @param caseProduct
	 *            the caseProduct to set
	 */
	public void setCaseProduct(String caseProduct) {
		this.caseProduct = caseProduct;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the censusAddress
	 */
	public String getCensusAddress() {
		return censusAddress;
	}

	/**
	 * @param censusAddress
	 *            the censusAddress to set
	 */
	public void setCensusAddress(String censusAddress) {
		this.censusAddress = censusAddress;
	}

	/**
	 * @return the caseLevel
	 */
	public String getCaseLevel() {
		return caseLevel;
	}

	/**
	 * @param caseLevel
	 *            the caseLevel to set
	 */
	public void setCaseLevel(String caseLevel) {
		this.caseLevel = caseLevel;
	}

	/**
	 * @return the cashedStatus
	 */
	public String getCashedStatus() {
		return cashedStatus;
	}

	/**
	 * @param cashedStatus
	 *            the cashedStatus to set
	 */
	public void setCashedStatus(String cashedStatus) {
		this.cashedStatus = cashedStatus;
	}

	/**
	 * @return the reclaimStatus
	 */
	public String getReclaimStatus() {
		return reclaimStatus;
	}

	/**
	 * @param reclaimStatus
	 *            the reclaimStatus to set
	 */
	public void setReclaimStatus(String reclaimStatus) {
		this.reclaimStatus = reclaimStatus;
	}

	/**
	 * @return the remark1
	 */
	public String getRemark1() {
		return remark1;
	}

	/**
	 * @param remark1
	 *            the remark1 to set
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	/**
	 * @return the aDD_TIME
	 */
	public String getADD_TIME() {
		return ADD_TIME;
	}

	/**
	 * @param aDD_TIME
	 *            the aDD_TIME to set
	 */
	public void setADD_TIME(String aDD_TIME) {
		ADD_TIME = aDD_TIME;
	}

	public static void main(String[] args) throws Exception {
		// File file = new File(
		// "C:\\Users\\YYZYHC\\Desktop\\yiliangcuishou_basicinfo_copy.sql");
		// List<String> lines = FileUtils.readLines(file);
		// for (String line : lines) {
		// if (line.contains("DEFAULT")) {
		// int index1 = line.indexOf("`");
		// int index2 = line.indexOf("` ");
		// if (index1 >= 0 && index2 >= 0) {
		// String text = line.substring(index1 + 1, index2);
		// System.out.println("private String " + text + ";");
		// }
		// }
		// }

		Class<?> clazz = BasicInfo.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.print(field.getName() + ",");
		}
		System.out.println();
		for (Field field : fields) {
			System.out.print(":t." + field.getName() + ",");
		}
	}
}

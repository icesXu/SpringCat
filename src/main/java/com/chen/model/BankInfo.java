package com.chen.model;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 
 */

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017��6��8�� ����2:39:11
 */
public class BankInfo {
	private String UUID;
	private String serialNumber;
	private String entrustDate;
	private String nationalCaseAmt;
	private String RMB;
	private String HKD;
	private String USD;
	private String sex;
	private String name;
	private String bankCardNo;
	private String identityCardNo;
	private String urgeId;
	private String M;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private String email;
	private String provinceId;
	private String cityId;
	private String districtId;
	private String postCode;
	private String advanceReclaimDate;
	private String cardStopDate;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	private String remark5;
	private String remark6;
	private String caseProduct;
	private String commercialTenant;
	private String fileNumber;
	private String issuingBank;
	private String accountNo;
	private String cardType;
	private String principleAmt;
	private String minPaymentAmt;
	private String creditLimit;
	private String defaultLevel;
	private String lastPaidDate;
	private String lastPaidAmt;
	private String lastConsumeDate;
	private String lastWithdrawDate;
	private String billDeadlineDate;
	private String issuingDate;
	private String repaymentTime;
	private String creditClass;
	private String urgeType;
	private String overdraftInterest;
	private String latefeeAmt;
	private String margin;
	private String currency;
	private String oriUrgeRecord;
	private String overdueTime;
	private String companyName;
	private String cardOwnerPosition;
	private String cardOwnerBranch;
	private String companyAddr;
	private String homeAddr;
	private String bankStatementAddr;
	private String permanentAddr;
	private String contacts1Name;
	private String contacts1CardNumber;
	private String contacts1Relation;
	private String contacts1Phone;
	private String contacts1CellPhone;
	private String contacts1Addr;
	private String contacts1Company;
	private String contacts2Name;
	private String contacts2CardNumber;
	private String contacts2Relation;
	private String contacts2Phone;
	private String contacts2CellPhone;
	private String contacts2Addr;
	private String contacts2Company;
	private String contacts3Name;
	private String contacts3CardNumber;
	private String contacts3Relation;
	private String contacts3Phone;
	private String contacts3CellPhone;
	private String contacts3Addr;
	private String contacts3Company;
	private String contacts4Name;
	private String contacts4CardNumber;
	private String contacts4Relation;
	private String contacts4Phone;
	private String contacts4CellPhone;
	private String contacts4Addr;
	private String contacts4Company;
	private String performancePoint;
	private String taskPoint;
	private String caseType;
	private Date ADD_TIME;

	

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
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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
	 * @return the rMB
	 */
	public String getRMB() {
		return RMB;
	}

	/**
	 * @param rMB
	 *            the rMB to set
	 */
	public void setRMB(String rMB) {
		RMB = rMB;
	}

	/**
	 * @return the hKD
	 */
	public String getHKD() {
		return HKD;
	}

	/**
	 * @param hKD
	 *            the hKD to set
	 */
	public void setHKD(String hKD) {
		HKD = hKD;
	}

	/**
	 * @return the uSD
	 */
	public String getUSD() {
		return USD;
	}

	/**
	 * @param uSD
	 *            the uSD to set
	 */
	public void setUSD(String uSD) {
		USD = uSD;
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
	 * @return the urgeId
	 */
	public String getUrgeId() {
		return urgeId;
	}

	/**
	 * @param urgeId
	 *            the urgeId to set
	 */
	public void setUrgeId(String urgeId) {
		this.urgeId = urgeId;
	}

	/**
	 * @return the m
	 */
	public String getM() {
		return M;
	}

	/**
	 * @param m
	 *            the m to set
	 */
	public void setM(String m) {
		M = m;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}

	/**
	 * @param workPhone
	 *            the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone
	 *            the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the provinceId
	 */
	public String getProvinceId() {
		return provinceId;
	}

	/**
	 * @param provinceId
	 *            the provinceId to set
	 */
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the districtId
	 */
	public String getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId
	 *            the districtId to set
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 *            the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * @return the remark2
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * @param remark2
	 *            the remark2 to set
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * @return the remark3
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * @param remark3
	 *            the remark3 to set
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * @return the remark4
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * @param remark4
	 *            the remark4 to set
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * @return the remark5
	 */
	public String getRemark5() {
		return remark5;
	}

	/**
	 * @param remark5
	 *            the remark5 to set
	 */
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	/**
	 * @return the remark6
	 */
	public String getRemark6() {
		return remark6;
	}

	/**
	 * @param remark6
	 *            the remark6 to set
	 */
	public void setRemark6(String remark6) {
		this.remark6 = remark6;
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
	 * @return the fileNumber
	 */
	public String getFileNumber() {
		return fileNumber;
	}

	/**
	 * @param fileNumber
	 *            the fileNumber to set
	 */
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
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
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
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
	 * @return the defaultLevel
	 */
	public String getDefaultLevel() {
		return defaultLevel;
	}

	/**
	 * @param defaultLevel
	 *            the defaultLevel to set
	 */
	public void setDefaultLevel(String defaultLevel) {
		this.defaultLevel = defaultLevel;
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
	 * @return the overdraftInterest
	 */
	public String getOverdraftInterest() {
		return overdraftInterest;
	}

	/**
	 * @param overdraftInterest
	 *            the overdraftInterest to set
	 */
	public void setOverdraftInterest(String overdraftInterest) {
		this.overdraftInterest = overdraftInterest;
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
	 * @return the margin
	 */
	public String getMargin() {
		return margin;
	}

	/**
	 * @param margin
	 *            the margin to set
	 */
	public void setMargin(String margin) {
		this.margin = margin;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the oriUrgeRecord
	 */
	public String getOriUrgeRecord() {
		return oriUrgeRecord;
	}

	/**
	 * @param oriUrgeRecord
	 *            the oriUrgeRecord to set
	 */
	public void setOriUrgeRecord(String oriUrgeRecord) {
		this.oriUrgeRecord = oriUrgeRecord;
	}

	/**
	 * @return the overdueTime
	 */
	public String getOverdueTime() {
		return overdueTime;
	}

	/**
	 * @param overdueTime
	 *            the overdueTime to set
	 */
	public void setOverdueTime(String overdueTime) {
		this.overdueTime = overdueTime;
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
	 * @return the cardOwnerPosition
	 */
	public String getCardOwnerPosition() {
		return cardOwnerPosition;
	}

	/**
	 * @param cardOwnerPosition
	 *            the cardOwnerPosition to set
	 */
	public void setCardOwnerPosition(String cardOwnerPosition) {
		this.cardOwnerPosition = cardOwnerPosition;
	}

	/**
	 * @return the cardOwnerBranch
	 */
	public String getCardOwnerBranch() {
		return cardOwnerBranch;
	}

	/**
	 * @param cardOwnerBranch
	 *            the cardOwnerBranch to set
	 */
	public void setCardOwnerBranch(String cardOwnerBranch) {
		this.cardOwnerBranch = cardOwnerBranch;
	}

	/**
	 * @return the companyAddr
	 */
	public String getCompanyAddr() {
		return companyAddr;
	}

	/**
	 * @param companyAddr
	 *            the companyAddr to set
	 */
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	/**
	 * @return the homeAddr
	 */
	public String getHomeAddr() {
		return homeAddr;
	}

	/**
	 * @param homeAddr
	 *            the homeAddr to set
	 */
	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	/**
	 * @return the bankStatementAddr
	 */
	public String getBankStatementAddr() {
		return bankStatementAddr;
	}

	/**
	 * @param bankStatementAddr
	 *            the bankStatementAddr to set
	 */
	public void setBankStatementAddr(String bankStatementAddr) {
		this.bankStatementAddr = bankStatementAddr;
	}

	/**
	 * @return the permanentAddr
	 */
	public String getPermanentAddr() {
		return permanentAddr;
	}

	/**
	 * @param permanentAddr
	 *            the permanentAddr to set
	 */
	public void setPermanentAddr(String permanentAddr) {
		this.permanentAddr = permanentAddr;
	}

	/**
	 * @return the contacts1Name
	 */
	public String getContacts1Name() {
		return contacts1Name;
	}

	/**
	 * @param contacts1Name
	 *            the contacts1Name to set
	 */
	public void setContacts1Name(String contacts1Name) {
		this.contacts1Name = contacts1Name;
	}

	/**
	 * @return the contacts1CardNumber
	 */
	public String getContacts1CardNumber() {
		return contacts1CardNumber;
	}

	/**
	 * @param contacts1CardNumber
	 *            the contacts1CardNumber to set
	 */
	public void setContacts1CardNumber(String contacts1CardNumber) {
		this.contacts1CardNumber = contacts1CardNumber;
	}

	/**
	 * @return the contacts1Relation
	 */
	public String getContacts1Relation() {
		return contacts1Relation;
	}

	/**
	 * @param contacts1Relation
	 *            the contacts1Relation to set
	 */
	public void setContacts1Relation(String contacts1Relation) {
		this.contacts1Relation = contacts1Relation;
	}

	/**
	 * @return the contacts1Phone
	 */
	public String getContacts1Phone() {
		return contacts1Phone;
	}

	/**
	 * @param contacts1Phone
	 *            the contacts1Phone to set
	 */
	public void setContacts1Phone(String contacts1Phone) {
		this.contacts1Phone = contacts1Phone;
	}

	/**
	 * @return the contacts1CellPhone
	 */
	public String getContacts1CellPhone() {
		return contacts1CellPhone;
	}

	/**
	 * @param contacts1CellPhone
	 *            the contacts1CellPhone to set
	 */
	public void setContacts1CellPhone(String contacts1CellPhone) {
		this.contacts1CellPhone = contacts1CellPhone;
	}

	/**
	 * @return the contacts1Addr
	 */
	public String getContacts1Addr() {
		return contacts1Addr;
	}

	/**
	 * @param contacts1Addr
	 *            the contacts1Addr to set
	 */
	public void setContacts1Addr(String contacts1Addr) {
		this.contacts1Addr = contacts1Addr;
	}

	/**
	 * @return the contacts1Company
	 */
	public String getContacts1Company() {
		return contacts1Company;
	}

	/**
	 * @param contacts1Company
	 *            the contacts1Company to set
	 */
	public void setContacts1Company(String contacts1Company) {
		this.contacts1Company = contacts1Company;
	}

	/**
	 * @return the contacts2Name
	 */
	public String getContacts2Name() {
		return contacts2Name;
	}

	/**
	 * @param contacts2Name
	 *            the contacts2Name to set
	 */
	public void setContacts2Name(String contacts2Name) {
		this.contacts2Name = contacts2Name;
	}

	/**
	 * @return the contacts2CardNumber
	 */
	public String getContacts2CardNumber() {
		return contacts2CardNumber;
	}

	/**
	 * @param contacts2CardNumber
	 *            the contacts2CardNumber to set
	 */
	public void setContacts2CardNumber(String contacts2CardNumber) {
		this.contacts2CardNumber = contacts2CardNumber;
	}

	/**
	 * @return the contacts2Relation
	 */
	public String getContacts2Relation() {
		return contacts2Relation;
	}

	/**
	 * @param contacts2Relation
	 *            the contacts2Relation to set
	 */
	public void setContacts2Relation(String contacts2Relation) {
		this.contacts2Relation = contacts2Relation;
	}

	/**
	 * @return the contacts2Phone
	 */
	public String getContacts2Phone() {
		return contacts2Phone;
	}

	/**
	 * @param contacts2Phone
	 *            the contacts2Phone to set
	 */
	public void setContacts2Phone(String contacts2Phone) {
		this.contacts2Phone = contacts2Phone;
	}

	/**
	 * @return the contacts2CellPhone
	 */
	public String getContacts2CellPhone() {
		return contacts2CellPhone;
	}

	/**
	 * @param contacts2CellPhone
	 *            the contacts2CellPhone to set
	 */
	public void setContacts2CellPhone(String contacts2CellPhone) {
		this.contacts2CellPhone = contacts2CellPhone;
	}

	/**
	 * @return the contacts2Addr
	 */
	public String getContacts2Addr() {
		return contacts2Addr;
	}

	/**
	 * @param contacts2Addr
	 *            the contacts2Addr to set
	 */
	public void setContacts2Addr(String contacts2Addr) {
		this.contacts2Addr = contacts2Addr;
	}

	/**
	 * @return the contacts2Company
	 */
	public String getContacts2Company() {
		return contacts2Company;
	}

	/**
	 * @param contacts2Company
	 *            the contacts2Company to set
	 */
	public void setContacts2Company(String contacts2Company) {
		this.contacts2Company = contacts2Company;
	}

	/**
	 * @return the contacts3Name
	 */
	public String getContacts3Name() {
		return contacts3Name;
	}

	/**
	 * @param contacts3Name
	 *            the contacts3Name to set
	 */
	public void setContacts3Name(String contacts3Name) {
		this.contacts3Name = contacts3Name;
	}

	/**
	 * @return the contacts3CardNumber
	 */
	public String getContacts3CardNumber() {
		return contacts3CardNumber;
	}

	/**
	 * @param contacts3CardNumber
	 *            the contacts3CardNumber to set
	 */
	public void setContacts3CardNumber(String contacts3CardNumber) {
		this.contacts3CardNumber = contacts3CardNumber;
	}

	/**
	 * @return the contacts3Relation
	 */
	public String getContacts3Relation() {
		return contacts3Relation;
	}

	/**
	 * @param contacts3Relation
	 *            the contacts3Relation to set
	 */
	public void setContacts3Relation(String contacts3Relation) {
		this.contacts3Relation = contacts3Relation;
	}

	/**
	 * @return the contacts3Phone
	 */
	public String getContacts3Phone() {
		return contacts3Phone;
	}

	/**
	 * @param contacts3Phone
	 *            the contacts3Phone to set
	 */
	public void setContacts3Phone(String contacts3Phone) {
		this.contacts3Phone = contacts3Phone;
	}

	/**
	 * @return the contacts3CellPhone
	 */
	public String getContacts3CellPhone() {
		return contacts3CellPhone;
	}

	/**
	 * @param contacts3CellPhone
	 *            the contacts3CellPhone to set
	 */
	public void setContacts3CellPhone(String contacts3CellPhone) {
		this.contacts3CellPhone = contacts3CellPhone;
	}

	/**
	 * @return the contacts3Addr
	 */
	public String getContacts3Addr() {
		return contacts3Addr;
	}

	/**
	 * @param contacts3Addr
	 *            the contacts3Addr to set
	 */
	public void setContacts3Addr(String contacts3Addr) {
		this.contacts3Addr = contacts3Addr;
	}

	/**
	 * @return the contacts3Company
	 */
	public String getContacts3Company() {
		return contacts3Company;
	}

	/**
	 * @param contacts3Company
	 *            the contacts3Company to set
	 */
	public void setContacts3Company(String contacts3Company) {
		this.contacts3Company = contacts3Company;
	}

	/**
	 * @return the contacts4Name
	 */
	public String getContacts4Name() {
		return contacts4Name;
	}

	/**
	 * @param contacts4Name
	 *            the contacts4Name to set
	 */
	public void setContacts4Name(String contacts4Name) {
		this.contacts4Name = contacts4Name;
	}

	/**
	 * @return the contacts4CardNumber
	 */
	public String getContacts4CardNumber() {
		return contacts4CardNumber;
	}

	/**
	 * @param contacts4CardNumber
	 *            the contacts4CardNumber to set
	 */
	public void setContacts4CardNumber(String contacts4CardNumber) {
		this.contacts4CardNumber = contacts4CardNumber;
	}

	/**
	 * @return the contacts4Relation
	 */
	public String getContacts4Relation() {
		return contacts4Relation;
	}

	/**
	 * @param contacts4Relation
	 *            the contacts4Relation to set
	 */
	public void setContacts4Relation(String contacts4Relation) {
		this.contacts4Relation = contacts4Relation;
	}

	/**
	 * @return the contacts4Phone
	 */
	public String getContacts4Phone() {
		return contacts4Phone;
	}

	/**
	 * @param contacts4Phone
	 *            the contacts4Phone to set
	 */
	public void setContacts4Phone(String contacts4Phone) {
		this.contacts4Phone = contacts4Phone;
	}

	/**
	 * @return the contacts4CellPhone
	 */
	public String getContacts4CellPhone() {
		return contacts4CellPhone;
	}

	/**
	 * @param contacts4CellPhone
	 *            the contacts4CellPhone to set
	 */
	public void setContacts4CellPhone(String contacts4CellPhone) {
		this.contacts4CellPhone = contacts4CellPhone;
	}

	/**
	 * @return the contacts4Addr
	 */
	public String getContacts4Addr() {
		return contacts4Addr;
	}

	/**
	 * @param contacts4Addr
	 *            the contacts4Addr to set
	 */
	public void setContacts4Addr(String contacts4Addr) {
		this.contacts4Addr = contacts4Addr;
	}

	/**
	 * @return the contacts4Company
	 */
	public String getContacts4Company() {
		return contacts4Company;
	}

	/**
	 * @param contacts4Company
	 *            the contacts4Company to set
	 */
	public void setContacts4Company(String contacts4Company) {
		this.contacts4Company = contacts4Company;
	}

	/**
	 * @return the performancePoint
	 */
	public String getPerformancePoint() {
		return performancePoint;
	}

	/**
	 * @param performancePoint
	 *            the performancePoint to set
	 */
	public void setPerformancePoint(String performancePoint) {
		this.performancePoint = performancePoint;
	}

	/**
	 * @return the taskPoint
	 */
	public String getTaskPoint() {
		return taskPoint;
	}

	/**
	 * @param taskPoint
	 *            the taskPoint to set
	 */
	public void setTaskPoint(String taskPoint) {
		this.taskPoint = taskPoint;
	}

	/**
	 * @return the caseType
	 */
	public String getCaseType() {
		return caseType;
	}

	/**
	 * @param caseType
	 *            the caseType to set
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
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

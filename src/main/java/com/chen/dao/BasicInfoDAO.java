/**
 * 
 */
package com.chen.dao;

import com.chen.model.BasicInfo;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午3:13:53
 */
@DAO
public interface BasicInfoDAO {
	String table = "yiliangcuishou_basicinfo_copy";

	@ReturnGeneratedKeys
	@SQL("insert into yiliangcuishou_basicinfo_copy (UUID,nationalCaseAmt,paidAmt,debtAmt,principleAmt,remainPrincipleAmt,interestAmt,penalty,latefeeAmt,overrunAmt,serviceAmt,minPaymentAmt,name,pinyin,shareDebitCount,customName,batchCode,entrustDate,identityCardNo,bankCardNo,caseArea,caseStatus,overDueAge,cardStopDate,urgeName,advanceReclaimDate,cardOwnerCompany,cardOwnerEmail,reclaimDate,billingDate,accountNo,issuingBank,issuingDate,lastPaidDate,lastPaidAmt,lastConsumeDate,lastWithdrawDate,creditLimit,caseNo,creditClass,handTimes,repaymentTime,billDeadlineDate,cardOwnerJob,commercialTenant,caseProduct,nextUrgeTime,urgeStatus,sex,censusAddress,caseLevel,cashedStatus,reclaimStatus,remark1,ADD_TIME) values ("
			+ ":t.UUID,:t.nationalCaseAmt,:t.paidAmt,:t.debtAmt,:t.principleAmt,:t.remainPrincipleAmt,:t.interestAmt,:t.penalty,:t.latefeeAmt,:t.overrunAmt,:t.serviceAmt,:t.minPaymentAmt,:t.name,:t.pinyin,:t.shareDebitCount,:t.customName,:t.batchCode,:t.entrustDate,:t.identityCardNo,:t.bankCardNo,:t.caseArea,:t.caseStatus,:t.overDueAge,:t.cardStopDate,:t.urgeName,:t.advanceReclaimDate,:t.cardOwnerCompany,:t.cardOwnerEmail,:t.reclaimDate,:t.billingDate,:t.accountNo,:t.issuingBank,:t.issuingDate,:t.lastPaidDate,:t.lastPaidAmt,:t.lastConsumeDate,:t.lastWithdrawDate,:t.creditLimit,:t.caseNo,:t.creditClass,:t.handTimes,:t.repaymentTime,:t.billDeadlineDate,:t.cardOwnerJob,:t.commercialTenant,:t.caseProduct,:t.nextUrgeTime,:t.urgeStatus,:t.sex,:t.censusAddress,:t.caseLevel,:t.cashedStatus,:t.reclaimStatus,:t.remark1,:t.ADD_TIME)")
	public int addBasicInfo(@SQLParam("t") BasicInfo basicInfo);

}

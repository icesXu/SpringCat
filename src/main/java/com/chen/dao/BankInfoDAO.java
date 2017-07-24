/**
 * 
 */
package com.chen.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.chen.model.BankInfo;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午3:11:30
 */
@DAO
public interface BankInfoDAO {
	String table = "yiliangcuishou_bankinfo_copy";

	@ReturnGeneratedKeys
	@SQL("INSERT into yiliangcuishou_bankinfo_copy (UUID,serialNumber,entrustDate,nationalCaseAmt,RMB,HKD,USD,sex,name,bankCardNo,identityCardNo,urgeId,M,homePhone,workPhone,cellPhone,email,provinceId,cityId,districtId,postCode,advanceReclaimDate,cardStopDate,remark1,remark2,remark3,remark4,remark5,remark6,caseProduct,commercialTenant,fileNumber,issuingBank,accountNo,cardType,principleAmt,minPaymentAmt,creditLimit,defaultLevel,lastPaidDate,lastPaidAmt,lastConsumeDate,lastWithdrawDate,billDeadlineDate,issuingDate,repaymentTime,creditClass,urgeType,overdraftInterest,latefeeAmt,margin,currency,oriUrgeRecord,overdueTime,companyName,cardOwnerPosition,cardOwnerBranch,companyAddr,homeAddr,bankStatementAddr,permanentAddr,contacts1Name,contacts1CardNumber,contacts1Relation,contacts1Phone,contacts1CellPhone,contacts1Addr,contacts1Company,contacts2Name,contacts2CardNumber,contacts2Relation,contacts2Phone,contacts2CellPhone,contacts2Addr,contacts2Company,contacts3Name,contacts3CardNumber,contacts3Relation,contacts3Phone,contacts3CellPhone,contacts3Addr,contacts3Company,contacts4Name,contacts4CardNumber,contacts4Relation,contacts4Phone,contacts4CellPhone,contacts4Addr,contacts4Company,performancePoint,taskPoint,caseType,ADD_TIME) values (:t.UUID,:t.serialNumber,:t.entrustDate,:t.nationalCaseAmt,:t.RMB,:t.HKD,:t.USD,:t.sex,:t.name,:t.bankCardNo,:t.identityCardNo,:t.urgeId,:t.M,:t.homePhone,:t.workPhone,:t.cellPhone,:t.email,:t.provinceId,:t.cityId,:t.districtId,:t.postCode,:t.advanceReclaimDate,:t.cardStopDate,:t.remark1,:t.remark2,:t.remark3,:t.remark4,:t.remark5,:t.remark6,:t.caseProduct,:t.commercialTenant,:t.fileNumber,:t.issuingBank,:t.accountNo,:t.cardType,:t.principleAmt,:t.minPaymentAmt,:t.creditLimit,:t.defaultLevel,:t.lastPaidDate,:t.lastPaidAmt,:t.lastConsumeDate,:t.lastWithdrawDate,:t.billDeadlineDate,:t.issuingDate,:t.repaymentTime,:t.creditClass,:t.urgeType,:t.overdraftInterest,:t.latefeeAmt,:t.margin,:t.currency,:t.oriUrgeRecord,:t.overdueTime,:t.companyName,:t.cardOwnerPosition,:t.cardOwnerBranch,:t.companyAddr,:t.homeAddr,:t.bankStatementAddr,:t.permanentAddr,:t.contacts1Name,:t.contacts1CardNumber,:t.contacts1Relation,:t.contacts1Phone,:t.contacts1CellPhone,:t.contacts1Addr,:t.contacts1Company,:t.contacts2Name,:t.contacts2CardNumber,:t.contacts2Relation,:t.contacts2Phone,:t.contacts2CellPhone,:t.contacts2Addr,:t.contacts2Company,:t.contacts3Name,:t.contacts3CardNumber,:t.contacts3Relation,:t.contacts3Phone,:t.contacts3CellPhone,:t.contacts3Addr,:t.contacts3Company,:t.contacts4Name,:t.contacts4CardNumber,:t.contacts4Relation,:t.contacts4Phone,:t.contacts4CellPhone,:t.contacts4Addr,:t.contacts4Company,:t.performancePoint,:t.taskPoint,:t.caseType,:t.ADD_TIME)")
	public int addBankInfo(@SQLParam("t") BankInfo bankInfo);

}

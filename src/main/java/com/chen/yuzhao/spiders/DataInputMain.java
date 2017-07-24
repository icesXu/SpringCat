/**
 * 
 */
package com.chen.yuzhao.spiders;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.chen.dao.BankInfoDAO;
import com.chen.dao.BasicInfoDAO;
import com.chen.dao.ContactAddressDAO;
import com.chen.dao.ContactPhoneDAO;
import com.chen.dao.UrgeRecordDAO;
import com.chen.model.BankInfo;
import com.chen.model.BasicInfo;
import com.chen.model.ContactAddress;
import com.chen.model.ContactPhone;
import com.chen.model.UrgeRecord;
import com.chen.utils.ReadExcelUtils;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午3:18:01
 */
public class DataInputMain {

	private WebDriver driver;

	private static final String ROOT_PATH = "C:\\Users\\YYZYHC\\Desktop\\AllDocuments";
	private static final String SUFFIX = "\\"
			+ "79b4504d-30b6-11e7-9963-00163e0e060e";

	public static void main(String[] args) throws Exception {
		DataInputMain test = new DataInputMain();
		// test.generateArray();
		// test.processFirst();
		test.process();
		// test.test();
	}

	public void test() throws Exception {
		File file = new File(ROOT_PATH + SUFFIX);

		RoseAppContext cxt = new RoseAppContext();

		// 银行卡信息
		BankInfoDAO bankInfoDAO = cxt.getBean(BankInfoDAO.class);
		// 基本信息
		BasicInfoDAO basicInfoDAO = cxt.getBean(BasicInfoDAO.class);
		// 联系电话信息
		ContactPhoneDAO contactPhoneDAO = cxt.getBean(ContactPhoneDAO.class);
		// 联系地址信息
		ContactAddressDAO contactAddressDAO = cxt
				.getBean(ContactAddressDAO.class);
		// 电话催收记录
		UrgeRecordDAO urgeRecordDAO = cxt.getBean(UrgeRecordDAO.class);
		File[] finalFiles = new File(ROOT_PATH + SUFFIX).listFiles();
		Document doc = null;
		Document doc1 = null;

		String caseId = SUFFIX.substring(2);

		for (File finalFile : finalFiles) {
			if (finalFile.getName().contains("base")) {
				doc = Jsoup.parse(finalFile, "UTF-8");
			}
			if (finalFile.getName().contains("more")) {
				doc1 = Jsoup.parse(finalFile, "UTF-8");
			}

		}
		try {
			// 三个在一块
			getBasicInfo(doc, caseId, basicInfoDAO);
			getContactPhones(doc, caseId, contactPhoneDAO);
			getUrgeRecords(doc, caseId, urgeRecordDAO);

			// 另外两个
			getBankInfo(doc1, caseId, bankInfoDAO);
			getContactAddress(doc1, caseId, contactAddressDAO);
			System.out.println(caseId + "---操作成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @description:所有文档都已经下载下来，因此可以直接使用了
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws IOException
	 * @time:2017年6月8日 下午7:45:49
	 */
	public void process() throws IOException {

		Jedis redisUtil = new Jedis("192.168.10.35", 6379);

		RoseAppContext cxt = new RoseAppContext();

		// 银行卡信息
		BankInfoDAO bankInfoDAO = cxt.getBean(BankInfoDAO.class);
		// 基本信息
		BasicInfoDAO basicInfoDAO = cxt.getBean(BasicInfoDAO.class);
		// 联系电话信息
		ContactPhoneDAO contactPhoneDAO = cxt.getBean(ContactPhoneDAO.class);
		// 联系地址信息
		ContactAddressDAO contactAddressDAO = cxt
				.getBean(ContactAddressDAO.class);
		// 电话催收记录
		UrgeRecordDAO urgeRecordDAO = cxt.getBean(UrgeRecordDAO.class);

		File file = new File(ROOT_PATH);
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File innerFiles : listFiles) {

				String caseId = innerFiles.getName();
				System.out.println("当前正在解析的案件：" + caseId);
				File[] finalFiles = innerFiles.listFiles();
				Document doc = null;
				Document doc1 = null;
				for (File finalFile : finalFiles) {
					if (finalFile.getName().contains("base")) {
						doc = Jsoup.parse(finalFile, "UTF-8");
					}
					if (finalFile.getName().contains("more")) {
						doc1 = Jsoup.parse(finalFile, "UTF-8");
					}

				}
				try {
					// 三个在一块
					getBasicInfo(doc, caseId, basicInfoDAO);
					// getContactPhones(doc, caseId, contactPhoneDAO);
					// getUrgeRecords(doc, caseId, urgeRecordDAO);

					// 另外两个
					// getBankInfo(doc1, caseId, bankInfoDAO);
					// getContactAddress(doc1, caseId, contactAddressDAO);
					System.out.println(caseId + "---操作成功!");
				} catch (Exception e) {
					redisUtil.lpush("Again", caseId);
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * 
	 * @description:生成位置和时间的数组
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @time:2017年5月15日 下午6:36:07
	 */
	public void generateArray() throws Exception {

		// 生成默认的浏览器
		getWebDriver();
		driver.get("http://www.e-liang.net/login.html");
	}

	/**
	 * 
	 * @description:处理和存储数据
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月8日 下午1:56:35
	 */
	public void processFirst() throws Exception {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ReadExcelUtils util = new ReadExcelUtils(
				"C:\\Users\\YYZYHC\\Desktop\\20170607124119CASHED1500EXPORT.xlsx");
		Map<Integer, Map<Integer, Object>> readExcelContent = util
				.readExcelContent();

		for (Integer key : readExcelContent.keySet()) {

			Map<Integer, Object> map = readExcelContent.get(key);
			String caseId = (String) map.get(0);
			System.out.println("caseId:" + caseId);

			driver.get("http://www.e-liang.net/pages/oms-company/windows-case-view.html?caseId="
					+ caseId + "#/login.html");

			// 先点击打开银行的详情页

			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Document doc = Jsoup.parse(driver.getPageSource());

			// 先保存直接进行来的基本文档

			String rootPath = "C:\\Users\\YYZYHC\\Desktop\\AllDocuments";
			String newPath = rootPath + "\\" + caseId;

			File file = new File(newPath);
			if (!file.exists()) {
				file.mkdir();
			}

			System.out.println(file.getAbsolutePath());

			// 第一个是基本页面，即doc
			String basePath = newPath + "\\base.txt";
			File baseFile = new File(basePath);
			FileUtils.write(baseFile, doc.outerHtml());

			// 第二个是带有银行信息和地址信息的页面
			driver.findElement(
					By.xpath("//*[@id='caseDetailWindows']/div[4]/div/div[1]/div[4]/div/div[2]/div/span/b"))
					.click();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			driver.findElement(
					By.xpath("//*[@id='caseDetailWindows']/div[4]/div/div[2]/div[3]/div/div[1]/ul/li[2]/a"))
					.click();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Document doc1 = Jsoup.parse(driver.getPageSource());
			String withBankInfo = newPath + "\\more.txt";
			FileUtils.write(new File(withBankInfo), doc1.outerHtml());

			// getBasicInfo(doc, caseId);
			// getContactPhones(doc, caseId);
			// getUrgeRecords(doc, caseId);
			//
			// getContactPhones(doc1, caseId);
			// getBankInfo(doc1);

		}

		// 很可能今天玩不转，但是最好能够完成一部分数据导入再说

		// 但最好是能够将其所需要的dom保存下来，方便解析

		// for (Element table : tables) {
		// System.out.println(table.outerHtml());
		// }
		//

		// 先处理一遍
	}

	/**
	 * 
	 * @description:获取催收记录
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月8日 下午3:33:43
	 */
	public void getUrgeRecords(Document doc, String caseId,
			UrgeRecordDAO urgeRecordDAO) {
		Element table = doc.select("table").last();

		Element tbody = table.select("tbody").last();
		Elements trs = tbody.select("tr");
		if (null != trs && trs.size() != 0) {
			for (Element tr : trs) {

				UrgeRecord record = new UrgeRecord();

				Elements tds = tr.select("td");

				record.setADD_TIME(new Date());
				record.setUrgeTime(tds.get(1).text().trim());
				record.setUrgeUserName(tds.get(2).text().trim());
				record.setContactorName(tds.get(3).text().trim());
				record.setPhoneNum(tds.get(4).text().trim());
				record.setUrgeDesc(tds.get(5).text().trim());
				record.setIfUrgePromise(tds.get(6).text().trim());
				record.setUUID(caseId);
				System.out.println(JSON.toJSONString(record));

				urgeRecordDAO.insertTest(record);

				// 余下添加进去即可
			}

		}
	}

	/**
	 * 
	 * @description:获取基本信息
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月8日 下午3:20:11
	 */
	public void getBasicInfo(Document doc, String caseId,
			BasicInfoDAO basicInfoDAO) {

		BasicInfo info = new BasicInfo();

		Elements tables = doc.select("table");
		for (Element element : tables) {
			if (element.text().contains("大地保险")
					&& element.text().contains("户籍地址")) {
				Elements tds = element.select("td");
				info.setUUID(caseId);
				info.setName(tds.get(1).text().trim());
				info.setCustomName(tds.get(3).text().trim());
				info.setBatchCode(tds.get(5).text().trim());
				info.setEntrustDate(tds.get(7).text().trim());

				info.setIdentityCardNo(tds.get(9).text().trim());
				info.setBankCardNo(tds.get(11).text().trim());
				info.setCaseArea(tds.get(13).text().trim());
				info.setCaseStatus(tds.get(15).text().trim());

				info.setOverDueAge(tds.get(17).text().trim());
				info.setCardStopDate(tds.get(19).text().trim());
				info.setUrgeName(tds.get(21).text().trim());
				info.setAdvanceReclaimDate(tds.get(23).text().trim());

				info.setCardOwnerCompany(tds.get(25).text().trim());
				info.setCardOwnerEmail(tds.get(27).text().trim());
				info.setReclaimDate(tds.get(29).text().trim());
				info.setBillingDate(tds.get(31).text().trim());

				info.setAccountNo(tds.get(33).text().trim());
				info.setIssuingBank(tds.get(35).text().trim());
				info.setIssuingDate(tds.get(37).text().trim());
				info.setLastPaidDate(tds.get(39).text().trim());

				info.setLastPaidAmt(tds.get(41).text().trim());
				info.setLastConsumeDate(tds.get(43).text().trim());
				info.setLastWithdrawDate(tds.get(45).text().trim());
				info.setCreditLimit(tds.get(47).text().trim());

				info.setCaseNo(tds.get(49).text().trim());
				info.setCreditClass(tds.get(51).text().trim());
				info.setHandTimes(tds.get(53).text().trim());
				info.setRepaymentTime(tds.get(55).text().trim());

				info.setBillDeadlineDate(tds.get(57).text().trim());
				info.setCardOwnerJob(tds.get(59).text().trim());
				info.setCommercialTenant(tds.get(61).text().trim());
				info.setCaseProduct(tds.get(63).text().trim());

				info.setNextUrgeTime(tds.get(65).text().trim());
				info.setUrgeStatus(tds.get(67).text().trim());
				info.setSex(tds.get(69).text().trim());
				info.setCensusAddress(tds.get(71).text().trim());

				info.setCaseLevel(tds.get(73).text().trim());
				info.setCashedStatus(tds.get(75).text().trim());
				info.setReclaimStatus(tds.get(77).text().trim());
				info.setRemark1(tds.get(79).text().trim());

				System.out.println(JSON.toJSONString(info));

			} else {
				continue;
			}
		}

		Elements uls = doc.select("ul");
		for (Element ul : uls) {
			if (ul.text().contains("最新欠款")) {
				Elements lis = ul.select("li");
				info.setNationalCaseAmt(lis.get(0).select("span").last().text()
						.replace("￥", ""));
				info.setPaidAmt(lis.get(1).select("span").last().text());
				info.setDebtAmt(lis.get(2).select("span").last().text()
						.replace("￥", ""));
				info.setPrincipleAmt(lis.get(3).select("span").last().text());
				info.setRemainPrincipleAmt(lis.get(4).select("span").last()
						.text());
				info.setInterestAmt(lis.get(5).select("span").last().text());
				info.setPenalty(lis.get(6).select("span").last().text());
				info.setLatefeeAmt(lis.get(7).select("span").last().text());
				info.setOverrunAmt(lis.get(8).select("span").last().text());
				info.setServiceAmt(lis.get(9).select("span").last().text());
				info.setMinPaymentAmt(lis.get(10).select("span").last().text()
						.trim());
			}
		}
		System.out.println(JSON.toJSONString(info));
		basicInfoDAO.addBasicInfo(info);
	}

	/**
	 * 
	 * @description:获取银行数据
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月8日 下午5:45:42
	 */
	public void getBankInfo(Document doc, String caseId, BankInfoDAO bankInfoDAO) {
		Elements tables = doc.select("table");
		for (Element table : tables) {
			if (table.text().contains("个案序列号")) {
				Elements tds = table.select("td");
				BankInfo bankInfo = new BankInfo();
				bankInfo.setUUID(caseId);

				bankInfo.setSerialNumber(tds.get(1).text().trim());
				bankInfo.setEntrustDate(tds.get(3).text().trim());
				bankInfo.setNationalCaseAmt(tds.get(5).text().trim());
				bankInfo.setRMB(tds.get(7).text().trim());

				bankInfo.setHKD(tds.get(9).text().trim());
				bankInfo.setUSD(tds.get(11).text().trim());
				bankInfo.setSex(tds.get(13).text().trim());
				bankInfo.setName(tds.get(15).text().trim());

				bankInfo.setBankCardNo(tds.get(17).text().trim());
				bankInfo.setIdentityCardNo(tds.get(19).text().trim());
				bankInfo.setUrgeId(tds.get(21).text().trim());
				bankInfo.setM(tds.get(23).text().trim());

				bankInfo.setHomePhone(tds.get(25).text().trim());
				bankInfo.setWorkPhone(tds.get(27).text().trim());
				bankInfo.setCellPhone(tds.get(29).text().trim());
				bankInfo.setEmail(tds.get(31).text().trim());

				bankInfo.setProvinceId(tds.get(33).text().trim());
				bankInfo.setCityId(tds.get(35).text().trim());
				bankInfo.setDistrictId(tds.get(37).text().trim());
				bankInfo.setPostCode(tds.get(39).text().trim());

				bankInfo.setAdvanceReclaimDate(tds.get(41).text().trim());
				bankInfo.setCardStopDate(tds.get(43).text().trim());
				bankInfo.setRemark1(tds.get(45).text().trim());
				bankInfo.setRemark2(tds.get(47).text().trim());

				bankInfo.setRemark3(tds.get(49).text().trim());
				bankInfo.setRemark4(tds.get(51).text().trim());
				bankInfo.setRemark5(tds.get(53).text().trim());
				bankInfo.setRemark6(tds.get(55).text().trim());

				bankInfo.setCaseProduct(tds.get(57).text().trim());
				bankInfo.setCommercialTenant(tds.get(59).text().trim());
				bankInfo.setFileNumber(tds.get(61).text().trim());
				bankInfo.setIssuingBank(tds.get(63).text().trim());

				bankInfo.setAccountNo(tds.get(65).text().trim());
				bankInfo.setCardType(tds.get(67).text().trim());
				bankInfo.setPrincipleAmt(tds.get(69).text().trim());
				bankInfo.setMinPaymentAmt(tds.get(71).text().trim());

				bankInfo.setCreditLimit(tds.get(73).text().trim());
				bankInfo.setDefaultLevel(tds.get(75).text().trim());
				bankInfo.setLastPaidDate(tds.get(77).text().trim());
				bankInfo.setLastPaidAmt(tds.get(79).text().trim());

				bankInfo.setLastConsumeDate(tds.get(81).text().trim());
				bankInfo.setLastWithdrawDate(tds.get(83).text().trim());
				bankInfo.setBillDeadlineDate(tds.get(85).text().trim());
				bankInfo.setIssuingDate(tds.get(87).text().trim());

				bankInfo.setRepaymentTime(tds.get(89).text().trim());
				bankInfo.setCreditClass(tds.get(91).text().trim());
				bankInfo.setUrgeType(tds.get(93).text().trim());
				bankInfo.setOverdraftInterest(tds.get(95).text().trim());

				bankInfo.setLatefeeAmt(tds.get(97).text().trim());
				bankInfo.setMargin(tds.get(99).text().trim());
				bankInfo.setCurrency(tds.get(101).text().trim());
				bankInfo.setOriUrgeRecord(tds.get(103).text().trim());

				bankInfo.setOverdueTime(tds.get(105).text().trim());
				bankInfo.setCompanyName(tds.get(107).text().trim());
				bankInfo.setCardOwnerPosition(tds.get(109).text().trim());
				bankInfo.setCardOwnerBranch(tds.get(111).text().trim());

				bankInfo.setCompanyAddr(tds.get(113).text().trim());
				bankInfo.setHomeAddr(tds.get(115).text().trim());
				bankInfo.setBankStatementAddr(tds.get(117).text().trim());
				bankInfo.setPermanentAddr(tds.get(119).text().trim());

				bankInfo.setContacts1Name(tds.get(121).text().trim());
				bankInfo.setContacts1CardNumber(tds.get(123).text().trim());
				bankInfo.setContacts1Relation(tds.get(125).text().trim());
				bankInfo.setContacts1Phone(tds.get(127).text().trim());

				bankInfo.setContacts1CellPhone(tds.get(129).text().trim());
				bankInfo.setContacts1Addr(tds.get(131).text().trim());
				bankInfo.setContacts1Company(tds.get(133).text().trim());
				bankInfo.setContacts2Name(tds.get(135).text().trim());

				bankInfo.setContacts2CardNumber(tds.get(137).text().trim());
				bankInfo.setContacts2Relation(tds.get(139).text().trim());
				bankInfo.setContacts2Phone(tds.get(141).text().trim());
				bankInfo.setContacts2CellPhone(tds.get(143).text().trim());

				bankInfo.setContacts2Addr(tds.get(145).text().trim());
				bankInfo.setContacts2Company(tds.get(147).text().trim());
				bankInfo.setContacts3Name(tds.get(149).text().trim());
				bankInfo.setContacts3CardNumber(tds.get(151).text().trim());

				bankInfo.setContacts3Relation(tds.get(153).text().trim());
				bankInfo.setContacts3Phone(tds.get(155).text().trim());
				bankInfo.setContacts3CellPhone(tds.get(157).text().trim());
				bankInfo.setContacts3Addr(tds.get(159).text().trim());

				bankInfo.setContacts3Company(tds.get(161).text().trim());
				bankInfo.setContacts4Name(tds.get(163).text().trim());
				bankInfo.setContacts4CardNumber(tds.get(165).text().trim());
				bankInfo.setContacts4Relation(tds.get(167).text().trim());

				bankInfo.setContacts4Phone(tds.get(169).text().trim());
				bankInfo.setContacts4CellPhone(tds.get(171).text().trim());
				bankInfo.setContacts4Addr(tds.get(173).text().trim());
				bankInfo.setContacts4Company(tds.get(175).text().trim());

				bankInfo.setPerformancePoint(tds.get(177).text().trim());
				bankInfo.setTaskPoint(tds.get(179).text().trim());
				bankInfo.setCaseType(tds.get(181).text().trim());
				bankInfo.setADD_TIME(new Date());

				System.out.println(JSON.toJSONString(bankInfo));

				bankInfoDAO.addBankInfo(bankInfo);
			} else {
				continue;
			}
		}

	}

	/**
	 * 
	 * @description:获取通话地址
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月8日 下午3:23:19
	 */
	public void getContactAddress(Document doc, String caseId,
			ContactAddressDAO contactAddressDAO) {

		Elements tables = doc.select("table");
		for (Element table : tables) {
			if (table.text().contains("信函次数") && table.text().contains("地址类型")) {
				Elements trs = table.select("tr");
				for (Element tr : trs) {
					Elements tds = tr.select("td");
					if (null != tds && tds.size() > 0) {
						ContactAddress address = new ContactAddress();
						address.setUUID(caseId);
						address.setADD_TIME(new Date());
						address.setContactorName(tds.get(0).text().trim());
						address.setCompanyName(tds.get(1).text().trim());
						address.setRelation(tds.get(2).text().trim());
						address.setAddress(tds.get(3).text().trim());
						address.setIsResolved(tds.get(4).text().trim());
						address.setAddressType(tds.get(5).text().trim());
						address.setIsAddrEffect(tds.get(6).text().trim());
						address.setSendLetterTimes(tds.get(7).text().trim());
						address.setVisitTimes(tds.get(8).text().trim());
						System.out.println(JSON.toJSONString(address));

						contactAddressDAO.insertTest(address);
					}
				}
				break;
			}
		}
	}

	/**
	 * 
	 * @description:获取联系电话
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月8日 下午2:57:45
	 */
	public void getContactPhones(Document doc, String caseId,
			ContactPhoneDAO contactPhoneDAO) {
		Elements tables = doc.select("table");

		for (Element table : tables) {
			if (table.text().contains("自己") && table.text().contains("号码归属地")) {

				Elements trs = table.select("tr");

				for (Element tr : trs) {
					Elements tds = tr.select("td");
					if (null != tds && tds.size() != 0) {
						ContactPhone phone = new ContactPhone();
						phone.setUUID(caseId);
						phone.setContactorName(tds.get(0).text());
						phone.setCompanyName(tds.get(1).text());
						phone.setRelation(tds.get(2).text());
						phone.setPhoneNo(tds.get(3).text());
						phone.setPhoneType(tds.get(4).text());
						phone.setPhoneLocation(tds.get(5).text());
						phone.setIsEffect(tds.get(6).text());
						phone.setCallTimes(tds.get(7).text());
						phone.setSmsTimes(tds.get(8).text());
						phone.setDetectMessage(tds.get(9).text());
						phone.setDetectDate(tds.get(10).text());

						System.out.println(JSON.toJSONString(phone));

						// 通过DAO进行数据添加即可

						contactPhoneDAO.insertTest(phone);
					}
				}
				break;
			}

		}
	}

	public void processAfter() throws Exception {
	}

	/**
	 * 
	 * @description:生成一个WebDriver
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年5月15日 下午6:35:21
	 */
	public void getWebDriver() {
		File file = new File(
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.firefox.bin", file.getAbsolutePath());
		driver = new FirefoxDriver();
	}

}

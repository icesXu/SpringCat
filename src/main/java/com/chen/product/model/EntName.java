/**
 * 
 */
package com.chen.product.model;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年7月5日 下午3:25:23
 */
public class EntName {
	// 企业ID
	private Long ID;

	// 企业名称
	private String ENTNAME;

	// 插入时间
	private String IDT;

	// FLAG,标志位，无意义
	private Integer FLAG;

	/**
	 * @return the iD
	 */
	public Long getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(Long iD) {
		ID = iD;
	}

	/**
	 * @return the eNTNAME
	 */
	public String getENTNAME() {
		return ENTNAME;
	}

	/**
	 * @param eNTNAME
	 *            the eNTNAME to set
	 */
	public void setENTNAME(String eNTNAME) {
		ENTNAME = eNTNAME;
	}

	/**
	 * @return the iDT
	 */
	public String getIDT() {
		return IDT;
	}

	/**
	 * @param iDT
	 *            the iDT to set
	 */
	public void setIDT(String iDT) {
		IDT = iDT;
	}

	/**
	 * @return the fLAG
	 */
	public Integer getFLAG() {
		return FLAG;
	}

	/**
	 * @param fLAG
	 *            the fLAG to set
	 */
	public void setFLAG(Integer fLAG) {
		FLAG = fLAG;
	}

}

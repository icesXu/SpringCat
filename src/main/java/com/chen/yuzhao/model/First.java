/**
 * 
 */
package com.chen.yuzhao.model;

import com.chen.yuzhao.annotations.Select;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月9日 上午11:20:51
 */
public class First {

	private Integer id_number;
	
	@Select
	private String msg;

	/**
	 * @return the id_number
	 */
	public Integer getId_number() {
		return id_number;
	}

	/**
	 * @param id_number
	 *            the id_number to set
	 */
	public void setId_number(Integer id_number) {
		this.id_number = id_number;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}

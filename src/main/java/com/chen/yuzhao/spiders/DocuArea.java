/**
 * 
 */
package com.chen.yuzhao.spiders;

import com.chen.yuzhao.annotations.Select;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月12日 下午2:42:29
 */
public class DocuArea {

	@Select(cssValue = ".sethome", xpathValue = "//*[@id='bottom_container']/div/div[2]/div[1]/p/a")
	public String index;

	/**
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(String index) {
		this.index = index;
	}

}

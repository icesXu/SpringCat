/**
 * 
 */
package com.chen.akka;

import net.paoding.rose.scanning.context.RoseAppContext;

import com.chen.dao.TestDAO;
import com.chen.model.Test;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 上午10:13:39
 */
public class InsetionTest {
	public static void main(String[] args) {

		Test test = new Test();
		test.setId_number(10);
		test.setMsg("test");

		RoseAppContext cxt = new RoseAppContext();
		TestDAO testDAO = cxt.getBean(TestDAO.class);
		testDAO.insertTest(test);

	}
}

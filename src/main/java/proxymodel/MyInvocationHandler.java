/**
 * 
 */
package proxymodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.script.Invocable;

/**
 * 下午1:23:49
 * 
 * @author yuzhao.yang
 *
 */
public class MyInvocationHandler implements InvocationHandler {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月22日
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("正在执行的方法:" + method);
		if (args != null) {
			System.out.println("下面是执行该方法时候传入的实参:");
			for (Object val : args) {
				System.out.println(val);
			}
		} else {
			System.out.println("没有实参!");
		}
		return null;
	}
}

/**
 * 
 */
package proxymodelnew;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月14日 下午1:27:14
 */
public class CoderDynamicProxy implements InvocationHandler {
	private ICoder coder;

	public CoderDynamicProxy(ICoder coder) {
		this.coder = coder;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("开始时间:" + System.currentTimeMillis());
		Object result = method.invoke(coder, args);
		System.out.println("结束时间:" + System.currentTimeMillis());
		return result;
	}
}

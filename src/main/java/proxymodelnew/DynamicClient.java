/**
 * 
 */
package proxymodelnew;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月14日 下午1:30:02
 */
public class DynamicClient {
	public static void main(String[] args) {
		ICoder coder = new JavaCoder("zhang");
		// 构建动态代理类
		InvocationHandler handler = new CoderDynamicProxy(coder);
		// 获取类加载器
		ClassLoader classLoader = coder.getClass().getClassLoader();
		ICoder proxy = (ICoder) Proxy.newProxyInstance(classLoader, coder
				.getClass().getInterfaces(), handler);
		proxy.implDemands("Modify user management");

	}
}

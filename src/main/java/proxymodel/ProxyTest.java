/**
 * 
 */
package proxymodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 下午1:24:35
 * 
 * @author yuzhao.yang
 *
 */
public class ProxyTest {
	public static void main(String[] args) {
		InvocationHandler handler = new MyInvocationHandler();
		Person p = (Person) Proxy.newProxyInstance(
				Person.class.getClassLoader(), new Class[] { Person.class },
				handler);
		p.walk();
		p.sayHello("孙悟空");
	}
}

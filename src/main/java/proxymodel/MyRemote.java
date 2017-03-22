/**
 * 
 */
package proxymodel;

import java.rmi.*;

/**
 * 下午2:40:59
 * 
 * @author yuzhao.yang
 *
 */
public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
}

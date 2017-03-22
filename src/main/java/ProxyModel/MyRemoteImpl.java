/**
 * 
 */
package ProxyModel;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 下午2:42:53
 * 
 * @author yuzhao.yang
 *
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	/**
	 * @throws RemoteException
	 */
	protected MyRemoteImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2016年11月13日
	 */
	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Server says, 'hello'";
	}

	public static void main(String... args) {
		try {
			 LocateRegistry.createRegistry(12312);

			MyRemote service = new MyRemoteImpl();
			Naming.rebind("rmi://127.0.0.1:12312/RemoteHello", service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * 
 */
package proxymodel;

import java.rmi.Naming;

/**
 *下午2:48:28
 * @author yuzhao.yang
 *
 */
public class MyRemoteClient {
	public static void main(String [] args){
		new MyRemoteClient().go();
	}
	
	public void go(){
		try{
			MyRemote service = (MyRemote)Naming.lookup("rmi://127.0.0.1:12312/RemoteHello");
			System.out.println(service.sayHello());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

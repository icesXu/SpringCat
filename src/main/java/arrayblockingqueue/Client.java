/**
 * 
 */
package arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *下午6:26:44
 * @author yuzhao.yang
 *
 */
public class Client {
	public static void main(String[] args) {  
        int capacity = 10;  
        ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<Bread>(capacity);  
  
        new Thread(new Producer(queue)).start();  
        new Thread(new Producer(queue)).start();  
        new Thread(new Consumer(queue)).start();  
        new Thread(new Consumer(queue)).start();  
        new Thread(new Consumer(queue)).start();  
    }

}

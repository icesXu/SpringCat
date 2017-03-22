/**
 * 
 */
package arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *下午6:25:42
 * @author yuzhao.yang
 *
 */
public class Consumer implements Runnable {
	
	private final ArrayBlockingQueue<Bread> queue;  
    
    public Consumer(ArrayBlockingQueue<Bread> queue){  
        this.queue = queue;  
    }  
  
    @Override  
    public void run() {  
        while(true){  
            consume();  
        }  
    }  
      
    public void consume(){  
        /** 
         * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起 
         * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null 
         */  
        try {  
            Bread bread = queue.take();  
            System.out.println("consumer:"+bread);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  

}

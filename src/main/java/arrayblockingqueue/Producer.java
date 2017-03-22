package arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable{  
      
    //容器  
    private final ArrayBlockingQueue<Bread> queue;  
      
    public Producer(ArrayBlockingQueue<Bread> queue){  
        this.queue = queue;  
    }  
    
    @Override  
    public void run() {  
        while(true){  
            produce();  
        }  
    }  
      
    public void produce(){  
        /** 
         * put()方法是如果容器满了的话就会把当前线程挂起 
         * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。 
         */  
        try {  
            Bread bread = new Bread();  
            queue.put(bread);  
            System.out.println("Producer:"+bread);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  
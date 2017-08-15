/**
 * 
 */
package queue;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 下午12:56:40
 */
public interface Queue<T> {
	/**
	 * 
	 * @description:返回队列的长度
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:00:54
	 */
	int size();

	/**
	 * 
	 * @description:判断队列是否为空
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:01:03
	 */
	boolean isEmpty();

	/**
	 * 
	 * @description:向队列中插入元素
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:01:18
	 */
	boolean add(T data);

	/**
	 * 
	 * @description:插入元素
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:01:39
	 */
	T offer(T data);

	/**
	 * 
	 * @description:返回队头操作，不执行删除操作；队列为空，返回null
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:02:57
	 */
	T peek();

	/**
	 * 
	 * @description:返回队头元素，不执行删除操作
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:04:23
	 */
	T element();

	/**
	 * 
	 * @description:返回队头元素，执行删除操作;若队列为空，抛出异常
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:05:35
	 */
	T remove();

	/**
	 * 
	 * @description:同上，队列为空，返回null
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:05:57
	 */
	T poll();

	/**
	 * 
	 * @description:队列是否满了
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:27:59
	 */
	boolean isFull();

	void clearQueue();
}

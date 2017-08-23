/**
 * 
 */
package netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 上午11:05:08
 */
public class ObjectServerHandler extends SimpleChannelHandler {
	/**
	 * 当接受到消息的时候触发
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		Command command = (Command) e.getMessage();
		// 打印看看是不是我们刚才传过来的那个
		System.out.println(command.getActionName());
	}
}

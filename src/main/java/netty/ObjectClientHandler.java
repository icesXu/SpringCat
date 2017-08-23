/**
 * 
 */
package netty;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 上午11:07:14
 */
public class ObjectClientHandler extends SimpleChannelHandler {

	/**
	 * 当绑定到服务端的时候触发，给服务端发消息。
	 *
	 * @author lihzh
	 * @alia OneCoder
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
		// 向服务端发送Object信息
		sendObject(e.getChannel());
	}

	/**
	 * 发送Object
	 *
	 * @param channel
	 * @author lihzh
	 * @alia OneCoder
	 */
	private void sendObject(Channel channel) {
		Command command = new Command();
		command.setActionName("Hello action.");
		channel.write(command);
	}

}

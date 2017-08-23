/**
 * 
 */
package netty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 上午10:37:46
 */
public class NettyClient {

	public static void main(String[] args) {
		// Configure the client.
		ClientBootstrap bootstrap = new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));

		// Set up the default event pipeline.
		// bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
		// @Override
		// public ChannelPipeline getPipeline() throws Exception {
		// return Channels.pipeline(new StringDecoder(),
		// new StringEncoder(), new ClientHandler());
		// }
		// });
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

			@Override
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				return Channels.pipeline(new ObjectEncoder(),
						new ObjectClientHandler());
			}
		});

		// Start the connection attempt.
		ChannelFuture future = bootstrap.connect(new InetSocketAddress(
				"localhost", 8000));

		// Wait until the connection is closed or the connection attempt fails.
		future.getChannel().getCloseFuture().awaitUninterruptibly();

		// Shut down thread pools to exit.
		bootstrap.releaseExternalResources();
	}

	private static class ClientHandler extends SimpleChannelHandler {
		private BufferedReader sin = new BufferedReader(new InputStreamReader(
				System.in));

		@Override
		public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
				throws Exception {
			if (e.getMessage() instanceof String) {
				String message = (String) e.getMessage();
				System.out.println(message);

				e.getChannel().write(sin.readLine());

				System.out.println("\n等待客户端输入。。。");
			}

			super.messageReceived(ctx, e);
		}

		@Override
		public void channelConnected(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			System.out.println("已经与Server建立连接。。。。");
			System.out.println("\n请输入要发送的信息：");
			super.channelConnected(ctx, e);

			e.getChannel().write(sin.readLine());
		}
	}
}

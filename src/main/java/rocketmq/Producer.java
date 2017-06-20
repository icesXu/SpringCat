package rocketmq;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class Producer {

	public static void main(String[] args) {
		DefaultMQProducer producer = new DefaultMQProducer("Producer");
		// nameserver服务,多个以;分开
		producer.setNamesrvAddr("192.168.79.1:9876");
		System.out.println(producer.getClientIP());
		try {
			producer.start();
			producer.setVipChannelEnabled(false);

			Message msg = new Message("PushTopic", "push", "1",
					"Just for test.".getBytes());
			SendResult result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:"
					+ result.getSendStatus());
			;

			msg = new Message("PushTopic", "push", "2",
					"Just for test.".getBytes());
			result = producer.send(msg);
			System.out.println(result.toString());
			System.out.println("id:" + result.getMsgId() + " result:"
					+ result.getSendStatus());
			;

			msg = new Message("PullTopic", "pull", "1",
					"Just for test.".getBytes());
			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:"
					+ result.getSendStatus());
			;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.shutdown();
		}
	}
}

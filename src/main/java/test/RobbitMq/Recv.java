package test.RobbitMq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Recv {
	 
	 public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		final Channel channel = connection.createChannel();
		
		
//		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		channel.exchangeDeclare("test-mq-exchange", "direct");
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, "test-mq-exchange", "test_queue_key"); 
		
//		channel.basicQos(1);//公平调度
		
		Consumer consumer = new DefaultConsumer(channel){

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				 String message = new String(body, "UTF-8");
				 System.out.println(" [x] Received '" + message + "'");
//				 channel.basicAck(envelope.getDeliveryTag(), false);//手动应答
			}
		};
//		boolean autoAck = false;
		channel.basicConsume(queueName, true, consumer);
	}
}

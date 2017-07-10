package test.RobbitMq;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class RabbitMq {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
//		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		channel.exchangeDeclare("logs1", "topic");
		
//		String message = "Hello World";
		
//		channel.basicPublish("",QUEUE_NAME,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
//		channel.basicPublish("logs", "rr.name", null, message.getBytes());
		
		String[] routing_keys = new String[] { "male.black.high", "male.black.nohign","female.black.high"};   
        for (String routing_key : routing_keys)  
        {  
        	String msg = routing_key;
            channel.basicPublish("logs1", routing_key, null, msg.getBytes());  
            System.out.println(" [x] Sent routingKey = "+routing_key+" ,msg = " + msg + ".");  
        }  
		
		channel.close();
		connection.close();
	}
}

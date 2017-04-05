package com.writer;

import java.io.Serializable;

import javax.jms.Queue;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;

public class ArtemisProducer implements Serializable {
	
	private static final long serialVersionUID = -2741693343187840932L;
	int counter = 0;
	
	public void send2Queue(String payload) {
		Queue queue = new ActiveMQQueue("artemis-queue-test");
		JmsMessagingTemplate jms = new JmsMessagingTemplate();
		jms.convertAndSend(queue, ++counter + payload);
	}
}

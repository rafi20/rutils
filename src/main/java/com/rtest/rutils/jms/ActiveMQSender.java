package com.rtest.rutils.jms;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActiveMQSender {

	private final Logger logger = LoggerFactory.getLogger(ActiveMQSender.class);
	private SecureRandom random = new SecureRandom();
	public void createTask(){
	    String taskName = generateTaskName();
	    Runnable sendTask = () -> {
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	        Connection connection = null;
	        try {
	            connection = connectionFactory.createConnection("minifi", "minifi");
	            connection.start();
	            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            Destination destination = session.createQueue("test_minifi");
	            MessageProducer producer = session.createProducer(destination);
	            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	            String text = "Hello from: " + taskName + " : " + this.hashCode();
	            TextMessage message = session.createTextMessage(text);
	            logger.info("Sent message text: "+ text);
	            logger.info("Sent message hash code: "+ message.hashCode() + " : " + taskName);
	            producer.send(message);
	            session.close();
	            connection.close();
	        } catch (JMSException e) {
	            logger.error("Sender createTask method error", e);
	        }
	    };
	    new Thread(sendTask).start();
	}
	private String generateTaskName() {
	    return new BigInteger(20, random).toString(16);
	}
}
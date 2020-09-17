package com.rtest.rutils.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActiveMQReceiver implements ExceptionListener{
    private final Logger logger = LoggerFactory.getLogger(ActiveMQReceiver.class);
    public void createRecieveTask() {
        Runnable recTask = () -> {
            try {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
                Connection connection = connectionFactory.createConnection("minifi", "minifi");
                connection.start();
                connection.setExceptionListener(this);
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("test_minifi");
                MessageConsumer consumer = session.createConsumer(destination);
                Message message = consumer.receive(4000);
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                   logger.info("Received TextMessage object: " + text);
                } else {
                    logger.info("Received other object type with message: " + message);
                }
                consumer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                logger.error("Reciver createRecieveTask method error", e);
            }
        };
        new Thread(recTask).start();
    }
    @Override
    public void onException(JMSException exception) {
        logger.error("Recieve error occured.");
    }

}

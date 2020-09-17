package com.rtest.rutils.jms;

public class TestActiveMQ {

	public static void main(String[] args) {
		if(args[0].equalsIgnoreCase("send")) {
			ActiveMQSender sender = new ActiveMQSender();
			sender.createTask();
		} else {
			ActiveMQReceiver receiver = new ActiveMQReceiver();
			receiver.createRecieveTask();	
		}		
	}
}

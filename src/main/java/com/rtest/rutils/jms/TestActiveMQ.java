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

/*
#Configure ActiveMQ authentication/Authorization
#In activemq.xml
<plugins>
    <simpleAuthenticationPlugin anonymousAccessAllowed="false">
        <users>
            <authenticationUser username="minifi" password="minifi" groups="admins, producers, consumers"/>
        </users>
    </simpleAuthenticationPlugin>


    <authorizationPlugin>
        <map>
            <authorizationMap>
                <authorizationEntries>
					<authorizationEntry queue="test_minifi" read="consumers" write="producers" admin="producers,consumers,admins" /> 
                    <authorizationEntry queue="myQueue" read="consumers" write="producers" admin="producers,consumers,admins" />    
                    <authorizationEntry topic="ActiveMQ.Advisory.>" read="consumers" write="producers" admin="producers,consumers,admins"/>
                </authorizationEntries>
            </authorizationMap>
        </map>
    </authorizationPlugin>
</plugins>

#Client
https://repo1.maven.org/maven2/org/apache/activemq/activemq-all/5.15.9/activemq-all-5.15.9.jar
https://repo1.maven.org/maven2/org/apache/activemq/activemq-client/5.15.9/activemq-client-5.15.9.jar

#Admin 
http://localhost:8161/admin/
admin/admin
admin/manager

*/
package pl.agh.aghgrid.model;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQ {
    private static String url = "failover://tcp://aghgrid.dyn.pl:61616";
            // queue name
            private static String subject = "TOiK";

            public static boolean sendRequest(Tasks task) {
                    try {
                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();

                // Create a Session - createSession(boolean transacted, int acknowledgeMode) 
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                // Create the destination (Queue)
                Destination destination = session.createQueue(subject);

                // Create a MessageProducer from the Session to the Queue
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                // message = request_id;request;sendtime;user_id;
                String text = task.getId() + ';' + task.getRequest() + ';' + task.getSendtime() + ';' + task.getUsers().getId() + ';';
                TextMessage message = session.createTextMessage(text);                
                producer.send(message);

                // Clean up
                session.close();
                connection.close();
                return true;
            }
            catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
                return false;
            }
        }
}
package ejb.messageDrivenBean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class MessageClient {

    @Resource(lookup = "java:jboss/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:jboss/exported/jms/queue/test")
    private Queue queue;

    @Resource(lookup = "java:jboss/exported/jms/topic/test")
    private Topic topic;


    private int NUM_MSGS = 3;

    public void sendMessages(){
        try(JMSContext context = connectionFactory.createContext()){
            for(int i = 0; i < NUM_MSGS; i++){
                String message = "Message " + (i + 1);
                context.createProducer().send(queue, message);
                context.createProducer().send(topic, message);
            }
        }
    }
}

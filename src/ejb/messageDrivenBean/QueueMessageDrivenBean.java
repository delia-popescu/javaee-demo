package ejb.messageDrivenBean;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = "java:jboss/exported/jms/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue")
})
public class QueueMessageDrivenBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;

    public void onMessage(Message inMessage){
        try {
            if (inMessage instanceof TextMessage) {
                System.out.println("Queue received message: " + inMessage.getBody(String.class));
            } else {
                System.out.println("Message is in the wrong format");
            }
        }catch (JMSException e){
           mdc.setRollbackOnly();
        }
    }
}

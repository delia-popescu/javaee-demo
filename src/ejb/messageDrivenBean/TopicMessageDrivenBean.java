package ejb.messageDrivenBean;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig =
        {@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jboss/exported/jms/topic/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")})
public class TopicMessageDrivenBean implements MessageListener {

    @Resource
    MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("Topic received message: " + textMessage.getText());
            } catch (JMSException e) {
                mdc.setRollbackOnly();
            }
        } else {
            System.out.println("Message has bad format");
        }
    }
}

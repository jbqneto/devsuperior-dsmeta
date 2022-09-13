package io.jbqneto.devsuperior.dsmeta.client.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.jbqneto.devsuperior.dsmeta.client.MessageClient;
import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;
import io.jbqneto.devsuperior.dsmeta.entities.SMSResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioClient implements MessageClient {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String phoneTo;

    @Override
    public ClientMessageResponse sendMessage(String message) {
        Twilio.init(twilioSid, twilioKey);

        Message twilioMessage = Message
                .creator(new PhoneNumber(this.phoneTo), new PhoneNumber(twilioPhoneFrom), message)
                .create();

        System.out.println(twilioMessage.getSid());

        String text = twilioMessage.getErrorMessage() != null
                ? twilioMessage.getErrorMessage()
                : "Mensagem enviada com sucesso";

        return new SMSResponse(twilioMessage.getSid(), text);
    }
}

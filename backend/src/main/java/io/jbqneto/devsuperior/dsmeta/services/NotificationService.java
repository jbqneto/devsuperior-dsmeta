package io.jbqneto.devsuperior.dsmeta.services;

import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;
import io.jbqneto.devsuperior.dsmeta.client.MessageClient;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final MessageClient twilioClient;

    public NotificationService(MessageClient twilioClient) {
        this.twilioClient = twilioClient;
    }

    public ClientMessageResponse sendMessage(String to, String message) {
        return this.twilioClient.sendMessage(to, message);
    }
}

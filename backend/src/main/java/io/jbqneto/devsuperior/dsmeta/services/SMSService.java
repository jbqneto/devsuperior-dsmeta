package io.jbqneto.devsuperior.dsmeta.services;

import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;
import io.jbqneto.devsuperior.dsmeta.client.MessageClient;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    private final MessageClient messageClient;

    public SMSService(MessageClient client) {
        this.messageClient = client;
    }

    public ClientMessageResponse sendMessage(String to, String message) {
        return this.messageClient.sendMessage(to, message);
    }
}

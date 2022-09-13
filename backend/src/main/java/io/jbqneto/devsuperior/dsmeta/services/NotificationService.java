package io.jbqneto.devsuperior.dsmeta.services;

import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;
import io.jbqneto.devsuperior.dsmeta.client.MessageClient;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final MessageClient telegramClient;

    public NotificationService(MessageClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    public ClientMessageResponse sendMessage(String message) {
        return this.telegramClient.sendMessage(message);
    }
}

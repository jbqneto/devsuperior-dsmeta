package io.jbqneto.devsuperior.dsmeta.client;

public interface MessageClient {
    public ClientMessageResponse sendMessage(String to, String message);
}

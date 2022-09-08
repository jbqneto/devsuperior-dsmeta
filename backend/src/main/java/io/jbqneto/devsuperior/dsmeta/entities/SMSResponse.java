package io.jbqneto.devsuperior.dsmeta.entities;

import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;

public class SMSResponse implements ClientMessageResponse {
    private final String id;
    private final String message;

    public SMSResponse(String code, String message) {
        this.id = code;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return this.id + ": " + this.message;
    }

    @Override
    public boolean isSuccess() {
        return this.id != null;
    }
}

package io.jbqneto.devsuperior.dsmeta.entities;

import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;

public class DefaultMessageResponse implements ClientMessageResponse {

    private final String message;
    private final boolean isSuccess;

    public DefaultMessageResponse(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isSuccess() {
        return this.isSuccess;
    }
}

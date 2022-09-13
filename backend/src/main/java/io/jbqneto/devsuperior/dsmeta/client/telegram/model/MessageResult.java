package io.jbqneto.devsuperior.dsmeta.client.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResult {

    @JsonProperty("ok")
    private boolean isSuccess;

    private Message result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Message getResult() {
        return result;
    }

    public void setResult(Message result) {
        this.result = result;
    }
}

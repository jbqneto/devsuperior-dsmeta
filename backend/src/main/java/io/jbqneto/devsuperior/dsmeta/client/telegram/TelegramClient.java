package io.jbqneto.devsuperior.dsmeta.client.telegram;

import io.jbqneto.devsuperior.dsmeta.client.MessageClient;
import io.jbqneto.devsuperior.dsmeta.client.ClientMessageResponse;
import io.jbqneto.devsuperior.dsmeta.client.telegram.model.Message;
import io.jbqneto.devsuperior.dsmeta.client.telegram.model.Update;
import io.jbqneto.devsuperior.dsmeta.entities.DefaultMessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
public class TelegramClient implements MessageClient {

    private static final Logger log = LogManager.getLogger(TelegramClient.class);

    private String token;

    @Value("${telegram.bot}")
    private String botName;

    @Value("${telegram.chatId}")
    private String chatId;

    private final RestTemplate client;

    public TelegramClient(RestTemplate restTemplate,
                          @Value("${telegram.url}") String baseUrl,
                          @Value("${telegram.token}") String token) {
        this.client = restTemplate;
        this.token = token;
        this.client.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl + this.token));
    }

    public void getMe() {
        var response = this.client.getForEntity("/getMe", String.class);

        log.info("Response Me {}", response.getBody());
    }

    public void getUpdates() {
        var response = this.client.getForEntity("/getUpdates", String.class);

        log.info("response {}", response.getBody());
    }

    @Override
    public ClientMessageResponse sendMessage(String message) {
        this.getMe();
        this.getUpdates();

        var response = this.client
                .getForEntity("/sendMessage?chat_id=" + this.chatId + "&text=" + message, String.class);

        log.info("response {}", response);

        return new DefaultMessageResponse("Mensagem enviada com sucesso!", true);
    }
}

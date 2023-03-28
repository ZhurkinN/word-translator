package ru.zhurkin.translatortask.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static ru.zhurkin.translatortask.support.constants.YandexApiConstantsKeeper.BASE_URL;

@Configuration
public class YandexWebClientConfig {

    @Value("${yandex.api.key}")
    private String apiKey;

    @Bean
    public WebClient getWebClient() {

        return WebClient.builder().
                baseUrl(BASE_URL)
                .defaultHeader(AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
}

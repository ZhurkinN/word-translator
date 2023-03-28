package ru.zhurkin.translatortask.configгuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static ru.zhurkin.translatortask.constants.YandexApiConstantsKeeper.BASE_URL;

@Configuration
public class YandexWebClientConfig {

    @Value("${yandex.api.key}")
    private String apiKey;

    @Value("${yandex.api.folder-id}")
    private String folderId;

    @Bean
    public WebClient getWebClient() {
        Map<String, String> uriParametersMap = new HashMap<>();
        uriParametersMap.put("folderId", folderId);

        return WebClient.builder().
                baseUrl(BASE_URL)
                .defaultHeader(AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON)
                //.defaultUriVariables(uriParametersMap)
                .build();
    }
}

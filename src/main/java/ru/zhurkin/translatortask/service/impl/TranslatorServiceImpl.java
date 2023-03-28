package ru.zhurkin.translatortask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.zhurkin.translatortask.dto.request.YandexRequestDTO;
import ru.zhurkin.translatortask.dto.response.YandexResponseDTO;
import ru.zhurkin.translatortask.exception.YandexWebClientException;
import ru.zhurkin.translatortask.helper.InputParametersValidator;
import ru.zhurkin.translatortask.helper.StringHelper;
import ru.zhurkin.translatortask.repository.TranslatorRepository;
import ru.zhurkin.translatortask.service.TranslatorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.zhurkin.translatortask.constants.ErrorMessageKeeper.YANDEX_API_ERROR;

@Service
@RequiredArgsConstructor
public class TranslatorServiceImpl implements TranslatorService {

    @Value("${yandex.api.folder-id}")
    private String folderId;

    private final WebClient webClient;
    private final TranslatorRepository translatorRepository;

    @Override
    public String getTranslation(String inputText,
                                 String translationRule,
                                 String requestIp) {

        InputParametersValidator.validateInputParameters(inputText, translationRule);
        List<String> inputWords = StringHelper.separateWords(inputText);
        Long requestId = translatorRepository.saveRequestInfo(LocalDateTime.now(), inputText, translationRule, requestIp);
        String targetLanguage = StringHelper.getTargetLanguage(translationRule);
        List<String> translatedWords = new ArrayList<>();

        for (String word : inputWords) {
            YandexRequestDTO request = new YandexRequestDTO(targetLanguage, List.of(word), folderId);
            YandexResponseDTO response = webClient.post()
                    .body(BodyInserters.fromValue(request))
                    .retrieve()
                    .bodyToMono(YandexResponseDTO.class)
                    .blockOptional()
                    .orElseThrow(() -> new YandexWebClientException(YANDEX_API_ERROR));

            String translatedWord = response.translations().get(0).text();
            translatedWords.add(translatedWord);
            translatorRepository.saveTranslatedWord(requestId, word, translatedWord);
        }

        String translatedText = StringHelper.uniteWords(translatedWords);
        translatorRepository.setTranslatedText(requestId, translatedText);

        return translatedText;
    }
}

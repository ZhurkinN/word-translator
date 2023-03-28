package ru.zhurkin.translatortask.dto.response;

public record YandexTranslatedWordDTO(String text,
                                      String detectedLanguageCode) {
}

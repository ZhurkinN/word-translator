package ru.zhurkin.translatortask.service.model;

public record YandexTranslatedWordDTO(String text,
                                      String detectedLanguageCode) {
}

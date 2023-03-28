package ru.zhurkin.translatortask.service.model;

import java.util.List;

public record YandexRequestDTO(String targetLanguageCode,
                               List<String> texts,
                               String folderId) {
}

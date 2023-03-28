package ru.zhurkin.translatortask.dto.request;

import java.util.List;

public record YandexRequestDTO(String targetLanguageCode,
                               List<String> texts,
                               String folderId) {
}

package ru.zhurkin.translatortask.service.model;

import java.util.List;

public record YandexResponseDTO(List<YandexTranslatedWordDTO> translations) {

}

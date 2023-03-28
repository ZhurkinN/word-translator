package ru.zhurkin.translatortask.dto.response;

import java.util.List;

public record YandexResponseDTO(List<YandexTranslatedWordDTO> translations) {

}

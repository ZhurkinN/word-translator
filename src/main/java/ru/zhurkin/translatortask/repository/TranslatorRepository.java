package ru.zhurkin.translatortask.repository;

import java.time.LocalDateTime;

public interface TranslatorRepository {

    boolean saveRequestInfo(Long id,
                            LocalDateTime dateTime,
                            String inputText,
                            String translatedText,
                            String translationRule,
                            String ip);

    boolean saveTranslatedWord(Long id,
                               Long requestId,
                               String inputWord,
                               String translatedWord);

}

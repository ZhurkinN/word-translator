package ru.zhurkin.translatortask.repository;

import java.time.LocalDateTime;

public interface TranslatorRepository {

    Long saveRequestInfo(LocalDateTime dateTime,
                            String inputText,
                            String translationRule,
                            String ip);

    boolean saveTranslatedWord(Long requestId,
                               String inputWord,
                               String translatedWord);

    boolean setTranslatedText(Long requestId,
                              String translatedText);

}

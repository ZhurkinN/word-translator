package ru.zhurkin.translatortask.service;

public interface TranslatorService {

    String getTranslation(String inputText,
                          String translationRule,
                          String requestIp);
}

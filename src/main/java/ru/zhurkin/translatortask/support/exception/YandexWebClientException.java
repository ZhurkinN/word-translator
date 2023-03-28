package ru.zhurkin.translatortask.support.exception;

public class YandexWebClientException extends RuntimeException {

    public YandexWebClientException() {
        super();
    }

    public YandexWebClientException(String message) {
        super(message);
    }
}

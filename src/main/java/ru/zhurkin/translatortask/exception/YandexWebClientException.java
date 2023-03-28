package ru.zhurkin.translatortask.exception;

public class YandexWebClientException extends RuntimeException {

    public YandexWebClientException() {
        super();
    }

    public YandexWebClientException(String message) {
        super(message);
    }
}

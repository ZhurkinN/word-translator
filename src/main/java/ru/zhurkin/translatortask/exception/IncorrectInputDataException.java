package ru.zhurkin.translatortask.exception;

public class IncorrectInputDataException extends RuntimeException {

    public IncorrectInputDataException() {
        super();
    }

    public IncorrectInputDataException(String message) {
        super(message);
    }
}

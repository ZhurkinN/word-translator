package ru.zhurkin.translatortask.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.zhurkin.translatortask.dto.response.ApplicationErrorDTO;
import ru.zhurkin.translatortask.exception.IncorrectInputDataException;
import ru.zhurkin.translatortask.exception.YandexWebClientException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApplicationErrorDTO> catchIncorrectInputDataException(
            IncorrectInputDataException e
    ) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body(new ApplicationErrorDTO(e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationErrorDTO> catchYandexWebClientException(
            YandexWebClientException e
    ) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body(new ApplicationErrorDTO(e.getMessage()));
    }
}

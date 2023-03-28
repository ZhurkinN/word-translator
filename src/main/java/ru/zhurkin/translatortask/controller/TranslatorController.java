package ru.zhurkin.translatortask.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zhurkin.translatortask.controller.model.TranslatorParametersDTO;
import ru.zhurkin.translatortask.controller.model.TranslatorResultDTO;
import ru.zhurkin.translatortask.service.TranslatorService;

@RestController
@RequestMapping("/api/v2/translate")
@RequiredArgsConstructor
public class TranslatorController {

    private final TranslatorService translatorService;

    @PostMapping
    public ResponseEntity<TranslatorResultDTO> translateText(@RequestBody TranslatorParametersDTO requestDto,
                                                             HttpServletRequest request) {
        String inputText = requestDto.inputText();
        String translationRule = requestDto.translationRule();
        String requestIp = request.getRemoteAddr();

        String translatedText = translatorService.getTranslation(inputText, translationRule, requestIp);

        return ResponseEntity.ok(new TranslatorResultDTO(translatedText));
    }
}

package ru.zhurkin.translatortask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zhurkin.translatortask.service.impl.TranslatorServiceImpl;
import ru.zhurkin.translatortask.support.exception.IncorrectInputDataException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.zhurkin.translatortask.support.constants.ErrorMessageKeeper.WRONG_TRANSLATION_RULE;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TranslatorServiceTests {

    private static final String EXPECTED_TRANSLATION = "здравствуйте, мир";
    private static final String ERROR_TRANSLATION_RULE = "ru";

    @InjectMocks
    @Autowired
    private TranslatorServiceImpl translatorService;

    private String inputText;
    private String translationRule;
    private String requestIp;

    @BeforeEach
    public void setup() {
        inputText = "hello, world";
        translationRule = "en-ru";
        requestIp = "0.0.0.0.1";
    }

    @Test
    public void getTranslation() {

        String translatedText = translatorService.getTranslation(inputText, translationRule, requestIp);

        assertThat(translatedText).isNotNull().isNotEmpty();
        assertEquals(translatedText, EXPECTED_TRANSLATION);
    }

    @Test
    public void itShouldCatchIncorrectInputDataException() {

        IncorrectInputDataException exception = Assertions.assertThrows(IncorrectInputDataException.class, () -> {
            translatorService.getTranslation(inputText, ERROR_TRANSLATION_RULE, requestIp);
        });

        assertEquals(WRONG_TRANSLATION_RULE, exception.getMessage());
    }
}

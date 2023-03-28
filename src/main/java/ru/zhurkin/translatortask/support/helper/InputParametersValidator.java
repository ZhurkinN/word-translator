package ru.zhurkin.translatortask.support.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.zhurkin.translatortask.support.exception.IncorrectInputDataException;

import static ru.zhurkin.translatortask.support.constants.ErrorMessageKeeper.EMPTY_PARAMETERS;
import static ru.zhurkin.translatortask.support.constants.ErrorMessageKeeper.WRONG_TRANSLATION_RULE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputParametersValidator {

    public static void validateInputParameters(String inputText,
                                               String translationRule) {
        if (inputText.isEmpty() || translationRule.isEmpty()) {
            throw new IncorrectInputDataException(EMPTY_PARAMETERS);
        }

        if (translationRule.length() != 5 || translationRule.charAt(2) != '-') {
            throw new IncorrectInputDataException(WRONG_TRANSLATION_RULE);
        }
    }
}

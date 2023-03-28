package ru.zhurkin.translatortask.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessageKeeper {

    public static final String EMPTY_PARAMETERS = "Given parameters or parameter are empty!";
    public static final String WRONG_TRANSLATION_RULE = "Wrong format of translation rule! It must look like - en-ru";
    public static final String YANDEX_API_ERROR = "Something went wrong with API query!";

}

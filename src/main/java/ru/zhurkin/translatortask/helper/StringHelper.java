package ru.zhurkin.translatortask.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringHelper {

    public static List<String> separateWords(String text) {
        String editedText = text.replaceAll("\\s+", " ")
                .trim();
        return new ArrayList<>(List.of(editedText.split(" ")));
    }

    public static String uniteWords(List<String> words) {

        return String.join(" ", words);
    }

    public static String getTargetLanguage(String translationRule) {
        return translationRule.substring(3);
    }
}

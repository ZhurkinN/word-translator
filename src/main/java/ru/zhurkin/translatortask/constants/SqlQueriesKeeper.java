package ru.zhurkin.translatortask.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SqlQueriesKeeper {

    public static final String INSERT_REQUEST_QUERY = "" +
            "INSERT INTO request (date_time, input_text, translation_rule, ip) " +
            "VALUES (?, ?, ?, ?)";

    public static final String INSERT_TRANSLATED_WORD = "" +
            "INSERT INTO translated_words (request_id, input_word, translated_word) " +
            "VALUES (?, ?, ?)";

    public static final String SET_TRANSLATED_TEXT = "" +
            "UPDATE request " +
            "SET translated_text = ? " +
            "WHERE id = ?";
}

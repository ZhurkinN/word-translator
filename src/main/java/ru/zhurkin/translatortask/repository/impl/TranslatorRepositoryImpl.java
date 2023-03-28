package ru.zhurkin.translatortask.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.zhurkin.translatortask.repository.TranslatorRepository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import static ru.zhurkin.translatortask.constants.SqlQueriesKeeper.INSERT_REQUEST_QUERY;
import static ru.zhurkin.translatortask.constants.SqlQueriesKeeper.INSERT_TRANSLATED_WORD;

@Repository
@RequiredArgsConstructor
public class TranslatorRepositoryImpl implements TranslatorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveRequestInfo(Long id,
                                   LocalDateTime dateTime,
                                   String inputText,
                                   String translatedText,
                                   String translationRule,
                                   String ip) {

        int rowsChanged = jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_REQUEST_QUERY);
            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, dateTime);
            preparedStatement.setObject(3, inputText);
            preparedStatement.setObject(4, translatedText);
            preparedStatement.setObject(5, translationRule);
            preparedStatement.setObject(6, ip);
            return preparedStatement;
        });
        return rowsChanged > 0;
    }

    @Override
    public boolean saveTranslatedWord(Long id,
                                      Long requestId,
                                      String inputWord,
                                      String translatedWord) {

        int rowsChanged = jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_TRANSLATED_WORD);
            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, requestId);
            preparedStatement.setObject(3, inputWord);
            preparedStatement.setObject(4, translatedWord);
            return preparedStatement;
        });
        return rowsChanged > 0;
    }
}

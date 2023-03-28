package ru.zhurkin.translatortask.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.zhurkin.translatortask.repository.TranslatorRepository;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static ru.zhurkin.translatortask.support.constants.SqlQueriesKeeper.*;

@Repository
@RequiredArgsConstructor
public class TranslatorRepositoryImpl implements TranslatorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long saveRequestInfo(LocalDateTime dateTime,
                                String inputText,
                                String translationRule,
                                String ip) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                INSERT_REQUEST_QUERY,
                Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
        );
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator preparedStatementCreator =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        List.of(dateTime, inputText, translationRule, ip)
                );
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public boolean saveTranslatedWord(Long requestId,
                                      String inputWord,
                                      String translatedWord) {

        int rowsChanged = jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_TRANSLATED_WORD);
            preparedStatement.setObject(1, requestId);
            preparedStatement.setObject(2, inputWord);
            preparedStatement.setObject(3, translatedWord);
            return preparedStatement;
        });
        return rowsChanged > 0;
    }

    @Override
    public boolean setTranslatedText(Long requestId,
                                     String translatedText) {

        int rowsChanged = jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(SET_TRANSLATED_TEXT);
            preparedStatement.setObject(1, translatedText);
            preparedStatement.setObject(2, requestId);
            return preparedStatement;
        });
        return rowsChanged > 0;
    }
}

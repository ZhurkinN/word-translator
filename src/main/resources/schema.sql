CREATE TABLE IF NOT EXISTS request
(
    id bigint NOT NULL UNIQUE,
    date_time timestamp NOT NULL,
    input_text varchar(255) NOT NULL,
    translated_text varchar(255) NOT NULL,
    translation_rule varchar(255) NOT NULL,
    ip varchar(255) NOT NULL,
    CONSTRAINT pk_request PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS translated_words
(
    id bigint NOT NULL UNIQUE,
    request_id bigint NOT NULL,
    input_word varchar(255) NOT NULL,
    translated_word varchar(255) NOT NULL,
    CONSTRAINT pk_words PRIMARY KEY (id),
    CONSTRAINT fk_request FOREIGN KEY (request_id)
        REFERENCES request (id)
);

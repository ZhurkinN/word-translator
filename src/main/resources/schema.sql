drop table if exists request;
create table request
(
    id bigint not null unique,
    date timestamp not null,
    input_text varchar(255) not null,
    translated_text varchar(255) not null,
    translation_rule varchar(255) not null,
    ip varchar(255) not null
);

alter table request
    add constraint pk_id primary key(id);

drop table if exists translated_words;
create table translated_words
(
    id bigint not null,
    request_id bigint not null,
    input_word varchar(255) not null,
    translated_word varchar(255) not null
);

alter table translated_words
    add constraint fk_id foreign key(request_id)
        references request(id);
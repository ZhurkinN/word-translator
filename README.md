# Переводчик слов

## Описание
Приложение представляет собой REST-сервис, способный перевести предложение пословно на другой язык и записать результаты в базу данных.

## Пример запроса
На вход:
```javascript
{ 
  "inputText" : "hello, world",
  "translationRule" : "en-ru"
}
```
На выход:
```javascript
{ 
  "translatedText": "здравствуйте, мир"
}
```

## Гайд по запуску Docker

1) Клонируйте к себе этот проект <br>
2) В файле `docker-compose.yml` измените следующие поля конфигурации на свои:
```yaml
environment:
      - YANDEX_API_KEY=
      - YANDEX_FOLDER_ID=
      - DB_NAME=
      - DB_USER=
      - DB_PASSWORD=
```
3) Выполнить команду для сборки:
```sh
  docker compose build
```
4) Выполнить команду для запуска:
```sh
  docker-compose up
```

p.s.: Если докер не поднялся, то есть возможность запустить в ручную. <br>
Для этого в файле `src/main/resources/application.yml` необходимо именить поля конфигурации и запустить проект в IDE.
## Стек технологий
- ``Java 17``
- ``Spring Boot``
- ``Spring JDBC``
- ``Spring WebFlux``
- ``H2-database``
- ``REST``
- ``Gradle``
- ``Lombok``
- ``Docker``
- ``JUnit 5``
- ``Yandex API``
- ``Intellij Idea for IDE``

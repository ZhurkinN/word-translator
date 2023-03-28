# word-translator

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

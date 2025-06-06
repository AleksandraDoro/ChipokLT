Добро пожаловать в "Чипок-онлайн"! Мы вам рады, но не сильно!
Описание проекта
"Чипок-онлайн" — это сервис, который предоставляет информацию о товарах. Сервис использует заглушки (Mock01 и Mock02) для имитации внешних API и позволяет проводить НТ с помощью JMeter.

Архитектура
Проект состоит из основного сервиса (Application) и двух заглушек (Mock01 и Mock02). Основной сервис обрабатывает запросы и взаимодействует с заглушками для получения данных о товарах.

Сборка и запуск

Application
1. Сборка:
   mvn clean install
2. Запуск:
   mvn spring-boot:run
   Сервис будет доступен по адресу: http://localhost:8080

Mock01
1. Сборка:
   mvn clean install
2. Запуск:
   mvn spring-boot:run
   Заглушка будет доступна по адресу: http://localhost:8081

Запуск Mock02 (wiremock)
1. java -jar wiremock.jar --port 8082 --global-response-templating --container-threads 120 --no-request-journal --async-response-enabled true --async-response-threads 80
   Заглушка будет доступна по адресу: http://localhost:8082

## Нагрузочное тестирование с JMeter
1. Откройте JMeter и загрузите файл `chipok_script/Test_chipok.jmx`.
2. Убедитесь, что файл `items.csv` находится в директории `chipok_script`.
3. Запустите тест в JMeter.

Пример запроса к основному сервису
curl http://localhost:8080/api/item/{itemName}
Заменить {itemName} на название товара.

### Пример ответа
{
  "name": "Товар",
  "price": 100,
  "description": "Описание товара"
}

Дополнительная информация:
- Схема проекта и заметки в Figma: (https://www.figma.com/file/42apT2RakRBQUuK2kMMrRu/Untitled?type=design&node-id=0-1&mode=design&t=W5PdgAVV6VOGAwAW-0)
- Swagger UI: http://localhost:8080/swagger-ui/index.html#/Chipok's%20endpoints/getItemInfo

Документация
- Методика нагрузочного тестирования: `documentation/Методика нагрузочного тестирования Чипок.docx`
- Отчет по тесту: `documentation/Отчет по тесту поиска максимума Чипок-v8-20240307_132444.docx`
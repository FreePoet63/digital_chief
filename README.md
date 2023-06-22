# digital_chief
Для запуска приложения потребуются:

Java 17+, Maven 3.6.3+, PostgreSQL, Spring Framework 5

До запуска приложения необходимо создать Базу Данных в PostgreSQL, чтоб она и данные пула подключения была идентичными, как в файле свойств, application.properties: 

spring.datasource.url = jdbc:postgresql://localhost/gigital_chiefdb

spring.datasource.username = postgres

spring.datasource.password = 11111

Все необходимые библиотеки и зависмости находятся в файле, pom.xml

Файлы инициализации схемы Базы Данных, находятся в каталоге src/main/resources: schema.sql и data.sql  

Тестовые данные для проверки POST и PUT методов, лежат в testDataAuthorPostAndPut.json (реализация AuthorController) и testDataBookPostAndPut.json (реализация BookController), данные нужно скопировать и вставить в тело реализуемого запроса.

#  Данные для авторизации:

user - test

password - test

# Запуск приложения:

# Финальное задание курса, 2-я часть (AQA на JAVA Яндекс.Практикум)
Тестирование ручек API для Stellar Burgers [(документация)](https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf) с использованием JUnit 4, RestAssured и Allure.
Тестами покрыт перечисленный ниже функционал.
## Создание пользователя:
- создать уникального пользователя;
- создать пользователя, который уже зарегистрирован;
- создать пользователя и не заполнить одно из обязательных полей.
## Логин пользователя:
- логин под существующим пользователем,
- логин с неверным логином и паролем.
## Изменение данных пользователя:
- с авторизацией,
- без авторизации,
Для обеих ситуаций нужно проверить, что любое поле можно изменить. Для неавторизованного пользователя — ещё и то, что система вернёт ошибку.
## Создание заказа:
- с авторизацией,
- без авторизации,
- с ингредиентами,
- без ингредиентов,
- с неверным хешем ингредиентов.
## Получение заказов конкретного пользователя:
- авторизованный пользователь,
- неавторизованный пользователь.

### Критерии успешной сдачи
- Для каждой ручки тесты лежат в отдельном классе.
- Тесты запускаются и проходят.
- Написаны все тесты, указанные в задании.
- В тестах проверяется тело и код ответа.
- Все тесты независимы.
- Для всех шагов автотестов должна быть использована аннотация @Step.
- Нужные тестовые данные создаются перед тестом и удаляются после того, как он выполнится.
- Сделан Allure-отчёт. Отчёт добавлен в пул-реквест.
- Тесты в test/java.
- В файле pom.xml нет ничего лишнего.

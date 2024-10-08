# Featuric - Викторины 

## Описание проекта
Featuric — это веб-приложение, разработанное с использованием **Spring Boot**, которое позволяет пользователям участвовать в викторинах на различные темы. Проект использует **Spring Security** для авторизации и аутентификации, а также **Spring Data JPA** и **Hibernate** для взаимодействия с базой данных. **Thymeleaf** применяется для рендеринга динамических страниц, а миграции базы данных управляются с помощью **Flyway**.
Данный проект был написан в образовательных целях, чтобы разобраться как работать co Spring Framework, а также различными технологиями Java.

## Функциональные возможности
- Регистрация и аутентификация с использованием OAuth2.
- Прохождение викторин на разные темы.
- Сохранение и отображение результатов.
- Управление пользователями и викторинами через административную панель.
- Поддержка PostgreSQL и H2 баз данных.

## Используемые технологии
- **Spring Boot**: создание REST API.
- **Spring Security** и **OAuth2**: для безопасности и аутентификации.
- **Hibernate**: ORM для работы с базами данных.
- **Thymeleaf**: генерация динамических веб-страниц.
- **Flyway**: миграции базы данных.
- **JUnit**: тестирование.
- **PostgreSQL** и **H2**: базы данных.

## Установка и запуск проекта
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/KrisRadchikova/featuric.git

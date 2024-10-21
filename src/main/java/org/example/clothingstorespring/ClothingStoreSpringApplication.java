package org.example.clothingstorespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClothingStoreSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothingStoreSpringApplication.class, args);
    }

}
//Запуск сервера с помощью Spring Boot
//Основная зависимость-Эта зависимость включает в себя все необходимые настройки и зависимости для Spring Boot. Она служит основой для вашего проекта.
//<parent>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-parent</artifactId>
//    <version>3.3.4</version>
//</parent>

//Стартовый веб-модуль-Эта зависимость добавляет необходимые компоненты для разработки веб-приложений, включая встроенный сервер (обычно Tomcat). Это позволяет вам запускать приложение как веб-сервер.
//<dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-web</artifactId>
//</dependency>

//Плагин Maven: Этот плагин отвечает за процесс сборки и запуска приложения. Он предоставляет команды для запуска вашего приложения с помощью Maven
//<plugin>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-maven-plugin</artifactId>
//</plugin>

//Как это работает:
//Когда вы запускаете команду Maven, spring-boot-maven-plugin ищет основной класс вашего приложения, который должен быть помечен аннотацией @SpringBootApplication. Этот класс является точкой входа для вашего приложения.
//Плагин запускает встроенный сервер (по умолчанию Tomcat), который начинает слушать указанный порт (обычно 8080).
//Ваше приложение будет доступно по адресу http://localhost:8080, и вы сможете обращаться к его конечным точкам (endpoints).

//зависимости и плагины в вашем pom.xml файле обеспечивают функциональность для запуска сервера Spring Boot, что делает разработку веб-приложений более удобной и быстрой. Вы можете легко управлять зависимостями и конфигурацией проекта с помощью Maven.

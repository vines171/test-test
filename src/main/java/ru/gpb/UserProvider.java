package ru.gpb;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Класс провайдер, в котором обязательно переопределяются 2 метода
 *
 * @Override boolean supportsTestTemplate
 * возвращает истину, если тип параметра поддерживается
 *
 * @Override Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts (выбираем подходящее значение из выгрузки)
 * и создаётся
 * новый Stream.of(new TestTemplateInvocationContextBuilder() он будет применён в методе теста
 * в нём содержатся DISPLAY_NAME, String.class, WEB_SERVICE_PATH, User.class, request
 */

public class UserProvider implements TestTemplateInvocationContextProvider {
    public static final String DISPLAY_NAME = "Отправка корректного запроса";
    public static final String WEB_SERVICE_PATH = "https://reqres.in/api/users";

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        List<User> individualListBank = LegalList
                .getLegalList()
                .stream()
                .filter(user ->                 //выбираем не пустые значения, поля
                        user.getName() != null &&
                                user.getJob() != null &&
                                user.getAge() != null)

                .map(legal ->
                        User.UserBuilder
                                .aLoginRequestRequest()
                                .withName(legal.getName())
                                .withJob(legal.getJob())
                                .withAge(legal.getAge())
                                .build())
                .collect(Collectors.toList());

        User individualList = individualListBank
                .stream()
                .findFirst()
                .get();

        User request = individualList;

        return Stream.of(
                new TestTemplateInvocationContextBuilder()
                        .withDisplayName(DISPLAY_NAME)
                        .addParameterResolved(String.class, WEB_SERVICE_PATH)
                        .addParameterResolved(User.class, request)
                        .build()
        );
    }
}






package ru.gpb;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserProvider implements TestTemplateInvocationContextProvider {
    private static final String DISPLAY_NAME = "Отправка корректного запроса";
    protected static final String WEB_SERVICE_PATH = "https://reqres.in/api/users";

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        List<User> individualList = LegalList
                .getLegalList()
                .stream()
                .filter(user ->                 //выбираем не пустые значения, поля
                        user.getName() != null &&
                                user.getName() != null &&
                                user.getName() != null
                )
                .map(legal ->
                        User.Builder
                                .builder()
                                .withName(legal.getName())
                                .withJob(legal.getJob())
                                .withAge(legal.getAge())
                                .build())
                .collect(Collectors.toList());

        User individualList1 = individualList
                .stream()
                .findFirst()
                .get();


        User request = individualList1;

        return Stream.of(new TestTemplateInvocationContextBuilder()
                .withDisplayName(DISPLAY_NAME)
                .addParameterResolved(String.class, WEB_SERVICE_PATH)
                .addParameterResolved(User.class, request)
                .build()
        );
    }
}
package ru.gpb;// Чтение csv файла с разделенем

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CsvUtil {
    public static List<String[]> getAllLines (String testCsvResoursePath, char separator) {
        try {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .withQuoteChar('"')
                    .build();

            Reader reader = getReader(testCsvResoursePath);

            return
                    Collections.unmodifiableList(new CSVReaderBuilder(reader)
                            .withCSVParser(parser)
                            .withSkipLines(0)
                            .build()
                            .readAll());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удаётся считать csv файл");
        }
    }
    private static Reader getReader(String classPathResoursePath) {
        InputStream inputStream = CsvUtil.class.getClassLoader().getResourceAsStream(classPathResoursePath);
        return new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
    }

//    public static class UserProvider  implements TestTemplateInvocationContextProvider {
//        private static final String DISPLAY_NAME = "Отправка корректного запроса";
//        protected static final String WEB_SERVICE_PATH  = "https://reqres.in/api/users";
//
//        @Override
//        public boolean supportsTestTemplate(ExtensionContext context) {
//            return true;
//        }
//
//        @Override
//        public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
//            List<User> individualList = LegalList
//                    .getLegalList()
//                    .stream()
//                    .filter(user ->                 //выбираем не пустые значения, поля
//                            user.getName() != null &&
//                                    user.getName() != null &&
//                                    user.getName() != null
//                    )
//                    .map(legal ->
//                            User.Builder
//                            .builder()
//                            .withName(legal.getName())
//                            .withJob(legal.getJob())
//                                    .withAge(legal.getAge())
//                            .build())
//                    .collect(Collectors.toList());
//
//            User individualList1 = individualList
//                    .stream()
//                    .findFirst()
//                    .get();
//
//
//            User request = individualList1;
//
//            return Stream.of(new TestTemplateInvocationContextBuilder()
//                    .withDisplayName(DISPLAY_NAME)
//                    .addParameterResolved(String.class, WEB_SERVICE_PATH)
//                    .addParameterResolved(User.class, request)
//                    .build()
//            );
//        }
    }


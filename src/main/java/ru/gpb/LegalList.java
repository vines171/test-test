package ru.gpb;

import java.util.List;
import java.util.stream.Collectors;

import static ru.gpb.CsvUtil.getAllLines;

public class LegalList {
    private static final String ORGANIZATIONS_DATA_PATH = "src/test/resources/testDate.csv"; // прописываем путь до файла, который не меняется
    private static final List<String[]> ORGANIZATIONS_DATA = getAllLines(ORGANIZATIONS_DATA_PATH, ','); // превращаем в список массива и разделяем значение знаком ","
    private static List<User> LEGAL_LIST = getLegalList(ORGANIZATIONS_DATA); // делаем из массива список List<User>

    public static List<User> getLegalList(List<String[]> organizationsData) {
        /**
          метод, который возвращает стрим размапиных по name, job, age
         */
          return organizationsData
                .stream()
                .map(string -> {
                            String name = string[0];
                            String job = string[1];
                            String age = string[2];
                            return User
                                    .UserBuilder
                                    .aLoginRequestRequest()
                                    /**
                                     * собирает значения name, job, age
                                     */
                                    .withName(name)
                                    .withJob(job)
                                    .withAge(age)
                                    .build();
                        }
                ).collect(Collectors.toList());
//                    ).collect(Collectors.collectingAndThen(
//                                Collectors.toList(),
//                                x -> Collections.unmodifiableList(x)));
//                ).collect(Collectors.toUnmodifiableList());// неизменяемый список
    }

    public static List<User> getLegalList(){
        /**
         *  возвращаем  список List<User>
         */
        return LEGAL_LIST;
    }
}


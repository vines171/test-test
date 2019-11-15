package ru.gpb;

//import com.typesafe.config.ConfigFactory;
import java.util.List;
import java.util.stream.Collectors;

import static ru.gpb.CsvUtil.getAllLines;

public class LegalList {
    public static void main(String[] args) {
    }
    private static final String ORGANIZATIONS_DATA_PATH = "src/test/resources/testDate.csv"; // прописываем путь до файла, который не меняется
   // private static final String ORGANIZATIONS_DATA_PATH = ConfigFactory.load().getString("user.read");

    private static final List<String[]> ORGANIZATIONS_DATA = getAllLines(ORGANIZATIONS_DATA_PATH, ','); // превращаем в список массива и разделяем значение знаком ","
    private static final List<User> LEGAL_LIST = getLegalList(ORGANIZATIONS_DATA); // делаем из массива список List<User>

    private static List<User> getLegalList(List<String[]> organizationData) {
        /**
          метод, который возвращает стрим размапиных по name, job, age
         */
          return organizationData
                .stream()
                .map(strings ->  {
                    String name = strings[0];
                    String job = strings[1];
                    String age = strings[2];

                    return User.Builder
                            /**
                             * собирает значения name, job, age
                             */
                            .builder()
                            .withName(name)
                            .withJob(job)
                            .withAge(age)
                            .build();
                })
//                .filter(person ->
//                        person.getAge() != null)
        .collect(Collectors.toList());
//        .collect(Collectors.toUnmodifiableList()); // неизменяемый список

    }
    public static List<User> getLegalList(){
        /**
         *  возвращаем  список List<User>
         */
        return LEGAL_LIST;
    }
}

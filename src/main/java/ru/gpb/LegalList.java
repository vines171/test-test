package ru.gpb;
//C:\Users\Ira\projects\test-test\src\test\resources\testDate.csv

import java.util.List;
import java.util.stream.Collectors;


public class LegalList {
    private static final String ORGANIZATIONS_DATA_PATH = "src\\test\\resources\\testDate.csv"; // прописываем путь до файла, который не ихменяется
    private static final List<String[]> ORGANIZATIONS_DATA = CsvUtil.getAllLines(ORGANIZATIONS_DATA_PATH, ','); // превращаем в список массива и разделяем значение знаком ","
    private static final List<User> LEGAL_LIST = getLegalList(ORGANIZATIONS_DATA); // делаем из массива список List<User>


    private static List<User> getLegalList(List<String[]> organizationData) {
        return organizationData // метод, который возвращает стрим размапиных по name, job, age
                .stream()
                .map(strings ->  {
                    String name = strings[0];
                    String job = strings[1];
                    String age = strings[2];

                    return User.Builder  //собирает значения name, job, age
                            .builder()
                            .withName(name)
                            .withJob(job)
                            .withAge(age)
                            .build();
                })
        .collect(Collectors.toList());
        //.collect(Collectors.toUnmodifiableList());  неизменяемый список
    }
    public static List<User> getLegalList(){
        return LEGAL_LIST; // возвращаем  список List<User>
    }
}

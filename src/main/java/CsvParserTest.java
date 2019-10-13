//package ru.gpb.generators;
//
//import org.supercsv.cellprocessor.constraint.NotNull;
//import org.supercsv.cellprocessor.ift.CellProcessor;
//import org.supercsv.io.CsvBeanReader;
//import org.supercsv.io.ICsvBeanReader;
//import org.supercsv.prefs.CsvPreference;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CsvParserTest {
//    private static List<String[]> getCsvParserTest (List<String[]> stringUser1)
//            throws IOException {
//        List<User> userList = new ArrayList<>();
//        ICsvBeanReader csvBeanReader = new CsvBeanReader(new FileReader("src/test/resources/testDate.csv"), CsvPreference.STANDARD_PREFERENCE);
//
//        String[] mapping = new String[]{"name", "job", "age"};
//        CellProcessor[] procs = getProcessors();
//        User user;
//        while ((user = csvBeanReader.read(User.class, mapping, procs)) != null) {
//            userList.add(user);
//        }
//        List<String[]> userList1 = new ArrayList<>();
//        userList.add((User) userList);
//
//        List<User> stringUser = userList1
//                .stream()
//                .map(strings -> {
//                            User individual = new User();
//                    individual.setName(strings[0]);
//                    individual.setJob(strings[1]);
//                    individual.setAge(strings[2]);
//                            return individual;
//                        }
//                ).collect(Collectors.toList());
//
//        csvBeanReader.close();
////        return stringUser.stream().collect(Collectors.toList());
//        return stringUser1;
//    }
//
//    public static List<User> getCsvParserTest() {
//        return stringUser;
//    }
//
//    public static CellProcessor[] getProcessors() {
//        return new CellProcessor[]{
//                new NotNull(),
//                new NotNull(),
//                new NotNull()
//        };
//    }
//}
//
//
//

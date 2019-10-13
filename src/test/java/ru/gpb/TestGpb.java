package ru.gpb;

//import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

        import static io.restassured.RestAssured.*;

        import static org.hamcrest.core.IsEqual.equalTo;



class TestGpb  {

//    private static final Logger logger = LoggerFactory.getLogger(TestGpb.class);

    @Test
    @DisplayName("Ололо мой тест")
    void test() {
        given()
                .log()
                .all()
                //.get("https://reqres.in/api/users")
                .get("https://reqres.in/api/users")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("page", equalTo(1));
//                .body("data[0].id", equalTo(0))
//                .body("data[1].id", equalTo(1));

    }

//    @TestTemplate
//    // @MethodSource("newUserNameJobNumbers")
//    @ExtendWith(UserProvider.class)
//   // @DisplayName("Имя и профессия заполненны валидными значениями")
//    void testNewUserNameJobNumbers(Request request, String webServicePath) {
//        given()
//                .log()
//                .all()
//                .body(request)
//                .post(webServicePath)
//                .then()
//                .log()
//                .all()
//                .statusCode(201)
//                .body("id", notNullValue());
//    }


//    @Test
//    @MethodSource("createNewUser")
//    @DisplayName("Создание пользователя")
//    void testCreateNewUser(User user) {
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/users")
//                .then()
//                .log()
//                .all()
//                .statusCode(201)
//                .body("id", notNullValue());
//    }
//
//    private static Stream<Arguments> createNewUser() {
//        return Stream.of(
//                Arguments.of(new User.Builder.("morpheus").withJob("leader").build()));
//    }
//
//    @MethodSource("newUserUppercaseName")
//    @DisplayName("Создание пользователя в верхнем регистре")
//      void  testCreateNewUserUppercase(User user) {
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/users")
//                .then()
//                .log()
//                .all()
//                .statusCode(201)
//                .body("id", notNullValue());
//    }
//    private static Stream<Arguments> newUserUppercaseName() {
//        return Stream.of(
//                Arguments.of(new User.Builder("ВАСЯ").withJob("раб").withAge("300").build()),
//                Arguments.of(new User.Builder("КАТЯ").withJob("лекарь").build()),
//                Arguments.of(new User.Builder("ОЛЕГ").withAge("40").build()));
//    }
//
//    @MethodSource("newUserUppercaseNameAndJob")
//    @DisplayName("Создание пользователя и должности в верхнем регистре")
//    void testCreateNewUserUppercaseNameAndJob(User user) {
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/users")
//                .then()
//                .log()
//                .all()
//                .statusCode(201)
//                .body("id", notNullValue());
//    }
//
//    private static Stream<Arguments> newUserUppercaseNameAndJob() {
//        return Stream.of(
//                Arguments.of(new User.Builder("Вася").withJob("Жнец, певец, на дуде игрец").withAge("500").build()),
//                Arguments.of(new User.Builder("Оля").withJob("Танцор диско").build()),
//                Arguments.of(new User.Builder("Актёр").withAge("45").build()),
//                Arguments.of(new User.Builder("Олег").withJob(RandomStringUtils.randomAlphabetic(10)).build()));
//        //      Arguments.of(new User.Builder("Глеб").withJob(" ").build());
//
//    }
//
//    @MethodSource("userUpdate")
//    @DisplayName("Обновление пользователя")
//    void testUpdateUser(User user) {
//        String id = given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/users")
//                .then()
//                .log()
//                .all()
//                .extract()
//                .body()
//                .jsonPath()
//                .get("id");
//        given()
//                .log()
//                .all()
//                .body(user)
//                .patch("https://reqres.in/api/users/{id}", id)
//                .then()
//                .log()
//                .all()
//                .statusCode(200)
//                .body("name", equalTo("Олег"))
//                .body("job", equalTo("слесарь"));
//    }
//
//    private static Stream<Arguments> userUpdate() {
//        return Stream.of(
//                Arguments.of(new User.Builder("Олег").withJob("слесарь").build()));
//    }
//
//    @Test
//    @DisplayName("Удаление пользователя")
//    void testDeleteUser(User user) {
//        String id = given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/users")
//                .then()
//                .log()
//                .all()
//                .extract()
//                .body()
//                .jsonPath()
//                .get("id");
//
//        given()
//                .log()
//                .all()
//                .delete("https://reqres.in/api/users/{id}", id)
//                .then()
//                .log()
//                .all()
//                .statusCode(204);
//    }
//
//    @MethodSource("registerSuccessful")
//    @DisplayName("Регистрация пользователя удачная")
//    void testRegisterSuccessful(User user) {
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/register")
//                .then()
//                .log()
//                .all()
//                .statusCode(200)
//                .body("id", notNullValue());
//    }
//
//    private static Stream<Arguments> registerSuccessful() {
//        return Stream.of(
//                Arguments.of(new User.Builder("Екатерина").withAge("20").withJob("сантехник").build()));
//    }
//
//
//    @MethodSource("registerFailed")
//    @DisplayName("Регистрация пользователя")
//    void testRegisterUnSuccessful(User user) {
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post() //"https://reqres.in/api/login"
//                .then()
//                .statusCode(400)
//                .body("error", equalTo("Missing password"));
//    }
//    private static Stream<Arguments> registerFailed() {
//        return Stream.of(
//                Arguments.of(new User.Builder("#@*%^+-").build()),
//                Arguments.of(new User.Builder("№#Наф-наф").withAge("5").withJob(RandomStringUtils.randomAlphabetic(10)).build()));
//    }
//    @Test
//    @MethodSource("loginSuccessful")
//    @DisplayName("Успешный сход в систему")
//    void testLoginSuccessful(User user) {
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/register")
//                .then()
//                .log()
//                .all()
//                .extract()
//                .body()
//                .jsonPath()
//                .get("id");
//        given()
//                .log()
//                .all()
//                .body(user)
//                .post("https://reqres.in/api/login")
//                .then()
//                .log()
//                .all()
//                .statusCode(201)
//                .body("name", equalTo("Ниф-ниф"));
//    }
//
//    private static Stream<Arguments> loginSuccessful() {
//        return Stream.of(
//                Arguments.of(new User.Builder("Наф-наф").withAge("7").withJob("парасёнок").build()));
//    }
//
//
//
//    @MethodSource
//    @DisplayName("Ресурс не найден")
//    void testNotFoundResource() {
//        given()
//                .log()
//                .all()
//                .get("https://reqres.in/api/unknown/43")
//                .then()
//                .log()
//                .all()
//                .statusCode(404);
//    }
//
//    @MethodSource
//    @DisplayName("Список ресурса")
//    void  testListResource() {
//        given()
//                .log()
//                .all()
//                .get("https://reqres.in/api/unknown")
//                .then()
//                .log()
//                .all()
//                .statusCode(200);
//    }
//
//    @MethodSource
//    @DisplayName("Список пользователей")
//    void testListUsers(){
//        given()
//                .log()
//                .all()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .log()
//                .all()
//                .statusCode(200);
//    }

}

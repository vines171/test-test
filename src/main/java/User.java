import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.RandomStringUtils;

@JsonSerialize
public class User {
    private String name;
    private String job;
    private String age;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getAge() {
        return age;
    }


    public void setName(String name) {
    this.name = name;
}

    public void setJob(String job) {
        this.job = job;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static class Builder  {
        private String name;
        private String job;
        private String age;
        private User user;


        public static Builder builder() {
            return null;
        }

//        public Builder(String name) { //делаем обязатель ное поле name
//            this.user = new User();
//            user.setName(name);
//        }

        public  Builder withName(String name) {
            user.setName(name);
            return this;
        }

        public Builder withJob(String job) {
            user.setJob(job);
            return this;
        }

        public Builder withAge(String age) {
            user.setAge(age);
            return this;
        }

        public User build(){
            return user;
        }
    }

    String genStrAndNumber = RandomStringUtils.randomAlphanumeric(10);
    String genStr = RandomStringUtils.randomAlphabetic(10);
    String genInt = RandomStringUtils.randomNumeric(10);
    String genStrCapsLk = RandomStringUtils.randomAlphabetic(10).toLowerCase();
}

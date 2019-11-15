package ru.gpb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.RandomStringUtils;

@JsonSerialize
public class User {
    private String name;
    private String job;
    private String age;

    public void withName(String name) {
        this.name = name;
    }

    public void withJob(String job) {
        this.job = job;
    }

    public void withAge(String age) {
        this.age = age;
    }
    
    public static Builder builder() {
        return new User.Builder();
    }
    

    public String getName() { return name; }

    public String getJob() { return job; }

    public String getAge() {
        return age;
    }

    public static class Builder  {
        private String name;
        private String job;
        private String age;
        private User user;

        public static Builder builder() {
            return new User.Builder();
        }


        public  Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withJob(String job) {
            this.job = job;
            return this;
        }

        public Builder withAge(String age) {
            this.age = age;
            return this;
        }

        public User build(){
            return user;
        }

        public String getName() { return name; }

        public String getJob() {
            return job;
        }

        public String getAge() {
            return age;
        }
    }

    String genStrAndNumber = RandomStringUtils.randomAlphanumeric(10);
    String genStr = RandomStringUtils.randomAlphabetic(10);
    String genInt = RandomStringUtils.randomNumeric(10);
    String genStrCapsLk = RandomStringUtils.randomAlphabetic(10).toLowerCase();
}


//        public Builder(String name) { //делаем
// обязатель ное поле name
//            this.user = new User();
//            user.setName(name);
//        }
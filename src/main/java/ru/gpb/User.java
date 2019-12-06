package ru.gpb;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job",
        "age"
})
public class User {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("age")
    private String age;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("name");
//        sb.append('=');
//        sb.append(((this.name == null)?"<null>":this.name));
//        sb.append(',');
//        sb.append("job");
//        sb.append('=');
//        sb.append(((this.job == null)?"<null>":this.job));
//        sb.append(',');
//        sb.append("age");
//        sb.append('=');
//        sb.append(((this.age == null)?"<null>":this.age));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.job == null)? 0 :this.job.hashCode()));
        result = ((result* 31)+((this.age == null)? 0 :this.age.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return (((((this.job == rhs.job)||((this.job != null)&&this.job.equals(rhs.job)))&&((this.age == rhs.age)||((this.age!= null)&&this.age.equals(rhs.age))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.name == rhs.name)||((this.name != null)&&this.name.equals(rhs.name))));
    }

    public static final class UserBuilder {
        private User loginRequestRequest;

        public UserBuilder() {
            loginRequestRequest = new User();
        }

        public static UserBuilder aLoginRequestRequest() {
            return new UserBuilder();
        }

        public UserBuilder withName(String name) {
            loginRequestRequest.setName(name);
            return this;
        }

        public UserBuilder withJob(String job) {
            loginRequestRequest.setJob(job);
            return this;
        }

        public UserBuilder withAge(String age) {
            loginRequestRequest.setAge(age);
            return this;
        }

        public User build() {
            return loginRequestRequest;
        }
    }
}
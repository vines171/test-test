package ru.gpb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job",
        "id",
        "age"
})
public class LegalObject {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private String id;
    @JsonProperty("age")
    private String age;

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
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("age")
    public String getAge() {
        return age;
    }
    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LegalObject)) return false;
        LegalObject that = (LegalObject) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getJob(), that.getJob()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getJob(), getId(), getAge());
    }



    public static final class LegalObjectBuilder {
        private LegalObject legalObject;

        public LegalObjectBuilder(){
            legalObject = new LegalObject();}
        }

    }


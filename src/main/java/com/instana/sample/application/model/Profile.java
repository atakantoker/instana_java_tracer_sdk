package com.instana.sample.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @Generated
    private String id;

    private String name;

    private String employer;

    private String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmployer() {
        return employer;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

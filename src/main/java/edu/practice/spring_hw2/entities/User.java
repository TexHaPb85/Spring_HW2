package edu.practice.spring_hw2.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Map;

public class User {
    private String name;
    private String surName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate lastLoginDate;

    @JsonIgnore
    private String accessId;

    private String email;
    private Map<String, Boolean> doneHomework;

    public User(String name, String surName, LocalDate lastLoginDate, String accessId, String email, Map<String, Boolean> doneHomework) {
        this.name = name;
        this.surName = surName;
        this.lastLoginDate = lastLoginDate;
        this.accessId = accessId;
        this.email = email;
        this.doneHomework = doneHomework;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Boolean> getDoneHomework() {
        return doneHomework;
    }

    public void setDoneHomework(Map<String, Boolean> doneHomework) {
        this.doneHomework = doneHomework;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", accessId='" + accessId + '\'' +
                ", email='" + email + '\'' +
                ", doneHomework=" + doneHomework +
                '}';
    }
}

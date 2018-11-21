package com.skills.bean;

import com.skills.composer.Composer;

import java.util.Date;

public class User {
    public static final Composer<Long, User> USER_ID_COMPOSER = new Composer<Long, User>() {
        @Override
        public Long getComposerId(User var1) {
            return var1.getId();
        }
    };

    Long id;
    String name;
    Integer age;
    Date birthDay;

    public User(Long id, String name, Integer age, Date birthDay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                '}';
    }
}

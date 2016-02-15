package com.springapp.mvc.classes;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Анатолий on 13.02.2016.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "name")
    @Size(min = 1, max = 25)
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "isAdmin")
    private boolean isAdmin;
    @Column(name = "createdDate")
    private Date createdDate;

    public User() {
    }
    public User(long id){
        this.id=id;
    }

    public User(long id, String name, int age, boolean isAdmin, Date createdDate) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate = createdDate;
    }

    public User(String name, int age, boolean isAdmin) {
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate=new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date timestamp) {
        this.createdDate = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

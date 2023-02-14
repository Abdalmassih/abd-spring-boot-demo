package com.abdalmassih;

import java.util.Objects;

public class Customer {
    private int id;
    private int age;
    private String name;
    private String mail;

    public Customer(int id, int age, String name, String mail) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.mail = mail;
    }

    public Customer() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", age='" + getAge() + "'" +
                ", name='" + getName() + "'" +
                ", mail='" + getMail() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return id == customer.id && age == customer.age && Objects.equals(name, customer.name)
                && Objects.equals(mail, customer.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, mail);
    }

}

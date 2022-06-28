package com.training.calculator.person;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private Integer height;
    private Integer weight;
    private LocalDate birthdate;

    public static Person create(){
        return new Person();
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Person setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Person setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Person setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name,
                              person.name) && Objects.equals(surname,
                                                             person.surname)
                && Objects.equals(height,
                                  person.height) && Objects.equals(weight,
                                                                   person.weight)
                && Objects.equals(birthdate,
                                  person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            surname,
                            height,
                            weight,
                            birthdate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthdate=" + birthdate +
                '}';
    }
}

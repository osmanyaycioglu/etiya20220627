package com.training.calculator.person;

import java.time.LocalDate;

public class PersonRun {
    public static void main(String[] args) {
        Person person = new Person().setName("osman")
                                    .setSurname("aya")
                                    .setHeight(200)
                                    .setWeight(95)
                                    .setBirthdate(LocalDate.of(1970,
                                                               9,
                                                               11));
        Person person2 = Person.create()
                              .setName("osman")
                              .setSurname("aya")
                              .setHeight(200)
                              .setWeight(95)
                              .setBirthdate(LocalDate.of(1970,
                                                         9,
                                                         11));

    }
}

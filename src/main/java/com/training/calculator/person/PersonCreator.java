package com.training.calculator.person;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;

public class PersonCreator {

    public Person createOldPerson(int year) {
        Random random = new SecureRandom();
        return Person.create()
                     .setName("osman" + random.nextInt())
                     .setSurname("aya" + random.nextInt())
                     .setHeight(random.nextInt(250))
                     .setWeight(random.nextInt(200))
                     .setBirthdate(LocalDate.of(year,
                                                random.nextInt(12),
                                                random.nextInt(30)));
    }

    public Person createFatPerson(int weight) {
        Random random = new SecureRandom();
        return Person.create()
                     .setName("mehmet")
                     .setSurname("aya")
                     .setHeight(200)
                     .setWeight(95)
                     .setBirthdate(LocalDate.of(2010 - random.nextInt(30),
                                                random.nextInt(12),
                                                random.nextInt(30)));
    }

    public Person createOldPerson(String name,
                                  String surname,
                                  int height,
                                  int weight,
                                  LocalDate localDate) {
        return Person.create()
                     .setName(name)
                     .setSurname(surname)
                     .setHeight(height)
                     .setWeight(weight)
                     .setBirthdate(localDate);
    }

    public Person notCreatePerson(int year) {
        throw new IllegalStateException("olmadı");
    }

}

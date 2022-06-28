package com.training.calculator.person;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PersonCreatorTest {

    PersonCreator personCreator;

    @BeforeEach
    void setUp() {
        personCreator = new PersonCreator();
    }

    @AfterEach
    void tearDown() {
    }

    Condition<Person> fatPerson = new Condition<>(p -> p.getWeight() > 100,
                                                  "şişman adam 100 kilodan fazla olmalı");
    Condition<Person> oldPerson = new Condition<>(p -> p.getBirthdate()
                                                        .isBefore(LocalDate.of(2000,
                                                                               1,
                                                                               1)),
                                                  "yaşlı adam");

    @Test
    @DisplayName("Old Person Testi")
    void createOldPerson() {
        Person oldPerson = personCreator.createOldPerson(1980);

        assertThat(oldPerson.getName()).as("Person Name Testi")
                                       .contains("osman")
                                       .contains("os")
                                       .containsSubsequence("man")
                                       .containsAnyOf("os",
                                                      "kos",
                                                      "mos")
                                       .startsWith("os");
        assertThat(oldPerson).as("sub old person testi")
                             .isExactlyInstanceOf(Person.class)
                             .is(this.fatPerson)
                             .is(this.oldPerson);
        assertThat(oldPerson.getHeight() > 100).as("Tall person test")
                                               .isEqualTo(true);
        assertThat(oldPerson.getHeight()).isGreaterThan(100)
                                         .isPositive();
        assertThatThrownBy(() -> personCreator.notCreatePerson(100)).isInstanceOf(IllegalStateException.class)
                                                                    .hasMessageContaining("olma")
                                                                    .hasMessageStartingWith("olmadı");
    }

}
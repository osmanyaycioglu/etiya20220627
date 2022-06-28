package com.training.pack.usage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProcessSomethingTest {
    ProcessSomething ps;

    @BeforeEach
    void setUp() {
        ps = new ProcessSomething();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void processPublic() {
        assertThat(ps.processPublic("osman")).as("process something public test")
                                             .contains("osman")
                                             .startsWith("Processed")
                                             .isEqualTo("Processed osman");
    }

    @Test
    void processProtected() {
        assertThat(ps.processProtected("osman")).as("process something public test")
                                             .contains("osman")
                                             .startsWith("Processed")
                                             .isEqualTo("Processed osman");
    }

    @Test
    void processPackageProtected() {
        assertThat(ps.processPackagePrivate("osman")).as("process something public test")
                                                     .contains("osman")
                                                     .startsWith("Processed")
                                                     .isEqualTo("Processed osman");
    }
}
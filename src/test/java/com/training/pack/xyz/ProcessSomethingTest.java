package com.training.pack.xyz;

import com.training.pack.usage.ProcessSomething;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}
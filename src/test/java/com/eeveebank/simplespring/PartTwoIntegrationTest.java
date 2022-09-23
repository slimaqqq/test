package com.eeveebank.simplespring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"test", "part2"})
public class PartTwoIntegrationTest {

    // Please feel free to use whatever method of testing the endpoints you think is appropriate or you are familiar with.

    @Test
    public void test() throws Exception {
    }
}

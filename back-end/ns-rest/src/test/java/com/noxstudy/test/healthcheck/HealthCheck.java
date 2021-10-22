package com.noxstudy.test.healthcheck;

import com.noxstudy.rest.controller.UserRestController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserRestController.class)
public class HealthCheck {
    @Test
    public void healthCheckAssertion() {
        Assertions.assertEquals(1,2);
    }
}

package ru.netology.springbootauthorization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.file.Paths;

@DisplayName("Verification of authorization")
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootAuthorizationApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Container
    private static final GenericContainer<?> genContainer = new GenericContainer<>(
            new ImageFromDockerfile().withDockerfile(Paths.get("./Dockerfile")))
            .withExposedPorts(8080);

    @Test
    @DisplayName("Login test")
    void contextLoads() {
        final String host = "http://localhost:";
        final String expected = "[\"READ\",\"WRITE\",\"DELETE\"]";
        final String authorizeUser = "/authorize?user=Andrew&password=1234";
        Integer appPort = genContainer.getMappedPort(8080);
        ResponseEntity<String> result = restTemplate.getForEntity(host + appPort + authorizeUser, String.class);

        Assertions.assertEquals(expected, result.getBody());
        System.out.println("Test Ok!\n=> " + expected + " = " + result.getBody());
    }
}

package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.lifecyclemanager.QuarkusTestResourceLM;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(QuarkusTestResourceLM.class)
public class GreetingResourceTest {

    @Test
    public void should_return_aloha_test() {
        given()
          .when().get("/hello-resteasy")
          .then()
             .statusCode(200)
             .body(is("ALOHA TEST"));
    }

}
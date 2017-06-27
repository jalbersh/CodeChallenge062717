package acceptance;

import com.dish.ofm.service.APPLICATION_NAMEApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

@SpringApplicationConfiguration(classes = APPLICATION_NAMEApplication.class)
@WebIntegrationTest(randomPort = true)
@ActiveProfiles("ci")
@RunWith(SpringJUnit4ClassRunner.class)
public class APPLICATION_NAMETest {
    @Value("${local.server.port}")
    private int port;

    @Rule
    public MockServerRule mockServerRule = new MockServerRule(this, true, 9000);

    private MockServerClient externalServices;

    @Before
    public void setup() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://127.0.0.1";
    }

    @After
    public void tearDown() {
        externalServices.reset();
    }

    @Test
    public void REST_ENDPOINT_CAMEL_CASE_returnsSuccess() throws Exception {
        Response REST_ENDPOINT_CAMEL_CASEResponse = given()
            .when()
            .accept("application/json")
            .contentType("application/json")
            .queryParam("sessionId", "78903jhtioert893475934")
            .queryParam("agentId", "james.bond")
            .get("/REST_ENDPOINT")
            .then()
            .statusCode(200)
            .extract()
            .response();
    }
}

package termone.devops.exam;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathCalculationEndToEnd {
    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testApiEndpoint() {
        String url = "http://localhost:" + port + "/api/someEndpoint";
        String response = restTemplate.getForObject(url, String.class);

        assertEquals("Expected Response", response);
    }
}

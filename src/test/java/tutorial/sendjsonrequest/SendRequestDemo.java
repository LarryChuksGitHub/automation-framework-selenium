package tutorial.sendjsonrequest;

import org.assertj.core.api.Assertions;
import org.testng.SkipException;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SendRequestDemo {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("testcaseName", "Test 1");
        map.put("Author", "larry");
        map.put("testStatus", "pass");
        map.put("time",LocalDateTime.now().toString());
       // throw new SkipException("Skipping the test");
        var response = given().header("Content-Type", "application/json")
                .log()
                .all()
                .body(map)
                .post("localhost/3332/movies");

        //Assertions.assertThat(response).isNotNull().isEqualTo(201);

    }

}

package pl.venustus.ExSpringApiHello.app;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@RestController
public class Hello {

    @GetMapping("/do")
    public void sendDataToElectronicApps() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Computer[]> responseEntity = restTemplate.exchange("https://localhost:8080/api/computers/get",
                HttpMethod.GET,
                null,
                Computer[].class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);

    }

    @GetMapping("/")
    public String hello() {
        return "Hello.";
    }

}

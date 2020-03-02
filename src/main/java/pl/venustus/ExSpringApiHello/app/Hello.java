package pl.venustus.ExSpringApiHello.app;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@RestController
public class Hello {

    @GetMapping("/getElectronicsData")
    public void getElectronicsData() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Computer[]> responseEntity = restTemplate.exchange("http://localhost:8080/api/computers/get",
                HttpMethod.GET,
                null,
                Computer[].class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);

    }

    @DeleteMapping("/deleteElectronicData")
    public void deleteElectronicData(@RequestParam long removeId) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/computers/delete?id=" + removeId;

        System.out.println(url);

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url,
                HttpMethod.DELETE,
                null,
                Boolean.class);

        System.out.println(responseEntity.getBody());
    }

    @GetMapping("/")
    public String hello() {
        return "Hello.";
    }

}

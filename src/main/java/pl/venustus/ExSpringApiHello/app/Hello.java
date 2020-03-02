package pl.venustus.ExSpringApiHello.app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/deleteElectronicData")
    public void deleteElectronicData(@RequestParam int id) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/computers/delete?id=" + id;

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url,
                HttpMethod.DELETE,
                null,
                Boolean.class);
        System.out.println(responseEntity.getBody());
    }

    @GetMapping("/addElectronicData")
    public void addElectronicData() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        String url = "http://localhost:8080/api/computers/add";
        String objToSent = " {\n" +
                "        \"id\": 4,\n" +
                "        \"ddrType\": \"dd4\",\n" +
                "        \"mhz\": 400,\n" +
                "        \"memorySize\": 40\n" +
                "    }";

        HttpEntity httpEntity = new HttpEntity(objToSent, httpHeaders);

        restTemplate.exchange(url,
                HttpMethod.POST,
                httpEntity,
                void.class);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello.";
    }

}

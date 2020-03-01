package pl.venustus.ExSpringApiHello.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/do")
    public void sendDataTo() {

    }

    @GetMapping("/")
    public String hello() {
        return "Hello.";
    }

}

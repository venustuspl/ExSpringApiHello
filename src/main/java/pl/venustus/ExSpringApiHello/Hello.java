package pl.venustus.ExSpringApiHello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/dw")
    public void sendDataTo() {
    }


}

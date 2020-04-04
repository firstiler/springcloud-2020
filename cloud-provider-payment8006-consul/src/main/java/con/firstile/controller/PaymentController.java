package con.firstile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment")
    public String payment(){

        return "SpringCloud_PaymentWithConsul_ServerPort=" + serverPort;
    }

}

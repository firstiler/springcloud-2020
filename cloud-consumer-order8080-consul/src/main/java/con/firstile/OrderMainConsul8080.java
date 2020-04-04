package con.firstile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainConsul8080 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainConsul8080.class, args);
    }

}

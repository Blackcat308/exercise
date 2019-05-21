package exercise.bc.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("exercise.bc.app.*.mapper")
public class BcAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcAppApplication.class, args);
    }

}

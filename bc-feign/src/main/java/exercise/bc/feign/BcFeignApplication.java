package exercise.bc.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author BlackCat
 * @Description //TODO feign端
 * @Date 10:53 2019/3/27
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BcFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcFeignApplication.class, args);
    }

}

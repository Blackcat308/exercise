package exercise.bc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author BlackCat
 * @Description //TODO
 * @Date 9:47 2019/3/27
 **/
@EnableEurekaClient
@SpringBootApplication
public class BcWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcWebApplication.class, args);
	}

}

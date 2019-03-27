package exercise.bc.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BcAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcAdminApplication.class, args);
	}

}

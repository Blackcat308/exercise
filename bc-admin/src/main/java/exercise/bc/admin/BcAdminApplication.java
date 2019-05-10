package exercise.bc.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("exercise.bc.admin.*.mapper")
public class BcAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcAdminApplication.class, args);
	}

}

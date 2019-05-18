package exercise.bc.wechat.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WechatMpAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WechatMpAppApplication.class, args);
	}

}

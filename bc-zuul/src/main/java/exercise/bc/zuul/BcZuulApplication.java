package exercise.bc.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author BlackCat
 * @Description //TODO 网关
 * @Date 12:06 2019/3/27
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class BcZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcZuulApplication.class, args);
	}

}

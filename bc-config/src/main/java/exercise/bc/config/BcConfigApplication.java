package exercise.bc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author BlackCat
 * @Description //TODO 公共配置启动类
 * @Date 20:58 2019/3/27
 **/
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class BcConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcConfigApplication.class, args);
	}

}

package exercise.bc.wechat.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 微信公众号
 *
 * @author : blackCat
 * @date : 2019/5/19 9:25
 */
@SpringBootApplication
@EnableEurekaClient
public class WechatMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatMpApplication.class, args);
    }

}

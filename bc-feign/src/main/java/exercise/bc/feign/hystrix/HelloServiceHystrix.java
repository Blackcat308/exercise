package exercise.bc.feign.hystrix;

import exercise.bc.feign.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO 熔断处理类
 * @Author BlackCat
 * @Date 2019/3/27 11:50
 * @Version 1.0.0
 **/
@Component
public class HelloServiceHystrix implements HelloService {

    @Override
    public String sayHello() {
        return "哎呀 宕机了 sorry";
    }

    @Override
    public String sayHello(String name) {
        return "哎呀 宕机了 sorry" + name;
    }
}

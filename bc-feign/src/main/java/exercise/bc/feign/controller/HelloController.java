package exercise.bc.feign.controller;

import exercise.bc.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author BlackCat
 * @Date 2019/3/27 10:55
 * @Version 1.0.0
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    /**
     * @Author BlackCat
     * @Description //TODO
     * @Date 11:02 2019/3/27
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("sayHello")
    public String sayHello() {
        return helloService.sayHello();
    }

    /**
     * @Author BlackCat
     * @Description //TODO
     * @Date 11:02 2019/3/27
     * @Param [name]
     * @return java.lang.String
     **/
    @GetMapping("sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return helloService.sayHello(name);
}
}

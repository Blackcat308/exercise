package exercise.bc.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author BlackCat
 * @Date 2019/3/27 9:46
 * @Version 1.0.0
 **/
@RestController
public class HelloController {

    @Value("${profile}")
    private String profile;

    /**
     * @Author BlackCat
     * @Description //TODO 
     * @Date 9:47 2019/3/27
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/")
    public String sayHello() {
        return "bc-web say hello from spring boot!" + this.profile;
    }

    /**
     * @Author BlackCat
     * @Description //TODO
     * @Date 11:02 2019/3/27
     * @Param [name]
     * @return java.lang.String
     **/
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "bc-web say hello from spring boot!" + name;
    }
}

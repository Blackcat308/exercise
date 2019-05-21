package exercise.bc.feign.service;

import exercise.bc.feign.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author BlackCat
 * @Description //TODO
 * @Date 11:03 2019/3/27
 **/
@FeignClient(name = "bc-web", fallback = HelloServiceHystrix.class)
public interface HelloService {

    /**
     * @return java.lang.String
     * @Author BlackCat
     * @Description //TODO
     * @Date 11:03 2019/3/27
     * @Param []
     **/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String sayHello();

    /**
     * @return java.lang.String
     * @Author BlackCat
     * @Description //TODO
     * @Date 11:03 2019/3/27
     * @Param [name]
     **/
    @RequestMapping(value = "sayHello/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable("name") String name);

}

package exercise.bc.web.user.controller;

import exercise.bc.web.user.entity.User;
import exercise.bc.web.user.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceI userService;

    /**
     * 功能描述:
     * 用户集合
     *
     * @param
     * @return : java.util.List<exercise.bc.web.user.entity.User>
     * @author : blackCat
     * @date : 2019/5/10 10:24
     */
    @GetMapping("/userAll")
    public List<User> listUser() {
        return userService.listUser();
    }
}

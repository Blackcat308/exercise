package exercise.bc.web.user.service.impl;

import exercise.bc.web.user.entity.User;
import exercise.bc.web.user.mapper.UserMapper;
import exercise.bc.web.user.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    /**
     * 功能描述:
     * 用户集合
     *
     * @param
     * @return : java.util.List<exercise.bc.web.user.entity.User>
     * @author : blackCat
     * @date : 2019/5/10 10:24
     */
    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}


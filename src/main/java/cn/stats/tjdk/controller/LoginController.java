package cn.stats.tjdk.controller;

import cn.stats.tjdk.dao.UserRepository;
import cn.stats.tjdk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    public String login(@RequestParam("uid")String uid, @RequestParam("password")String password){

        List<User> user = userRepository.findByUidAndPassword(uid,password);
        if(user.size()>0){
            return "success";
        }else {
            return "fail";
        }
    }


}

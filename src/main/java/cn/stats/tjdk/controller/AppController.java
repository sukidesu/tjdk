package cn.stats.tjdk.controller;


import cn.stats.tjdk.entity.Daka;
import cn.stats.tjdk.entity.User;
import cn.stats.tjdk.service.DakaService;
import cn.stats.tjdk.service.LoginService;
import cn.stats.tjdk.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    LoginService loginservice;
    @Autowired
    QueryService queryService;
    @Autowired
    DakaService dakaService;

    /**
     * 登录
     * @param uid 传入用户uid
     * @param password 传入用户password
     * @return 返回success或者fail，String型
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam("uid")String uid, @RequestParam("password")String password){
        User user = new User();
        user.setUid(uid);
        user.setPassword(password);
        return loginservice.verifyLogin(user);
    }

    /**
     * 打卡
     * @param uid 传入用户uid
     * @param tag 传入打卡状态，上午-上班，上午-下班 等等。。。
     * @return 返回打卡是否在范围的判断，YES或者NO，String型
     */
    @PostMapping(value = "/daka")
    public String daka(@RequestParam("uid")String uid, @RequestParam("tag")String tag){
        return dakaService.daka(uid,tag);
    }

    /**
     * 查询所有
     * @return Daka记录的对象
     */
    @GetMapping(value = "/listall")
    public List<Daka> listAll(){
        return queryService.queryALL();
    }

    /**
     * 按uid查询
     * @param uid 传入用户uid
     * @return 单个用户的打卡记录
     */
    @PostMapping(value = "/listbyuid")
    public List<Daka> listByUid(@RequestParam("uid") String uid){
        return queryService.quaryByUid(uid);
    }

}

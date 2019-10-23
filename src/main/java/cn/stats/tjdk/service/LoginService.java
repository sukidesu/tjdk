package cn.stats.tjdk.service;

import cn.stats.tjdk.dao.UserRepository;
import cn.stats.tjdk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public String verifyLogin(User u){
/*      List<User> user = userRepository.findByUidAndPassword(u.getUid(),u.getPassword());
        if(user.size()>0){
            return "success";
        }else {
            return "fail";
        }*/
        List<User> list = userRepository.findByUid(u.getUid());
        if(list.size()!=0){
            User user = list.get(0);
            if(u.getPassword().equals(user.getPassword())){
                return "success";
            }else {
                return "fail";
            }
        }
        return null;
    }

}

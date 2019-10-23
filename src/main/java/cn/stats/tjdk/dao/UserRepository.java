package cn.stats.tjdk.dao;

import cn.stats.tjdk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByUidAndPassword(String uid,String password);
    public List<User> findByUid(String uid);
}

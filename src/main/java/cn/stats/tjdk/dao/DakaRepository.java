package cn.stats.tjdk.dao;

import cn.stats.tjdk.entity.Daka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DakaRepository extends JpaRepository<Daka,Integer> {

    public List<Daka> findByUid(String uid);

}

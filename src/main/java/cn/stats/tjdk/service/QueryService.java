package cn.stats.tjdk.service;

import cn.stats.tjdk.dao.DakaRepository;
import cn.stats.tjdk.entity.Daka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QueryService {

    @Autowired
    private DakaRepository dakaRepository;

    public List<Daka> queryALL(){

        return dakaRepository.findAll();
    }

    public List<Daka> quaryByUid(String uid) {

        return dakaRepository.findByUid(uid);
    }
}

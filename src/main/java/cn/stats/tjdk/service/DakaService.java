package cn.stats.tjdk.service;

import cn.stats.tjdk.dao.DakaRepository;
import cn.stats.tjdk.entity.Daka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DakaService {

    @Autowired
    private DakaRepository dakaRepository;

    public String daka(String uid,String tag){
        Daka daka = new Daka();
        daka.setUid(uid);
        daka.setTag(tag);
        daka.setDate(new Date());
        daka.setInRange(isRange(tag));
        dakaRepository.save(daka);
        return isRange(tag);
    }

    public String isRange(String tag){

        String inRange = null;
        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();

        switch (tag){
            case "上午-上班":
                if ((hours == 7 && minutes >= 40) || (hours == 8 && minutes <= 20)){
                    inRange= "YES";
                }else{inRange=  "NO";}
                break;
            case"上午-下班":
                if ((hours == 11 && minutes >= 30) || (hours == 12 && minutes <= 20)){
                    inRange=  "YES";
                }else{inRange=  "NO";}
                break;
            case"下午-上班":
                if ((hours == 14 && minutes >= 10) || (hours == 14 && minutes <= 50)){
                    inRange=  "YES";
                }else{inRange=  "NO";}
                break;
            case"下午-下班":
                if ((hours == 17 && minutes >= 10) || (hours == 17 && minutes <= 50)){
                    inRange=  "YES";
                }else{inRange=  "NO";}
                break;

        }
        return inRange;
    }
}

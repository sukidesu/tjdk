package cn.stats.tjdk.controller;

import cn.stats.tjdk.dao.DakaRepository;
import cn.stats.tjdk.entity.Daka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class DakaController {

    @Autowired
    private DakaRepository dakaRepository;


    @GetMapping(value = "/listall")
    public List<Daka> listAll(){
      return dakaRepository.findAll();
    }

    @GetMapping(value = "/listall/{uid}")
    public List<Daka> listByUidGet(@PathVariable("uid") String uid){
        return dakaRepository.findByUid(uid);
    }
    @PostMapping(value = "/listbyuid")
    public List<Daka> listByUid(@RequestParam("uid") String uid){
        return dakaRepository.findByUid(uid);
    }

    @PostMapping(value = "/daka")
    public String daka(@RequestParam("uid")String uid, @RequestParam("tag")String tag){
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

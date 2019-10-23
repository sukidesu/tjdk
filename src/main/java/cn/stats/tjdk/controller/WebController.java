package cn.stats.tjdk.controller;

import cn.stats.tjdk.dao.DakaRepository;
import cn.stats.tjdk.entity.Daka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WebController {
    @Autowired
    private DakaRepository dakaRepository;

    @RequestMapping("/index")
    public ModelAndView webList(){
        List<Daka> list = dakaRepository.findAll();
        ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("weblists",list);
        return mav;
    }

    @RequestMapping("/index2")
    public ModelAndView indexList2(){

        return new ModelAndView("index.html");
    }

    @RequestMapping("/index3")
    public String indexList3(){

        return "index.html";
    }
}

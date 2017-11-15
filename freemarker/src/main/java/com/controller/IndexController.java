package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.custom.User;

@Controller //控制器（注入服务）
@RequestMapping("/") //访问地址，value="index" 则访问地址为：XXXX/index
public class IndexController {
    
    /**
     * @param value ：值同上用于访问命名
     */
    @RequestMapping(value = "/index")
    public ModelAndView initLoad(){
        //值为视图文件所在位置。
        ModelAndView mav = new ModelAndView();
        mav.addObject("username", "你好,Freemarker!");
        return mav;
    }
    
    @RequestMapping(value = "/cp1")
    public ModelAndView val(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp1");
        mv.addObject("intVar",100);
        mv.addObject("longVar",10000L);
        mv.addObject("stringVar","12332hjgjh");
        mv.addObject("doubleVar",3.45d);
        mv.addObject("booleanVar",true);
        mv.addObject("dateVar",new java.sql.Date(new Date().getTime()));//必须sql
        mv.addObject("date1Var",new Date());
        mv.addObject("nullVar",null);
        return mv;
    }
    
    @RequestMapping(value = "/cp2")
    public ModelAndView val2(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp2");
        User user=new User();
        user.setName("freemarker");
        user.setBrief("<font color='green'>对象</font>");
        mv.addObject("userObj",user);
        return mv;
    }
    
    @RequestMapping(value = "/cp3")
    public ModelAndView val3(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp3");
        List<String> list=new ArrayList<>();
    	list.add("java");
    	list.add("python");
    	list.add("nodejs");
    	Map<String, String> map=new HashMap<String,String>();
    	map.put("java", "java");
    	map.put("python", "python");
    	map.put("nodejs", "nodejs");
        mv.addObject("myList", list);
        mv.addObject("map", map);
        return mv;
    }
    
    @RequestMapping(value = "/cp4")
    public ModelAndView val4(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp4");
        return mv;
    }
    
    /**
     * 自定义排序
     */
    @RequestMapping(value = "/cp5")
    public ModelAndView val5(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp5");
        mv.addObject("sort_int",new SortMethod());
        return mv;
    }
    
    @RequestMapping(value = "/cp6")
    public ModelAndView val6(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp6");
        return mv;
    }
    
    /**
     * 自定义指令
     */
    @RequestMapping(value = "/cp7")
    public ModelAndView val7(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp7");
        return mv;
    }
    
    @RequestMapping(value = "/cp8")
    public ModelAndView val8(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp8");
        return mv;
    }
    
    @RequestMapping(value = "/cp9")
    public ModelAndView val9(){
        //值为视图文件所在位置。
        ModelAndView mv = new ModelAndView("cp9");
        return mv;
    }
    
//    @RequestMapping(value = "ftl")
//    public ModelAndView initFltLoad() throws Exception {
//        ModelAndView mav = new ModelAndView("/ftl/index");
//        return mav;
//    }
}
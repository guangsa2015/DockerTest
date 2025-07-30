package org.example;

import jakarta.annotation.Resource;
import org.example.mybatis.entry.Tab1;
import org.example.mybatis.service.impl.Tab1ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/main")
public class MainController {

    @Resource
    private RedisUtil redisUtil;

     @GetMapping("/a")
     public String  hellMan(){
         return "Hello,你好!";
     }

     @GetMapping("/b/set/{name}")
     public String setRedis(@PathVariable("name") String name){
         redisUtil.set(RedisUtil.TEST_NAME,name);
         return "set Redis data.";
     }

     @GetMapping("/b/get")
     public String getRedis(){
         String value = String.valueOf(redisUtil.get(RedisUtil.TEST_NAME));
         return "get Redis data:"+value;
     }


    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private int redisPort;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    @GetMapping("/cfg")
    public String getRedisConfig() {
        return "Redis Host: " + redisHost + ", Port: " + redisPort + ", Password: " + redisPassword;
    }

    @Resource
    private Tab1ServiceImpl tab1Service;

    /**
     * 获取所有数据
     * @return
     */
    @GetMapping("/users")
    public String getAllTabls(){
        List<Tab1> lists=tab1Service.getAllTab1s();
        lists.forEach(System.out::println);
        System.out.println(lists.size());

        return "all users";
    }
}

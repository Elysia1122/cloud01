package com.sx.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.sx.pojo.OrderInfo;
import com.sx.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sx
 * @since 2024-02-29
 */
@RestController
@RequestMapping("/order-info")
public class OrderInfoController {

    @Autowired
    private RestTemplate restTemplate;

    //消费者
    @GetMapping("/getOrder/{id}")
    public OrderInfo getOne(@PathVariable Integer id){
        OrderInfo order = Db.getById(id, OrderInfo.class);
        //远程调用userserver服务的/user=info/getUser/{id}接口
        UserInfo userInfo = restTemplate.getForObject("http://localhost:8080/user-info/getUser/" + order.getUid(), UserInfo.class);
        return order.setUserInfo(userInfo);
    }

    @GetMapping("/getAll")
    public List<UserInfo> getAllUser(){
        ResponseEntity<UserInfo[]> entity = restTemplate.getForEntity("http://localhost:8080/user-info/getAll", UserInfo[].class);
        List<UserInfo> list = Arrays.stream(entity.getBody()).collect(Collectors.toList());
        return list;
    }
}

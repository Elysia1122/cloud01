package com.sx.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.sx.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sx
 * @since 2024-02-29
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser/{id}")
    public UserInfo getUser(@PathVariable int id){
        return Db.getById(id,UserInfo.class);
    }
}

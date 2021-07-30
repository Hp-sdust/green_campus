package com.qdtdhl.campus.model.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(tags = "注销")
@CrossOrigin
@RestController
public class ExitController {

    @RequestMapping(value="exit",method= POST)
    public  String exit(
           String tokenvalue
    ) {

        StpUtil.logoutByTokenValue(tokenvalue);
        return "注销成功";
    }
}

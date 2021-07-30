package com.qdtdhl.campus.model.login.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.qdtdhl.campus.common.statent.Template;
import com.qdtdhl.campus.common.utils.QdTdhlTools;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(tags = "登录")
@CrossOrigin
@RestController
public class LoginController {
    private final IBaseUserService bokService;

    public LoginController(IBaseUserService bokService){
        this.bokService=bokService;
    }

    @RequestMapping(value="login/dologin",method= POST)
    public Template<SaTokenInfo> addBaseUser(
            String username,String password
    ) {
        if(bokService.finduser(username)!=null)
        {
             if(DigestUtil.md5Hex(password).equals(bokService.finduser(username).getPassword()))
             {

                 StpUtil.setLoginId(bokService.finduser(username).getId());
                 return QdTdhlTools.returnSuccess("登录成功",StpUtil.getTokenInfo());
             }
             else {
                 return QdTdhlTools.returnErr("密码错误");
             }


        }
        else {
            return  QdTdhlTools.returnErr("用户不存在");
        }
    }
}

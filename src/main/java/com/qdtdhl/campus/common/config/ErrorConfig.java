package com.qdtdhl.campus.common.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.qdtdhl.campus.common.statent.Contants;
import com.qdtdhl.campus.common.statent.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Controller
public class ErrorConfig {


    @ExceptionHandler({Exception.class})
    public Object exception(Exception e) {

        if (e instanceof ErrorException){
            return  ((ErrorException) e).getTTemplate();
        }
        if (e instanceof NotLoginException){
            Template<Object> template = new Template<>();
            template.setMsg("用户未登录,请重新登录.");
            template.setStatus(Contants.ERROR7);
            return template;
        }
        if (e instanceof NotRoleException){
            Template<Object> template = new Template<>();
            template.setMsg("用户未拥有该角色,请联系管理员.");
            template.setStatus(Contants.ERROR2);
            return template;
        }
        if (e instanceof NotPermissionException){
            Template<Object> template = new Template<>();
            template.setMsg("用户未拥有该权限,请联系管理员.");
            template.setStatus(Contants.ERROR2);
            return template;
        }

        Template<Object> template = new Template<>();
        template.setData(e.getMessage());
        template.setObject(e.getStackTrace());
        template.setMsg("错误-未知错误-请联系开发人员");
        template.setStatus(Contants.ERROR2);

        return template;
    }

}

package com.qdtdhl.campus.common.utils;


import com.qdtdhl.campus.common.config.ErrorException;
import com.qdtdhl.campus.common.statent.Contants;
import com.qdtdhl.campus.common.statent.Template;
import org.springframework.stereotype.Component;

@Component
public class ErrorUtil {

    public static  <T> Template<T> loginError(String msg) {
        Template<T> template = new Template<>();
        template.setMsg(msg);
        template.setStatus(Contants.ERROR6);
        throw new ErrorException(template);
    }

    /**
     * 用户未登录
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Template<T> checkLoginError(String msg) {
        Template<T> template = new Template<>();
        template.setMsg(msg);
        template.setStatus(Contants.ERROR7);
        throw new ErrorException(template);
    }

    /**
     * 失败/错误
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Template<T> error(String msg) {
        Template<T> template = new Template<>();
        template.setMsg(msg);
        template.setStatus(Contants.ERROR);
        throw new ErrorException(template);
    }
}

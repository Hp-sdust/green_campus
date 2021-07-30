package com.qdtdhl.campus.common.jwt;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouterUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    // 注册sa-token的拦截器
    //@Override
    /*public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义验证规则
        registry.addInterceptor(new SaRouteInterceptor((request, response, handler) -> {

            // 登录验证 -- 排除多个路径
            SaRouterUtil.match(Arrays.asList("/**"), Arrays.asList(
                    //排除 登录接口验证
                    "/login/doLogin",
                    //排除 文档访问地址
                    "/campus/doc.html",
                    "/campus/swagger-ui.html",
                    //排除 文档相关css js 等
                    "/campus/webjars/**",
                    "/campus/v2/api-docs",
                    "/campus/swagger-resources/**"
            ), StpUtil::checkLogin);

            // 角色认证 -- 拦截以 admin 开头的路由，必须具备[admin]角色或者[super-admin]角色才可以通过认证
            SaRouterUtil.match("/admin/**", () -> StpUtil.checkRoleOr("admin", "super-admin"));

            // 权限认证 -- 不同模块, 校验不同权限
            SaRouterUtil.match("/user/**", () -> StpUtil.checkPermission("user"));
            SaRouterUtil.match("/admin/**", () -> StpUtil.checkPermission("admin"));
            SaRouterUtil.match("/goods/**", () -> StpUtil.checkPermission("goods"));
            SaRouterUtil.match("/orders/**", () -> StpUtil.checkPermission("orders"));
            SaRouterUtil.match("/notice/**", () -> StpUtil.checkPermission("notice"));
            SaRouterUtil.match("/comment/**", () -> StpUtil.checkPermission("comment"));


        })).addPathPatterns("/**");
    }*/

        // 注册sa-token的注解拦截器，打开注解式鉴权功能
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
            registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
        }


}

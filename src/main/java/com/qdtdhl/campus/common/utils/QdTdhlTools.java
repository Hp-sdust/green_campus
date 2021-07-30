package com.qdtdhl.campus.common.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qdtdhl.campus.common.statent.Contants;
import com.qdtdhl.campus.common.statent.Template;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class QdTdhlTools {

    private final RedisUtil redisUtil;


    public QdTdhlTools(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }


    public static <T> Template<T> returnSuccess(String msg) {
        return returnSuccess(msg, null, null, null);
    }

    public static <T> Template<T> returnSuccess(String msg, T data) {

        return returnSuccess(msg, data, null, null);
    }

    public static <T> Template<T> returnSuccess(String msg, T data, Object object) {

        return returnSuccess(msg, data, null, object);
    }

    public static <T> Template<T> returnSuccess(String msg, List<T> dataList) {

        return returnSuccess(msg, null, dataList, null);
    }

    public static <T> Template<T> returnSuccess(String msg, List<T> dataList, Object object) {

        return returnSuccess(msg, null, dataList, object);
    }

    public static <T> Template<T> returnSuccess(String msg, T data, List<T> dataList) {

        return returnSuccess(msg, data, dataList, null);
    }
    public static <T> Template<T> returnSuccess(String msg, String m) {

        return returnSuccess(msg, m);
    }

    /**
     * 正确返回
     * @param msg 消息
     * @param data 数据
     * @param dataList 数据list
     * @param object 额外数据
     * @param <T> 数据类型
     * @return 返回web
     */
    public static <T> Template<T> returnSuccess(String msg, T data, List<T> dataList, Object object) {
        Template<T> template = new Template<>();

        template.setMsg(msg);
        template.setData(data);
        template.setDataList(dataList);
        template.setObject(object);
        template.setStatus(1);

        return template;
    }

    public static <T> Template<T> returnErr(String msg) {
        return returnErr(msg, null, null, null);
    }

    public static <T> Template<T> returnErr(String msg, T data) {

        return returnErr(msg, data, null, null);
    }

    public static <T> Template<T> returnErr(String msg, T data, Object object) {

        return returnErr(msg, data, null, object);
    }

    public static <T> Template<T> returnErr(String msg, List<T> dataList) {

        return returnErr(msg, null, dataList, null);
    }

    public static <T> Template<T> returnErr(String msg, List<T> dataList, Object object) {

        return returnErr(msg, null, dataList, object);
    }

    public static <T> Template<T> returnErr(String msg, T data, List<T> dataList) {

        return returnErr(msg, data, dataList, null);
    }

    /**
     * 错误返回
     * @param msg 消息
     * @param data 数据
     * @param dataList 数据list
     * @param object 额外数据
     * @param <T> 数据类型
     * @return 返回到web
     */
    public static <T> Template<T> returnErr(String msg, T data, List<T> dataList, Object object) {
        Template<T> template = new Template<>();

        template.setMsg(msg);
        template.setData(data);
        template.setDataList(dataList);
        template.setObject(object);
        template.setStatus(Contants.ERROR);

        return template;
    }

    /**
     * 根据实体生成相同的查询条件 添加del_flg条件
     * @param object
     * @param <T>
     * @return
     */
    public static <T> EntityWrapper<T> addEqualsEw(T object) {

        EntityWrapper<T> entityWrapper = new EntityWrapper<>();
        entityWrapper.andNew("del_flg != 0");
        Map<String, Object> param = BeanUtil.beanToMap(object, true, false);

        param.forEach((x, y) -> {
            if (y != null) {
                entityWrapper.andNew(x + " = {0} ", y);
            }
        });

        return entityWrapper;
    }

    /**
     * 根据实体生成相似的查询条件 添加del_flg条件
     * null 不算
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> EntityWrapper<T> addConditionToEw(T object) {

        EntityWrapper<T> entityWrapper = new EntityWrapper<>();
        entityWrapper.andNew("del_flg != 0");

        Map<String, Object> param = BeanUtil.beanToMap(object, true, false);

        param.forEach((x, y) -> {
            if (y != null) {
                if (y instanceof String) {
                    entityWrapper.like(x, String.valueOf(y));
                } else if (y instanceof Integer) {
                    entityWrapper.andNew(x + " = {0} ", y);
                }
            }
        });

        return entityWrapper;
    }

    /**
     * 实体 到 实体 相同字段赋值转换
     * @param t
     * @param k
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> K switchBeanToBean(T t, K k) {
        k = (K) BeanUtil.mapToBean(BeanUtil.beanToMap(t), k.getClass(), false);
        return k;
    }


}
